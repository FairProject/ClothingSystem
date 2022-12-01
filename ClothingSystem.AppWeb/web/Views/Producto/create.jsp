<%-- 
    Document   : create
    Created on : 28 ago 2022, 08:55:52
    Author     : Cristopher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clothingsystem.entidadesdenegocio.Producto"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Crear Producto</title>
    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />  
        <main class="container">   
            <h5>Crear Producto</h5>
       
            <form action="Producto" method="post">
                <input type="hidden" name="accion" value="<%=request.getAttribute("accion")%>">                
                <div class="row">
                    <div class="input-field col l4 s12">
                        <input  id="txtCodigo" type="text" name="codigo" required class="validate" maxlength="25">
                        <label for="txtCodigo">Codigo</label>
                    </div>                       
                    <div class="input-field col l4 s12">
                        <input  id="txtDescripcion" type="text" name="descripcion" required class="validate" maxlength="75">
                        <label for="txtDescripcion">Descripcion</label>
                    </div> 
                    <div class="input-field col l4 s12">
                        <input  id="txtPrecioCompra" type="text" name="precioCompra" required class="validate" maxlength="4,2">
                        <label for="txtPrecioCompra">Precio Compra</label>
                    </div> 
                    <div class="input-field col l4 s12">
                        <input  id="txtPrecioVenta" type="text" name="precioVenta" required class="validate" maxlength="4,2">
                        <label for="txtPrecioVenta">Precio Venta</label>
                    </div> 
                    <div class="input-field col l4 s12">
                        <input  id="txtExistencia" type="text" name="existencia" required class="validate">
                        <label for="txtExistencia">Existencia</label>
                    </div> 
                    <div class="input-field col l4 s12">   
                        <select id="slEstatus" name="estatus" class="validate">
                            <option value="0">SELECCIONAR</option>
                            <option value="<%=Producto.EstatusProducto.ENEXISTENCIA%>">EN EXISTENCIA</option>
                            <option value="<%=Producto.EstatusProducto.NOHAYEXISTENCIAS%>">NO HAY EXISTENCIAS</option>
                        </select>       
                        <label for="slEstatus">Estatus</label>
                        <span id="slEstatus_error" style="color:red" class="helper-text"></span>
                    </div>
                   
                    <div class="input-field col l4 s12">
                        <input  id="txtFechaVencimiento" type="text" name="fechaVencimiento" required class="validate">
                        <label for="txtFechaVencimiento">Fecha Vencimiento</label>
                    </div>

                    <div class="input-field col l4 s12">
                        <input  id="txtComentario" type="text" name="comentario" required class="validate" maxlength="200">
                        <label for="txtComentario">Comentario</label>
                    </div> 
                    <div class="input-field col l4 s12">   
                        <jsp:include page="/Views/Categoria/select.jsp">                           
                            <jsp:param name="id" value="0" />  
                        </jsp:include>  
                        <span id="slCategoria_error" style="color:red" class="helper-text"></span>
                    </div>
                </div>

                <div class="row">
                    <div class="col l12 s12">
                        <button type="sutmit" class="waves-effect waves-light btn blue"><i class="material-icons right">save</i>Guardar</button>
                        <a href="Producto" class="waves-effect waves-light btn blue"><i class="material-icons right">list</i>Cancelar</a>                          
                    </div>
                </div>
            </form>          
        </main>
        <jsp:include page="/Views/Shared/footerBody.jsp" />   
    </body>
</html>
