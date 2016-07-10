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
    <link href="<c:url value="/resources/css/Bootstrap/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/Bootstrap/bootstrap-theme.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/Icons/elegant-icons-style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/fontAwesome/Fontcss/font-awesome.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/main/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/main/style-responsive.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/Input/component.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/Input/normalize.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/Loader/loader.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/course_icons/icons.css" />" rel="stylesheet">

    <link href="<c:url value="/resources/css/iconpicker/bootstrap-iconpicker.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/chat/bubble.css" />" rel="stylesheet">

    <!-- JS -->
    <script src="<c:url value="/resources/js/jQuery/jquery-1.10.2.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/Bootstrap/bootstrap.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/jquery.scrollTo.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/jquery.nicescroll.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/jquery.knob.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/scripts.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/ga.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/jquery.hotkeys.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/jquery.tagsinput.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/bootstrap-switch.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/bootstrap-wysiwyg.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/bootstrap-wysiwyg-custom.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/form-component.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/course/teacher_handler.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/SweetAlerts/sweetalert-dev.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/social/friendRequest.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/Chart.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/chartjs-custom.js" />" type="text/javascript"></script>

</head>

<body>
<script src="<c:url value="https://static.opentok.com/v2/js/opentok.js"/>" charset="utf-8"></script>



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
                    <h3 class="page-header"><i class="fa fa-laptop"></i> Dashboard</h3>
                    <ol class="breadcrumb">
                        <li><i class="fa fa-home"></i><a href="<c:url value="/" />">Home</a></li>
                        <li><i class="fa fa-laptop"></i>Dashboard</li>
                    </ol>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                    <div class="info-box blue-bg">
                        <i class="fa fa-cloud-download"></i>
                        <div class="count">${nrLoginsMonth}</div>
                        <div class="title">Nr Logins este Mês</div>
                    </div><!--/.info-box-->
                </div><!--/.col-->

                <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                    <div class="info-box green-bg">
                        <i class="fa fa-cubes"></i>
                        <div class="count">${nrUsers}</div>
                        <div class="title">Número de Utilizadores</div>
                    </div><!--/.info-box-->
                </div><!--/.col-->

                <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                    <div class="info-box brown-bg">
                        <i class="fa fa-shopping-cart"></i>
                        <div class="count">${nrStudents}</div>
                        <div class="title">Número de estudantes</div>
                    </div><!--/.info-box-->
                </div><!--/.col-->

                <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                    <div class="info-box dark-bg">
                        <i class="fa fa-thumbs-o-up"></i>
                        <div class="count">${nrActions}</div>
                        <div class="title">Número de Cursos</div>
                    </div><!--/.info-box-->
                </div><!--/.col-->

            </div><!--/.row-->

            <div class="col-lg-6">
                <section class="panel">
                    <header class="panel-heading">
                        Movimentação ultimos 20 dias
                    </header>
                    <div class="panel-body text-center">
                        <canvas id="myChart" height="300" width="500"></canvas>
                    </div>
                </section>
            </div>

        </section>
    </section>
</section>

