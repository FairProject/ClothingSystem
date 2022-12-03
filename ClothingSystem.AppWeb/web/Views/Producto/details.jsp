<%-- 
    Document   : details
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
        <title>Detalle del Producto</title>
         <link rel="icon" type="image/png" href="images/Logo.png">
    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />  
        <main class="container">   
            <h5>Detalle del Producto</h5>
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
                    <input  id="txtExistencia" type="text" value="<%=producto.getExistencia()%>" disabled>
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
                    <input  id="txtFechaCreacion" type="text" value="<%=producto.getFechaCreacion()%>" disabled>
                    <label for="txtFechaCreacion">Fecha Creacion</label>
                </div>
                <div class="input-field col l4 s12">
                    <input  id="txtFechaVencimiento" type="text" value="<%=producto.getFechaVencimiento()%>" disabled>
                    <label for="txtFechaVencimiento">Fecha Vencimiento</label>
                </div>
                <div class="input-field col l4 s12">
                    <input  id="txtComentario" type="text" value="<%=producto.getComentario()%>" disabled>
                    <label for="txtComentario">Comentario</label>
                </div>  
                <div class="input-field col l4 s12">
                    <input id="txtCategoria" type="text" value="<%=producto.getCategoria().getNombre()%>" disabled>
                    <label for="txtCategoria">Categoria</label>
                </div> 
                <div class="input-field col l4 s12">
                    <td><img width="90%" height="90%" src="<%=producto.getFoto()%>" /></td>
                </div>
            </div>

            <div class="row">
                <div class="col l12 s12">
                    <a href="Producto?accion=edit&id=<%=producto.getId()%>" class="waves-effect waves-light btn blue"><i class="material-icons right">edit</i>Ir modificar</a>            
                    <a href="Producto" class="waves-effect waves-light btn blue"><i class="material-icons right">list</i>Cancelar</a>                          
                </div>
            </div>          
        </main>
        <jsp:include page="/Views/Shared/footerBody.jsp" />   
    </body>
</html>
