<%@page import="clothingsystem.entidadesdenegocio.RopaFoto"%>
<%@page import="clothingsystem.entidadesdenegocio.Ropa"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clothingsystem.appweb.utils.*"%>
<% ArrayList<Ropa> ropas = (ArrayList<Ropa>) request.getAttribute("ropas");%>

<!DOCTYPE html>
<html>
    <head>        
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Clothing</title>
        <link rel="icon" type="image/png" href="images/Logo.png">
        <!-- Swiper CSS -->
        <link rel="stylesheet" href="wwwroot/css/swiper-bundle.min.css">

        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>


    </head>
    <body style="background: #5D4157;  /* fallback for old browsers */
          background: -webkit-linear-gradient(to right, #A8CABA, #5D4157);  /* Chrome 10-25, Safari 5.1-6 */
          background: linear-gradient(to right, #A8CABA, #5D4157); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
          ">

        <a href="https://api.whatsapp.com/send?phone=50379563965&text=¡Hola vengo de la App Web!" class="float" target="_blank">
            <i class='bx bxl-whatsapp my-float'></i>
        </a>
        <jsp:include page="/Views/Shared/headerBody.jsp" />  
        <jsp:include page="/Views/Shared/bannerBody.jsp" />  

        <br>
        <br>
        <br>
        <br>
        <main class="container"> 
            <div class="row">
                <center><div class="col l12 s12">
                        <h3 style="color: #FFF">Buscar Ofertas</h3> 
                        <hr>

                    </div></center>
            </div>  
            <br>
            <form id="formBuscar" action="Home" method="post">
                <div class="row">
                    <div class="col l12 s12">
                        <div class="input-field col l10 s10"> 
                            <input type="text" name="descripcion" placeholder="Buscar" required />                                                
                        </div> 
                        <a id="btnBuscar" class="waves-effect waves-light btn-large">
                            <i class="material-icons left">search</i></a> 
                    </div>                
                </div>  
            </form> 
            <br>          
            </div>

             <% for (Ropa ropa : ropas) {%>
            <div class="row">

                <!-- Card 1 -->
                <div class="col s4">

                     
                    <% for (RopaFoto ropaFoto : ropa.getRopaFoto()) {%>
                    <div class="card">
                        <center> <div class="card-image">
                                <img src="<%=ropaFoto.getFoto()%>">  
                                <span class="card-title"></span>

                            </div> </center>
                            <%}%> 
                        <div class="card-content">
                            <center><h2 class="name">Oferta: $<%=ropa.getPrecioVenta()%></h2>
                                <p class="descripcion">
                                    Nombre: <%=ropa.getCodigoBarra()%>
                                    <br>
                                    Marca: <%=ropa.getMarca().getNombre()%> 
                                    <br>
                                    Descripcion: <%=ropa.getDescripcion()%></p></center> 
                        </div>
                    </div>
                </div>

                <%}%> 
        </main>  
        <br>
        <br>
        <br>
        <br>
        <hr>
        <script src="https://utteranc.es/client.js"
                repo="ADONAY1234/gestion-comentarios"
                issue-term="pathname"
                theme="github-dark-orange"
                crossorigin="anonymous"
                async>
        </script>
        <script>
            document.querySelector("#btnBuscar").addEventListener("click", function () {
                document.querySelector("#formBuscar").submit();
            });

        </script>

        <script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
        <jsp:include page="/Views/Shared/footerBody.jsp" />      
    </body>

</html>

