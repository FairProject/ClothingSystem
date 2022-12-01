/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package clothingsystem.appweb.controllers;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import clothingsystem.accesoadatos.CategoriaDAL;

import clothingsystem.entidadesdenegocio.Categoria;
import clothingsystem.appweb.utils.*;
/**
 *
 * @author Brenda
 */
@WebServlet(name = "CategoriaServlet", urlPatterns = {"/Categoria"})
public class CategoriaServlet extends HttpServlet {

   // <editor-fold defaultstate="collapsed" desc="Metodos para procesar las solicitudes get o post del Servlet">
    /**
     * En este método vamos a obtener la información enviada, en una peticion
     * get o post, obteniendo los datos de los parámetros enviados de un
     * formulario o la url del navegador, enviar esa información a una instancia
     * de la entidad Categoria
     *
     * @param request en este parámetro vamos a recibir el request de la
     * peticion get o post enviada al servlet Categoria
     * @return Usuario devolver la instancia de la entidad Categoria con los
     * valores obtenidos del request
     */
    private Categoria obtenerCategoria(HttpServletRequest request) {
        // Obtener el parámetro accion del request
        String accion = Utilidad.getParameter(request, "accion", "index");
        Categoria categoria = new Categoria();
                    categoria.setId(Integer.parseInt(Utilidad.getParameter(request, "id", "0")));

        // Obtener el parámetro nombre del request  y asignar ese valor a la propiedad Nombre de Categoria.
        categoria.setNombre(Utilidad.getParameter(request, "nombre", ""));
        // Obtener el parámetro descripcion del request  y asignar ese valor a la propiedad Descripcion de Categoria.
        categoria.setDescripcion(Utilidad.getParameter(request, "descripcion", ""));    
         // Obtener el parámetro descripcion del request  y asignar ese valor a la propiedad Descripcion de Categoria.
        categoria.setComentario(Utilidad.getParameter(request, "comentario", "")); 
        // Obtener el parámetro estatus del request  y asignar ese valor a la propiedad Estatus de Categoria.
        categoria.setEstatus(Byte.parseByte(Utilidad.getParameter(request, "estatus", "0")));
        if (accion.equals("index")) {
            // Obtener el parámetro top_aux del request  y asignar ese valor a la propiedad Top_aux de Categoria.
            categoria.setTop_aux(Integer.parseInt(Utilidad.getParameter(request, "top_aux", "10")));
            categoria.setTop_aux(categoria.getTop_aux() == 0 ? Integer.MAX_VALUE : categoria.getTop_aux());
        }
     
        // Devolver la instancia de la entidad Usuario con los valores obtenidos del request.
        return categoria;
    }

