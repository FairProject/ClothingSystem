
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clothingsystem.entidadesdenegocio.RopaFoto"%>
<%@page import="clothingsystem.accesoadatos.RopaFotoDAL"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<RopaFoto> ropafotos = RopaFotoDAL.obtenerTodos();
    int id = Integer.parseInt(request.getParameter("id"));
%>
<select id="slRopaFoto" name="idRopa">
    <option <%=(id == 0) ? "selected" : ""%>  value="0">SELECCIONAR</option>
    <% for (RopaFoto ropafoto : ropafotos) {%>
    <option <%=(id == ropafoto.getId()) ? "selected" : ""%>  value="<%=ropafoto.getId()%>"><%= ropafoto.getUrl()%></option>
    <%}%>
</select>
<label for="idRopa">RopaFoto</label>
