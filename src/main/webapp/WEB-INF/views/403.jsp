<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html class="error-page">
    <head>
        <title>403 error page | Bootstrap 3.x Admin Theme</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link media="screen" href="<c:url value="/resources/css/Bootstrap/bootstrap.min.css" />" rel="stylesheet">
        <link media="screen" href="<c:url value="/resources/css/Bootstrap/bootstrap-theme.min.css" />" rel="stylesheet">
        <link media="screen" href="<c:url value="/resources/css/Bootstrap/bootstrap-admin-theme.css" />" rel="stylesheet">
        <link media="screen" href="<c:url value="/resources/css/Bootstrap/bootstrap-admin-theme-change-size.css" />" rel="stylesheet">

    </head>
    <body>

        <div class="container-fluid">
            <div class="row-fluid">
                <div class="col-lg-12">
                    <div class="centering text-center error-container">
                        <div class="text-center">
                            <h2 class="without-margin">Don't worry. It's <span class="text-warning"><big>403</big></span> error only.</h2>
                            <h4 class="text-warning">Dear <strong>${user}</strong>, You are not authorized to access this page</h4>
                        </div>
                        <div class="text-center">
                            <h3><small>Choose an option below</small></h3>
                        </div>
                        <hr>
                        <ul class="pager">
                            <li><a href="<c:url value="/" />">&larr; Home</a></li>
                            <li><a href="<c:url value="/logout" />">Logout</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <script src="<c:url value="http://code.jquery.com/jquery-2.0.3.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/bootstrap-admin-theme-change-size.js" />" type="text/javascript"></script>
    </body>
</html>
