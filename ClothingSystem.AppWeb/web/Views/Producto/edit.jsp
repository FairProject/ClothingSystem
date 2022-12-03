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
                        <input  id="txtCodigo" type="text" name="codigo" value="<%=producto.getCodigo()%>" required class="validate" maxlength="25">
                        <label for="txtCodigo">Codigo</label>
                    </div>                       
                    <div class="input-field col l4 s12">
                        <input  id="txtDescripcion" type="text" name="descripcion" value="<%=producto.getDescripcion()%>" required class="validate" maxlength="75">
                        <label for="txtDescripcion">Descripcion</label>
                    </div>
                    <div class="input-field col l4 s12">
                        <input  id="txtPrecioCompra" type="text" name="precioCompra" value="<%=producto.getPrecioCompra()%> "required class="validate" maxlength="4,3">
                        <label for="txtPrecioCompra">PrecioCompra</label>
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
                        <input  id="txtComentario" type="text" name="comentario" value="<%=producto.getComentario()%>" required  class="validate">
                        <label for="txtCometario">Comentario</label>
                    </div> 
                    <div class="input-field col l4 s12">   
                        <select id="slEstatus" name="estatus" class="validate">
                            <option value="0" <%=(producto.getEstatus() == 10) ? "selected" : ""%>>SELECCIONAR</option>
                            <option value="<%=Producto.EstatusProducto.ENEXISTENCIA%>"  <%=(producto.getEstatus() == Producto.EstatusProducto.ENEXISTENCIA) ? "selected" : ""%>>EN EXISTENCIA</option>
                            <option value="<%=Producto.EstatusProducto.NOHAYEXISTENCIAS%>"  <%=(producto.getEstatus() == Producto.EstatusProducto.NOHAYEXISTENCIAS) ? "selected" : ""%>>NO HAY EXISTENCIAS</option>
                        </select>       
                        <label for="slEstatus">Estatus</label>
                        <span id="slEstatus_error" style="color:red" class="helper-text"></span> 

                        <div class="input-field col l4 s12">   
                            <jsp:include page="/Views/Categoria/select.jsp">                           
                                <jsp:param name="id" value="<%=producto.getIdCategoria()%>" />  
                            </jsp:include>  
                            <span id="slCategoria_error" style="color:red" class="helper-text"></span>
                        </div>

                        <div class="input-field col l8 s12">
                            <img id="imgPreview" width="40%" height="40%"/>
                            <div class="file-field input-field">
                                <div class="btn">
                                    <span>Selecciona una imagen</span>
                                    <input type="file" name="Foto" onchange="previewImage(event, '#imgPreview')"">
                                </div>
                                <div class="file-path-wrapper">
                                    <input class="file-path validate" type="text">
                                </div>
                            </div>
                        </div>


                        <div class="row">
                            <div class="col l12 s12">
                                <button type="sutmit" class="waves-effect waves-light btn blue"><i class="material-icons right">save</i>Guardar</button>
                                <a href="Producto" class="waves-effect waves-light btn blue"><i class="material-icons right">list</i>Cancelar</a>                          
                            </div>
                        </div>          
                        </main>
                        <jsp:include page="/Views/Shared/footerBody.jsp" />   
                       
       </body>     
        <script>
               function previewImage(event, querySelector){

	//Recuperamos el input que desencadeno la acción
	const input = event.target;
	
	//Recuperamos la etiqueta img donde cargaremos la imagen
	$imgPreview = document.querySelector(querySelector);

	// Verificamos si existe una imagen seleccionada
	if(!input.files.length) return
	
	//Recuperamos el archivo subido
	file = input.files[0];

	//Creamos la url
	objectURL = URL.createObjectURL(file);
	
	//Modificamos el atributo src de la etiqueta img
	$imgPreview.src = objectURL;
                
}
            </script>
</html>
