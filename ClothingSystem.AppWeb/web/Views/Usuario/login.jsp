<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Login</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="wwwroot/css/login.css">
        <link rel="icon" type="image/png" href="images/Logo.png">

    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />  
        <main class="container">   
            <div class="row justify-content-center pt-5 mt-5 m-1">

                <div class="col-md-6 col-sm-8 col-xl-4 col-lg-5 formulario">

                    <h1 class="text-black text-center">Login</h1>
                    <form action="Usuario?accion=login" method="post">

                        <input type="hidden" name="accion" value="<%=request.getAttribute("accion")%>">                
                        <div class="row">

                            <div class="form-group mx-sm-4 pt-3">                                             
                                <i class="material-icons prefix">account_circle</i>
                                <input  id="txtLogin" type="text" name="login" required class="validate" maxlength="25">  
                                <label for="txtLogin">Login</label>
                            </div>                                       
                        </div>
                        <div class="row">
                            <div class="form-group mx-sm-4 pt-1">                                             
                                <i class="material-icons prefix">enhanced_encryption</i>
                                <input  id="txtPassword" type="password" name="password" required class="validate" minlength="5" maxlength="32">  
                                <label for="txtPassword">Password</label>
                            </div>                                       
                        </div>
                        <div class="form-group text-center">

                            <div class="form-group text-center">
                                <button  type="sutmit"  class="btn btn-block ingresar" >Iniciar sesión</button>
                            </div> 
                        </div>
                        <div class="from-group text-center">

                            <div class="from-group text-center">
                                <a href="Usuario?accion=create" class="btn btn-block ingresar"><i class=""></i>Crear Usuario</a>

                            </div>
                        </div>
                        <% if (request.getAttribute("error") != null) {%>
                        <div class="row">
                            <div class="col l12 s12">
                                <span style="color:yellow"><%= request.getAttribute("error")%></span>                                              
                            </div>
                        </div>
                        <%}%>
                </div>         
            </div> 
        </form>          
    </main>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>

