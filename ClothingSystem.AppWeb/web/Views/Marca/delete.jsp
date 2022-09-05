<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clothingsystem.entidadesdenegocio.Marca"%>
<% Marca marca = (Marca) request.getAttribute("marca");%>
<!DOCTYPE html>
<html>
    <head>        
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Eliminar Marca</title>
         <link rel="icon" type="image/png" href="images/Logo.png">
    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />  
        <main class="container">   
            <h5>Eliminar Marca</h5>          
            <form action="Marca" method="post">
                <input type="hidden" name="accion" value="<%=request.getAttribute("accion")%>">   
                <input type="hidden" name="id" value="<%=marca.getId()%>">   
                <div class="row">
                    <div class="input-field col l4 s12">
                    <input disabled  id="txtNombre" type="text" value="<%=marca.getNombre()%>">
                    <label for="txtNombre">Nombre</label>
                </div>    

                <div class="input-field col l4 s12">   
                    <select id="slEstatus" name="estatus" disabled>
                        <option value="0" <%=(marca.getEstatus() == 10) ? "selected" : ""%>>SELECCIONAR</option>
                        <option value="<%=Marca.EstatusMarca.ACTIVO%>"  <%=(marca.getEstatus() == Marca.EstatusMarca.ACTIVO) ? "selected" : ""%>>ACTIVO</option>
                        <option value="<%=Marca.EstatusMarca.INACTIVO%>"  <%=(marca.getEstatus() == Marca.EstatusMarca.INACTIVO) ? "selected" : ""%>>INACTIVO</option>
                    </select>       
                    <label for="slEstatus">Estatus</label>
                    <span id="slEstatus_error" style="color:red" class="helper-text"></span>
                </div>

                <div class="input-field col l4 s12">
                    <input  id="txtDescripcion" type="text" value="<%=marca.getDescripcion()%>" disabled>
                    <label for="txtDescripcion">Descripcion</label>
                </div>     
                <div class="input-field col l4 s12">
                    <input  id="txtPaisOrigen" type="text" value="<%=marca.getPaisOrigen()%>" disabled>
                    <label for="txtPaisOrigen">PaisOrigen</label>
                </div> 
            </div>                                      
                </div>
                <div class="row">
                    <div class="col l12 s12">
                        <button type="sutmit" class="waves-effect waves-light btn blue"><i class="material-icons right">delete</i>Eliminar</button>
                        <a href="Marca" class="waves-effect waves-light btn blue"><i class="material-icons right">list</i>Cancelar</a>                          
                    </div>
                </div>
            </form>          
        </main>
        <jsp:include page="/Views/Shared/footerBody.jsp" />      
    </body>
</html>

