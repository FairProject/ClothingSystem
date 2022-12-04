<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clothingsystem.entidadesdenegocio.Ropa"%>
<% Ropa ropa = (Ropa) request.getAttribute("ropa");%>
<!DOCTYPE html>
<html>
    <head>        
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Editar Ropa</title>
        <link rel="icon" type="image/png" href="images/Logo.png">

    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />  
        <main class="container">   
            <h5>Editar Ropa</h5>
            <form action="Ropa" method="post" onsubmit="return  validarFormulario()">
                <input type="hidden" name="accion" value="<%=request.getAttribute("accion")%>">   
                <input type="hidden" name="id" value="<%=ropa.getId()%>">   

                <div class="row">

                    <div class="input-field col l4 s12">
                        <input  id="txtNombre" type="text" name="nombre" value="<%=ropa.getCodigoBarra()%>" required class="validate" maxlength="30">
                        <label for="txtNombre">Nombre</label>
                    </div>                       

                    <div class="input-field col l4 s12">
                        <input  id="txtPrecioVenta" type="text" name="precioventa" value="<%=ropa.getPrecioVenta()%>" required class="validate" maxlength="25">
                        <label for="txtPrecioVenta">PrecioVenta</label>
                    </div> 

                    <div class="input-field col l4 s12">
                        <input  id="txtDescripcion" type="text" name="descripcion"  value="<%=ropa.getDescripcion()%>" required class="validate" maxlength="30">
                        <label for="txtDescripcion">Descripcion</label>
                    </div>     


                    <div class="input-field col l4 s12">   
                        <jsp:include page="/Views/Marca/select.jsp">                           
                            <jsp:param name="id" value="0" />  
                        </jsp:include>  
                        <span id="slMarca_error" style="color:red" class="helper-text"></span>
                    </div>
                </div>

                <div class="row">
                    <div class="col l12 s12">
                        <button type="sutmit" class="waves-effect waves-light btn blue"><i class="material-icons right">save</i>Guardar</button>
                        <a href="Ropa" class="waves-effect waves-light btn black"><i class="material-icons right">list</i>Cancelar</a>                          
                    </div>
                </div>
            </form>          
        </main>
        <jsp:include page="/Views/Shared/footerBody.jsp" />     

        <script>
            function validarFormulario() {
                var result = true;
                var txtNombre = document.getElementById("txtNombre");
                var txtDescripcion = document.getElementById("txtDescripcion");

                var slMarca = document.getElementById("slMarca");
                var slMarca_error = document.getElementById("slMarca_error");

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
