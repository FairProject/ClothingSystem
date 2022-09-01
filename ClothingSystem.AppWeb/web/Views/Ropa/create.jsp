<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clothingsystem.entidadesdenegocio.Ropa"%>
<!DOCTYPE html>
<html>
    <head>        
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Crear Ropa</title>
    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />  
        <main class="container">   
            <h5>Crear Ropa</h5>
            <form action="Ropa" method="post">
                <input type="hidden" name="accion" value="<%=request.getAttribute("accion")%>">                
                <div class="row">

                    <div class="input-field col l4 s12">
                        <input  id="txtCodigoBarra" type="text" name="codigobarra" required class="validate" maxlength="30">
                        <label for="txtCodigoBarra">CodigoBarra</label>
                    </div>     
                    <div class="input-field col l4 s12">
                        <input  id="txtNombre" type="text" name="nombre" required class="validate" maxlength="30">
                        <label for="txtNombre">Nombre</label>
                    </div>                       
                    <div class="input-field col l4 s12">
                        <input  id="txtPrecioCompra" type="text" name="preciocompra" required class="validate" maxlength="30">
                        <label for="txtPrecioCompra">PrecioCompra</label>
                    </div> 
                    <div class="input-field col l4 s12">
                        <input  id="txtPrecioVenta" type="text" name="precioventa" required class="validate" maxlength="25">
                        <label for="txtPrecioVenta">PrecioVenta</label>
                    </div> 
                    <div class="input-field col l4 s12">
                        <input  id="txtExistencia" type="text" name="existencia" required class="validate" maxlength="32">
                        <label for="txtExistencia">Existencia</label>
                    </div> 
                    <div class="input-field col l4 s12">   
                        <select id="slEstatus" name="estatus" class="validate">
                            <option value="0">SELECCIONAR</option>
                            <option value="<%=Ropa.EstatusRopa.ACTIVO%>">ACTIVO</option>
                            <option value="<%=Ropa.EstatusRopa.INACTIVO%>">INACTIVO</option>
                        </select>       
                        <label for="slEstatus">Estatus</label>
                        <span id="slEstatus_error" style="color:red" class="helper-text"></span>
                    </div>

                    <div class="input-field col l4 s12">
                        <input  id="txtTalla" type="text" name="talla" required class="validate" maxlength="30">
                        <label for="txtTalla">Talla</label>
                    </div>     

                    <div class="input-field col l4 s12">
                        <input  id="txtColor" type="text" name="color" required class="validate" maxlength="30">
                        <label for="txtColor">Color</label>
                    </div>     
                    <div class="input-field col l4 s12">
                        <input  id="txtEstilo" type="text" name="estilo" required class="validate" maxlength="30">
                        <label for="txtEstilo">Estilo</label>
                    </div>   
                    <div class="input-field col l4 s12">
                        <input  id="txtDescripcion" type="text" name="descripcion" required class="validate" maxlength="30">
                        <label for="txtDescripcion">Descripcion</label>
                    </div>     
                    <div class="input-field col l4 s12">
                        <input  id="txtTipoTela" type="text" name="tipotela" required class="validate" maxlength="30">
                        <label for="txtTipoTela">TipoTela</label>
                    </div>  

                    <div class="input-field col l4 s12">   
                        <jsp:include page="/Views/Marca/select.jsp">                           
                            <jsp:param name="id" value="0" />  
                        </jsp:include>  
                        <span id="slRol_error" style="color:red" class="helper-text"></span>
                    </div>
                </div>

                <div class="row">
                    <div class="col l12 s12">
                        <button type="sutmit" class="waves-effect waves-light btn blue"><i class="material-icons right">save</i>Guardar</button>
                        <a href="Ropa" class="waves-effect waves-light btn blue"><i class="material-icons right">list</i>Cancelar</a>                          
                    </div>
                </div>
            </form>          
        </main>
        <jsp:include page="/Views/Shared/footerBody.jsp" />   
        <script>
            function validarFormulario() {
                var result = true;
                var txtCodigoBarra = document.getElementById("txtCodigoBarra");
                var txtNombre = document.getElementById("txtNombre");
                var txtPrecioCompra = document.getElementById("txtPrecioCompra");
                 var txtPrecioVenta = document.getElementById("txtPrecioVenta");
                  var txtExistencia = document.getElementById("txtExistencia");
                var slEstatus = document.getElementById("slEstatus");
                var slEstatus_error = document.getElementById("slEstatus_error");
                var txtTalla = document.getElementById("txtTalla");
                var txtColor = document.getElementById("txtColor");
                var txtEstilo = document.getElementById("txtEstilo");
                var txtDescripcion = document.getElementById("txtDescripcio");
                var txtTipoTela = document.getElementById("txtTipoTela");
                
                var slMarca = document.getElementById("slMarca");
                var slMarca_error = document.getElementById("slMarca_error");
                
                if (slEstatus.value == 0) {
                    slEstatus_error.innerHTML = "El estatus es obligatorio";
                    result = false;
                } else {
                    slEstatus_error.innerHTML = "";
                }
                if (slMarca.value == 0) {
                    slMarca_error.innerHTML = "La Marca es obligatorio";
                    result = false;
                } else {
                    slMarca_error.innerHTML = "";
                }

                return result;
            }
        </script>
    </body>
</html>

