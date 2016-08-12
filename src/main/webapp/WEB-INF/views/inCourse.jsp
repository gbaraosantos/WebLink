<%--@elvariable id="_csrf" type="org.springframework.security.web.csrf.CsrfAuthenticationStrategy.SaveOnAccessCsrfToken"--%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Weblink :: eLearning</title>

    <!-- CSS -->
    <link href="<c:url value="/resources/css/Bootstrap/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/Bootstrap/bootstrap-theme.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/Icons/elegant-icons-style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/fontAwesome/Fontcss/font-awesome.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/main/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/callendar/fullcalendar.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/callendar/bootstrap-fullcalendar.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/main/style-responsive.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/course_icons/icont2.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/Input/component.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/Input/normalize.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/Loader/loader.css" />" rel="stylesheet">
    <!-- JS -->
    <script src="<c:url value="/resources/js/main/jquery.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/jquery-ui-1.10.4.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/jquery-1.8.3.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/jquery-ui-1.9.2.custom.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/bootstrap.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/jquery.scrollTo.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/jquery.nicescroll.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/jquery.knob.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/course/materialType.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/course/scripts.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/course/inCourse.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/social/friendRequest.js" />" type="text/javascript"></script>

    <script src="<c:url value="/resources/js/callendar/fullcalendar.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/callendar/fullcalendar.min.js" />" type="text/javascript"></script>


    <script src="<c:url value="/resources/js/SweetAlerts/sweetalert-dev.js" />" type="text/javascript"></script>
    <link href="<c:url value="/resources/css/SweetAlerts/sweetalert.css" />" rel="stylesheet">




    <script>(function(e,t,n){var r=e.querySelectorAll("html")[0];r.className=r.className.replace(/(^|\s)no-js(\s|$)/,"$1js$2")})(document,window,0);</script>

</head>

<body>


