package clothingsystem.appweb.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList; // Importar la clase ArrayList
import clothingsystem.accesoadatos.CategoriaDAL; // Importar la clase CategoriaDAL de la capa de acceso a datos
import clothingsystem.accesoadatos.ProductoDAL; // Importar la clase productoDAL de la capa de acceso a datos
import clothingsystem.appweb.utils.*; // Importar las clases SessionUser, Utilidad del paquete de utils
import clothingsystem.entidadesdenegocio.Categoria; // Importar la clase categoria de la capa de entidades de negocio
import clothingsystem.entidadesdenegocio.Producto; // Importar la clase producto de la capa de entidades de negocio
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet(name = "ProductoServlet", urlPatterns = {"/Producto"})
public class ProductoServlet extends HttpServlet {
    
       private String pathFiles = "C:\\Users\\carlos\\Documents\\proyecto2\\ClothingSystem\\ClothingSystem.AppWeb\\web\\wwwroot\\imag";
    private File fileUpload = new File(pathFiles);
    private String[] typeImage = {".ico", ".png", ".jpg", ".jpeg", ".jfif"};
    private String fileName = "";
    private String guardarImagen(Part part, File pathUpload) {
        String absolutePath = "";
        try {
            Path path = Paths.get(part.getSubmittedFileName());
            fileName = path.getFileName().toString();
            InputStream input = part.getInputStream();
            
            if (input != null) {
                File file = new File(pathUpload, fileName);
                absolutePath = file.getAbsolutePath();
                Files.copy(input, file.toPath()); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return "wwwroot\\imag\\" + fileName;
    }
    
    private boolean isExtension(String fileName, String[] extensions) {
        for (String ext : extensions) {
            if (fileName.toLowerCase().endsWith(ext)) {
                return true;
            }
        }
        return false;
    }
    
        private Producto obtenerProducto(HttpServletRequest request) {
        // Obtener el par??metro accion del request
        String accion = Utilidad.getParameter(request, "accion", "index");
        Producto producto = new Producto();
        // Obtener el par??metro codigo del request  y asignar ese valor a la propiedad Codigo de producto.
        producto.setCodigo(Utilidad.getParameter(request, "codigo", ""));
        // Obtener el par??metro Descripcion del request  y asignar ese valor a la propiedad Descripcion de producto.
        producto.setDescripcion(Utilidad.getParameter(request, "descripcion", ""));
        // Obtener el par??metro comentario del request  y asignar ese valor a la propiedad Comentario de producto.
        producto.setComentario(Utilidad.getParameter(request, "comentario", ""));
        
        producto.setFoto(Utilidad.getParameter(request, "Foto", ""));
        
        producto.setPrecioCompra(Double.parseDouble(Utilidad.getParameter(request, "precioCompra", "0")));
        
        producto.setPrecioVenta(Double.parseDouble(Utilidad.getParameter(request, "precioVenta", "0")));
        
        producto.setExistencia(Integer.parseInt(Utilidad.getParameter(request, "existencia", "0")));
        // Obtener el par??metro idCategoria del request  y asignar ese valor a la propiedad IdCategoria de producto.
        producto.setIdCategoria(Integer.parseInt(Utilidad.getParameter(request, "idCategoria", "0")));
        // Obtener el par??metro estatus del request  y asignar ese valor a la propiedad Estatus de producto.
        producto.setEstatus(Byte.parseByte(Utilidad.getParameter(request, "estatus", "0")));
        if (accion.equals("index")) {
            // Obtener el par??metro top_aux del request  y asignar ese valor a la propiedad Top_aux de producto.
            producto.setTop_aux(Integer.parseInt(Utilidad.getParameter(request, "top_aux", "10")));
            producto.setTop_aux(producto.getTop_aux() == 0 ? Integer.MAX_VALUE : producto.getTop_aux());
        }
       else {
            // Obtener el par??metro id del request  y asignar ese valor a la propiedad Id de producto.
            producto.setId(Integer.parseInt(Utilidad.getParameter(request, "id", "0")));
        }
        // Devolver la instancia de la entidad producto con los valores obtenidos del request.
        return producto;
    }

    /** si le pongo lo de la fecha amor jmmmm pues no se , diria que no hmmm seria en el jsp va a vere
     * En este m??todo se ejecutara cuando se envie una peticion get al servlet
     * producto, y el parametro accion sea igual index. Este m??todo se encargara
     * de enviar los datos de los usuarios al jsp de index de producto.
     *
     * @param request en este par??metro vamos a recibir el request de la
     * peticion get enviada al servlet producto
     * @param response en este par??metro vamos a recibir el response de la
     * peticion get enviada al servlet producto que utlizaremos para enviar el
     * jsp
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doGetRequestIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Producto producto = new Producto(); // Crear una instancia  de la entidad de producto.
            producto.setTop_aux(10); // Agregar el Top_aux con el valor de 10 a la propiedad Top_aux de producto.
            // Ir a la capa de acceso a datos y buscar los registros de producto y asociar Categoria.
            ArrayList<Producto> productos = ProductoDAL.buscarIncluirCategoria(producto);
            // Enviar los productos al jsp utilizando el request.setAttribute con el nombre del atributo producto.
            request.setAttribute("productos", productos);
            // Enviar el Top_aux de producto al jsp utilizando el request.setAttribute con el nombre del atributo top_aux.
            request.setAttribute("top_aux", producto.getTop_aux());
            request.getRequestDispatcher("Views/Producto/index.jsp").forward(request, response); // Direccionar al jsp index de producto.
        } catch (Exception ex) {
            Utilidad.enviarError(ex.getMessage(), request, response); // Enviar al jsp de error si hay un Exception.
        }
    }

    /**
     * En este m??todo se ejecutara cuando se envie una peticion post, al servlet
     * producto , y el par??metro accion sea igual index. Este m??todo se encargara
     * de enviar los datos de los productos al jsp de index de producto
     *
     * @param request en este par??metro vamos a recibir el request de la
     * peticion post enviada al servlet producto
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doPostRequestIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Producto producto = obtenerProducto(request); // Llenar la instancia de producto con los par??metros enviados en el request.
            // Ir a la capa de acceso a datos y buscar los registros de producto y asociar Categoria.
            ArrayList<Producto> productos = ProductoDAL.buscarIncluirCategoria(producto);
            // Enviar los productos al jsp utilizando el request.setAttribute con el nombre del atributo producto.
            request.setAttribute("productos", productos);
            // Enviar el Top_aux de producto al jsp utilizando el request.setAttribute con el nombre del atributo top_aux.
            request.setAttribute("top_aux", producto.getTop_aux());
            request.getRequestDispatcher("Views/Producto/index.jsp").forward(request, response); // Direccionar al jsp index de producto.
        } catch (Exception ex) {
            Utilidad.enviarError(ex.getMessage(), request, response); // Enviar al jsp de error si hay un Exception.
        }
    }

    /**
     * En este m??todo se ejecutara cuando se envie una peticion get al servlet
     * producto, y el par??metro accion sea igual create.
     *
     * @param request en este par??metro vamos a recibir el request de la
     * peticion get enviada al servlet producto
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doGetRequestCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // direccionar al jsp create de producto
        request.getRequestDispatcher("Views/Producto/create.jsp").forward(request, response);
    }

    /**
     * En este m??todo se ejecutara cuando se envie una peticion post al servlet
     * producto , y el par??metro accion sea igual create.
     *
     * @param request en este par??metro vamos a recibir el request de la
     * peticion post enviada al servlet producto
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    
    private void doPostRequestCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
            Producto producto = obtenerProducto(request); 
             Part part = request.getPart("foto");
            if (part == null) {
                System.out.println("No ha seleccionado ningun archivo");
                return;
            }
            
            if (isExtension(part.getSubmittedFileName(), typeImage)) {
                String Producto = guardarImagen(part, fileUpload);
               producto.setFoto(Producto);
            }
            int result = ProductoDAL.crear(producto);
            if (result != 0) { // Si el result es diferente a cero significa que los datos fueron ingresados correctamente.
                // Enviar el atributo accion con el valor index al jsp de index
                request.setAttribute("accion", "index");
                doGetRequestIndex(request, response); // Ir al metodo doGetRequestIndex para que nos direcciones al jsp index
            } else {
                // Enviar al jsp de error el siguiente mensaje. No se logro registrar un nuevo registro
                Utilidad.enviarError("No se logro registrar un nuevo registro", request, response);
            }
        } catch (Exception ex) {
            // Enviar al jsp de error si hay un Exception
            Utilidad.enviarError(ex.getMessage(), request, response);
        }


    }

    /**
     * En este m??todo obtiene por Id un producto desde la capa de acceso a datos
     * el Id se captura del request que se envio al servlet de producto
     *
     * @param request en este par??metro vamos a recibir el request de la
     * peticion get o post enviada al servlet producto
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void requestObtenerPorId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Producto producto = obtenerProducto(request); // Llenar la instancia de producto con los par??metros enviados en el request.
            Producto producto_result = ProductoDAL.obtenerPorId(producto); // Obtener desde la capa de acceso a datos el producto por Id.
            if (producto_result.getId() > 0) { // Si el Id es mayor a cero.
                Categoria categoria = new Categoria();
                categoria.setId(producto_result.getIdCategoria());
                // Obtener desde la capa de acceso a datos el categoria por Id y asignarlo al producto.
                producto_result.setCategoria(CategoriaDAL.obtenerPorId(categoria));
                // Enviar el atributo producto con el valor de los datos del producto de nuestra base de datos a un jsp
                request.setAttribute("producto", producto_result);
            } else {
                // Enviar al jsp de error el siguiente mensaje. El Id: ? no existe en la tabla de producto
                Utilidad.enviarError("El Id:" + producto_result.getId() + " no existe en la tabla de Producto", request, response);
            }
        } catch (Exception ex) {
            // enviar al jsp de error si hay un Exception
            Utilidad.enviarError(ex.getMessage(), request, response);
        }
    }

    /**
     * En este m??todo se ejecutara cuando se envie una peticion get al servlet
     * producto , y el par??metro accion sea igual edit.
     *
     * @param request en este par??metro vamos a recibir el request de la
     * peticion get enviada al servlet producto
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doGetRequestEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Enviar el producto al jsp de edit que se obtiene por Id
        requestObtenerPorId(request, response);
        // Direccionar al jsp edit de producto
        request.getRequestDispatcher("Views/Producto/edit.jsp").forward(request, response);
    }

    /**
     * En este m??todo se ejecutara cuando se envie una peticion post al servlet
     * producto , y el par??metro accion sea igual edit.
     *
     * @param request en este par??metro vamos a recibir el request de la
     * peticion post enviada al servlet producto
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doPostRequestEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Producto producto = obtenerProducto(request); // Llenar la instancia de producto con los par??metros enviados en el request.
            // Enviar los datos de Usuario a la capa de accesoa a datos para modificar el registro.
             Part part = request.getPart("foto");
            if (part == null) {
                System.out.println("No ha seleccionado ningun archivo");
                return;
            }
            
            if (isExtension(part.getSubmittedFileName(), typeImage)) {
                String Producto = guardarImagen(part, fileUpload);
               producto.setFoto(Producto);
            }
            int result = ProductoDAL.modificar(producto);
            if (result != 0) { // Si el result es diferente a cero significa que los datos fueron modificado correctamente.
                // Enviar el atributo accion con el valor index al jsp de index.
                request.setAttribute("accion", "index");
                doGetRequestIndex(request, response); // Ir al metodo doGetRequestIndex para que nos direcciones al jsp index.
            } else {
                // Enviar al jsp de error el siguiente mensaje. No se logro actualizar el registro.
                Utilidad.enviarError("No se logro actualizar el registro", request, response);
            }
        } catch (Exception ex) {
            // Enviar al jsp de error si hay un Exception
            Utilidad.enviarError(ex.getMessage(), request, response);
        }
    }

    /**
     * En este m??todo se ejecutara cuando se envie una peticion get al servlet
     * producto , y el par??metro accion sea igual details.
     *
     * @param request en este par??metro vamos a recibir el request de la
     * peticion get enviada al servlet producto
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doGetRequestDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Enviar el producto al jsp de details que se obtiene por Id.
        requestObtenerPorId(request, response);
        // Direccionar al jsp details de producto.
        request.getRequestDispatcher("Views/Producto/details.jsp").forward(request, response);
    }

    /**
     * En este m??todo se ejecutara cuando se envie una peticion get al servlet
     * producto , y el par??metro accion sea igual delete.
     *
     * @param request en este par??metro vamos a recibir el request de la
     * peticion get enviada al servlet producto
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doGetRequestDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Enviar el producto al jsp de delete que se obtiene por Id.
        requestObtenerPorId(request, response);
        // Direccionar al jsp delete de producto.
        request.getRequestDispatcher("Views/Producto/delete.jsp").forward(request, response);
    }

    /**
     * En este m??todo se ejecutara cuando se envie una peticion post al servlet
     * producto , y el par??metro accion sea igual delete.
     *
     * @param request en este par??metro vamos a recibir el request de la
     * peticion post enviada al servlet producto
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doPostRequestDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Producto producto = obtenerProducto(request); // Llenar la instancia de producto con los par??metros enviados en el request.
            // Enviar los datos de producto a la capa de accesoa a datos para que elimine el registro.
            int result = ProductoDAL.eliminar(producto);
            if (result != 0) { // Si el result es diferente a cero significa que los datos fueron eliminados correctamente.
                // Enviar el atributo accion con el valor index al jsp de index.
                request.setAttribute("accion", "index");
                doGetRequestIndex(request, response);  // Ir al m??todo doGetRequestIndex para que nos direccione al jsp index.
            } else {
                // Enviar al jsp de error el siguiente mensaje. No se logro eliminar el registro.
                Utilidad.enviarError("No se logro eliminar el registro", request, response);
            }
        } catch (Exception ex) {
            // Enviar al jsp de error si hay un Exception.
            Utilidad.enviarError(ex.getMessage(), request, response);
        }
    }   
    // </editor-fold>
    
    
     // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Este m??todo es un override al m??todo de la clase HttpServlet para recibir
     * todas las peticiones get que se realice al Servlet Producto
     *
     * @param request en este par??metro vamos a recibir el request de la
     * peticion get enviada al servlet Producto
     * @param response en este par??metro vamos a recibir el response de la
     * peticion get enviada al servlet Usuario que utilizaremos para enviar el
     * jsp al navegador web
     * @throws ServletException devolver una exception de un servlet
     * @throws IOException devolver una exception al leer o escribir un archivo
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener el par??metro accion del request
        String accion = Utilidad.getParameter(request, "accion", "index");
            // Utilizar el m??todo authorize de la clase SessionUser para validar que solo usuario con permiso
            // puedan acceder al servlet de Usuario. Todo el codigo que este dentro  expresion Lambda, se ejecutara si el Producto tiene permitido
            // acceder a este Servlet 
            SessionUser.authorize(request, response, () -> {
                // Hacer un switch para decidir a cual metodo ir segun el valor que venga en el par??metro de accion.
                switch (accion) {
                    case "index":
                        // Enviar el atributo accion al jsp de index.
                        request.setAttribute("accion", accion);
                        doGetRequestIndex(request, response); // Ir al m??todo doGetRequestIndex.
                        break;
                    case "create":
                        // Enviar el atributo accion al jsp de create.
                        request.setAttribute("accion", accion);
                        doGetRequestCreate(request, response); // Ir al m??todo doGetRequestCreate.
                        break;
                    case "edit":
                        // Enviar el atributo accion al jsp de edit.
                        request.setAttribute("accion", accion);
                        doGetRequestEdit(request, response); // Ir al m??todo doGetRequestEdit.
                        break;
                    case "delete":
                        // Enviar el atributo accion al jsp de delete.
                        request.setAttribute("accion", accion);
                        doGetRequestDelete(request, response); // Ir al m??todo doGetRequestDelete.
                        break;
                    case "details":
                        // Enviar el atributo accion al jsp de details.
                        request.setAttribute("accion", accion);
                        doGetRequestDetails(request, response); // Ir al m??todo doGetRequestDetails.
                        break;
                    default:
                        // Enviar el atributo accion al jsp de index.
                        request.setAttribute("accion", accion);
                        doGetRequestIndex(request, response); // Ir al m??todo doGetRequestIndex.
                }
            });
        }
    

    /**
     * Este m??todo es un override al m??todo de la clase HttpServlet para recibir
     * todas las peticiones post que se realice al Servlet Producto
     *
     * @param request en este par??metro vamos a recibir el request de la
     * peticion post enviada al servlet Producto
     * @param response en este par??metro vamos a recibir el response de la
     * peticion get enviada al servlet Usuario que utlizaremos para enviar el
     * jsp al navegador web
     * @throws ServletException devolver una exception de un servlet
     * @throws IOException devolver una exception al leer o escribir un archivo
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         // Obtener el par??metro accion del request
            String accion = Utilidad.getParameter(request, "accion", "index");
            // Utilizar el m??todo authorize de la clase SessionUser para validar que solo Producto con permiso
            // puedan acceder al servlet de Producto. Todo el codigo que este dentro  expresion Lambda, se ejecutara si el usuario tiene permitido
            // acceder a este Servlet 
            SessionUser.authorize(request, response, () -> {
                // Hacer un switch para decidir a cual metodo ir segun el valor que venga en el par??metro de accion.
                switch (accion) {
                    case "index":
                        // Enviar el atributo accion al jsp de index.
                        request.setAttribute("accion", accion);
                        doPostRequestIndex(request, response);  // Ir al metodo doPostRequestIndex.
                        break;
                    case "create":
                        // Enviar el atributo accion al jsp de create.
                        request.setAttribute("accion", accion);
                        doPostRequestCreate(request, response);  // Ir al metodo doPostRequestCreate.
                        break;
                    case "edit":
                        // Enviar el atributo accion al jsp de edit.
                        request.setAttribute("accion", accion);
                        doPostRequestEdit(request, response);  // Ir al metodo doPostRequestEdit.
                        break;
                    case "delete":
                        // Enviar el atributo accion al jsp de delete.
                        request.setAttribute("accion", accion);
                        doPostRequestDelete(request, response);  // Ir al metodo doPostRequestDelete.
                        break;
                    default:
                        // Enviar el atributo accion al jsp de index.
                        request.setAttribute("accion", accion);
                        doGetRequestIndex(request, response);  // Ir al metodo doGetRequestIndex.
                }
            });
        }
    }
// </editor-fold>