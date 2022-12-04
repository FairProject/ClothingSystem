<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clothingsystem.entidadesdenegocio.Producto"%>
<% Producto producto = (Producto) request.getAttribute("producto");%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Editar producto</title>
        <link rel="icon" type="image/png" href="images/Logo.png">
    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />  
        <main class="container">   
            <h5>Editar Producto</h5>

            <form action="Producto" method="post" onsubmit="return  validarFormulario()" enctype="multipart/form-data">
                <input type="hidden" name="accion" value="<%=request.getAttribute("accion")%>"> 
                <input type="hidden" name="id" value="<%=producto.getId()%>">  
                <div class="row">                       
                    <div class="input-field col l4 s12">
                        <input  id="txtDescripcion" type="text" name="descripcion" value="<%=producto.getDescripcion()%>" required class="validate" maxlength="75">
                        <label for="txtDescripcion">Descripcion</label>
                    </div>
                    <div class="input-field col l4 s12">
                        <input  id="txtPrecioVenta" type="text" name="precioVenta" value="<%=producto.getPrecioVenta()%> "required class="validate" maxlength="4,3">
                        <label for="txtPrecioVenta">PrecioVenta</label>
                    </div> 
                    <div class="input-field col l4 s12">
                        <input  id="txtExistencia" type="text" name="existencia" value="<%=producto.getExistencia()%>" required  class="validate">
                        <label for="txtExistencia">Existencia</label>
                    </div>                    
                    <div class="input-field col l4 s12">   
                        <select id="slEstatus" name="estatus" class="validate">
                            <option value="0" <%=(producto.getEstatus() == 10) ? "selected" : ""%>>SELECCIONAR</option>
                            <option value="<%=Producto.EstatusProducto.ENEXISTENCIA%>"  <%=(producto.getEstatus() == Producto.EstatusProducto.ENEXISTENCIA) ? "selected" : ""%>>EN EXISTENCIA</option>
                            <option value="<%=Producto.EstatusProducto.NOHAYEXISTENCIAS%>"  <%=(producto.getEstatus() == Producto.EstatusProducto.NOHAYEXISTENCIAS) ? "selected" : ""%>>NO HAY EXISTENCIAS</option>
                        </select>       
                        <label for="slEstatus">Estatus</label>
                        <span id="slEstatus_error" style="color:red" class="helper-text"></span> 
                    </div>   
                            <div class="input-field col l4 s12">   
                                <jsp:include page="/Views/Categoria/select.jsp">                           
                                    <jsp:param name="id" value="<%=producto.getIdCategoria()%>" />  
                                </jsp:include>  
                                <span id="slCategoria_error" style="color:red" class="helper-text"></span>
                            </div>
                        
                       
                            <div class="input-field col l4 s12">
                                <input type="file" id="myfile" name="foto"><br><br>
                            </div>
                       

                        <div class="row">
                            <div class=" col l12 s12">
                                <button type="sutmit" class="waves-effect waves-light btn blue"><i class="material-icons right">save</i>Guardar</button>
                                <a href="Producto" class="waves-effect waves-light btn black"><i class="material-icons right">list</i>Cancelar</a>                          
                            </div>
                        </div>          
                        </main>
                        <jsp:include page="/Views/Shared/footerBody.jsp" />   

                        </body>     
                        </html>
