package clothingsystem.appweb.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;  // Importar la clase ArrayList
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import clothingsystem.accesoadatos.RopaFotoDAL;
import clothingsystem.entidadesdenegocio.RopaFoto;
import clothingsystem.entidadesdenegocio.Ropa;
import clothingsystem.accesoadatos.RopaDAL;
import clothingsystem.appweb.utils.*;
import java.io.File;
import java.io.InputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet(name = "RopaFotoServlet", urlPatterns = {"/RopaFoto"})
public class RopaFotoServlet extends HttpServlet {

   private String pathFiles = "C:\\ClothingSystem\\ClothingSystem.AppWeb\\web\\wwwroot\\images";
    private File fileUpload = new File(pathFiles);
    private String[] typeImage = {".ico", ".png", ".jpg", ".jpeg", "jfif"};
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
        
        return "wwwroot\\images\\" + fileName;
    }
    
    private boolean isExtension(String fileName, String[] extensions) {
        for (String ext : extensions) {
            if (fileName.toLowerCase().endsWith(ext)) {
                return true;
            }
        }
        return false;
    }
    private RopaFoto obtenerRopaFoto(HttpServletRequest request) {
        // Obtener el par??metro accion del request
        String accion = Utilidad.getParameter(request, "accion", "index");
        RopaFoto ropafoto = new RopaFoto();
        // Obtener el par??metro nombre del request   y asignar ese valor a la propiedad Nombre de Rol.
        ropafoto.setUrl(Utilidad.getParameter(request, "url", ""));
        // Obtener el par??metro nombre del request   y asignar ese valor a la propiedad Nombre de Rol.

        ropafoto.setEstatus(Byte.parseByte(Utilidad.getParameter(request, "estatus", "0")));
        
        ropafoto.setFoto(Utilidad.getParameter(request, "Foto", ""));
        

        ropafoto.setIdRopa(Integer.parseInt(Utilidad.getParameter(request, "idRopa", "0")));

        if (accion.equals("index")) {  // Si accion es index.
            // Obtener el par??metro top_aux del request  y asignar ese valor a la propiedad Top_aux de Rol.
            ropafoto.setTop_aux(Integer.parseInt(Utilidad.getParameter(request, "top_aux", "10")));
            ropafoto.setTop_aux(ropafoto.getTop_aux() == 0 ? Integer.MAX_VALUE : ropafoto.getTop_aux());
            // Utilizando un operador ternario, colocar en el Top_aux, si  es igual a cero enviar en el Top_aux, el valor maximo de un entero 
            // en java, para obtener todos los registro, en el caso contrario obtener la cantidad de registros
            // que se obtiene en el par??metro top_aux del request.
            ropafoto.setTop_aux(ropafoto.getTop_aux() == 0 ? Integer.MAX_VALUE : ropafoto.getTop_aux());
        } else {
            // Obtener el par??metro id del request  y asignar ese valor a la propiedad Id de Usuario.
            ropafoto.setId(Integer.parseInt(Utilidad.getParameter(request, "id", "0")));
        }
        // Devolver la instancia de la entidad Rol con los valores obtenidos del request.
        return ropafoto;
    }

    /**
     * En este m??todo se ejecutara cuando se envie una peticion get al servlet
     * Rol, y el par??metro accion sea igual index. Este m??todo se encargara de
     * enviar los datos de los roles al jsp de index de Rol.
     *
     * @param request en este par??metro vamos a recibir el request de la
     * peticion get enviada al servlet Rol
     * @param response en este par??metro vamos a recibir el response de la
     * peticion get enviada al servlet Rol que utlizaremos para enviar el jsp
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doGetRequestIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            RopaFoto ropafoto = new RopaFoto(); // Crear una instancia  de la entidad de Rol.
            ropafoto.setTop_aux(10); // Agregar el Top_aux con el valor de 10 a la propiedad Top_aux de rol.
            ArrayList<RopaFoto> ropafotos = RopaFotoDAL.buscarIncluirRopa(ropafoto); // Ir a la capa de acceso a datos y buscar los registros de Rol.
            // El request.setAttribute se utiliza para enviar datos desde un servlet a un jsp.
            request.setAttribute("ropafotos", ropafotos); // Enviar los roles al jsp utilizando el request.setAttribute con el nombre del atributo roles.
            // Enviar el Top_aux de Rol al jsp utilizando el request.setAttribute con el nombre del atributo top_aux.
            request.setAttribute("top_aux", ropafoto.getTop_aux());
            // El request.getRequestDispatcher nos permite direccionar a un jsp desde un servlet.              
            request.getRequestDispatcher("Views/RopaFoto/index.jsp").forward(request, response); // Direccionar al jsp index de Rol.
        } catch (Exception ex) {
            Utilidad.enviarError(ex.getMessage(), request, response); // Enviar al jsp de error si hay un Exception.
        }
    }

    /**
     * En este m??todo se ejecutara cuando se envie una peticion post, al servlet
     * Rol , y el par??metro accion sea igual index. Este m??todo se encargara de
     * enviar los datos de los roles al jsp de index de Rol
     *
     * @param request en este par??metro vamos a recibir el request de la
     * peticion post enviada al servlet Rol
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doPostRequestIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            RopaFoto ropafoto = obtenerRopaFoto(request); // Llenar la instancia de Rol con los par??metros enviados en el request 
            ArrayList<RopaFoto> ropafotos = RopaFotoDAL.buscarIncluirRopa(ropafoto);// Buscar los roles que cumple con los datos enviados en el request
            request.setAttribute("ropafotos", ropafotos); // Enviar los roles al jsp utilizando el request.setAttribute con el nombre del atributo roles
            // Enviar el Top_aux de Rol al jsp utilizando el request.setAttribute con el nombre del atributo top_aux
            request.setAttribute("top_aux", ropafoto.getTop_aux());
            request.getRequestDispatcher("Views/RopaFoto/index.jsp").forward(request, response); // Direccionar al jsp index de Rol
        } catch (Exception ex) {
            // Enviar al jsp de error si hay un Exception 
            Utilidad.enviarError(ex.getMessage(), request, response);
        }
    }

    /**
     * En este m??todo se ejecutara cuando se envie una peticion get al servlet
     * Rol, y el par??metro accion sea igual create.
     *
     * @param request en este par??metro vamos a recibir el request de la
     * peticion get enviada al servlet Rol
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doGetRequestCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // direccionar al jsp create de Rol
        request.getRequestDispatcher("Views/RopaFoto/create.jsp").forward(request, response);
    }

    /**
     * En este m??todo se ejecutara cuando se envie una peticion post al servlet
     * Rol , y el par??metro accion sea igual create.
     *
     * @param request en este par??metro vamos a recibir el request de la
     * peticion post enviada al servlet Rol
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doPostRequestCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            RopaFoto ropafoto = obtenerRopaFoto(request); // Llenar la instancia de Rol con los par??metros enviados en el request.
            // Enviar los datos de Rol a la capa de accesoa a datos para que lo almacene en la base de datos el registro.
            Part part = request.getPart("foto");
            if (part == null) {
                System.out.println("No ha seleccionado ningun archivo");
                return;
            }
            
            if (isExtension(part.getSubmittedFileName(), typeImage)) {
                String Ropafoto = guardarImagen(part, fileUpload);
               ropafoto.setFoto(Ropafoto);
            }
            int result = RopaFotoDAL.crear(ropafoto);
            if (result != 0) { // Si el result es diferente a cero significa que los datos fueron ingresados correctamente.
                // Enviar el atributo accion con el valor index al jsp de index
                request.setAttribute("accion", "index");
                doGetRequestIndex(request, response); // ir al metodo doGetRequestIndex para que nos direcciones al jsp index
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
     * En este m??todo obtiene por Id un Rol desde la capa de acceso a datos el
     * Id se captura del request que se envio al servlet de Rol
     *
     * @param request en este par??metro vamos a recibir el request de la
     * peticion get o post enviada al servlet Rol
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void requestObtenerPorId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            RopaFoto ropafoto = obtenerRopaFoto(request); // Llenar la instancia de Usuario con los par??metros enviados en el request.
            RopaFoto ropafoto_result = RopaFotoDAL.obtenerPorId(ropafoto); // Obtener desde la capa de acceso a datos el usuario por Id.
            if (ropafoto_result.getId() > 0) { // Si el Id es mayor a cero.
                Ropa ropa = new Ropa();
                ropa.setId(ropafoto_result.getIdRopa());
                // Obtener desde la capa de acceso a datos el rol por Id y asignarlo al usuario.
                ropafoto_result.setRopa(RopaDAL.obtenerPorId(ropa));
                // Enviar el atributo usuario con el valor de los datos del usuario de nuestra base de datos a un jsp
                request.setAttribute("ropafoto", ropafoto_result);
            } else {
                // Enviar al jsp de error el siguiente mensaje. El Id: ? no existe en la tabla de Usuario
                Utilidad.enviarError("El Id:" + ropafoto_result.getId() + " no existe en la tabla de Usuario", request, response);
            }
        } catch (Exception ex) {
            // enviar al jsp de error si hay un Exception
            Utilidad.enviarError(ex.getMessage(), request, response);
        }
    }

    /**
     * En este m??todo se ejecutara cuando se envie una peticion get al servlet
     * Rol , y el par??metro accion sea igual edit.
     *
     * @param request en este par??metro vamos a recibir el request de la
     * peticion get enviada al servlet Rol
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doGetRequestEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Enviar el rol al jsp de edit que se obtiene por Id
        requestObtenerPorId(request, response);
        // Direccionar al jsp edit de Rol
        request.getRequestDispatcher("Views/RopaFoto/edit.jsp").forward(request, response);
    }

    /**
     * En este m??todo se ejecutara cuando se envie una peticion post al servlet
     * Rol , y el par??metro accion sea igual edit.
     *
     * @param request en este par??metro vamos a recibir el request de la
     * peticion post enviada al servlet Rol
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doPostRequestEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            RopaFoto ropaFoto=obtenerRopaFoto(request);
             Part part = request.getPart("foto");
            if (part == null) {
                System.out.println("No ha seleccionado ningun archivo por lo que no se puede modificar");
                return;
            }
            
            if (isExtension(part.getSubmittedFileName(), typeImage)) {
                String FotoRopa = guardarImagen(part, fileUpload);
               ropaFoto.setFoto(FotoRopa);
            }
            // Enviar los datos de Rol a la capa de accesoa a datos para modificar el registro.
            int result = RopaFotoDAL.modificar(ropaFoto);
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
     * Rol , y el par??metro accion sea igual details.
     *
     * @param request en este par??metro vamos a recibir el request de la
     * peticion get enviada al servlet Rol
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doGetRequestDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Enviar el rol al jsp de details que se obtiene por Id.
        requestObtenerPorId(request, response);
        // Direccionar al jsp details de Rol.
        request.getRequestDispatcher("Views/RopaFoto/details.jsp").forward(request, response);
    }

    /**
     * En este m??todo se ejecutara cuando se envie una peticion get al servlet
     * Rol , y el par??metro accion sea igual delete.
     *
     * @param request en este par??metro vamos a recibir el request de la
     * peticion get enviada al servlet Rol
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doGetRequestDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Enviar el rol al jsp de delete que se obtiene por Id.
        requestObtenerPorId(request, response);
        // Direccionar al jsp delete de Rol.
        request.getRequestDispatcher("Views/RopaFoto/delete.jsp").forward(request, response);
    }

    /**
     * En este m??todo se ejecutara cuando se envie una peticion post al servlet
     * Rol , y el par??metro accion sea igual delete.
     *
     * @param request en este par??metro vamos a recibir el request de la
     * peticion post enviada al servlet Rol
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doPostRequestDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            RopaFoto ropafoto = obtenerRopaFoto(request); // Llenar la instancia de Rol con los par??metros enviados en el request.
            // Enviar los datos de Rol a la capa de accesoa a datos para que elimine el registro.
            int result = RopaFotoDAL.eliminar(ropafoto);
            if (result != 0) {// Si el result es diferente a cero significa que los datos fueron eliminados correctamente.
                // Enviar el atributo accion con el valor index al jsp de index.
                request.setAttribute("accion", "index");
                doGetRequestIndex(request, response); // Ir al m??todo doGetRequestIndex para que nos direccione al jsp index.
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
     * todas las peticiones get que se realice al Servlet Rol
     *
     * @param request en este par??metro vamos a recibir el request de la
     * peticion get enviada al servlet Rol
     * @param response en este par??metro vamos a recibir el response de la
     * peticion get enviada al servlet Rol que utlizaremos para enviar el jsp al
     * navegador web
     * @throws ServletException devolver una exception de un servlet
     * @throws IOException devolver una exception al leer o escribir un archivo
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Utilizar el m??todo authorize de la clase SessionUser para validar que solo usuario con permiso
        // puedan acceder al servlet de Rol. Todo el codigo que este dentro  expresion Lambda, se ejecutara si el usuario tiene permitido
        // acceder a este Servlet 
        SessionUser.authorize(request, response, () -> { // Expresion Lambda  
            // Obtener el par??metro accion del request
            String accion = Utilidad.getParameter(request, "accion", "index");
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
                    doGetRequestCreate(request, response); // Ir al metodo doGetRequestCreate.
                    break;
                case "edit":
                    // Enviar el atributo accion al jsp de edit.
                    request.setAttribute("accion", accion);
                    doGetRequestEdit(request, response);// Ir al metodo doGetRequestEdit.
                    break;
                case "delete":
                    // Enviar el atributo accion al jsp de delete.
                    request.setAttribute("accion", accion);
                    doGetRequestDelete(request, response); // Ir al metodo doGetRequestDelete.
                    break;
                case "details":
                    // Enviar el atributo accion al jsp de details.
                    request.setAttribute("accion", accion);
                    doGetRequestDetails(request, response); // Ir al metodo doGetRequestDetails.
                    break;
                default:
                    // Enviar el atributo accion al jsp de index.
                    request.setAttribute("accion", accion);
                    doGetRequestIndex(request, response); // Ir al metodo doGetRequestIndex.
            }
        });
    }

    /**
     * Este m??todo es un override al m??todo de la clase HttpServlet para recibir
     * todas las peticiones post que se realice al Servlet Rol
     *
     * @param request en este par??metro vamos a recibir el request de la
     * peticion post enviada al servlet Rol
     * @param response en este par??metro vamos a recibir el response de la
     * peticion get enviada al servlet Rol que utlizaremos para enviar el jsp al
     * navegador web
     * @throws ServletException devolver una exception de un servlet
     * @throws IOException devolver una exception al leer o escribir un archivo
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Utilizar el m??todo authorize de la clase SessionUser para validar que solo usuario con permiso
        // puedan acceder al servlet de Rol. Todo el codigo que este dentro  expresion Lambda,  se ejecutara si el usuario tiene permitido
        // acceder a este Servlet 
        SessionUser.authorize(request, response, () -> {
            // Obtener el par??metro accion del request.
            String accion = Utilidad.getParameter(request, "accion", "index");
            // Hacer un switch para decidir a cual metodo ir segun el valor que venga en el par??metro de accion.
            switch (accion) {
                case "index":
                    // Enviar el atributo accion al jsp de index.
                    request.setAttribute("accion", accion);
                    doPostRequestIndex(request, response); // Ir al metodo doGetRequestIndex.
                    break;
                case "create":
                    // Enviar el atributo accion al jsp de create.
                    request.setAttribute("accion", accion);
                    doPostRequestCreate(request, response); // Ir al metodo doPostRequestCreate.
                    break;
                case "edit":
                    // Enviar el atributo accion al jsp de edit.
                    request.setAttribute("accion", accion);
                    doPostRequestEdit(request, response); // Ir al metodo doPostRequestEdit.
                    break;
                case "delete":
                    // Enviar el atributo accion al jsp de delete.
                    request.setAttribute("accion", accion);
                    doPostRequestDelete(request, response); // Ir al metodo doPostRequestDelete.
                    break;
                default:
                    // Enviar el atributo accion al jsp de index.
                    request.setAttribute("accion", accion);
                    doGetRequestIndex(request, response); // Ir al metodo doGetRequestIndex.
            }
        });
    }

    // </editor-fold>
}
