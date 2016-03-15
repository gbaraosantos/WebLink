<%--@elvariable id="_csrf" type="org.springframework.security.web.csrf.CsrfAuthenticationStrategy.SaveOnAccessCsrfToken"--%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Weblink :: eLearning</title>

    <!-- CSS -->
    <link href="<c:url value="/resources/css/Bootstrap/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/Bootstrap/bootstrap-theme.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/Icons/elegant-icons-style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/fontAwesome/Fontcss/font-awesome.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/main/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/main/style-responsive.css" />" rel="stylesheet">
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

    <script src="<c:url value="/resources/js/SweetAlerts/sweetalert-dev.js" />" type="text/javascript"></script>
    <link href="<c:url value="/resources/css/SweetAlerts/sweetalert.css" />" rel="stylesheet">


    <script>(function(e,t,n){var r=e.querySelectorAll("html")[0];r.className=r.className.replace(/(^|\s)no-js(\s|$)/,"$1js$2")})(document,window,0);</script>


</head>

<body>
    <div id = "LoaderImage"> <img src="<c:url value="/resources/images/page-loader/ajax-loader.gif" />"> </div>



    <section id="container" class="">


        <header class="header dark-bg">
            <div class="toggle-nav">
                <div class="icon-reorder tooltips" data-original-title="Toggle Navigation" data-placement="bottom"><i class="icon_menu"></i></div>
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

                    <sec:authorize access="hasRole('User')">
                        <li>
                            <a class="" href="<c:url value="/weblink/courses" />">
                                <i class="fa fa-lightbulb-o"></i>
                                <span>&nbsp; Cursos</span>
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
                        <h3 class="page-header"><i class="fa fa-user-md"></i> Profile</h3>
                        <ol class="breadcrumb">
                            <li><i class="fa fa-home"></i><a href="<c:url value="/" />">Home</a></li>
                            <li><i class="fa fa-laptop"></i><a href="<c:url value="/weblink" />">Dashboard</a></li>
                            <li><i class="fa fa-user-md"></i>Profile</li>
                        </ol>
                    </div>


                    <div class="col-lg-12">
                        <div class="profile-widget profile-widget-info">

                            <div class="panel-body">
                                <div class="col-lg-2 col-sm-2">
                                    <h4>${User.name}</h4>
                                    <div class="follow-ava">
                                        <img src="<c:url value="${pageContext.request.contextPath}/customImgLoader?dir=${User.avatarLocation}"/>" alt="">
                                    </div>

                                    <d:forEach var="permission" items="${User.userProfiles}">
                                    <h6>${permission.type}</h6>
                                    </d:forEach>

                                </div>


                                <div class="col-lg-4 col-sm-4 follow-info">
                                    <p><b>Email:</b>&nbsp;${User.email}</p>

                                    <p><b>Data de nascimento:</b>&nbsp; <fmt:formatDate pattern="yyyy-MM-dd" type="DATE" value="${User.dateBirth}"/></p>
                                    <p><b>Data de Registo:</b>&nbsp; <fmt:formatDate pattern="yyyy-MM-dd" type="DATE" value="${User.regDate}"/></p>
                                    <p><b>Numero do utilizador: </b>&nbsp; ${User.id}</p>

                                    <h6>
                                        <span><i class="icon_key"></i>${User.state}</span>
                                        <span><i class="icon_calendar"></i><fmt:formatDate pattern="yyyy-MM-dd" type="DATE" value="${User.lastChangeDate}"/></span>
                                        <span><i class="icon_pin_alt"></i>${User.nationality}</span>
                                    </h6>
                                </div>



                                <div class="col-lg-2 col-sm-6 follow-info weather-category">
                                    <ul>

                                            <p> Upload de uma nova imagem. </p>
                                            <form:form action="/upload?${_csrf.parameterName}=${_csrf.token}"  modelAttribute="fileBucket" method="post" enctype="multipart/form-data">
                                                <form:input path="file" onchange="this.form.submit();" type="file" name="file-5[]" id="file-5" class="inputfile inputfile-4"/>
                                                <label for="file-5"><figure><svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17"><path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"></path></svg></figure> <span>Choose a Picture&hellip;</span></label>
                                            </form:form>



                                    </ul>
                                </div>

                                <div class="col-lg-2 col-sm-6 follow-info weather-category">
                                    <ul>
                                        <li class="active" style="height: 120px" >

                                            <i class="fa fa-comments fa-2x"> </i><br>

                                            <p style="color: #d43f3a;"><b>${ErrorUpload}</b></p>
                                            <p style="color: #16ad12;"><b>${Success}</b></p>

                                        </li>

                                    </ul>
                                </div>


                                <div class="col-lg-2 col-sm-6 follow-info weather-category">
                                    <ul>

                                        <p> Se decidir apagar a sua conta, clique na cruz abaixo </p>
                                        <a onclick="deleteConfirm('${User.email}'); " style="cursor: pointer;"><i class="fa fa-times fa-5x" style="color:#ff3738"> </i></a><br>

                                    </ul>
                                </div>
                            </div>

                        </div>
                    </div>


                    <div class="col-lg-12">
                        <section class="panel">
                            <div class="panel-body bio-graph-info">
                                <h1> Profile Info</h1>
                                <form class="form-horizontal" role="form" action="<c:url value="/weblink/profileUpdate"/>" method="post">
                                    <div class="form-group">
                                        <label class="col-lg-2 control-label">Nome Completo</label>
                                        <div class="col-lg-9">
                                            <input type="text" class="form-control" name="nome" id="nome" autocomplete="off" placeholder="${User.name}">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-lg-2 control-label">Email</label>
                                        <div class="col-lg-9">
                                            <input type="text" class="form-control" name="email" id="email" autocomplete="off" placeholder="${User.email}">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-lg-2 control-label">Password</label>
                                        <div class="col-lg-9">
                                            <input type="password" class="form-control" name="password" id="password" autocomplete="off" placeholder="Your new Password">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-lg-2 control-label">Repeat Password</label>
                                        <div class="col-lg-9">
                                            <input type="password" class="form-control" name="re_password" id="re_password" autocomplete="off" placeholder="Your new Password Again">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-lg-2 control-label">Pais</label>
                                        <div class="col-lg-9">
                                            <input type="text" class="form-control" name="nacionalidade" id="nacionalidade" autocomplete="off" placeholder="${User.nationality}">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-lg-2 control-label">Morada</label>
                                        <div class="col-lg-9">
                                            <input type="text" class="form-control" name="morada" id="morada" autocomplete="off" placeholder="${User.address}">
                                        </div>
                                    </div>

                                    <div class = "form-group">
                                        <label class="col-lg-2 control-label">Postal Code</label>
                                        <div  class="col-lg-2">
                                            <input class="form-control" name="postal1" id= "postal1" autocomplete="off" type="text" title="postal1" placeholder="${User.postal1}">
                                        </div>
                                        <div class="col-lg-2">
                                            <input class="form-control" name="postal2" id= "postal2" autocomplete="off" type="text" title="postal2" placeholder="${User.postal2}">
                                        </div>
                                    </div>

                                    <div class="form-group">

                                            <center>
                                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                                <button type="submit" onclick="return verify_profileUpdate();" class="btn btn-primary">Save</button>
                                            </center>

                                    </div>
                                </form>
                            </div>
                        </section>
                    </div>

                </div>
            </section>
        </section>
    </section>



    <script src="<c:url value="/resources/js/Input/custom-file-input.js" />" type="text/javascript"></script>

    <script>

        //knob
        $(".knob").knob();

    </script>

</body>
</html>