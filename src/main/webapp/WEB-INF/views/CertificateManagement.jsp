d="_csrf" type="org.springframework.security.web.csrf.CsrfAuthenticationStrategy.SaveOnAccessCsrfToken"--%>
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
    <link href="<c:url value="/resources/css/main/bootstrap-fullcalendar.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/main/fullcalendar.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/main/jquery.easy-pie-chart.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/owlCarrosel/owl.carousel.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/JQuery/jquery-jvectormap-1.2.2.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/main/fullcalendar.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/main/widgets.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/main/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/main/style-responsive.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/xCharts/xcharts.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/JQuery/jquery-ui-1.10.4.min.css" />" rel="stylesheet">

    <!-- JS -->
    <script src="<c:url value="/resources/js/main/jquery.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/jquery-ui-1.10.4.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/jquery-1.8.3.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/jquery-ui-1.9.2.custom.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/bootstrap.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/jquery.scrollTo.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/jquery.nicescroll.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/jquery.knob.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/jquery.sparkline.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/jquery.easy-pie-chart.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/owl.carousel.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/fullcalendar.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/fullcalendar.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/calendar-custom.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/jquery.rateit.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/jquery.customSelect.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/Chart.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/scripts.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/sparkline-chart.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/easy-pie-chart.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/jquery-jvectormap-1.2.2.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/jquery-jvectormap-world-mill-en.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/xcharts.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/jquery.autosize.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/jquery.placeholder.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/gdp-data.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/morris.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/sparklines.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/charts.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/jquery.slimscroll.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/social/friendRequest.js" />" type="text/javascript"></script>

</head>

<body style="max-height: calc(100vh); overflow-y: auto">
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
        <section class="wrapper" >
            <div class="row">
                <div class="col-lg-12">
                    <h3 class="page-header"><i class="fa fa-gavel"></i> User Management </h3>
                    <ol class="breadcrumb">
                        <li><i class="fa fa-home"></i><a href="<c:url value="/" />">Home</a></li>
                        <li><i class="fa fa-laptop"></i><a href="<c:url value="/weblink" />">Dashboard</a></li>
                        <li><i class="fa fa-gavel"></i>User Management</li>
                    </ol>
                </div>
            </div>


            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <p style = "color: #b81900">${ErrorMessage}</p>
                        <p style = "color: #247000">${SuccessMessage}</p>

                        <table class="table table-striped table-advance table-hover">
                            <tbody>
                            <tr>
                                <th><i class="icon_key"></i>Id</th>
                                <th><i class="icon_profile"></i> Nome Curso </th>
                                <th><i class="icon_calendar"></i> Data da request</th>
                                <th><i class="icon_mail_alt"></i> Email</th>
                                <th><i class="icon_pin_alt"></i> Morada</th>
                                <th><i class="icon_pin_alt"></i> Nota final</th>
                                <th><i class="icon_pin_alt"></i> Apagar </th>
                            </tr>

                            <d:forEach var="cert" items="${certList}">
                                <tr>
                                    <td>${cert.id}</td>
                                    <td>${cert.getStudent().getAction().getCourse().getName()}</td>
                                    <td><fmt:formatDate pattern="yyyy-MM-dd" type="DATE" value="${cert.getCreationDate()}"/></td>
                                    <td>${cert.getStudent().getUser().getEmail()}</td>
                                    <td>${cert.getStudent().getUser().getAddress()}</td>
                                    <td>${cert.getStudent().getFinalGrade()}%</td>
                                    <td>
                                        <a href="<c:url value="/deleteCert?certId=${cert.id}" />"  style="color: #901b0b; " >
                                            <i class="fa fa-times fa-fw"></i>
                                        </a>

                                    </td>
                                </tr>
                            </d:forEach>


                            </tbody>
                        </table>
                    </section>
                </div>
            </div>


        </section>
    </section>








    <script src="<c:url value="/resources/js/Input/custom-file-input.js" />" type="text/javascript"></script>

    <script>

        //knob
        $(".knob").knob();

    </script>
</section>
</body>
</html>