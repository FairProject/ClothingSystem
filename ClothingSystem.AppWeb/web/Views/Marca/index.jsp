<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clothingsystem.entidadesdenegocio.Marca"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<Marca> marcas = (ArrayList<Marca>) request.getAttribute("marcas");
    int numPage = 1;
    int numReg = 10;
    int countReg = 0;
    if (marcas == null) {
        marcas = new ArrayList();
    } else if (marcas.size() > numReg) {
        double divNumPage = (double) marcas.size() / (double) numReg;
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
        <title>Buscar Marca</title>
         <link rel="icon" type="image/png" href="images/Logo.png">

    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />  
        <main class="container">   
            <h5>Buscar Marca</h5>
            <form action="Marca" method="post">
                <input type="hidden" name="accion" value="<%=request.getAttribute("accion")%>"> 
                <div class="row">

                    <div class="input-field col l6 s12">
                        <input  id="txtNombre" type="text" name="nombre">
                        <label for="txtNombre">Nombre</label>
                    </div>       

                    <div class="input-field col l4 s12">   
                        <select id="slEstatus" name="estatus">
                            <option value="0">SELECCIONAR</option>
                            <option value="<%=Marca.EstatusMarca.ACTIVO%>">ACTIVO</option>
                            <option value="<%=Marca.EstatusMarca.INACTIVO%>">INACTIVO</option>
                        </select>       
                        <label for="slEstatus">Estatus</label>                     
                    </div> 

                    <div class="input-field col l6 s12">
                        <input  id="txtDescripcion" type="text" name="descripcion">
                        <label for="txtDescripcion">Descripcion</label>
                    </div>       


                    <div class="input-field col l6 s12">
                        <input  id="txtPaisOrigen" type="text" name="paisorigen">
                        <label for="txtPaisOrigen">PaisOrigen</label>
                    </div>     


                    <div class="input-field col l3 s12">   
                        <jsp:include page="/Views/Shared/selectTop.jsp">
                            <jsp:param name="top_aux" value="<%=top_aux%>" />                        
                        </jsp:include>                        
                    </div> 

                </div>
                <div class="row">
                    <div class="col l12 s12">
                        <button type="sutmit" class="waves-effect waves-light btn blue"><i class="material-icons right">search</i>Buscar</button>
                        <a href="Marca?accion=create" class="waves-effect waves-light btn green accent-3"><i class="material-icons right">add</i>Crear</a>                          
                    </div>
                </div>
            </form>

            <div class="row">
                <div class="col l12 s12">
                    <div style="overflow: auto">
                        <table class="paginationjs">
                            <thead>
                                <tr>
                                    <th>Nombre</th>   
                                    <th>Estatus</th>   
                                    <th>Descripcion</th>   
                                    <th>PaisOrigen</th>   
                                    <th>Acciones</th>
                                </tr>
                            </thead>                       
                            <tbody>                           
                                <% for (Marca marca : marcas) {
                                        int tempNumPage = numPage;
                                        if (numPage > 1) {
                                            countReg++;
                                            double divTempNumPage = (double) countReg / (double) numReg;
                                            tempNumPage = (int) Math.ceil(divTempNumPage);
                                        }
                                        String estatus = "";
                                        switch (marca.getEstatus()) {
                                            case Marca.EstatusMarca.ACTIVO:
                                                estatus = "ACTIVO";
                                                break;
                                            case Marca.EstatusMarca.INACTIVO:
                                                estatus = "INACTIVO";
                                                break;
                                            default:
                                                estatus = "";
                                        }
                                %>
                                <tr data-page="<%= tempNumPage%>">
                                    <td><%=marca.getNombre()%></td>
                                    <td><%=estatus%></td>
                                    <td><%=marca.getDescripcion()%></td>
                                    <td><%=marca.getPaisOrigen()%></td>

                                    <td>
                                        <div style="display:flex">
                                            <a href="Marca?accion=edit&id=<%=marca.getId()%>" title="Modificar" class="waves-effect waves-light btn green">
                                                <i class="material-icons ">edit</i>
                                            </a>
                                            <a href="Marca?accion=details&id=<%=marca.getId()%>" title="Ver" class="waves-effect waves-light btn blue">
                                                <i class="material-icons">description</i>
                                            </a>
                                            <a href="Marca?accion=delete&id=<%=marca.getId()%>" title="Eliminar" class="waves-effect waves-light btn red">
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
