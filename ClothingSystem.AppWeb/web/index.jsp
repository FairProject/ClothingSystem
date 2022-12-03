<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clothingsystem.appweb.utils.*"%>
<% if (SessionUser.isAuth(request) == false) {
        response.sendRedirect("Usuario?accion=login");
    }
%>

<!DOCTYPE html>
<html>
    <head>        
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Clothing</title>
        <link rel="icon" type="image/png" href="images/Logo.png">



    </head>
    <body>
        
        
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
                <a href="https://api.whatsapp.com/send?phone=50379563965&text=Hola vengo de la App Web" class="float" target="_blank">
                    <i class="fa fa-whatsapp my-float"></i>
                </a>
        <jsp:include page="/Views/Shared/headerBody.jsp" />  
        <jsp:include page="/Views/Shared/bannerBody.jsp" />  

        <main class="container"> 
            <div class="row">
                <center><div class="col l12 s12">
                        <h1>Nuevas Ofertas</h1> 
                        <span>Busca por Nombre, Descripción y Precio de la Venta</span> 
                    </div></center>
            </div>  
            <br>
            <jsp:include page="/Views/Shared/buscador.jsp" />  
            <br>
            <div class="row">

                <!-- Card 1 -->
                <div class="col s4">
                    <div class="card">
                        <div class="card-image">
                            <img src="images/image 1.png">
                            <span class="card-title">Card Title</span>
                            <a class="btn-floating halfway-fab waves-effect waves-light red"><i class="material-icons">add</i></a>
                        </div>
                        <div class="card-content">
                            <p>I am a very simple card.</p>
                        </div>
                    </div>
                </div>


                <!-- Card 2 -->
                <div class="col s4">
                    <div class="card">
                        <div class="card-image">
                            <img src="images/image 2.png">
                            <span class="card-title">Card Title</span>
                            <a class="btn-floating halfway-fab waves-effect waves-light red"><i class="material-icons">add</i></a>
                        </div>
                        <div class="card-content">
                            <p>I am a very simple card.</p>
                        </div>
                    </div>
                </div>

                <!-- Card 3 -->

                <div class="col s4">
                    <div class="card">
                        <div class="card-image">
                            <img src="images/image 3.png">
                            <span class="card-title">Card Title</span>
                            <a class="btn-floating halfway-fab waves-effect waves-light red"  <a href="RopaFoto?accion=create"><i class="material-icons">add</i></a>
                        </div>
                        <div class="card-content">
                            <p>I am a very simple card.</p>
                        </div>
                    </div>
                </div>





        </main>  


        <jsp:include page="/Views/Shared/footerBody.jsp" />      
    </body>

</html>

