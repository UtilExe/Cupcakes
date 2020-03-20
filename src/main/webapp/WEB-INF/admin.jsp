<%@ page import="FunctionLayer.Initialisation" %>
<%@include file="../include/header.inc" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<link rel="stylesheet" href="css/styles.css">

<title>Admin Side</title>
</head>
<body>

    <%!
        @Override
        public void jspInit(){
            Initialisation.initEmails();
            Initialisation.initOrders();
        }

    %>

    <%
        request.setAttribute("custs", Initialisation.getUserEmailList());
        request.setAttribute("orders", Initialisation.getOrderList());
    %>

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
                        <a class="nav-link" href="FrontController?target=redirect&destination=admin"><h3>Admin</h3>
                            <span class="sr-only">(current)</span></a>
                </div>
                </li>
                <li class="nav-item">
                    <ul class="navbar-nav mr-5 mt-20 mt-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" href="FrontController?target=redirect&destination=customerList"><h3>
                                Kundeliste</h3></a>
                        </li>
                        <li class="nav-item">
                            <ul class="navbar-nav mr-5 mt-20 mt-lg-0">
                                <li class="nav-item">
                                    <a class="nav-link" href="FrontController?target=redirect&destination=orderList">
                                        <h3>Ordreliste</h3></a>
                                </li>
                            </ul>
                    </ul>
            </ul>
        </ul>
        </ul>

        <span class="navbar-text mr-5">
            ${sessionScope.email}
        </span>
        <%@include file="../include/dropdownMenu.inc" %>
    </div>
</nav>

<div class="container jumbotron ">
    <div class="container">
        <h1 class="display-4 mt-0 mb-5">Vælg hvad du vil:</h1>
    </div>

    <div class="row">
        <div class="col-2"></div>
        <div class="col-4">
            <form action="FrontController" method="POST">
                <input type="hidden" name="target" value="addBalance">

                <div class="container mb-4">
                    <div class="row">
                        <p class="lead mb-1">Vælg kunde</p>
                    </div>

                    <div class="row mt-0">
                        <select name="email">

                            <option value="Vælg kunde">Vælg kunde...</option>
                            <c:forEach var="email" items="${custs}">
                                <option name="email">${email}</option>
                            </c:forEach>

                        </select>
                    </div>
                </div>


                <div class="container mb-4">
                    <div class="row">
                        <p class="lead mb-1">Indtast beløb i kr.</p>
                    </div>
                    <div class="row mb-2">
                        <input name="addBalanceAmount" placeholder="Indtast beløb...">
                    </div>

                    <div class="row">
                        <button type="submit" class="btn btn-primary">Overfør</button>
                    </div>
                </div>
            </form>
        </div>


        <div class="col-4">
            <form action="FrontController" method="POST">
                <input type="hidden" name="target" value="removeOrder">

                <div class="container mb-4">
                    <div class="row">
                        <p class="lead mb-1">Fjern ordre hos kunde</p>
                    </div>

                    <div class="row mt-0">
                        <select name="email">

                            <option value="Vælg kunde">Vælg kunde...</option>
                            <c:forEach var="email" items="${custs}">
                                <option name="email">${email}</option>
                            </c:forEach>

                        </select>
                    </div>
                </div>


                <div class="container mb-4">
                    <div class="row">
                        <p class="lead mb-1">Vælg ordre</p>
                    </div>
                    <div class="row mb-2">
                        <select name="order">

                            <option value="Vælg kunde">Vælg ordre...</option>
                            <c:forEach var="order" items="${orders}">
                                <option name="order">${order}</option>
                            </c:forEach>

                        </select>
                    </div>

                    <div class="row">
                        <button type="submit" class="btn btn-primary">Fjern</button>
                    </div>
                </div>
            </form>
        </div>

        <div class="col-2"></div>
    </div>
</div>

<%@include file="../include/footer.inc" %>>