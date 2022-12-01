<%-- 
    Document   : index
    Created on : 28 ago 2022, 08:55:52
    Author     : Cristopher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clothingsystem.entidadesdenegocio.Producto"%>
<%@page import="clothingsystem.entidadesdenegocio.Categoria"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<Producto> productos = (ArrayList<Producto>) request.getAttribute("productos");
    int numPage = 1;
    int numReg = 10;
    int countReg = 0;
    if (productos == null) {
        productos = new ArrayList();
    } else if (productos.size() > numReg) {
        double divNumPage = (double) productos.size() / (double) numReg;
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
        <title>Buscar Producto</title>
    </head>
          <jsp:include page="/Views/Shared/headerBody.jsp" />  
        <main class="container">   
            <h5>Buscar Producto</h5>
            <form action="Producto" method="post">
                <input type="hidden" name="accion" value="<%=request.getAttribute("accion")%>"> 
                <div class="row">
                    <div class="input-field col l4 s12">
                        <input  id="txtCodigo" type="text" name="codigo">
                        <label for="txtCodigo">Codigo</label>
                    </div> 
                    <div class="input-field col l4 s12">
                        <input  id="txtDescripcion" type="text" name="descripcion">
                        <label for="txtDescripcion">Descripcion</label>
                    </div> 
                     <div class="input-field col l4 s12">
                        <input  id="txtPrecioCompra" type="text" name="precioCompra">
                        <label for="txtPrecioCompra">Precio Compra</label>
                    </div> 
                       <div class="input-field col l4 s12">
                        <input  id="txtPrecioVenta" type="text" name="precioVenta">
                        <label for="txtPrecioVenta">Precio Venta</label>
                    </div> 
                    <div class="input-field col l4 s12">
                        <input  id="txtExistencia" type="text" name="existencia">
                        <label for="txtExistencia">Existencia</label>
                    </div>                    
                    <div class="input-field col l4 s12">   
                        <select id="slEstatus" name="estatus">
                            <option value="0">SELECCIONAR</option>
                            <option value="<%=Producto.EstatusProducto.ENEXISTENCIA%>">EN EXISTENCIA</option>
                            <option value="<%=Producto.EstatusProducto.NOHAYEXISTENCIAS%>">NO HAY EXISTENCIAS</option>
                        </select>       
                        <label for="slEstatus">Estatus</label>
                    </div>
                         
                    <div class="input-field col l4 s12">   
                        <jsp:include page="/Views/Categoria/select.jsp">                           
                            <jsp:param name="id" value="0" />  
                        </jsp:include>                        
                    </div>
                    <div class="input-field col l4 s12">   
                        <jsp:include page="/Views/Shared/selectTop.jsp">
                            <jsp:param name="top_aux" value="<%=top_aux%>" />                        
                        </jsp:include>                        
                    </div> 
                </div>
                <div class="row">
                    <div class="col l12 s12">
                        <button type="sutmit" class="waves-effect waves-light btn blue"><i class="material-icons right">search</i>Buscar</button>
                        <a href="Producto?accion=create" class="waves-effect waves-light btn blue"><i class="material-icons right">add</i>Crear</a>                          
                    </div>
                </div>
            </form>
                        
                         <div class="row">
                <div class="col l12 s12">
                    <div style="overflow: auto">
                        <table class="paginationjs">
                            <thead>
                                <tr>     
                                    <th>Categoria</th>                                 
                                    <th>Codigo</th>  
                                    <th>Fecha creacion</th> 
                                    <th>Fecha vencimiento</th>
                                    <th>Descripcion</th> 
                                    <th>Precio compra</th>
                                    <th>Precio venta</th> 
                                    <th>Existencia</th>  
                                    <th>Estatus</th>  
                                    <th>Comentario</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>                       
                            <tbody>                           
                                <% for (Producto producto : productos) {
                                        int tempNumPage = numPage;
                                        if (numPage > 1) {
                                            countReg++;
                                            double divTempNumPage = (double) countReg / (double) numReg;
                                            tempNumPage = (int) Math.ceil(divTempNumPage);
                                        }
                                        String estatus = "";
                                        switch (producto.getEstatus()) {
                                            case Producto.EstatusProducto.ENEXISTENCIA:
                                                estatus = "ENEXISTENCIA";
                                                break;
                                            case Producto.EstatusProducto.NOHAYEXISTENCIAS:
                                                estatus = "NOHAYEXISTENCIAS";
                                                break;
                                            default:
                                                estatus = "";
                                        }
                                %> 
                                <tr data-page="<%= tempNumPage%>">                                          
                                    <td><%=producto.getCategoria().getNombre()%></td> 
                                    <td><%=producto.getCodigo()%></td> 
                                    <td><%=producto.getFechaCreacion()%></td>
                                    <td><%=producto.getFechaVencimiento()%></td> 
                                    <td><%=producto.getDescripcion()%></td>
                                    <td><%=producto.getPrecioCompra()%></td>
                                    <td><%=producto.getPrecioVenta()%></td> 
                                    <td><%=producto.getExistencia()%></td>  
                                    <td><%=estatus%></td>
                                    <td><%=producto.getComentario()%></td> 
                                    <td>
                                        <div style="display:flex">
                                             <a href="Producto?accion=edit&id=<%=producto.getId()%>" title="Modificar" class="waves-effect waves-light btn green">
                                            <i class="material-icons">edit</i>
                                        </a>
                                        <a href="Producto?accion=details&id=<%=producto.getId()%>" title="Ver" class="waves-effect waves-light btn blue">
                                            <i class="material-icons">description</i>
                                        </a>
                                        <a href="Producto?accion=delete&id=<%=producto.getId()%>" title="Eliminar" class="waves-effect waves-light btn red">
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
