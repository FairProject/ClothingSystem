<%-- 
    Document   : delete
    Created on : 28 ago 2022, 08:55:52
    Author     : Cristopher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clothingsystem.entidadesdenegocio.Producto"%>
<% Producto producto = (Producto) request.getAttribute("producto");%>
<!DOCTYPE html>
<html>
       <head>        
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Eliminar Producto</title>
    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />  
        <main class="container">   
            <h5>Eliminar Producto</h5>
            <form action="Producto" method="post">  
                <input type="hidden" name="accion" value="<%=request.getAttribute("accion")%>"> 
                <input type="hidden" name="id" value="<%=producto.getId()%>">  
                <div class="row">
                    <div class="input-field col l4 s12">
                        <input  id="txtCodigo" type="text" value="<%=producto.getCodigo()%>" disabled>
                        <label for="txtCodigo">Codigo</label>
                    </div>                       
                    <div class="input-field col l4 s12">
                        <input  id="txtDescripcion" type="text" value="<%=producto.getDescripcion()%>" disabled>
                        <label for="txtDescripcion">Descripcion</label>
                    </div> 
                        <div class="input-field col l4 s12">
                        <input  id="txtPrecioCompra" type="text" value="<%=producto.getPrecioCompra()%>" disabled>
                        <label for="txtPrecioCompra">Precio Compra</label>
                    </div> 
                        <div class="input-field col l4 s12">
                        <input  id="txtPrecioVenta" type="text" value="<%=producto.getPrecioVenta()%>" disabled>
                        <label for="txtPrecioVenta">Precio Venta</label>
                    </div> 
                        <div class="input-field col l4 s12">
                        <input  id="txt" type="text" value="<%=producto.getExistencia()%>" disabled>
                        <label for="txtExistencia">Existencia</label>
                    </div>                    
                    <div class="input-field col l4 s12">   
                        <select id="slEstatus" name="estatus" disabled>
                            <option value="0" <%=(producto.getEstatus() == 10) ? "selected" : ""%>>SELECCIONAR</option>
                            <option value="<%=Producto.EstatusProducto.ENEXISTENCIA%>"  <%=(producto.getEstatus() == Producto.EstatusProducto.ENEXISTENCIA) ? "selected" : ""%>>EN EXISTENCIA</option>
                            <option value="<%=Producto.EstatusProducto.NOHAYEXISTENCIAS%>"  <%=(producto.getEstatus() == Producto.EstatusProducto.NOHAYEXISTENCIAS) ? "selected" : ""%>>NO HAY EXISTENCIAS</option>
                        </select>       
                        <label for="slEstatus">Estatus</label>                       
                    </div>
                        <div class="input-field col l4 s12">
                        <input  id="txtComentario" type="text" value="<%=producto.getComentario()%>" disabled>
                        <label for="txtComentario">Comentario</label>
                    </div>  
                    <div class="input-field col l4 s12">
                        <input id="txtCategoria" type="text" value="<%=producto.getCategoria().getNombre()%>" disabled>
                        <label for="txtCategoria">Categoria</label>
                    </div> 
                </div>
                <div class="row">
                    <div class="col l12 s12">
                        <button type="sutmit" class="waves-effect waves-light btn blue"><i class="material-icons right">delete</i>Eliminar</button>
                        <a href="Producto" class="waves-effect waves-light btn blue"><i class="material-icons right">list</i>Cancelar</a>                          
                    </div>
                </div>
            </form>          
        </main>
        <jsp:include page="/Views/Shared/footerBody.jsp" />   
    </body>
</html>
    