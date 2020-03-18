<%--
  Created by IntelliJ IDEA.
  User: emilg
  Date: 16/03/2020
  Time: 10.33
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="/include/header.inc" %>

<title>Cupcakes</title>


</head>
<link rel="stylesheet" href="css/styles.css">
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

                    <a class="nav-link" href="FrontController?target=redirect&destination=index"><h3>Forside</h3> <span
                            class="sr-only">(current)</span></a>
                </div>

                <li class="nav-item">
                    <ul class="navbar-nav mr-5 mt-20 mt-lg-0">
                        <li class="nav-item active">
                            <a class="nav-link" href="#"><h3>Cupcakes</h3></a>
                        </li>
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
        <h1 class="display-4 text-center">Byg din egen Cupcake!</h1>
        <p class="lead text-left">
            Her har du mulighed for at bygge din egen cupcake - vælg din favorit top og bund.
        </p>


        <div class="row">
            <div class="col-1"></div>
            <div class="col-3">


                <form action="FrontController" method="post">
                    <input type="hidden" name="target" value="buildCupcakes">


                    <select id="bund" name="bund">

                        <option value="Vælg Bund">Vælg Bund</option>
                        <c:forEach var="bottom" items="${bottoms}">
                            <option name="bund"> ${bottom.name}, ${bottom.price} kr.</option>
                        </c:forEach>

                    </select>
            </div>
            <div class="col-3">
                <select id="top" name="top">
                    <option value="Vælg Topping">Vælg Topping</option>
                    <c:forEach var="topping" items="${toppings}">
                        <option name="top"> ${topping.name}, ${topping.price} kr.</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-3">

                <input name="antal" type="text" id="antal" placeholder="Skriv antal...">

            </div>
            <div class="text-right">

                <button class="btn btn-primary" type="submit">Læg i kurv</button>

                <p>${sessionScope.cupcake}</p>

            </div>

            </form>

        </div>

    </div>


</div>


<c:if test="${requestScope.error!= null}">

    <h2>Error ! </h2>
    ${requestScope.error}

</c:if>
</div>

</body>

<%@include file="/include/footer.inc" %>