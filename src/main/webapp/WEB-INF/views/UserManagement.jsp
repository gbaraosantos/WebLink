<%--@elvariable id="_csrf" type="org.springframework.security.web.csrf.CsrfAuthenticationStrategy.SaveOnAccessCsrfToken"--%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

</head>

<body>
<section id="container" class="">
    <header class="header dark-bg">
        <div class="toggle-nav">
            <div class="icon-reorder tooltips" data-original-title="Toggle Navation" data-placement="bottom"><i class="icon_menu"></i></div>
        </div>

        <a href="<c:url value="/weblink" />" class="logo">WEB<span class="lite">LINK</span></a>

        <!-- START Buttons top right -->
        <div class="top-nav notification-row">
            <ul class="nav pull-right top-menu">

                <!-- START Person Icon, Name Menu -->
                <li class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <div class="parent">
                            <span class="profile-ava">
                                <img alt="" style= "height:45px; width: 45px; " src = "<c:url value="${pageContext.request.contextPath}/customImgLoader?dir=${User.avatarLocation}" />">

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
                                    <th>&nbsp;</th>
                                    <th><i class="icon_key"></i>Id</th>
                                    <th><i class="icon_profile"></i> Nome Completo </th>
                                    <th><i class="icon_calendar"></i> Data de Nascimento</th>
                                    <th><i class="icon_mail_alt"></i> Email</th>
                                    <th><i class="icon_pin_alt"></i> Morada</th>
                                    <th><i class="icon_pin_alt"></i> Nacionalidade</th>

                                </tr>

                                <d:forEach var="user" items="${userList}">
                                    <tr data-toggle="collapse" data-target="#demo${user.id}" class="accordion-toggle" aria-expanded="true" aria-controls="demo${user.id}">>
                                        <td><button class="btn btn-default btn-xs"><span class="glyphicon glyphicon-eye-open"></span></button></td>
                                        <td>${user.id}</td>
                                        <td>${user.name}</td>
                                        <td><fmt:formatDate pattern="yyyy-MM-dd" type="DATE" value="${user.dateBirth}"/></td>
                                        <td>${user.email}</td>
                                        <td>${user.address}</td>
                                        <td>${user.nationality}</td>
                                    </tr>
                                    <tr>
                                        <td colspan="12" style="padding: 0; background-color:rgba(75, 75, 100, 0.14);" >
                                            <div class="accordian-body collapse" id="demo${user.id}" style="background-color:rgba(0, 0, 0, 0);">
                                                <table class="table" style="background-color:rgba(0, 0, 0, 0);">
                                                    <thead>
                                                    <tr>
                                                        <th>Imagem de Perfil</th>
                                                        <th>Data de Registo</th>
                                                        <th>Estado</th>
                                                        <th>Data da Última Alteração</th>
                                                        <th>Acções</th>
                                                        <th>Permissões</th>

                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr>
                                                        <td> <img alt="" style= "height:100px; width: 100px; " src = "<c:url value="${pageContext.request.contextPath}/customImgLoader?dir=${user.avatarLocation}" />"></td>
                                                        <td><fmt:formatDate pattern="yyyy-MM-dd" type="DATE" value="${user.regDate}"/></td>
                                                        <td>${user.state}</td>
                                                        <td><fmt:formatDate pattern="yyyy-MM-dd" type="DATE" value="${user.lastChangeDate}"/></td>
                                                        <td>
                                                            <a class="btn btn-danger" href="<c:url value="/admin/ban?user_id=${user.id}" />"><i class="fa fa-trash-o fa-lg"></i> Ban</a>
                                                            <a class="btn btn-success" href="<c:url value="/admin/unban?user_id=${user.id}" />"><i class="icon_check_alt2"></i> Set Active</a>
                                                        </td>
                                                        <td>
                                                            <table class="table" style="background-color:rgba(0, 0, 0, 0);">
                                                                <tr>
                                                                    <td>Administrador</td>
                                                                    <td>${user.hasPermission('Admin')}</td>

                                                                    <d:choose>
                                                                        <d:when test="${user.hasPermission('Admin')}">
                                                                            <td><a class="btn btn-danger" href="<c:url value="/admin/remPermission?user_id=${user.id}&perm=Admin" />"><i class="icon_close_alt2"></i></a></td>
                                                                        </d:when>
                                                                        <d:otherwise>
                                                                            <td><a class="btn btn-primary" href="<c:url value="/admin/addPermission?user_id=${user.id}&perm=Admin" />"><i class="icon_plus_alt2"></i></a></td>
                                                                        </d:otherwise>
                                                                    </d:choose>
                                                                </tr>
                                                                <tr>
                                                                    <td>Coordenador</td>
                                                                    <td>${user.hasPermission('Coordinator')}</td>

                                                                    <d:choose>
                                                                        <d:when test="${user.hasPermission('Coordinator')}">
                                                                            <td><a class="btn btn-danger" href="<c:url value="/admin/remPermission?user_id=${user.id}&perm=Coordinator" />"><i class="icon_close_alt2"></i></a></td>
                                                                        </d:when>
                                                                        <d:otherwise>
                                                                            <td><a class="btn btn-primary" href="<c:url value="/admin/addPermission?user_id=${user.id}&perm=Coordinator" />"><i class="icon_plus_alt2"></i></a></td>
                                                                        </d:otherwise>
                                                                    </d:choose>
                                                                </tr>
                                                                <tr>
                                                                    <td>Professor</td>
                                                                    <td>${user.hasPermission('Teacher')}</td>

                                                                    <d:choose>
                                                                        <d:when test="${user.hasPermission('Teacher')}">
                                                                            <td><a class="btn btn-danger" href="<c:url value="/admin/remPermission?user_id=${user.id}&perm=Teacher" />"><i class="icon_close_alt2"></i></a></td>
                                                                        </d:when>
                                                                        <d:otherwise>
                                                                            <td><a class="btn btn-primary" href="<c:url value="/admin/addPermission?user_id=${user.id}&perm=Teacher" />"><i class="icon_plus_alt2"></i></a></td>
                                                                        </d:otherwise>
                                                                    </d:choose>
                                                                </tr>
                                                                <tr>
                                                                    <td>Utilizador</td>
                                                                    <td>${user.hasPermission('User')}</td>

                                                                    <d:choose>
                                                                        <d:when test="${user.hasPermission('User')}">
                                                                            <td><a class="btn btn-danger" href="<c:url value="/admin/remPermission?user_id=${user.id}&perm=User" />"><i class="icon_close_alt2"></i></a></td>
                                                                        </d:when>
                                                                        <d:otherwise>
                                                                            <td><a class="btn btn-primary" href="<c:url value="/admin/addPermission?user_id=${user.id}&perm=User" />"><i class="icon_plus_alt2"></i></a></td>
                                                                        </d:otherwise>
                                                                    </d:choose>
                                                                </tr>

                                                            </table>
                                                        </td>

                                                    </tr>
                                                    </tbody>
                                                </table>

                                            </div>
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