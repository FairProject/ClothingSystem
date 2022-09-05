<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clothingsystem.entidadesdenegocio.Ropa"%>
<%@page import="clothingsystem.entidadesdenegocio.Marca"%>

<%@page import="java.util.ArrayList"%>
<% ArrayList<Ropa> ropas = (ArrayList<Ropa>) request.getAttribute("ropas");
    int numPage = 1;
    int numReg = 10;
    int countReg = 0;
    if (ropas == null) {
        ropas = new ArrayList();
    } else if (ropas.size() > numReg) {
        double divNumPage = (double) ropas.size() / (double) numReg;
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
        <title>Buscar Ropa</title>

    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />  
        <main class="container">   
            <h5>Buscar Ropa</h5>
            <form action="Ropa" method="post">
                <input type="hidden" name="accion" value="<%=request.getAttribute("accion")%>"> 
                <div class="row">

                    <div class="input-field col l6 s12">
                        <input  id="txtCodigoBarra" type="text" name="codigobarra">
                        <label for="txtCodigoBarra">CodigoBarra</label>
                    </div> 

                    <div class="input-field col l4 s12">
                        <input  id="txtNombre" type="text" name="nombre">
                        <label for="txtNombre">Nombre</label>
                    </div> 

                    <div class="input-field col l4 s12">
                        <input  id="txtPrecioCompra" type="text" name="preciocompra">
                        <label for="txtPrecioCompra">PrecioCompra</label>
                    </div> 

                    <div class="input-field col l4 s12">
                        <input  id="txtPrecioVenta" type="text" name="precioventa">
                        <label for="txtPrecioVenta">PrecioVenta</label>
                    </div> 

                    <div class="input-field col l4 s12">
                        <input  id="txtExistencia" type="text" name="existencia">
                        <label for="txtExistencia">Existencia</label>
                    </div> 

                    <div class="input-field col l4 s12">   
                        <select id="slEstatus" name="estatus">
                            <option value="0">SELECCIONAR</option>
                            <option value="<%=Ropa.EstatusRopa.ACTIVO%>">ACTIVO</option>
                            <option value="<%=Ropa.EstatusRopa.INACTIVO%>">INACTIVO</option>
                        </select>       
                        <label for="slEstatus">Estatus</label>                     
                    </div> 

                    <div class="input-field col l4 s12">
                        <input  id="txtTalla" type="text" name="talla">
                        <label for="txtTalla">Talla</label>
                    </div> 

                    <div class="input-field col l4 s12">
                        <input  id="txtColor" type="text" name="color">
                        <label for="txxColor">Color</label>
                    </div> 

                    <div class="input-field col l4 s12">
                        <input  id="txtEstilo" type="text" name="estilo">
                        <label for="txtEstilo">Estilo</label>
                    </div> 

                    <div class="input-field col l4 s12">
                        <input  id="txtDescripcion" type="text" name="descripcion">
                        <label for="txtDescripcion">Descripcion</label>
                    </div> 

                    <div class="input-field col l4 s12">
                        <input  id="txtTipoTela" type="text" name="tipotela">
                        <label for="txtTipoTela">TipoTela</label>
                    </div> 


                    <div class="input-field col l4 s12">   
                        <jsp:include page="/Views/Marca/select.jsp">                           
                            <jsp:param name="id" value="0" />  
                        </jsp:include>                        
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
                        <a href="Ropa?accion=create" class="waves-effect waves-light btn green accent-3"><i class="material-icons right">add</i>Crear</a>                          
                    </div>
                </div>

            </form>

            <div class="row">
                <div class="col l12 s12">
                    <div style="overflow: auto">
                        <table class="paginationjs">
                            <thead>
                                <tr>
                                    <th>CodigoBarra</th>  
                                    <th>Nombre</th>  
                                    <th>PrecioCompra</th> 
                                    <th>PrecioVenta</th> 
                                    <th>Existencia</th> 
                                    <th>Estatus</th> 
                                    <th>Talla</th> 
                                    <th>Color</th> 
                                    <th>Estilo</th> 
                                    <th>Descripcion</th> 
                                    <th>TipoTela</th> 
                                    <th>Marca</th> 
                                    <th>Acciones</th>

                                </tr>
                            </thead>                       
                            <tbody>                           
                                <% for (Ropa ropa : ropas) {
                                        int tempNumPage = numPage;
                                        if (numPage > 1) {
                                            countReg++;
                                            double divTempNumPage = (double) countReg / (double) numReg;
                                            tempNumPage = (int) Math.ceil(divTempNumPage);
                                        }
                                        String estatus = "";
                                        switch (ropa.getEstatus()) {
                                            case Ropa.EstatusRopa.ACTIVO:
                                                estatus = "ACTIVO";
                                                break;
                                            case Ropa.EstatusRopa.INACTIVO:
                                                estatus = "INACTIVO";
                                                break;
                                            default:
                                                estatus = "";
                                        }
                                %>
                                <tr data-page="<%= tempNumPage%>"> 



                                    <td><%=ropa.getNombre()%></td> 
                                    <td><%=ropa.getCodigoBarra()%></td> 
                                    <td><%=ropa.getPrecioCompra()%></td> 
                                    <td><%=ropa.getPrecioVenta()%></td> 
                                    <td><%=ropa.getExistencia()%></td>
                                    <td><%=estatus%></td>
                                    <td><%=ropa.getTalla()%></td>
                                    <td><%=ropa.getColor()%></td>
                                    <td><%=ropa.getEstilo()%></td>
                                    <td><%=ropa.getDescripcion()%></td>
                                    <td><%=ropa.getTipoTela()%></td>
                                    <td><%=ropa.getIdMarca()%></td> 
                                    
                                    <td>
                                        <div style="display:flex">
                                            <a href="Ropa?accion=edit&id=<%=ropa.getId()%>" title="Modificar" class="waves-effect waves-light btn green">
                                                <i class="material-icons">edit</i>
                                            </a>
                                            <a href="Ropa?accion=details&id=<%=ropa.getId()%>" title="Ver" class="waves-effect waves-light btn blue">
                                                <i class="material-icons">description</i>
                                            </a>
                                            <a href="Ropa?accion=delete&id=<%=ropa.getId()%>" title="Eliminar" class="waves-effect waves-light btn red">
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
