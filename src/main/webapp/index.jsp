<%@include file="include/header.inc"%>
    <title>Welcome page</title>

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
                    <li class="nav-item active">
                        <a class="nav-link" href="#"><h3>Forside</h3> <span class="sr-only">(current)</span></a>
                </div>
                </li>
                <li class="nav-item">
                    <ul class="navbar-nav mr-5 mt-20 mt-lg-0">
                        <a class="nav-link" href="FrontController?target=redirect&destination=cupcakes"><h3>Cupcakes</h3></a>
                        </li>
                        <li class="nav-item">
                            <ul class="navbar-nav mr-5 mt-20 mt-lg-0">
                                <a class="nav-link" href="FrontController?target=redirect&destination=contact"><h3>Kontakt</h3></a>
                                </li>
                                <li class="nav-item">
                                    <ul class="navbar-nav mr-5 mt-20 mt-lg-0">
                                        <div class="col-lg-5">
                                            <a class="nav-link" href="FrontController?target=redirect&destination=cart"><h3>Kurv</h3></a>
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
        <a class="navbar-brand" href="#"> <img src="./images/foto.png" height="70" alt="Logo"></a>
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
        <h1 class="display-4">Velkommen til Olsker Cupcakes!</h1>
        <p class="lead">
            Olsker Cupcakes er endnu et dybdeøkologisk iværksættereventyr fra Bornholm, som har ramt den helt rigtige
            opskrift.
            Små lækre cupcakes eller muffins er skønne, som portionsservering af dejlige kageopskrifter. Sådan en
            cupcake passer perfekt
            til et koldt glas mælk en eftermiddag, eller til en varm kop kaffe, som dessert efter et godt måltid.
            Jeg synes det er vigtigt at selve kagen i en cupkage smager vidunderligt – det nytter ikke noget bare at
            pynte den flot … egentlig er jeg ikke den store kagepynter og det er ret begrænset, hvad der er af
            kagepyntsinspiration, fondant og den slags her på bloggen, men grunddelen – selve muffinskagen – er i top,
            og så må du endelig pynte den lige som du har lyst.

        </p>
    </div>

    <c:if test="${requestScope.error!= null}">

        <h2>Error ! </h2>
        ${requestScope.error}

    </c:if>
</div>

<%@include file="include/footer.inc"%>