<div aria-hidden="true" aria-labelledby="myModelLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
    <div class="modal-dialog" style = "width: 800px; margin:0 -400px; height: auto; position: absolute; overflow: visible;" >
        <div class="modal-content">
            <div class="modal-header">
                <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                <h4 class="modal-title">Adicao de avaliacao</h4>
            </div>

            <div class="modal-body">
                <div class="panel-body bio-graph-info">
                    <form class="form-horizontal" role="form" action="<c:url value="/teacher/addevaluation?actionId=${action.getId()}"/>" method="post">

                        <div class="form-group">
                            <div class = "col-lg-12">
                                <div class="col-lg-6" style="padding-left: 0">
                                    <label class="col-lg-5 control-label" style="text-align: left">Data: </label>
                                    <div class="col-lg-7">
                                        <input type="date" class="form-control" name="date" id="date" autocomplete="off" placeholder="mm/dd/yyyy">
                                    </div>
                                </div>

                                <div class="col-lg-6" style="padding-left: 0">
                                    <label class="col-lg-5 control-label" style="text-align: left" >Tipo:</label>
                                    <div class="col-lg-7">
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="optionsRadios" id="class" value="1" checked>
                                                Class
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="optionsRadios" id="notclass" value="0">
                                                Quiz
                                            </label>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class = "col-lg-12">
                                <div class="col-lg-6" style="padding-left: 0">
                                    <label class="col-lg-5 control-label" style="text-align: left">Hora de inicio: </label>
                                    <div class="col-lg-7">
                                        <input type="time" class="form-control" name="time" id="time" autocomplete="off" placeholder="hh/mm">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <center>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <button type="submit" onclick="return verify_newCourse();" class="btn btn-primary">Save</button>
                        </center>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<section id="container" class="">
    <header class="header dark-bg">
        <div class="toggle-nav">
            <div class="icon-reorder tooltips" data-original-title="Toggle Navigation" data-placement="bottom"><i class="icon_menu"></i></div>
        </div>

        <a href="<c:url value="/weblink" />" class="logo">WEB<span class="lite">LINK</span></a>


        <!-- START Buttons top right -->
        <div class="top-nav notification-row">
            <ul class="nav pull-right top-menu">


                <li id="task_notificatoin_bar" class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">

                        <i class="fa fa-users"></i>
                        <span class="badge bg-important">${nrRequestsPending}</span>
                    </a>
                    <ul class="dropdown-menu extended notification">
                        <div class="notify-arrow notify-arrow-blue"></div>
                        <li>
                            <p class="blue">Tem ${nrRequestsPending} pedidos de amizade</p>
                        </li>

                        <d:forEach var="toUser" items="${toMePending}">

                            <span class="label label-primary"><i class="icon_profile"></i></span>
                            <b style="color: #585858">${toUser.getUserA().getName()}</b>
                                <span class="small italic pull-right" style="color:#585858">
                                    <fmt:formatDate pattern="yyyy-MM-dd" type="DATE" value="${toUser.getRequestDate()}"/>
                                </span>

                            <div class="col-lg-12" style="margin-top: 0; margin-bottom: 10px">
                                <div class="col-lg-6" style="text-align: center;">
                                    <a style="color: #36c838" onclick="acceptRequestAjax(${toUser.getId()})"><i class="fa fa-check-circle-o fa-2x"></i></a>
                                </div>

                                <div class="col-lg-6" style="text-align: center;">
                                    <a style="color: #c84e27" onclick="deleteRequestAjax(${toUser.getId()})"><i class="fa fa-times-circle-o fa-2x"></i></a>
                                </div>
                            </div>

                        </d:forEach>


                        <li>
                            <a href="<c:url value="/weblink/social" />">Ver todos</a>
                        </li>
                    </ul>
                </li>

                <li id="mail_notificatoin_bar" class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">

                        <i class="fa fa-envelope"></i>
                        <span class="badge bg-important">${nrMessages}</span>
                    </a>
                    <ul class="dropdown-menu extended notification">
                        <div class="notify-arrow notify-arrow-blue"></div>
                        <li>
                            <p class="blue">Tem ${nrMessages} novas mensages</p>
                        </li>

                        <d:forEach var="message" items="${receivedList}">

                            <span class="label label-primary"><i class="icon_envelope"></i></span>
                            <b style="color: #585858">${message.getFrom().getName()}</b>
                            <span class="small italic pull-right" style="color:#585858">
                                <fmt:formatDate pattern="yyyy-MM-dd" type="DATE" value="${message.getSentDate()}"/>
                            </span>

                        </d:forEach>


                        <li>
                            <a href="<c:url value="/weblink/social" />">Ver todos</a>
                        </li>
                    </ul>
                </li>



                <!-- START Person Icon, Name Menu -->
                <li class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <div class="parent">
                            <span class="profile-ava">
                                <img alt="" style= "height:34px; width: 34px; " src = "<c:url value="${pageContext.request.contextPath}/customImgLoader?dir=${User.avatarLocation}" />">

                            </span>
                            <span class="username">${User.email}</span>
                            <b class="caret"></b>
                        </div>
                    </a>
                    <ul class="dropdown-menu extended logout">
                        <div class="log-arrow-up"></div>
                        <li class="eborder-top"> <a href="<c:url value="/weblink/profile" />"><i class="icon_profile"></i> My Profile</a> </li>
                        <li> <a href="#"><i class="icon_mail_alt"></i> My Inbox</a> </li>
                        <li> <a href="<c:url value="/logout" />"><i class="icon_key_alt"></i> Log Out</a> </li>
                    </ul>
                </li>
                <!-- END Person Icon, Name Menu -->

            </ul>
        </div>
        <!-- END Buttons top right -->


    </header>

    <aside>
        <div id="sidebar"  class="nav-collapse ">
            <!-- sidebar menu start-->
            <ul class="sidebar-menu">

                <sec:authorize access="hasRole('User')">
                    <li>
                        <a class="" href="<c:url value="/weblink" />">
                            <i class="fa fa-laptop"></i>
                            <span>&nbsp; Dashboard</span>
                        </a>
                    </li>
                    <li>
                        <a class="" href="<c:url value="/weblink/courses" />">
                            <i class="fa fa-lightbulb-o"></i>
                            <span>&nbsp; Cursos</span>
                        </a>
                    </li>

                    <li>
                        <a class="" href="<c:url value="/weblink/myCourses" />">
                            <i class="fa fa-unlock-alt"></i>
                            <span>&nbsp; Meus Cursos</span>
                        </a>
                    </li>

                    <li>
                        <a class="" href="<c:url value="/weblink/social" />">
                            <i class="fa fa-wechat"></i>
                            <span>&nbsp; Social</span>
                        </a>
                    </li>

                    <li>
                        <a class="" href="<c:url value="/weblink/completedCourses" />">
                            <i class="fa fa-trophy"></i>
                            <span>&nbsp; Cursos Completos</span>
                        </a>
                    </li>
                </sec:authorize>


                <sec:authorize access="hasRole('Admin')">
                    <li class="sub-menu">
                        <a href="javascript:;" class="">
                            <i class="fa fa-gavel"></i>
                            <span>Admin Zone</span>
                            <span class="menu-arrow arrow_carrot-right"></span>
                        </a>
                        <ul class="sub">
                            <li><a class="" href="<c:url value="/admin/userManagement" />">User Management</a></li>
                            <li><a class="" href="<c:url value="/admin/certificateRequestsManagement" />">Cert Requests</a></li>
                        </ul>
                    </li>
                </sec:authorize>


            </ul>
            <!-- sidebar menu end-->
        </div>
    </aside>

    <!-- Center Content -->
    <section id="main-content">
        <section class="wrapper">
            <div class="row">
                <div class="col-lg-12">

                    <div class="col-lg-12">
                        <div style="float:left">
                            <h3 class="page-header"><i class="fa fa-laptop"></i>${mpa.getModule().getName()} </h3>
                        </div>
                        <d:choose>
                            <d:when test="${(running == 'true') && (isTeacher == 'true')}">
                                <div style="float:right">
                                    <form:form action="/uploadMaterial?action=${mpa.getAction().getId()}&&${_csrf.parameterName}=${_csrf.token}"  modelAttribute="fileBucket" method="post" enctype="multipart/form-data">
                                        <form:input path="file" onchange="this.form.submit();" type="file" name="file-5[]" id="file-5" class="inputfile inputfile-4"/>
                                        <label for="file-5" style="margin-top: 0"><figure style="height: 50px; width: 50px"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17"><path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"></path></svg></figure></label>
                                    </form:form>
                                </div>
                            </d:when>
                        </d:choose>

                        <div style="float: clear"></div>

                    </div>

                    <ol class="breadcrumb">
                        <li><i class="fa fa-home"></i><a href="<c:url value="/" />">Home</a></li>
                        <li><i class="fa fa-laptop"></i><a href="<c:url value="/weblink" />">Dashboard</a></li>
                        <li><i class="fa fa-unlock-alt"></i><a href="<c:url value="/weblink/myCourses" />">My Courses</a></li>
                        <li><i class="fa fa-bookmark-o"></i>${mpa.getModule().getName()}</li>
                    </ol>
                </div>
            </div>

            <div class="col-lg-12">
                <h3>Proxima aula: ${nClass}</h3>

            </div>


            <div class="col-lg-12" style="margin-bottom: 20px">
                <div class="col-lg-4"></div>
                <div class="col-lg-1">
                    <a href="<c:url value="/weblink/classroom?mpa=${mpa.getId()}" />" class="btn btn-info btn-large"><i class = "fa fa-graduation-cap"></i> Sala de Aula</a>
                </div>
                <div class="col-lg-2">

                </div>
                <div class="col-lg-1">
                    <a href="<c:url value="/weblink/conference?mpa=${mpa.getId()}" />" class="btn btn-info btn-large"><i class = "fa fa-desktop"></i> Sala de Conferência</a>
                </div>
                <div class="col-lg-4"></div>

            </div>

            <div style="height: auto; text-align: center; margin-top: 30px">
                <h3 style="color: #d16826"><b>${someError}</b></h3>
            </div>

            <d:choose>
                <d:when test="${(running == 'true')}">
                    <div class="col-lg-12">
                        <div class="panel">
                            <div class="panel-heading" style="height: 45px; padding: 0; margin-top: 0">
                                <ul class="nav nav-tabs nav-justified" style="margin: 0">
                                    <li><a href="#Materiais" aria-controls="Materiais" role="tab" data-toggle="tab"><h5 style="color: #3870bc" class="modal-title"><b>Materiais</b></h5></a></li>
                                    <li><a href="#Avaliacoes" aria-controls="Avaliacoes" role="tab" data-toggle="tab"><h5 style="color: #3870bc" class="modal-title"><b>Avaliacoes</b> </h5></a></li>
                                </ul>
                            </div>

                            <div class="tab-content">


                                <div role="tabpanel" class="tab-pane" id="Materiais">
                                    <div class="panel-body" style="padding: 0">
                                        <center>
                                            <div class="btn-row">
                                                <div class="btn-group" data-toggle="buttons">
                                                    <label class="btn btn-default active">
                                                        <input type="radio" name="options" id="option1" onchange="activateVideos();"> Videos
                                                    </label>
                                                    <label class="btn btn-default">
                                                        <input type="radio" name="options" id="option2" onchange="activateSound();"> Audio
                                                    </label>
                                                    <label class="btn btn-default">
                                                        <input type="radio" name="options" id="option3" onchange="activateImages();"> Imagens
                                                    </label>
                                                    <label class="btn btn-default">
                                                        <input type="radio" name="options" id="option4"  onchange="activateDownloadables();"> Descarregaveis
                                                    </label>
                                                </div>
                                            </div>
                                        </center>


                                        <div class="col-lg-12" id="Videos">
                                            <d:forEach var="material" items="${materials}">
                                                <d:choose>
                                                    <d:when test="${material.getFileType() == 'video'}">
                                                        <div class="col-lg-4" style="border: solid #b5b5b5 thin; padding-top: 10px;">
                                                            <div class="col-lg-12" style="background-color: #dfdfdf">
                                                                <div class="col-lg-9">
                                                                    <b>Id: </b> ${material.getId()}
                                                                </div>

                                                                <d:choose>
                                                                    <d:when test="${(isTeacher == 'true')}">
                                                                        <div class="col-lg-1">
                                                                            <a style="color: #91280c" onclick="return deleteMaterial(${material.getId()},${mpa.getAction().getId()})"><i class="fa fa-times"></i></a>                                                                        </div>

                                                                    </d:when>
                                                                </d:choose>

                                                                <div class="col-lg-1">
                                                                    <a href="<c:url value="${pageContext.request.contextPath}/materialLoader?dir=${material.getDirectory()}" />" download="<c:url value="${pageContext.request.contextPath}/materialLoader?dir=${material.getDirectory()}" />" ><i class="fa fa-arrow-down"></i></a>
                                                                </div>
                                                            </div>

                                                            <div class="col-lg-12">
                                                                <div class="col-lg-12">
                                                                    <p><b>Name: </b> ${material.getName()}</p>
                                                                </div>
                                                            </div>

                                                            <video width="400" height="250" controls preload="metadata">
                                                                <source src="<c:url value="${pageContext.request.contextPath}/materialLoader?dir=${material.getDirectory()}" />" type='video/webm;' />
                                                                Your browser does not support HTML5 video.
                                                            </video>
                                                        </div>
                                                    </d:when>
                                                </d:choose>
                                            </d:forEach>
                                        </div>

                                        <div class="col-lg-12" id="Sounds" style="display: none; padding: 0; margin-left: 0; margin-right: 0">
                                            <d:forEach var="material" items="${materials}">
                                                <d:choose>
                                                    <d:when test="${material.getFileType() == 'sound'}">

                                                        <div class="col-lg-4" style="border: solid #b5b5b5 thin; padding-top: 10px;">
                                                            <div class="col-lg-12" style="background-color: #dfdfdf">
                                                                <div class="col-lg-9">
                                                                    <b>Id: </b> ${material.getId()}
                                                                </div>
                                                                <d:choose>
                                                                    <d:when test="${(isTeacher == 'true')}">
                                                                        <div class="col-lg-1">
                                                                            <a style="color: #91280c" onclick="return deleteMaterial(${material.getId()},${mpa.getAction().getId()})"><i class="fa fa-times"></i></a>                                                                        </div>
                                                                    </d:when>
                                                                </d:choose>
                                                                <div class="col-lg-1">
                                                                    <a href="<c:url value="${pageContext.request.contextPath}/materialLoader?dir=${material.getDirectory()}" />" download="<c:url value="${pageContext.request.contextPath}/materialLoader?dir=${material.getDirectory()}" />" ><i class="fa fa-arrow-down"></i></a>
                                                                </div>
                                                            </div>

                                                            <div class="col-lg-12">
                                                                <div class="col-lg-12">
                                                                    <p><b>Name: </b> ${material.getName()}</p>

                                                                    <center>
                                                                        <audio controls preload="none">
                                                                            <source src="<c:url value="${pageContext.request.contextPath}/materialLoader?dir=${material.getDirectory()}" />" type="audio/mpeg">
                                                                            Your browser does not support the audio element.
                                                                        </audio>
                                                                    </center>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </d:when>
                                                </d:choose>
                                            </d:forEach>
                                        </div>

                                        <div class="col-lg-12" id="Images" style="display: none">
                                            <d:forEach var="material" items="${materials}">

                                                <d:choose>
                                                    <d:when test="${material.getFileType() == 'image'}">
                                                        <div class="col-lg-4" style="border: solid #b5b5b5 thin; padding-top: 10px;">
                                                            <div class="col-lg-12" style="background-color: #dfdfdf">
                                                                <div class="col-lg-9">
                                                                    <b>Id: </b> ${material.getId()}
                                                                </div>
                                                                <d:choose>
                                                                    <d:when test="${(isTeacher == 'true')}">
                                                                        <div class="col-lg-1">
                                                                            <a style="color: #91280c" onclick="return deleteMaterial(${material.getId()},${mpa.getAction().getId()})"><i class="fa fa-times"></i></a>
                                                                        </div>
                                                                    </d:when>
                                                                </d:choose>
                                                                <div class="col-lg-1">
                                                                    <a href="<c:url value="${pageContext.request.contextPath}/materialLoader?dir=${material.getDirectory()}" />" download="<c:url value="${pageContext.request.contextPath}/materialLoader?dir=${material.getDirectory()}" />" ><i class="fa fa-arrow-down"></i></a>
                                                                </div>
                                                            </div>
                                                            <div class="col-lg-12">
                                                                <div class="col-lg-12" style="max-height: 600px; padding-bottom: 10px">
                                                                    <p><b>Name: </b> ${material.getName()}</p>
                                                                    <center>
                                                                        <a href="<c:url value="${pageContext.request.contextPath}/materialLoader?dir=${material.getDirectory()}" />">
                                                                            <img width="300" height="150" id="img${material.getId()}" src="<c:url value="${pageContext.request.contextPath}/materialLoader?dir=${material.getDirectory()}" />"  alt="Skaret View"/></a>
                                                                    </center>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </d:when>
                                                </d:choose>
                                            </d:forEach>
                                        </div>
                                        <div class="col-lg-12" id="Downloadables" style="display: none">
                                            <d:forEach var="material" items="${materials}">

                                                <d:choose>
                                                    <d:when test="${material.getFileType() == 'other'}">
                                                        <div class="col-lg-12" style="border: solid #b5b5b5 thin; margin: 5px;">
                                                            <div class="col-lg-2">
                                                                <h4><b>Id: </b> ${material.getId()}</h4>
                                                            </div>

                                                            <div class="col-lg-3">
                                                                <h4><b>Data de upload: </b> <fmt:formatDate pattern="yyyy-MM-dd" type="DATE" value="${material.getCreationDate()}"/></h4>
                                                            </div>

                                                            <div class="col-lg-4">
                                                                <h4><b>Name: </b> ${material.getName()}</h4>
                                                            </div>
                                                            <d:choose>
                                                                <d:when test="${(isTeacher == 'true')}">
                                                                    <div class="col-lg-1" style="margin-top: 5px">
                                                                        <a style="color: #91280c" onclick="return deleteMaterial(${material.getId()},${mpa.getAction().getId()})"><i class="fa fa-times-circle-o fa-3x"></i></a>
                                                                    </div>
                                                                </d:when>
                                                            </d:choose>
                                                            <div class="col-lg-2" style="margin-top: 5px">
                                                                <a href="<c:url value="${pageContext.request.contextPath}/materialLoader?dir=${material.getDirectory()}" />" download="<c:url value="${pageContext.request.contextPath}/materialLoader?dir=${material.getDirectory()}" />" ><i class="fa fa-arrow-circle-down fa-3x"></i></a>
                                                            </div>
                                                        </div>
                                                    </d:when>
                                                </d:choose>
                                            </d:forEach>

                                        </div>
                                    </div>

                                </div>
                                <div role="tabpanel" class="tab-pane" id="Avaliacoes">
                                    <div class="panel-body" style="padding: 0">




                                        <center>
                                            <d:choose>
                                                <d:when test="${(running == 'true') && (isTeacher == 'true')}">
                                                    <a data-toggle="modal" href="<c:url value="#myModal" />" style="text-align: center; color: #384dd1; margin-right: 20px; ">
                                                        <i style="color: green;" class="fa fa-plus-circle fa-4x"></i>
                                                    </a>
                                                </d:when>
                                            </d:choose>
                                        </center>

                                        <d:set var="now" value="<%=new java.util.Date()%>" />


                                        <d:forEach var="eval" items="${evals}">

                                            <d:choose>
                                                <d:when test="${eval.isEvaluated() == 'true'}">
                                                    <div class="col-lg-11" style=" margin: 5px;">
                                                        <div class="col-lg-2">
                                                            <h4><b>Id: </b> ${eval.getId()}</h4>
                                                        </div>

                                                        <div class="col-lg-3">
                                                            <h4><b>Data de Criacao: </b> <fmt:formatDate pattern="yyyy-MM-dd" type="DATE" value="${eval.getCreationDate()}"/></h4>
                                                        </div>

                                                        <div class="col-lg-4">
                                                            <h4><b>Data de Preenchimento: </b> <fmt:formatDate pattern="yyyy-MM-dd" type="DATE" value="${eval.getDueDate()}"/></h4>
                                                        </div>
                                                        <d:choose>
                                                            <d:when test="${(isTeacher == 'true')}">
                                                                <div class="col-lg-1" style="margin-top: 5px">
                                                                    <a style="color: #91280c" onclick="return deleteEvaluation(${eval.getId()},${mpa.getAction().getId()})"><i class="fa fa-times-circle-o fa-3x"></i></a>
                                                                </div>

                                                                <div class="col-lg-2" style="margin-top: 5px">
                                                                    <a style="color: #214e91" href="<c:url value="/weblink/inEval?evalId=${eval.getId()}" />"><i class="fa fa-arrow-circle-right fa-3x"></i></a>
                                                                </div>
                                                            </d:when>
                                                            <d:when test="${eval.getDueDate() <= now}">
                                                                <div class="col-lg-2" style="margin-top: 5px">
                                                                    <a style="color: #214e91" href="<c:url value="/weblink/inEval?evalId=${eval.getId()}" />"><i class="fa fa-arrow-circle-right fa-3x"></i></a>
                                                                </div>
                                                            </d:when>
                                                        </d:choose>



                                                    </div>
                                                </d:when>
                                            </d:choose>
                                        </d:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </d:when>
            </d:choose>


        </section>
    </section>
</section>

<script src="<c:url value="/resources/js/callendar/calendar-custom.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/js/Input/custom-file-input.js"/>" type="text/javascript"></script>
<script>


    session.publish('myPublisherDiv', {width: 320, height: 240});
    //knob
    $(".knob").knob();

</script>
</body>
</html>
