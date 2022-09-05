<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clothingsystem.entidadesdenegocio.Marca"%>
<% Marca marca = (Marca) request.getAttribute("marca");%>
<!DOCTYPE html>
<html>
    <head>        
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Editar Marca</title>
         <link rel="icon" type="image/png" href="images/Logo.png">

    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />  
        <main class="container">   
            <h5>Editar Marca</h5>
            <form action="Marca" method="post">
                <input type="hidden" name="accion" value="<%=request.getAttribute("accion")%>">   
                <input type="hidden" name="id" value="<%=marca.getId()%>">   

                <div class="row">

                    <div class="input-field col l4 s12">
                        <input  id="txtNombre" type="text" name="nombre" value="<%=marca.getNombre()%>" required class="validate" maxlength="30">
                        <label for="txtNombre">Nombre</label>
                    </div>                                       


                    <div class="input-field col l4 s12">   
                        <select id="slEstatus" name="estatus"  value="<%=marca.getEstatus()%>"class="validate">
                            <option value="0" <%=(marca.getEstatus() == 10) ? "selected" : ""%>>SELECCIONAR</option>
                            <option value="<%=Marca.EstatusMarca.ACTIVO%>"  <%=(marca.getEstatus() == Marca.EstatusMarca.ACTIVO) ? "selected" : ""%>>ACTIVO</option>
                            <option value="<%=Marca.EstatusMarca.INACTIVO%>"  <%=(marca.getEstatus() == Marca.EstatusMarca.INACTIVO) ? "selected" : ""%>>INACTIVO</option>
                        </select>       
                        <label for="slEstatus">Estatus</label>
                        <span id="slEstatus_error" style="color:red" class="helper-text"></span>
                    </div>

                    <div class="input-field col l4 s12">
                        <input  id="txtDescripcion" type="text" name="descripcion"  value="<%=marca.getDescripcion()%>" required class="validate" maxlength="30">
                        <label for="txtDescripcion">Descripcion</label>
                    </div>  

                    <div class="input-field col l4 s12">
                        <input  id="txtPaisOrigen" type="text" name="paisorigen" value="<%=marca.getPaisOrigen()%>" required class="validate" maxlength="30">
                        <label for="txtPaisOrigen">PaisOrigen</label>
                    </div> 
                </div> 



                <div class="row">
                    <div class="col l12 s12">
                        <button type="sutmit" class="waves-effect waves-light btn blue"><i class="material-icons right">save</i>Guardar</button>
                        <a href="Marca" class="waves-effect waves-light btn blue"><i class="material-icons right">list</i>Cancelar</a>                          
                    </div>
                </div>
            </form>          
        </main>
        <jsp:include page="/Views/Shared/footerBody.jsp" />      
    </body>
</html>
