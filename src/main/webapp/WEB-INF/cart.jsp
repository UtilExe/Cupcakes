<%@include file="../include/header.inc" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<link rel="stylesheet" href="css/styles.css">


<title>Kurv</title>

</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #F6F8F9;">
    <a class="navbar-brand" href="#"> <img src="./images/logo.png" width="100" height="60" alt="Logo"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText"
            aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav mr-auto">
            <ul class="navbar-nav mr-5 mt-60 mt-lg-0">
                <div class="col-lg-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="FrontController?target=redirect&destination=index"><h3>Forside</h3>
                        </a>
                </div>
                </li>
                <li class="nav-item">
                    <ul class="navbar-nav mr-5 mt-20 mt-lg-0">
                        <a class="nav-link" href="FrontController?target=redirect&destination=cupcakes"><h3>
                            Cupcakes</h3><span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <ul class="navbar-nav mr-5 mt-20 mt-lg-0">
                                <a class="nav-link" href="FrontController?target=redirect&destination=contact"><h3>
                                    Kontakt</h3></a>
                                </li>
                                <li class="nav-item">
                                    <ul class="navbar-nav mr-5 mt-20 mt-lg-0">
                                        <div class="col-lg-5">
                                            <a class="nav-link" href="FrontController?target=redirect&destination=cart">
                                                <h3>Kurv</h3></a>
                                        </div>
                                        </li>
                                    </ul>
                            </ul>
                    </ul>
            </ul>
        </ul>

        <span class="navbar-text mr-5">
      Email-adresse
    </span>
        <%@include file="../include/dropdownMenu.inc" %>
    </div>
</nav>

<div class="container jumbotron ">

    <img src="images/header.png" class="img-fluid" alt="Responsive header image"/>


    <%--        Bare lige se I har en ide om hvad vi forslå I ikke gør ! det hedder scpript lets --%>
    <%--        <% String error = (String) request.getAttribute( "error");--%>
    <%--           if ( error != null) { --%>
    <%--               out.println("<H2>Error!!</h2>");--%>
    <%--               out.println(error);--%>
    <%--           }--%>
    <%--        %>--%>

    <div class="jumbotron mr-5 mt-20 mt-lg-0">
        <h1 class="display-4" style="text-align: center;">Her er Deres indkøbskurv</h1>
        <div class="container" style="border: 1px solid #A3A3A3;">
            <div class="container">
                <ul>
                    <li class="lead" style="padding-bottom: 20%; margin-bottom: 0;">Cupcakes bliver printet her...</li>
                </ul>
            </div>

            <div class="row">
                <div class="col-xl-8 col-lg-7 col-md-4 col-sm-2"></div>
                <div class="col-xl-4 col-lg-5 col-md-8 col-sm-10">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text" style="background-color: darkslategrey; color: white;">Samlet Pris:</span>
                        </div>
                        <span class="input-group-text" style="background-color: white; padding-left: 20px;">${requestScope.total} kr.</span>
                        <input type="submit" class="btnSubmitKurv" value="Betal">
                    </div>
                </div>
            </div>
        </div>
    </div>

    <c:if test="${requestScope.error!= null}">

        <h2>Error ! </h2>
        ${requestScope.error}

    </c:if>
</div>

<%@include file="../include/footer.inc" %>