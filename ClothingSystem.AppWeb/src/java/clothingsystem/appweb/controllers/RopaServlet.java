package clothingsystem.appweb.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList; // Importar la clase ArrayList
import clothingsystem.accesoadatos.MarcaDAL; // Importar la clase RolDAL de la capa de acceso a datos
import clothingsystem.accesoadatos.RopaDAL; // Importar la clase UsuarioDAL de la capa de acceso a datos
import clothingsystem.appweb.utils.*; // Importar las clases SessionUser, Utilidad del paquete de utils
import clothingsystem.entidadesdenegocio.Marca; // Importar la clase Rol de la capa de entidades de negocio
import clothingsystem.entidadesdenegocio.Ropa; // Importar la clase Usuario de la capa de entidades de negocio


; // Importar la clase Usuario de la capa de entidades de negocio

/**
 * En este Servlet, vamos a recibir todas las peticiones get y post que se
 * realice al Servlet Rol. Aprender conceptos básicos de servlets
 * http://www.jtech.ua.es/j2ee/2002-2003/modulos/servlets/apuntes/apuntes1_1.htm
 * Actualizamos la anotación WebServlet para cambiar el atributo urlPatterns
 * para acceder al Servlet Rol utilizando la siguiente Url: la del sitio web mas
 * /Rol
 */
@WebServlet(name = "RopaServlet", urlPatterns = {"/Ropa"})
public class RopaServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="Metodos para procesar las solicitudes get o post del Servlet">
    /**
     * En este método vamos a obtener la información enviada, en una peticion
     * get o post, obteniendo los datos de los parámetros enviados de un
     * formulario o la url del navegador, enviar esa información a una instancia
     * de la entidad Rol
     *
     * @param request en este parámetro vamos a recibir el request de la
     * peticion get o post enviada al servlet Rol
     * @return Rol devolver la instancia de la entidad Rol con los valores
     * obtenidos del request
     */
    private Ropa obtenerRopa(HttpServletRequest request) {
        // Obtener el parámetro accion del request
        String accion = Utilidad.getParameter(request, "accion", "index");
        Ropa ropa = new Ropa();
        // Obtener el parámetro nombre del request   y asignar ese valor a la propiedad Nombre de Rol.
        ropa.setCodigoBarra(Utilidad.getParameter(request, "codigobarra", ""));
        // Obtener el parámetro nombre del request   y asignar ese valor a la propiedad Nombre de Rol.
        ropa.setNombre(Utilidad.getParameter(request, "nombre", ""));
        // Obtener el parámetro nombre del request   y asignar ese valor a la propiedad Nombre de Rol.
        ropa.setPrecioCompra(Double.parseDouble(Utilidad.getParameter(request, "preciocompra", "0")));
        // Obtener el parámetro nombre del request   y asignar ese valor a la propiedad Nombre de Rol.
        ropa.setPrecioVenta(Double.parseDouble(Utilidad.getParameter(request, "precioventa", "0")));

        ropa.setExistencia(Integer.parseInt(Utilidad.getParameter(request, "existencia", "0")));

        ropa.setEstatus(Byte.parseByte(Utilidad.getParameter(request, "estatus", "0")));

        ropa.setTalla(Utilidad.getParameter(request, "talla", ""));

        ropa.setColor(Utilidad.getParameter(request, "color", ""));
                
        ropa.setEstilo(Utilidad.getParameter(request, "estilo", ""));

        ropa.setDescripcion(Utilidad.getParameter(request, "descripcion", ""));

        ropa.setTipoTela(Utilidad.getParameter(request, "tipotela", ""));
        
        ropa.setIdMarca(Integer.parseInt(Utilidad.getParameter(request, "idMarca", "0")));

        if (accion.equals("index")) {  // Si accion es index.
            // Obtener el parámetro top_aux del request  y asignar ese valor a la propiedad Top_aux de Rol.
            ropa.setTop_aux(Integer.parseInt(Utilidad.getParameter(request, "top_aux", "10")));
            ropa.setTop_aux(ropa.getTop_aux() == 0 ? Integer.MAX_VALUE : ropa.getTop_aux());
            // Utilizando un operador ternario, colocar en el Top_aux, si  es igual a cero enviar en el Top_aux, el valor maximo de un entero 
            // en java, para obtener todos los registro, en el caso contrario obtener la cantidad de registros
            // que se obtiene en el parámetro top_aux del request.
            ropa.setTop_aux(ropa.getTop_aux() == 0 ? Integer.MAX_VALUE : ropa.getTop_aux());
        }
        else {
            // Obtener el parámetro id del request  y asignar ese valor a la propiedad Id de Usuario.
            ropa.setId(Integer.parseInt(Utilidad.getParameter(request, "id", "0")));
    }
    // Devolver la instancia de la entidad Rol con los valores obtenidos del request.
    return ropa ;
}

