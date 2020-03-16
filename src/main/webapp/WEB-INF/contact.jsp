<%@include file="../include/header.inc" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<title>Kontakt</title>
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
                            <span class="sr-only">(current)</span></a>
                </div>
                </li>
                <li class="nav-item">
                    <ul class="navbar-nav mr-5 mt-20 mt-lg-0">
                        <a class="nav-link" href="FrontController?target=redirect&destination=cupcakes"><h3>
                            Cupcakes</h3></a>
                        </li>
                        <li class="nav-item active">
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
        <a class="navbar-brand" href="#"> <img src="./images/foto.png" height="70" alt="Logo"></a>
    </div>
</nav>

<form name="contact" action="FrontController" method="POST">
    <input type="hidden" name="target" value="contact">
    <div class="row mt-4">
        <div class="col-3"></div>
        <div class="form-group col-6">
            <label for="email">Email address</label>
            <input type="email" name="email" class="form-control" id="email" placeholder="name@example.com">
        </div>
        <div class="col-3"></div>
        <div class="col-3"></div>
        <div class="form-group col-6">
            <label for="textArea">Example textarea</label>
            <textarea name="message" class="form-control" id="textArea" rows="8"></textarea>
        </div>
        <div class="col-3"></div>
    </div>
    <div class="row">
        <div class="col-4"></div>
        <div class="col-4">
            ${requestScope.besked}
        </div>
        <div class="col-4"></div>
    </div>
    <div class="row">
        <div class="col-7"></div>
        <div class="col-2">
            <input type="submit" class="btn btn-primary" value="Send Besked">
        </div>
        <div class="col-4"></div>
    </div>
</form>


<%@include file="../include/footer.inc" %>