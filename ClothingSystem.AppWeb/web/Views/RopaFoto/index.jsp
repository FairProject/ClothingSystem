<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clothingsystem.entidadesdenegocio.RopaFoto"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<RopaFoto> ropafotos = (ArrayList<RopaFoto>) request.getAttribute("ropafotos");
    int numPage = 1;
    int numReg = 10;
    int countReg = 0;
    if (ropafotos == null) {
        ropafotos = new ArrayList();
    } else if (ropafotos.size() > numReg) {
        double divNumPage = (double) ropafotos.size() / (double) numReg;
        numPage = (int) Math.ceil(divNumPage);
    }
    String strTop_aux = request.getParameter("top_aux");
    int top_aux = 10;
    if (strTop_aux != null && strTop_aux.trim().length() > 0) {
        top_aux = Integer.parseInt(strTop_aux);
    }
%>
<!DOCTYPE html>
<html>
    <head>        
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Buscar RopaFoto</title>
         <link rel="icon" type="image/png" href="images/Logo.png">

    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />  
        <main class="container">   
            <h5>Buscar RopaFoto</h5>
            <form action="RopaFoto" method="post">
                <input type="hidden" name="accion" value="<%=request.getAttribute("accion")%>"> 
                <div class="row">
                    <div class="input-field col l6 s12">        
                        <input  id="txtUrl" type="text" name="url">
                        <label for="txtUrl">Url</label>
                    </div> 
                    <div class="input-field col l4 s12">   
                        <select id="slEstatus" name="estatus">
                            <option value="0">SELECCIONAR</option>
                            <option value="<%=RopaFoto.EstatusRopaFoto.ACTIVO%>">ACTIVO</option>
                            <option value="<%=RopaFoto.EstatusRopaFoto.INACTIVO%>">INACTIVO</option>
                        </select>       
                        <label for="slEstatus">Estatus</label>
                    </div>
                        <div class="input-field col l6 s12">   
                        <jsp:include page="/Views/Ropa/select.jsp">                           
                            <jsp:param name="id" value="0" />  
                        </jsp:include>                        
                    </div>


                    <div class="input-field col l6 s12">   
                        <jsp:include page="/Views/Shared/selectTop.jsp">
                            <jsp:param name="top_aux" value="<%=top_aux%>" />                        
                        </jsp:include>                        
                    </div> 
                </div>
                <div class="row">
                    <div class="col l12 s12">
                        <button type="sutmit" class="waves-effect waves-light btn blue"><i class="material-icons right">search</i>Buscar</button>
                        <a href="RopaFoto?accion=create" class="waves-effect waves-light btn green accent-3"><i class="material-icons right">add</i>Crear</a>                          
                    </div>
                </div>
            </form>

            <div class="row">
                <div class="col l12 s12">
                    <div style="overflow: auto">
                        <table class="paginationjs">
                            <thead>
                                <tr>
                                    <th>Estatus</th>
                                     <th>Foto</th>
                                    <th>Ropa</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>                       
                            <tbody>                           
                                 <% for (RopaFoto ropafoto : ropafotos) {
                                        int tempNumPage = numPage;
                                        if (numPage > 1) {
                                            countReg++;
                                            double divTempNumPage = (double) countReg / (double) numReg;
                                            tempNumPage = (int) Math.ceil(divTempNumPage);
                                        }
                                        String estatus = "";
                                        switch (ropafoto.getEstatus()) {
                                            case RopaFoto.EstatusRopaFoto.ACTIVO:
                                                estatus = "ACTIVO";
                                                break;
                                            case RopaFoto.EstatusRopaFoto.INACTIVO:
                                                estatus = "INACTIVO";
                                                break;
                                            default:
                                                estatus = "";
                                        }
                                %>
                                <tr data-page="<%= tempNumPage%>">
                                    <td><%=ropafoto.getEstatus()%></td>
                                      <td><img width="30%" height="30%" src="<%=ropafoto.getFoto()%>" /></td>
                                    <%--<td><%=touristPlace.getPhotos()%></td>-->---%>
                                     <td><%=ropafoto.getRopa().getCodigoBarra()%></td>
                                    <td>
                                        <div style="display:flex">
                                            <a href="RopaFoto?accion=edit&id=<%=ropafoto.getId()%>" title="Modificar" class="waves-effect waves-light btn green">
                                                <i class="material-icons">edit</i>
                                            </a>
                                            <a href="RopaFoto?accion=details&id=<%=ropafoto.getId()%>" title="Ver" class="waves-effect waves-light btn blue">
                                                <i class="material-icons">description</i>
                                            </a>
                                            <a href="RopaFoto?accion=delete&id=<%=ropafoto.getId()%>" title="Eliminar" class="waves-effect waves-light btn red">
                                                <i class="material-icons">delete</i>
                                            </a>     
                                        </div>
                                    </td>                                   
                                </tr>
                                <%}%>                                                       
                            </tbody>
                        </table>
                    </div>                  
                </div>
            </div>
            <div class="row">
                <div class="col l12 s12">
                    <jsp:include page="/Views/Shared/paginacion.jsp">
                        <jsp:param name="numPage" value="<%= numPage%>" />                        
                    </jsp:include>
                </div>
            </div>
        </main>
        <jsp:include page="/Views/Shared/footerBody.jsp" />        
    </body>
</html>
