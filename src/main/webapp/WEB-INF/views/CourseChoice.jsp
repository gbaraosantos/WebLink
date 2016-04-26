<%--@elvariable id="_csrf" type="org.springframework.security.web.csrf.CsrfAuthenticationStrategy.SaveOnAccessCsrfToken"--%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
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
    <script src="<c:url value="/resources/js/main/scripts.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/social/friendRequest.js" />" type="text/javascript"></script>

    <script src="<c:url value="/resources/js/SweetAlerts/sweetalert-dev.js" />" type="text/javascript"></script>
    <link href="<c:url value="/resources/css/SweetAlerts/sweetalert.css" />" rel="stylesheet">

</head>

<body>
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


                <li id="alert_notificatoin_bar" class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">

                        <i class="fa fa-bell"></i>
                        <span class="badge bg-important">7</span>
                    </a>
                    <ul class="dropdown-menu extended notification">

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
                    <h3 class="page-header"><i class="fa fa-laptop"></i> My Courses </h3>
                    <ol class="breadcrumb">
                        <li><i class="fa fa-home"></i><a href="<c:url value="/" />">Home</a></li>
                        <li><i class="fa fa-laptop"></i><a href="<c:url value="/weblink" />">Dashboard</a></li>
                        <li><i class="fa fa-unlock-alt"></i>My Courses</li>
                    </ol>
                </div>
            </div>

            <div style="height: auto; text-align: center; margin-top: 30px">
                <h3 style="color: #d16826"><b>${NoActionsSubbed}</b></h3>
            </div>

            <d:choose>
                <d:when test="${teaching != null}">
                    <center><h2>Formador</h2></center>
                    <div class="devider"></div>

                    <d:forEach var="action" items="${teaching}">

                        <div style="width:90%; margin: 0 auto;">
                            <div class="panel">
                                <div class = "panel-body" >
                                    <div class="col-lg-1" >
                                        <a href="<c:url value="/weblink/inCourse?action=${action.getId()}" />" class="rotate-box-2 square-icon text-center wow zoomIn" data-wow-delay="0" style="margin-top: 14px; margin-bottom: 0">
                                            <span class="rotate-box-icon"><i class="fa ${action.getCourse().getIcon()}"></i></span>
                                        </a>
                                    </div>

                                    <div class="col-lg-3">
                                        <span><h4><b>Nome Curso: </b>${action.getCourse().getName()}</h4></span>
                                        <span><h4><b>Area: </b>${action.getCourse().getArea()}</h4></span>
                                    </div>
                                    <div class="col-lg-3">
                                        <span><h4><b>Data Inicio: </b><fmt:formatDate pattern="yyyy-MM-dd" type="DATE" value="${action.getStartDate()}"/></h4></span>
                                        <span><h4><b>Data Fim: </b><fmt:formatDate pattern="yyyy-MM-dd" type="DATE" value="${action.getEndDate()}"/></h4></span>
                                    </div>
                                    <div class="col-lg-4">
                                        <div class="progress" style="height: 45px; margin-top: 14px">
                                            <div class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar" aria-valuenow="${action.percentageComplete()}" aria-valuemin="0" aria-valuemax="100" style="width:${action.percentageComplete()}% ">
                                                    ${action.percentageComplete()}% do curso completado
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-1">
                                        <a href="<c:url value="/weblink/inCourse?action=${action.getId()}" />" style="float:right; margin-top: 12px"> <i class="fa fa-arrow-right fa-3x"></i></a>
                                    </div>

                                </div>

                            </div>
                        </div>

                    </d:forEach>
                </d:when>
            </d:choose>

            <d:choose>
                <d:when test="${attending != null}">
                    <center><h2>Estudante</h2></center>
                    <div class="devider"></div>

                    <d:forEach var="action" items="${attending}">

                        <div style="width:90%; margin: 0 auto;">
                            <div class="panel">
                                <div class = "panel-body" >
                                    <div class="col-lg-1" >
                                        <a href="<c:url value="/weblink/inCourse?action=${action.getId()}" />" class="rotate-box-2 square-icon text-center wow zoomIn" data-wow-delay="0" style="margin-top: 14px; margin-bottom: 0">
                                            <span class="rotate-box-icon"><i class="fa ${action.getCourse().getIcon()}"></i></span>
                                        </a>
                                    </div>

                                    <div class="col-lg-3">
                                        <span><h4><b>Nome Curso: </b>${action.getCourse().getName()}</h4></span>
                                        <span><h4><b>Area: </b>${action.getCourse().getArea()}</h4></span>
                                    </div>
                                    <div class="col-lg-3">
                                        <span><h4><b>Data Inicio: </b><fmt:formatDate pattern="yyyy-MM-dd" type="DATE" value="${action.getStartDate()}"/></h4></span>
                                        <span><h4><b>Data Fim: </b><fmt:formatDate pattern="yyyy-MM-dd" type="DATE" value="${action.getEndDate()}"/></h4></span>
                                    </div>
                                    <div class="col-lg-4">
                                        <div class="progress" style="height: 45px; margin-top: 14px">
                                            <div class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar" aria-valuenow="${action.percentageComplete()}" aria-valuemin="0" aria-valuemax="100" style="width:${action.percentageComplete()}% ">
                                                    ${action.percentageComplete()}% do curso completado
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-1">
                                        <a href="<c:url value="/weblink/inCourse?action=${action.getId()}" />" style="float:right; margin-top: 12px"> <i class="fa fa-arrow-right fa-3x"></i></a>
                                    </div>

                                </div>

                            </div>
                        </div>

                    </d:forEach>

                </d:when>
            </d:choose>






        </section>
    </section>
</section>

<script>
    //knob
    $(function() {
        $(".knob").knob({
            'draw' : function () {
                $(this.i).val(this.cv + '%')
            }
        })
    });



</script>
</body>
</html>

