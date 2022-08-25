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
        <jsp:include page="/Views/Shared/headerBody.jsp" />  
        <main class="container"> 
            <div class="row">
                <center><div class="col l12 s12">
                        <h1>Bienvenidos</h1> 
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

        <br>
        <br>
        <br>
        <br>
        <br> 
        <br>
        <br>

        <ul class="pagination">
            <li class="disabled"><a href="#!"><i class="material-icons">chevron_left</i></a></li>
            <li class="active"><a href="#!">1</a></li>
            <li class="waves-effect"><a href="#!">2</a></li>
            <li class="waves-effect"><a href="#!">3</a></li>
            <li class="waves-effect"><a href="#!">4</a></li>
            <li class="waves-effect"><a href="#!">5</a></li>
            <li class="waves-effect"><a href="#!"><i class="material-icons">chevron_right</i></a></li>
        </ul>



        <footer class="page-footer">
            <div class="container">
                <div class="row">
                    <div class="col l6 s12">
                        <h5 class="white-text">Footer Content</h5>
                        <p class="grey-text text-lighten-4">You can use rows and columns here to organize your footer content.</p>
                    </div>
                    <div class="col l4 offset-l2 s12">
                        <h5 class="white-text">Links</h5>
                        <ul>
                            <li><a class="grey-text text-lighten-3" href="#!">Link 1</a></li>
                            <li><a class="grey-text text-lighten-3" href="#!">Link 2</a></li>
                            <li><a class="grey-text text-lighten-3" href="#!">Link 3</a></li>
                            <li><a class="grey-text text-lighten-3" href="#!">Link 4</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="footer-copyright">
                <div class="container">
                    © 2022 Copyright ClothingSystem
                    <a class="grey-text text-lighten-4 right" href="#!">More Links</a>
                </div>
            </div>
        </footer>






        <jsp:include page="/Views/Shared/footerBody.jsp" />      
    </body>

</html>

