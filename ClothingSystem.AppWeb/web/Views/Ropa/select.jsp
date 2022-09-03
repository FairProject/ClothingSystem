
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clothingsystem.entidadesdenegocio.Ropa"%>
<%@page import="clothingsystem.accesoadatos.RopaDAL"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<Ropa> ropas = RopaDAL.obtenerTodos();
    int id = Integer.parseInt(request.getParameter("id"));
%>
<select id="slRopa" name="idRopa">
    <option <%=(id == 0) ? "selected" : ""%>  value="0">SELECCIONAR</option>
    <% for (Ropa ropa : ropas) {%>
    <option <%=(id == ropa.getId()) ? "selected" : ""%>  value="<%=ropa.getId()%>"><%= ropa.getCodigoBarra()%></option>
    <%}%>
</select>
<label for="idRopa">Ropa</label>
