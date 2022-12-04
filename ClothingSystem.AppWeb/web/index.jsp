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
        <!-- Swiper CSS -->
        <link rel="stylesheet" href="wwwroot/css/swiper-bundle.min.css">



    </head>
    <body>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
        <a href="https://api.whatsapp.com/send?phone=50379563965&text=¡Hola vengo de la App Web!" class="float" target="_blank">
            <i class="fa fa-whatsapp my-float"></i>
        </a>
        <jsp:include page="/Views/Shared/headerBody.jsp" />  
        <jsp:include page="/Views/Shared/bannerBody.jsp" />  

        <main class="container"> 
            <div class="row">
                <center><div class="col l12 s12">
                        <h3>Nuevas Ofertas</h3> 
                        <span>Busca por Nombre, Descripción y Precio de la Venta</span> 
                    </div></center>
            </div>  
            <br>
            <jsp:include page="/Views/Shared/buscador.jsp" />  
            <br>
            <div class="row">

                <div class="slide-container swiper">
                    <div class="slide-content">
                        <div class="card-wrapper swiper-wrapper">
                            <div class="card swiper-slide">
                                <div class="image-content">
                                    <span class="overlay"></span>

                                    <div class="card-image">
                                        <img src="images/image 1.png" alt="" class="card-img">
                                    </div>
                                </div>

                                <div class="card-content">
                                    <h2 class="name">David Dell</h2>
                                    <p class="description">The lorem text the section that contains header with having open functionality. Lorem dolor sit amet consectetur adipisicing elit.</p>

                                    <button class="button">View More</button>
                                </div>
                            </div>
                            <div class="card swiper-slide">
                                <div class="image-content">
                                    <span class="overlay"></span>

                                    <div class="card-image">
                                        <img src="images/image 2.png" alt="" class="card-img">
                                    </div>
                                </div>

                                <div class="card-content">
                                    <h2 class="name">David Dell</h2>
                                    <p class="description">The lorem text the section that contains header with having open functionality. Lorem dolor sit amet consectetur adipisicing elit.</p>

                                    <button class="button">View More</button>
                                </div>
                            </div>
                            <div class="card swiper-slide">
                                <div class="image-content">
                                    <span class="overlay"></span>

                                    <div class="card-image">
                                        <img src="images/image 3.png" alt="" class="card-img">
                                    </div>
                                </div>

                                <div class="card-content">
                                    <h2 class="name">David Dell</h2>
                                    <p class="description">The lorem text the section that contains header with having open functionality. Lorem dolor sit amet consectetur adipisicing elit.</p>

                                    <button class="button">View More</button>
                                </div>
                            </div>
                            <div class="card swiper-slide">
                                <div class="image-content">
                                    <span class="overlay"></span>

                                    <div class="card-image">
                                        <img src="images/profile4.jpg" alt="" class="card-img">
                                    </div>
                                </div>

                                <div class="card-content">
                                    <h2 class="name">David Dell</h2>
                                    <p class="description">The lorem text the section that contains header with having open functionality. Lorem dolor sit amet consectetur adipisicing elit.</p>

                                    <button class="button">View More</button>
                                </div>
                            </div>
                            <div class="card swiper-slide">
                                <div class="image-content">
                                    <span class="overlay"></span>

                                    <div class="card-image">
                                        <img src="images/profile5.jpg" alt="" class="card-img">
                                    </div>
                                </div>

                                <div class="card-content">
                                    <h2 class="name">David Dell</h2>
                                    <p class="description">The lorem text the section that contains header with having open functionality. Lorem dolor sit amet consectetur adipisicing elit.</p>

                                    <button class="button">View More</button>
                                </div>
                            </div>
                            <div class="card swiper-slide">
                                <div class="image-content">
                                    <span class="overlay"></span>

                                    <div class="card-image">
                                        <img src="images/profile6.jpg" alt="" class="card-img">
                                    </div>
                                </div>

                                <div class="card-content">
                                    <h2 class="name">David Dell</h2>
                                    <p class="description">The lorem text the section that contains header with having open functionality. Lorem dolor sit amet consectetur adipisicing elit.</p>

                                    <button class="button">View More</button>
                                </div>
                            </div>
                            <div class="card swiper-slide">
                                <div class="image-content">
                                    <span class="overlay"></span>

                                    <div class="card-image">
                                        <img src="images/profile7.jpg" alt="" class="card-img">
                                    </div>
                                </div>

                                <div class="card-content">
                                    <h2 class="name">David Dell</h2>
                                    <p class="description">The lorem text the section that contains header with having open functionality. Lorem dolor sit amet consectetur adipisicing elit.</p>

                                    <button class="button">View More</button>
                                </div>
                            </div>
                            <div class="card swiper-slide">
                                <div class="image-content">
                                    <span class="overlay"></span>

                                    <div class="card-image">
                                        <img src="images/profile8.jpg" alt="" class="card-img">
                                    </div>
                                </div>

                                <div class="card-content">
                                    <h2 class="name">David Dell</h2>
                                    <p class="description">The lorem text the section that contains header with having open functionality. Lorem dolor sit amet consectetur adipisicing elit.</p>

                                    <button class="button">View More</button>
                                </div>
                            </div>
                            <div class="card swiper-slide">
                                <div class="image-content">
                                    <span class="overlay"></span>

                                    <div class="card-image">
                                        <img src="images/profile9.jpg" alt="" class="card-img">
                                    </div>
                                </div>

                                <div class="card-content">
                                    <h2 class="name">David Dell</h2>
                                    <p class="description">The lorem text the section that contains header with having open functionality. Lorem dolor sit amet consectetur adipisicing elit.</p>

                                    <button class="button">View More</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="swiper-button-next swiper-navBtn"></div>
                    <div class="swiper-button-prev swiper-navBtn"></div>
                    <div class="swiper-pagination"></div>
                </div>


                <!-- Swiper JS -->
                <script src="wwwroot/js/swiper-bundle.min.js"></script>



                <!-- JavaScript -->
                <script src="wwwroot/js/script.js"></script>

        </main>  
        <br>
        <br>
        <br>
        <br>
        <hr>
        <script src="https://utteranc.es/client.js"
                repo="ADONAY1234/gestion-comentarios"
                issue-term="pathname"
                theme="boxy-light"
                crossorigin="anonymous"
                async>
        </script>


        <jsp:include page="/Views/Shared/footerBody.jsp" />      
    </body>

</html>