    /**
     * En este método se ejecutara cuando se envie una peticion get al servlet
     * Categoria, y el parametro accion sea igual index. Este método se encargara
     * de enviar los datos de los categorias al jsp de index de Categoria.
     *
     * @param request en este parámetro vamos a recibir el request de la
     * peticion get enviada al servlet Categoria
     * @param response en este parámetro vamos a recibir el response de la
     * peticion get enviada al servlet Categoria que utlizaremos para enviar el
     * jsp
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doGetRequestIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Categoria categoria = new Categoria(); // Crear una instancia  de la entidad de Categoria.
            categoria.setTop_aux(10); // Agregar el Top_aux con el valor de 10 a la propiedad Top_aux de Categoria.
 ArrayList<Categoria> categorias = CategoriaDAL.buscar(categoria);            
// Enviar los usuarios al jsp utilizando el request.setAttribute con el nombre del atributo categoria.
            request.setAttribute("categorias", categorias);
            // Enviar el Top_aux de Categoria al jsp utilizando el request.setAttribute con el nombre del atributo top_aux.
            request.setAttribute("top_aux", categoria.getTop_aux());
            request.getRequestDispatcher("Views/Categoria/index.jsp").forward(request, response); // Direccionar al jsp index de Categoria.
        } catch (Exception ex) {
            Utilidad.enviarError(ex.getMessage(), request, response); // Enviar al jsp de error si hay un Exception.
        }
    }

    /**
     * En este método se ejecutara cuando se envie una peticion post, al servlet
     * Categoria , y el parámetro accion sea igual index. Este método se encargara
     * de enviar los datos de los usuarios al jsp de index de Categoria
     *
     * @param request en este parámetro vamos a recibir el request de la
     * peticion post enviada al servlet Categoria
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doPostRequestIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
            try {
            Categoria categoria = obtenerCategoria(request); // Llenar la instancia de Categoria con los parámetros enviados en el request 
            ArrayList<Categoria> categorias = CategoriaDAL.buscar(categoria); // Buscar los roles que cumple con los datos enviados en el request
            request.setAttribute("categorias", categorias); // Enviar los roles al jsp utilizando el request.setAttribute con el nombre del atributo categorias
            // Enviar el Top_aux de Categoria al jsp utilizando el request.setAttribute con el nombre del atributo top_aux
            request.setAttribute("top_aux", categoria.getTop_aux());
            request.getRequestDispatcher("Views/Categoria/index.jsp").forward(request, response); // Direccionar al jsp index de Categoria
        } catch (Exception ex) {
            // Enviar al jsp de error si hay un Exception 
            Utilidad.enviarError(ex.getMessage(), request, response);
        }
    

    }

    /**
     * En este método se ejecutara cuando se envie una peticion get al servlet
     * Usuario, y el parámetro accion sea igual create.
     *
     * @param request en este parámetro vamos a recibir el request de la
     * peticion get enviada al servlet Categoria
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doGetRequestCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // direccionar al jsp create de Categoria
        request.getRequestDispatcher("Views/Categoria/create.jsp").forward(request, response);
    }

    /**
     * En este método se ejecutara cuando se envie una peticion post al servlet
     * Categoria , y el parámetro accion sea igual create.
     *
     * @param request en este parámetro vamos a recibir el request de la
     * peticion post enviada al servlet Categoria
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doPostRequestCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Categoria categoria = obtenerCategoria(request); // Llenar la instancia de Usuario con los parámetros enviados en el request
            // Enviar los datos de Categoria a la capa de accesoa a datos para que lo almacene en la base de datos el registro.
            int result = CategoriaDAL.crear(categoria);
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
     * En este método obtiene por Id un Categoria desde la capa de acceso a datos
     * el Id se captura del request que se envio al servlet de Categoria
     *
     * @param request en este parámetro vamos a recibir el request de la
     * peticion get o post enviada al servlet Categoria
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void requestObtenerPorId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Categoria categoria = obtenerCategoria(request); // Llenar la instancia de Rol con los parámetros enviados en el request.
            // Obtener desde la capa de acceso a datos el rol por Id.
            Categoria categoria_result = CategoriaDAL.obtenerPorId(categoria);
            if (categoria_result.getId() > 0) { // Si el Id es mayor a cero.
                // Enviar el atributo rol con el valor de los datos del rol de nuestra base de datos a un jsp
                request.setAttribute("categoria", categoria_result);
            } else {
                // Enviar al jsp de error el siguiente mensaje. El Id: ? no existe en la tabla de Rol
                Utilidad.enviarError("El Id:" + categoria.getId() + " no existe en la tabla de Categoria", request, response);
            }
        } catch (Exception ex) {
            // enviar al jsp de error si hay un Exception
            Utilidad.enviarError(ex.getMessage(), request, response);
        }
    }


    /**
     * En este método se ejecutara cuando se envie una peticion get al servlet
     * Categoria , y el parámetro accion sea igual edit.
     *
     * @param request en este parámetro vamos a recibir el request de la
     * peticion get enviada al servlet Categoria
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doGetRequestEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Enviar el usuario al jsp de edit que se obtiene por Id
        requestObtenerPorId(request, response);
        // Direccionar al jsp edit de Categoria
        request.getRequestDispatcher("Views/Categoria/edit.jsp").forward(request, response);
    }

    /**
     * En este método se ejecutara cuando se envie una peticion post al servlet
     * Categoria , y el parámetro accion sea igual edit.
     *
     * @param request en este parámetro vamos a recibir el request de la
     * peticion post enviada al servlet Usuario
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doPostRequestEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Categoria categoria = obtenerCategoria(request); // Llenar la instancia de Categoria con los parámetros enviados en el request.
            // Enviar los datos de Categoria a la capa de accesoa a datos para modificar el registro.
            int result = CategoriaDAL.modificar(categoria);
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
     * En este método se ejecutara cuando se envie una peticion get al servlet
     * Categoria , y el parámetro accion sea igual details.
     *
     * @param request en este parámetro vamos a recibir el request de la
     * peticion get enviada al servlet Usuario
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doGetRequestDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Enviar categoria al jsp de details que se obtiene por Id.
        requestObtenerPorId(request, response);
        // Direccionar al jsp details de Categoria.
        request.getRequestDispatcher("Views/Categoria/details.jsp").forward(request, response);
    }

    /**
     * En este método se ejecutara cuando se envie una peticion get al servlet
     * Categoria , y el parámetro accion sea igual delete.
     *
     * @param request en este parámetro vamos a recibir el request de la
     * peticion get enviada al servlet Categoria
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doGetRequestDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Enviar el categoria al jsp de delete que se obtiene por Id.
        requestObtenerPorId(request, response);
        // Direccionar al jsp delete de Categoria.
        request.getRequestDispatcher("Views/Categoria/delete.jsp").forward(request, response);
    }

    /**
     * En este método se ejecutara cuando se envie una peticion post al servlet
     * Categoria , y el parámetro accion sea igual delete.
     *
     * @param request en este parámetro vamos a recibir el request de la
     * peticion post enviada al servlet Categoria
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void doPostRequestDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Categoria categoria = obtenerCategoria(request); // Llenar la instancia de Categoria con los parámetros enviados en el request.
            // Enviar los datos de Categoria a la capa de accesoa a datos para que elimine el registro.
            int result = CategoriaDAL.eliminar(categoria);
            if (result != 0) { // Si el result es diferente a cero significa que los datos fueron eliminados correctamente.
                // Enviar el atributo accion con el valor index al jsp de index.
                request.setAttribute("accion", "index");
                doGetRequestIndex(request, response);  // Ir al método doGetRequestIndex para que nos direccione al jsp index.
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
       * Este método es un override al método de la clase HttpServlet para recibir
     * todas las peticiones get que se realice al Servlet Categoria
     *
     * @param request en este parámetro vamos a recibir el request de la
     * peticion get enviada al servlet Categoria
     * @param response en este parámetro vamos a recibir el response de la
     * peticion get enviada al servlet Categoria que utlizaremos para enviar el jsp al
     * navegador web
     * @throws ServletException devolver una exception de un servlet
     * @throws IOException devolver una exception al leer o escribir un archivo
     */
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Utilizar el método authorize de la clase SessionUser para validar que solo usuario con permiso
        // puedan acceder al servlet de Categoria. Todo el codigo que este dentro  expresion Lambda, se ejecutara si el categoria tiene permitido
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
     * todas las peticiones post que se realice al Servlet Categoria
     *
     * @param request en este parámetro vamos a recibir el request de la
     * peticion post enviada al servlet Categoria
     * @param response en este parámetro vamos a recibir el response de la
     * peticion get enviada al servlet Rol que utlizaremos para enviar el jsp al
     * navegador web
     * @throws ServletException devolver una exception de un servlet
     * @throws IOException devolver una exception al leer o escribir un archivo
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Utilizar el método authorize de la clase SessionUser para validar que solo Categoria con permiso
        // puedan acceder al servlet de Categoria. Todo el codigo que este dentro  expresion Lambda,  se ejecutara si categoria tiene permitido
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
