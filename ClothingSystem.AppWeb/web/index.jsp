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
        <link rel="stylesheet" href="css/style.css">


    </head>
    <body class="#cfd8dc blue-grey lighten-4">
        <jsp:include page="/Views/Shared/headerBody.jsp" />  
        <jsp:include page="/Views/Shared/bannerBody.jsp" />  

        <main class="container"> 
            <div class="row">
                <center><div class="col l12 s12">
                        <h1>Welcome</h1> 
                        <span>Al sistema donde podrán organizar muy bien su ropa: talla, marca, tela y más!!</span> 
                    </div></center>
            </div>  
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
                            <p>I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.</p>
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
                            <p>I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.</p>
                        </div>
                    </div>
                </div>

                <!-- Card 3 -->

                <div class="col s4">
                    <div class="card">
                        <div class="card-image">
                            <img src="images/image 3.png">
                            <span class="card-title">Card Title</span>
                            <a class="btn-floating halfway-fab waves-effect waves-light red"><i class="material-icons">add</i></a>
                        </div>
                        <div class="card-content">
                            <p>I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.</p>
                        </div>
                    </div>
                </div>
        </main>  


        <jsp:include page="/Views/Shared/footerBody.jsp" />      
    </body>

</html>