<script>
    var ctx = document.getElementById("myChart").getContext("2d");
    var array=${eventsPerDay}.reverse();
    var labelArray = [];
    var x;

    for(x = 0; x < array.length ; x++){
        labelArray[x] = "";

        if(x == array.length - 1)
            labelArray[x] = "Recente";

    }

    var data = {
        labels: labelArray,
        datasets: [
            {
                label: "Movimento Ultimos 20 dias",
                fillColor: "rgba(151,187,205,0.2)",
                strokeColor: "rgba(151,187,205,1)",
                pointColor: "rgba(151,187,205,1)",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(151,187,205,1)",
                data:array
            }
        ]
    };

    var myNewChart = new Chart(ctx).Line(data,
            {
                scaleShowGridLines : true,

                //String - Colour of the grid lines
                scaleGridLineColor : "rgba(0,0,0,.05)",

                //Number - Width of the grid lines
                scaleGridLineWidth : 1,

                //Boolean - Whether to show horizontal lines (except X axis)
                scaleShowHorizontalLines: false,

                //Boolean - Whether to show vertical lines (except Y axis)
                scaleShowVerticalLines: true,

                //Boolean - Whether the line is curved between points
                bezierCurve : true,

                //Number - Tension of the bezier curve between points
                bezierCurveTension : 0.4,

                //Boolean - Whether to show a dot for each point
                pointDot : true,

                //Number - Radius of each point dot in pixels
                pointDotRadius : 5,

                //Number - Pixel width of point dot stroke
                pointDotStrokeWidth : 1,

                //Number - amount extra to add to the radius to cater for hit detection outside the drawn point
                pointHitDetectionRadius : 20,

                //Boolean - Whether to show a stroke for datasets
                datasetStroke : true,

                //Number - Pixel width of dataset stroke
                datasetStrokeWidth : 2,

                //Boolean - Whether to fill the dataset with a colour
                datasetFill : true,

                showTooltips: true,
                customTooltips: false,
                tooltipEvents: ["mousemove", "touchstart", "touchmove"],

                // String - Tooltip background colour
                tooltipFillColor: "rgba(0,0,0,0.8)",

                // String - Tooltip label font declaration for the scale label
                tooltipFontFamily: "'Helvetica Neue', 'Helvetica', 'Arial', sans-serif",

                // Number - Tooltip label font size in pixels
                tooltipFontSize: 14,

                // String - Tooltip font weight style
                tooltipFontStyle: "normal",

                // String - Tooltip label font colour
                tooltipFontColor: "#fff",

                // String - Tooltip title font declaration for the scale label
                tooltipTitleFontFamily: "'Helvetica Neue', 'Helvetica', 'Arial', sans-serif",

                // Number - Tooltip title font size in pixels
                tooltipTitleFontSize: 14,

                // String - Tooltip title font weight style
                tooltipTitleFontStyle: "bold",

                // String - Tooltip title font colour
                tooltipTitleFontColor: "#fff",

                // Number - pixel width of padding around tooltip text
                tooltipYPadding: 6,

                // Number - pixel width of padding around tooltip text
                tooltipXPadding: 6,

                // Number - Size of the caret on the tooltip
                tooltipCaretSize: 8,

                // Number - Pixel radius of the tooltip border
                tooltipCornerRadius: 6,

                // Number - Pixel offset from point x to tooltip edge
                tooltipXOffset: 10,

                animationSteps: 60,

                // String - Animation easing effect
                // Possible effects are:
                // [easeInOutQuart, linear, easeOutBounce, easeInBack, easeInOutQuad,
                //  easeOutQuart, easeOutQuad, easeInOutBounce, easeOutSine, easeInOutCubic,
                //  easeInExpo, easeInOutBack, easeInCirc, easeInOutElastic, easeOutBack,
                //  easeInQuad, easeInOutExpo, easeInQuart, easeOutQuint, easeInOutCirc,
                //  easeInSine, easeOutExpo, easeOutCirc, easeOutCubic, easeInQuint,
                //  easeInElastic, easeInOutSine, easeInOutQuint, easeInBounce,
                //  easeOutElastic, easeInCubic]
                animationEasing: "easeOutQuart",

                // Boolean - If we should show the scale at all
                showScale: true,

                // Boolean - If we want to override with a hard coded scale
                scaleOverride: false,

                // ** Required if scaleOverride is true **
                // Number - The number of steps in a hard coded scale
                scaleSteps: null,
                // Number - The value jump in the hard coded scale
                scaleStepWidth: null,
                // Number - The scale starting value
                scaleStartValue: null,

                // String - Colour of the scale line
                scaleLineColor: "rgba(0,0,0,.1)",

                // Number - Pixel width of the scale line
                scaleLineWidth: 1,

                // Boolean - Whether to show labels on the scale
                scaleShowLabels: true,

                // Boolean - Whether the scale should stick to integers, not floats even if drawing space is there
                scaleIntegersOnly: true,

                // Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
                scaleBeginAtZero: false,

                // String - Scale label font declaration for the scale label
                scaleFontFamily: "'Helvetica Neue', 'Helvetica', 'Arial', sans-serif",

                // Number - Scale label font size in pixels
                scaleFontSize: 12,

                // String - Scale label font weight style
                scaleFontStyle: "normal",

                // String - Scale label font colour
                scaleFontColor: "#666",

                // Boolean - whether or not the chart should be responsive and resize when the browser does.
                responsive: false,

                // Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
                maintainAspectRatio: true,


                // Function - Will fire on animation progression.
                onAnimationProgress: function(){},

                // Function - Will fire on animation completion.
                onAnimationComplete: function(){},

                responsive: false

            });

</script>


</body>
</html>