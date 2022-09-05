<%@page import="clothingsystem.entidadesdenegocio.RopaFoto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Crear RopaFoto</title>
         <link rel="icon" type="image/png" href="images/Logo.png">

    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />  
        <main class="container">   
            <h5>Crear RopaFoto</h5>
            <form action="RopaFoto" method="post" onsubmit="return  validarFormulario()">

                <input type="hidden" name="accion" value="<%=request.getAttribute("accion")%>">                
                <div class="row">
                    
                    <div class="input-field col l4 s12">
                        <input  id="txtUrl" type="text" name="url" required class="validate" maxlength="30">
                        <label for="txtUrl">Url</label>
                    </div> 
                    <div class="input-field col l4 s12">
                        <label>Url</label>
                        <input type="file" name="fileUrl">
                    </div>
                    
                    
                    <div class="input-field col l4 s12">   
                        <select id="slEstatus" name="estatus">
                            <option value="0">SELECCIONAR</option>
                            <option value="<%=RopaFoto.EstatusRopaFoto.ACTIVO%>">ACTIVO</option>
                            <option value="<%=RopaFoto.EstatusRopaFoto.INACTIVO%>">INACTIVO</option>
                        </select>       
                        <label for="slEstatus">Estatus</label>
                        <span id="slEstatus_error" style="color:red" class="helper-text"></span>
                    </div>
                </div> 
                <div class="input-field col l3 s12">   
                    <jsp:include page="/Views/Ropa/select.jsp">                           
                        <jsp:param name="id" value="0" />  
                    </jsp:include>  
                    <span id="slRopa_error" style="color:red" class="helper-text"></span>
                </div>
                <div class="row">
                    <div class="col l12 s12">
                        <button type="sutmit" class="waves-effect waves-light btn blue"><i class="material-icons right">save</i>Guardar</button>
                        <a href="RopaFoto" class="waves-effect waves-light btn blue"><i class="material-icons right">list</i>Cancelar</a>                          
                    </div>
                </div>
            </form>          
        </main>
        <jsp:include page="/Views/Shared/footerBody.jsp" />   
        <script>
            function validarFormulario() {
                var result = true;
                var fileUrl = document.getElementById("fileUrl");
                var slEstatus = document.getElementById("slEstatus");
                var slEstatus_error = document.getElementById("slEstatus_error");

                var slRopa = document.getElementById("slRopa");
                var slRopa_error = document.getElementById("slRopa_error");

                if (slEstatus.value == 0) {
                    slEstatus_error.innerHTML = "El estatus es obligatorio";
                    result = false;
                } else {
                    slEstatus_error.innerHTML = "";
                }
                if (slRopa.value == 0) {
                    slRopa_error.innerHTML = "La Ropa es obligatorio";
                    result = false;
                } else {
                    slRopa_error.innerHTML = "";
                }

                return result;
            }
        </script>
    </body>
</html>
