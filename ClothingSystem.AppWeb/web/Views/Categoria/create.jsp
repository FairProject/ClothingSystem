<%-- 
    Document   : create
    Created on : 28 ago 2022, 16:01:52
    Author     : Brenda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clothingsystem.entidadesdenegocio.Categoria"%>
<!DOCTYPE html>
<html>
    <head>        
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Crear Categoría</title>
    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />  
        <main class="container">   
            <h5>Crear Categoría</h5>
            <form action="Categoria" method="post">
                <input type="hidden" name="accion" value="<%=request.getAttribute("accion")%>">                
                <div class="row">
                    <div class="input-field col l4 s12">
                        <input  id="txtNombre" type="text" name="nombre" required class="validate" maxlength="30">
                        <label for="txtNombre">Nombre</label>
                    </div>                                      
                    <div class="input-field col l4 s12">
                        <input  id="txtDescripcion" type="text" name="descripcion" required class="validate" maxlength="30">
                        <label for="txtDescripcion">Descripción</label>
                    </div> 
                    <div class="input-field col l4 s12">
                        <input  id="txtComentario" type="text" name="comentario" required class="validate" maxlength="25">
                        <label for="txtCometario">Comentario</label>


                    <div class="input-field col l0 s8">
                            <select id="slEstatus" name="estatus" class="validate">
                                <option value="0">SELECCIONAR</option>
                                <option value="<%=Categoria.EstatusCategoria.ENEXISTENCIA%>">EN EXISTENCIA</option>
                                <option value="<%=Categoria.EstatusCategoria.NOHAYEXISTENCIAS%>">NO HAY EXISTENCIAS</option>
                            </select>       
                            <label for="slEstatus">Estatus</label>
                            <span id="slEstatus_error" style="color:red" class="helper-text"></span>
                        </div>
                     
                    </div>
                    <div class="row">
                        <div class="col l12 s12">
                            <button type="sutmit" class="waves-effect waves-light btn green"><i class="material-icons right">save</i>Guardar</button>
                            <a href="Categoria" class="waves-effect waves-light btn red"><i class="material-icons right">list</i>Cancelar</a>                          
                        </div>
                    </div>                           
            </form>          
        </main>
        <jsp:include page="/Views/Shared/footerBody.jsp" />      
    </body>
</html>