<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clothingsystem.entidadesdenegocio.Ropa"%>
<% Ropa ropa = (Ropa) request.getAttribute("ropa");%>
<!DOCTYPE html>
<html>
    <head>        
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Eliminar Ropa</title>
    </head>
    <body class="#cfd8dc blue-grey lighten-4">
        <jsp:include page="/Views/Shared/headerBody.jsp" />  
        <main class="container">   
            <h5>Eliminar Ropa</h5>          
            <form action="Ropa" method="post">
                <input type="hidden" name="accion" value="<%=request.getAttribute("accion")%>">   
                <input type="hidden" name="id" value="<%=ropa.getId()%>">   
                <div class="row">
                   <div class="input-field col l4 s12">
                    <input  id="txtCodigoBarra" type="text"  value="<%=ropa.getCodigoBarra()%>" disabled>
                    <label for="txtCodigoBarra">CodigoBarra</label>
                </div>     
                <div class="input-field col l4 s12">
                    <input  id="txtNombre" type="text" value="<%=ropa.getNombre()%>" disabled>
                    <label for="txtNombre">Nombre</label>
                </div>                       
                <div class="input-field col l4 s12">
                    <input  id="txtPrecioCompra" type="text"  value="<%=ropa.getPrecioCompra()%>" disabled>
                    <label for="txtPrecioCompra">PrecioCompra</label>
                </div> 
                <div class="input-field col l4 s12">
                    <input  id="txtPrecioVenta" type="text" value="<%=ropa.getPrecioVenta()%>" disabled>
                    <label for="txtPrecioVenta">PrecioVenta</label>
                </div> 
                <div class="input-field col l4 s12">
                    <input  id="txtExistencia" type="text"  value="<%=ropa.getExistencia()%>" disabled>
                    <label for="txtExistencia">Existencia</label>
                </div> 
                <div class="input-field col l4 s12">   
                    <select id="slEstatus" name="estatus" disabled>
                        <option value="0" <%=(ropa.getEstatus() == 10) ? "selected" : ""%>>SELECCIONAR</option>
                        <option value="<%=Ropa.EstatusRopa.ACTIVO%>"  <%=(ropa.getEstatus() == Ropa.EstatusRopa.ACTIVO) ? "selected" : ""%>>ACTIVO</option>
                        <option value="<%=Ropa.EstatusRopa.INACTIVO%>"  <%=(ropa.getEstatus() == Ropa.EstatusRopa.INACTIVO) ? "selected" : ""%>>INACTIVO</option>
                    </select>       
                    <label for="slEstatus">Estatus</label>
                    <span id="slEstatus_error" style="color:red" class="helper-text"></span>
                </div>

                <div class="input-field col l4 s12">
                    <input  id="txtTalla" type="text" value="<%=ropa.getTalla()%>" disabled>
                    <label for="txtTalla">Talla</label>
                </div>     

                <div class="input-field col l4 s12">
                    <input  id="txtColor" type="text" value="<%=ropa.getColor()%>" disabled>
                    <label for="txtColor">Color</label>
                </div>     
                <div class="input-field col l4 s12">
                    <input  id="txtEstilo" type="text" value="<%=ropa.getEstilo()%>"  disabled>
                    <label for="txtEstilo">Estilo</label>
                </div>   
                <div class="input-field col l4 s12">
                    <input  id="txtDescripcion" type="text" value="<%=ropa.getDescripcion()%>" disabled>
                    <label for="txtDescripcion">Descripcion</label>
                </div>     
                <div class="input-field col l4 s12">
                    <input  id="txtTipoTela" type="text" value="<%=ropa.getTipoTela()%>" disabled>
                    <label for="txtTipoTela">TipoTela</label>
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

