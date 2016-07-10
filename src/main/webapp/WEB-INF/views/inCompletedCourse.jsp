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

    <meta property="fb:app_id" content="1236025403088867">
    <meta property="og:url" content="https://elearning.konkrets.pt/">
    <meta property="og:title" content="Melhor plataforma de elearning do mercado.">
    <meta property="og:description" content="Plataforma de elearning com os melhores precos. Vem ver.">
    <meta property="og:image" content="http://elearning.konkrets.pt/resources/images/successCourse/pass.png">
    <meta property="og:image:secure_url" content="https://elearning.konkrets.pt/resources/images/successCourse/pass.png">
    <meta property="og:image:type" content="image/png">
    <meta property="og:image:width" content="256">
    <meta property="og:image:height" content="256">

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
    <script src="<c:url value="/resources/js/course/materialType.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/course/scripts.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/course/inCourse.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/social/friendRequest.js" />" type="text/javascript"></script>

    <script src="<c:url value="/resources/js/SweetAlerts/sweetalert-dev.js" />" type="text/javascript"></script>
    <link href="<c:url value="/resources/css/SweetAlerts/sweetalert.css" />" rel="stylesheet">


    <script>(function(e,t,n){var r=e.querySelectorAll("html")[0];r.className=r.className.replace(/(^|\s)no-js(\s|$)/,"$1js$2")})(document,window,0);</script>

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
                            <h3 class="page-header"><i class="fa fa-laptop"></i>${action.getCourse().getName()} </h3>
                        </div>

                        <div style="float: clear"></div>

                    </div>

                    <ol class="breadcrumb">
                        <li><i class="fa fa-home"></i><a href="<c:url value="/" />">Home</a></li>
                        <li><i class="fa fa-laptop"></i><a href="<c:url value="/weblink" />">Dashboard</a></li>
                        <li><i class="fa fa-unlock-alt"></i><a href="<c:url value="/weblink/completedCourses" />">My Courses</a></li>
                        <li><i class="fa fa-bookmark-o"></i>${action.getCourse().getName()}</li>
                    </ol>
                </div>
            </div>


            <div class="panel">
                <div class = "panel-body" >
                    <div class="col-lg-4">
                        <span><h4><b>Obteve: </b> ${student.getFinalGrade()}%</h4></span>
                    </div>

                    <div class="col-lg-4">
                        <span><h4><b>Data Fim: </b><fmt:formatDate pattern="yyyy-MM-dd" type="DATE" value="${action.getEndDate()}"/></h4></span>
                    </div>

                    <d:choose>
                        <d:when test="${(student.getFinalGrade() >= 50)}">
                            <div class="col-lg-4">
                                <span><h4><b>Resultado: </b> Passado</h4></span>
                            </div>
                        </d:when>
                        <d:otherwise>
                            <div class="col-lg-4">
                                <span><h4><b>Resultado: </b> Chumbado</h4></span>
                            </div>
                        </d:otherwise>
                    </d:choose>

                </div>
            </div>

            <div class="row">
                <d:choose>
                    <d:when test="${(student.getFinalGrade() < 50)}">
                        <center>
                            <img src="<c:url value="/resources/images/successCourse/fail.png" />" alt="title"/>

                        </center>
                    </d:when>

                    <d:otherwise>
                            <div class="col-lg-12">
                                <center>
                                    <img src="<c:url value="/resources/images/successCourse/pass.png" />" alt="title"/>
                                </center>
                            </div>

                        <div class="col-lg-12">
                            <center>
                                <a href="<c:url value="/getCertificate?student=${student.getId()}" />" class="btn btn-info btn-large"><i class = "fa fa-graduation-cap"></i>Pedir Diploma </a>
                                <a onclick="funcao()" class="btn btn-info btn-large"><i class = "fa fa-graduation-cap"></i>Share the platform </a>
                            </center>
                        </div>


                    </d:otherwise>
                </d:choose>



            </div>

            <button onclick="funcao()"></button>

        </section>
    </section>
</section>


<script src="<c:url value="/resources/js/Input/custom-file-input.js"/>" type="text/javascript"></script>
<script>
    window.fbAsyncInit = function() {
        FB.init({
            appId      : '1236025403088867',
            xfbml      : true,
            version    : 'v2.6'
        });
    };

    (function(d, s, id){
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) {return;}
        js = d.createElement(s); js.id = id;
        js.src = "//connect.facebook.net/en_US/sdk.js";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));

    function funcao(){
        FB.ui(
                {
                    method: 'share',
                    href: 'https://elearning.konkrets.pt'
                }, function(response){});
    }
</script>

<script>


    session.publish('myPublisherDiv', {width: 320, height: 240});
    //knob
    $(".knob").knob();

</script>
</body>
</html>
