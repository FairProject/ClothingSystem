<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clothingsystem.entidadesdenegocio.Ropa"%>
<% Ropa ropa = (Ropa) request.getAttribute("ropa");%>
<!DOCTYPE html>
<html>
    <head>        
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Eliminar Ropa</title>
         <link rel="icon" type="image/png" href="images/Logo.png">
    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />  
        <main class="container">   
            <h5>Eliminar Ropa</h5>          
            <form action="Ropa" method="post">
                <input type="hidden" name="accion" value="<%=request.getAttribute("accion")%>">   
                <input type="hidden" name="id" value="<%=ropa.getId()%>">   
                  
                <div class="input-field col l4 s12">
                    <input  id="txtNombre" type="text" value="<%=ropa.getNombre()%>" disabled>
                    <label for="txtNombre">Nombre</label>
                </div>                       
              
                <div class="input-field col l4 s12">
                    <input  id="txtPrecioVenta" type="text" value="<%=ropa.getPrecioVenta()%>" disabled>
                    <label for="txtPrecioVenta">PrecioVenta</label>
                </div> 
               
                <div class="input-field col l4 s12">
                    <input  id="txtDescripcion" type="text" value="<%=ropa.getDescripcion()%>" disabled>
                    <label for="txtDescripcion">Descripcion</label>
                </div>     
                <div class="input-field col l4 s12">
                    <input  id="txtMarca" type="text" value="<%=ropa.getMarca().getNombre() %>" disabled>
                    <label for="txtMarca">Marca</label>
                </div>                                        
                </div>
                <div class="row">
                    <div class="col l12 s12">
                        <button type="sutmit" class="waves-effect waves-light btn blue"><i class="material-icons right">delete</i>Eliminar</button>
                        <a href="Ropa" class="waves-effect waves-light btn blue"><i class="material-icons right">list</i>Cancelar</a>                          
                    </div>
                </div>
            </form>          
        </main>
        <jsp:include page="/Views/Shared/footerBody.jsp" />      
    </body>
</html>

