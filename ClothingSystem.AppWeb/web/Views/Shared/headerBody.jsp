<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clothingsystem.appweb.utils.*"%>



<head><link rel="stylesheet" href="css/style.css"></head>
<nav>
    <div class="nav-wrapper black hoverable">
        <a href="Home" class="brand-logo">clothingsystem</a>
        <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>       
        <ul class="right hide-on-med-and-down">  
            <% if (SessionUser.isAuth(request)) {  %>
            <li class="hoverable"><a href="Home">Inicio</a></li>
            <li class="hoverable"><a href="Usuario">Usuario</a></li>
            <li class="hoverable"><a href="Rol">Rol</a></li>
             <li class="hoverable"><a href="Ropa">Ropa</a></li>
             <li class="hoverable"><a href="RopaFoto">RopaFoto</a></li>
            <li class="hoverable1"><a href="Usuario?accion=cambiarpass">Cambiar password</a></li>
            <li class="hoverable2"><a href="Usuario?accion=login">Cerrar sesión</a></li>
            
            <%}%>
        </ul>
    </div>
</nav>

<ul class="sidenav" id="mobile-demo">
     <% if (SessionUser.isAuth(request)) {  %>
    <li><a href="Home">Inicio</a></li>
    <li><a href="Usuario">Usuario</a></li>
    <li><a href="Rol">Rol</a></li>
     <li><a href="Ropa">Ropa</a></li>
      <li><a href="RopaFoto">RopaFoto</a></li>
    <li><a href="Usuario?accion=cambiarpass">Cambiar password</a></li>
    <li><a href="Usuario?accion=login">Cerrar sesión</a></li>
     <%}%>
</ul>
