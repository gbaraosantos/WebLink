<%--@elvariable id="_csrf" type="org.springframework.security.web.csrf.CsrfAuthenticationStrategy.SaveOnAccessCsrfToken"--%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">

<head>
    <spring:htmlEscape defaultHtmlEscape="true" />
    <meta charset="utf-8" >
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>WebLink -- Konkrets,Lda</title>

    <!-- CSS -->
    <link href="<c:url value="/resources/css/Bootstrap/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/fontAwesome/Fontcss/font-awesome.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/Login/form-elements.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/Login/style.css" />" rel="stylesheet">
    <link href="<c:url value="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500" />" rel="stylesheet">

    <script src="<c:url value="https://code.jquery.com/jquery-2.1.3.min.js" />" type="text/javascript"></script>

    <!-- Alerts -->

    <script src="<c:url value="/resources/js/SweetAlerts/sweetalert-dev.js" />" type="text/javascript"></script>
    <link href="<c:url value="/resources/css/SweetAlerts/sweetalert.css" />" rel="stylesheet">
    <!--.......................-->

    <script src="<c:url value="/resources/js/Bootstrap/bootstrap.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/Login/LoginRegister.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/jQuery/jquery.backstretch.min.js" />" type="text/javascript"></script>

</head>

<body background="<c:url value="/resources/images/Login/2.jpg" />">

<!-- Top content -->

<div class="top-content">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong><span style="color: #FF9933;">Web</span>Link</strong> e-Learning Platform</h1>
                    <div class="description">
                        <p>
                            Password Recovery
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">


                        <div class="form-top-left">
                            <p style="color: #d43f3a;">${errorMessage}</p>
                            <p style="color: #34AD34;">${success}</p>
                            <h3>Recuperação de Password</h3>
                            <p>Preencha com o seu email:</p>
                        </div>
                        <div class="form-top-right">
                            <span class="fa fa-lock" style="font-style: italic;"></span>
                        </div>
                    </div>

                    <div class="form-bottom">
                        <form role="form" action="<c:url value="/passwordResetConfirmation?token=${token}"/>" method="post" class="login-form" >
                            <div class = "input-group" style="margin-bottom: 7px;">
                                <input class="form-control" placeholder="Password" name="password" type="password" id = "password">
                                <span class="input-group-addon glyphicon glyphicon-lock" id="basic-addon6"></span>

                            </div>

                            <div class = "input-group">
                                <input class="form-control" placeholder="Repita a Password" name="password_again" id= "re_password" type="password">
                                <span class="input-group-addon glyphicon glyphicon-lock" id="basic-addon7"></span>
                            </div>

                            <br>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <button type="submit" class="btn" onclick="return verify_login();">Mande email!</button>
                        </form>

                    </div>
                </div>
            </div>

        </div>
    </div>

</div>
</body>

</html>