/**
 * En este método se ejecutara cuando se envie una peticion get al servlet Rol,
 * y el parámetro accion sea igual index. Este método se encargara de enviar los
 * datos de los roles al jsp de index de Rol.
 *
 * @param request en este parámetro vamos a recibir el request de la peticion
 * get enviada al servlet Rol
 * @param response en este parámetro vamos a recibir el response de la peticion
 * get enviada al servlet Rol que utlizaremos para enviar el jsp
 * @throws javax.servlet.ServletException
 * @throws java.io.IOException
 */
private void doGetRequestIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Ropa ropa = new Ropa(); // Crear una instancia  de la entidad de Rol.
            ropa.setTop_aux(10); // Agregar el Top_aux con el valor de 10 a la propiedad Top_aux de rol.
            ArrayList<Ropa> ropas = RopaDAL.buscarIncluirMarca(ropa); // Ir a la capa de acceso a datos y buscar los registros de Rol.
            // El request.setAttribute se utiliza para enviar datos desde un servlet a un jsp.
            request.setAttribute("ropas", ropas); // Enviar los roles al jsp utilizando el request.setAttribute con el nombre del atributo roles.
            // Enviar el Top_aux de Rol al jsp utilizando el request.setAttribute con el nombre del atributo top_aux.
            request.setAttribute("top_aux", ropa.getTop_aux());
            // El request.getRequestDispatcher nos permite direccionar a un jsp desde un servlet.              
            request.getRequestDispatcher("Views/Ropa/index.jsp").forward(request, response); // Direccionar al jsp index de Rol.
        } catch (Exception ex) {
            Utilidad.enviarError(ex.getMessage(), request, response); // Enviar al jsp de error si hay un Exception.
        }
    }

    /**
     * En este método se ejecutara cuando se envie una peticion post, al servlet
     * Rol , y el parámetro accion sea igual index. Este método se encargara de
     * enviar los datos de los roles al jsp de index de Rol
     *
     * @param request en este parámetro vamos a recibir el request de la
     * peticion post enviada al servlet Rol
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doPostRequestIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Ropa ropa = obtenerRopa(request); // Llenar la instancia de Rol con los parámetros enviados en el request 
            ArrayList<Ropa> ropas = RopaDAL.buscarIncluirMarca(ropa); // Buscar los roles que cumple con los datos enviados en el request
            request.setAttribute("ropas", ropas); // Enviar los roles al jsp utilizando el request.setAttribute con el nombre del atributo roles
            // Enviar el Top_aux de Rol al jsp utilizando el request.setAttribute con el nombre del atributo top_aux
            request.setAttribute("top_aux", ropa.getTop_aux());
            request.getRequestDispatcher("Views/Ropa/index.jsp").forward(request, response); // Direccionar al jsp index de Rol
        } catch (Exception ex) {
            // Enviar al jsp de error si hay un Exception 
            Utilidad.enviarError(ex.getMessage(), request, response);
        }
    }

    /**
     * En este método se ejecutara cuando se envie una peticion get al servlet
     * Rol, y el parámetro accion sea igual create.
     *
     * @param request en este parámetro vamos a recibir el request de la
     * peticion get enviada al servlet Rol
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doGetRequestCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // direccionar al jsp create de Rol
        request.getRequestDispatcher("Views/Ropa/create.jsp").forward(request, response);
    }

    /**
     * En este método se ejecutara cuando se envie una peticion post al servlet
     * Rol , y el parámetro accion sea igual create.
     *
     * @param request en este parámetro vamos a recibir el request de la
     * peticion post enviada al servlet Rol
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doPostRequestCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Ropa ropa = obtenerRopa(request); // Llenar la instancia de Rol con los parámetros enviados en el request.
            // Enviar los datos de Rol a la capa de accesoa a datos para que lo almacene en la base de datos el registro.
            int result = RopaDAL.crear(ropa);
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
     * En este método obtiene por Id un Rol desde la capa de acceso a datos el
     * Id se captura del request que se envio al servlet de Rol
     *
     * @param request en este parámetro vamos a recibir el request de la
     * peticion get o post enviada al servlet Rol
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void requestObtenerPorId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Ropa ropa = obtenerRopa(request); // Llenar la instancia de Usuario con los parámetros enviados en el request.
            Ropa ropa_result = RopaDAL.obtenerPorId(ropa); // Obtener desde la capa de acceso a datos el usuario por Id.
            if (ropa_result.getId() > 0) { // Si el Id es mayor a cero.
                Marca marca = new Marca();
                marca.setId(ropa_result.getIdMarca());
                // Obtener desde la capa de acceso a datos el rol por Id y asignarlo al usuario.
                ropa_result.setMarca(MarcaDAL.obtenerPorId(marca));
                // Enviar el atributo usuario con el valor de los datos del usuario de nuestra base de datos a un jsp
                request.setAttribute("ropa", ropa_result);
            } else {
                // Enviar al jsp de error el siguiente mensaje. El Id: ? no existe en la tabla de Usuario
                Utilidad.enviarError("El Id:" + ropa_result.getId() + " no existe en la tabla de Usuario", request, response);
            }
        } catch (Exception ex) {
            // enviar al jsp de error si hay un Exception
            Utilidad.enviarError(ex.getMessage(), request, response);
        }
    }

    /**
     * En este método se ejecutara cuando se envie una peticion get al servlet
     * Rol , y el parámetro accion sea igual edit.
     *
     * @param request en este parámetro vamos a recibir el request de la
     * peticion get enviada al servlet Rol
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doGetRequestEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Enviar el rol al jsp de edit que se obtiene por Id
        requestObtenerPorId(request, response);
        // Direccionar al jsp edit de Rol
        request.getRequestDispatcher("Views/Ropa/edit.jsp").forward(request, response);
    }

    /**
     * En este método se ejecutara cuando se envie una peticion post al servlet
     * Rol , y el parámetro accion sea igual edit.
     *
     * @param request en este parámetro vamos a recibir el request de la
     * peticion post enviada al servlet Rol
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doPostRequestEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Ropa ropa = obtenerRopa(request); // Llenar la instancia de Rol con los parámetros enviados en el request.
            // Enviar los datos de Rol a la capa de accesoa a datos para modificar el registro.
            int result = RopaDAL.modificar(ropa);
            if (result != 0) { // Si el result es diferente a cero significa que los datos fueron modificado correctamente.
                // Enviar el atributo accion con el valor index al jsp de index.
                request.setAttribute("accion", "index");
                doGetRequestIndex(request, response); // Ir al metodo doGetRequestIndex para que nos direcciones al jsp index.
            } else {
                // Enviar al jsp de error el siguiente mensaje. No se logro actualizar el registro.
                Utilidad.enviarError("No se logro actualizar la ropa", request, response);
            }
        } catch (Exception ex) {
            // Enviar al jsp de error si hay un Exception
            Utilidad.enviarError(ex.getMessage(), request, response);
        }
    }

    /**
     * En este método se ejecutara cuando se envie una peticion get al servlet
     * Rol , y el parámetro accion sea igual details.
     *
     * @param request en este parámetro vamos a recibir el request de la
     * peticion get enviada al servlet Rol
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doGetRequestDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Enviar el rol al jsp de details que se obtiene por Id.
        requestObtenerPorId(request, response);
        // Direccionar al jsp details de Rol.
        request.getRequestDispatcher("Views/Ropa/details.jsp").forward(request, response);
    }

    /**
     * En este método se ejecutara cuando se envie una peticion get al servlet
     * Rol , y el parámetro accion sea igual delete.
     *
     * @param request en este parámetro vamos a recibir el request de la
     * peticion get enviada al servlet Rol
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doGetRequestDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Enviar el rol al jsp de delete que se obtiene por Id.
        requestObtenerPorId(request, response);
        // Direccionar al jsp delete de Rol.
        request.getRequestDispatcher("Views/Ropa/delete.jsp").forward(request, response);
    }

    /**
     * En este método se ejecutara cuando se envie una peticion post al servlet
     * Rol , y el parámetro accion sea igual delete.
     *
     * @param request en este parámetro vamos a recibir el request de la
     * peticion post enviada al servlet Rol
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doPostRequestDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Ropa ropa = obtenerRopa(request); // Llenar la instancia de Rol con los parámetros enviados en el request.
            // Enviar los datos de Rol a la capa de accesoa a datos para que elimine el registro.
            int result = RopaDAL.eliminar(ropa);
            if (result != 0) {// Si el result es diferente a cero significa que los datos fueron eliminados correctamente.
                // Enviar el atributo accion con el valor index al jsp de index.
                request.setAttribute("accion", "index");
                doGetRequestIndex(request, response); // Ir al método doGetRequestIndex para que nos direccione al jsp index.
            } else {
                // Enviar al jsp de error el siguiente mensaje. No se logro eliminar el registro.
                Utilidad.enviarError("No se logro eliminar la ropa", request, response);
            }
        } catch (Exception ex) {
            // Enviar al jsp de error si hay un Exception.
            Utilidad.enviarError(ex.getMessage(), request, response);
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Este método es un override al método de la clase HttpServlet para recibir
     * todas las peticiones get que se realice al Servlet Rol
     *
     * @param request en este parámetro vamos a recibir el request de la
     * peticion get enviada al servlet Rol
     * @param response en este parámetro vamos a recibir el response de la
     * peticion get enviada al servlet Rol que utlizaremos para enviar el jsp al
     * navegador web
     * @throws ServletException devolver una exception de un servlet
     * @throws IOException devolver una exception al leer o escribir un archivo
     */
    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Utilizar el método authorize de la clase SessionUser para validar que solo usuario con permiso
        // puedan acceder al servlet de Rol. Todo el codigo que este dentro  expresion Lambda, se ejecutara si el usuario tiene permitido
        // acceder a este Servlet 
        SessionUser.authorize(request, response, () -> { // Expresion Lambda  
            // Obtener el parámetro accion del request
            String accion = Utilidad.getParameter(request, "accion", "index");
            // Hacer un switch para decidir a cual metodo ir segun el valor que venga en el parámetro de accion.
            switch (accion) {
                case "index":
                    // Enviar el atributo accion al jsp de index.
                    request.setAttribute("accion", accion);
                    doGetRequestIndex(request, response); // Ir al método doGetRequestIndex.
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
     * Este método es un override al método de la clase HttpServlet para recibir
     * todas las peticiones post que se realice al Servlet Rol
     *
     * @param request en este parámetro vamos a recibir el request de la
     * peticion post enviada al servlet Rol
     * @param response en este parámetro vamos a recibir el response de la
     * peticion get enviada al servlet Rol que utlizaremos para enviar el jsp al
     * navegador web
     * @throws ServletException devolver una exception de un servlet
     * @throws IOException devolver una exception al leer o escribir un archivo
     */
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Utilizar el método authorize de la clase SessionUser para validar que solo usuario con permiso
        // puedan acceder al servlet de Rol. Todo el codigo que este dentro  expresion Lambda,  se ejecutara si el usuario tiene permitido
        // acceder a este Servlet 
        SessionUser.authorize(request, response, () -> {
            // Obtener el parámetro accion del request.
            String accion = Utilidad.getParameter(request, "accion", "index");
            // Hacer un switch para decidir a cual metodo ir segun el valor que venga en el parámetro de accion.
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
