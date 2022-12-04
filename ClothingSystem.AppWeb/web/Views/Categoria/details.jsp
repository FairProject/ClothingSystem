<%-- 
    Document   : details
    Created on : 28 ago 2022, 16:02:44
    Author     : Brenda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clothingsystem.entidadesdenegocio.Categoria"%>
<% Categoria categoria = (Categoria) request.getAttribute("categoria");%>
<!DOCTYPE html>
<html>
    <head>        
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Detalle de Categoria</title>
    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />  
        <main class="container">   
            <h5>Detalle de Categoria</h5>
            <div class="row">
                <div class="input-field col l4 s12">
                    <input disabled  id="txtNombre" type="text" value="<%=categoria.getNombre()%>">
                    <label for="txtNombre">Nombre</label>
                </div>        

                <div class="input-field col l4 s12">
                    <input  id="txtDescripcion" type="text" value="<%=categoria.getDescripcion()%>" disabled>
                    <label for="txtDescripcion">Descripcion</label>
                </div> 

                <div class="input-field col l4 s12">   
                    <select id="slEstatus" name="estatus" disabled>
                        <option value="0" <%=(categoria.getEstatus() == 10) ? "selected" : ""%>>SELECCIONAR</option>

                        <option value="<%=Categoria.EstatusCategoria.ENEXISTENCIA%>"  <%=(categoria.getEstatus() == Categoria.EstatusCategoria.ENEXISTENCIA) ? "selected" : ""%>>EN EXISTENCIA</option>
                        <option value="<%=Categoria.EstatusCategoria.NOHAYEXISTENCIAS%>"  <%=(categoria.getEstatus() == Categoria.EstatusCategoria.NOHAYEXISTENCIAS) ? "selected" : ""%>>NO HAY EXISTENCIAS</option>
                    </select>       
                    <label for="slEstatus">Estatus</label>                       
                </div>
                     
            </div>
                    <div class="row">
                    <div class="col l12 s12">
                         <a href="Categoria?accion=edit&id=<%=categoria.getId()%>" class="waves-effect waves-light btn blue"><i class="material-icons right">edit</i>Ir modificar</a>            
                        <a href="Categoria" class="waves-effect waves-light btn black"><i class="material-icons right">list</i>Cancelar</a>     
            </div>         
            </div>         
        </main>
        <jsp:include page="/Views/Shared/footerBody.jsp" />      
    </body>
</html>
