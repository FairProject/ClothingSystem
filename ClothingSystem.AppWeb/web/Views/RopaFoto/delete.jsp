<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clothingsystem.entidadesdenegocio.RopaFoto"%>
<% RopaFoto ropafoto = (RopaFoto) request.getAttribute("ropafoto");%>
<!DOCTYPE html>
<html>
    <head>        
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Eliminar RopaFoto</title>
    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />  
        <main class="container">   
            <h5>Eliminar RopaFoto</h5>          
            <form action="RopaFoto" method="post">
                <input type="hidden" name="accion" value="<%=request.getAttribute("accion")%>">   
                <input type="hidden" name="id" value="<%=ropafoto.getId()%>">   
                <div class="row">
                   <div class="input-field col l4 s12">
                    <input  id="txtUrl" type="text" value="<%=ropafoto.getUrl()%>" disabled>
                    <label for="txtUrl">Url</label>
                </div>                       
                <div class="input-field col l4 s12">   
                    <select id="slEstatus" name="estatus" disabled>
                        <option value="0" <%=(ropafoto.getEstatus() == 10) ? "selected" : ""%>>SELECCIONAR</option>
                        <option value="<%=RopaFoto.EstatusRopaFoto.ACTIVO%>"  <%=(ropafoto.getEstatus() == RopaFoto.EstatusRopaFoto.ACTIVO) ? "selected" : ""%>>ACTIVO</option>
                        <option value="<%=RopaFoto.EstatusRopaFoto.INACTIVO%>"  <%=(ropafoto.getEstatus() == RopaFoto.EstatusRopaFoto.INACTIVO) ? "selected" : ""%>>INACTIVO</option>
                    </select>       
                    <label for="slEstatus">Estatus</label>
                    <span id="slEstatus_error" style="color:red" class="helper-text"></span>
                </div>
                </div> 
                <div class="input-field col l4 s12">
                    <input  id="txtRopa" type="text" value="<%=ropafoto.getRopa().getCodigoBarra() %>" disabled>
                    <label for="txtRopa">Ropa</label>
                </div>                                       
                </div>
                <div class="row">
                    <div class="col l12 s12">
                        <button type="sutmit" class="waves-effect waves-light btn blue"><i class="material-icons right">delete</i>Eliminar</button>
                        <a href="RopaFoto" class="waves-effect waves-light btn blue"><i class="material-icons right">list</i>Cancelar</a>                          
                    </div>
                </div>
            </form>          
        </main>
        <jsp:include page="/Views/Shared/footerBody.jsp" />      
    </body>
</html>
