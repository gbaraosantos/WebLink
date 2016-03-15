<%--@elvariable id="_csrf" type="org.springframework.security.web.csrf.CsrfAuthenticationStrategy.SaveOnAccessCsrfToken"--%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
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
            <div class="icon-reorder tooltips" data-original-title="Toggle Nav

ation" data-placement="bottom"><i class="icon_menu"></i></div>
        </div>

        <a href="<c:url value="/weblink" />" class="logo">WEB<span class="lite"
ig
>LINK</span></a>

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
                    <h3 class="page-header"><i class="fa fa-laptop"></i> Dashboard</h3>
                    <ol class="breadcrumb">
                        <li><i class="fa fa-home"></i><a href="<c:url value="/" />">Home</a></li>
                        <li><i class="fa fa-laptop"></i>Dashboard</li>
                    </ol>
                </div>
            </div>
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

    //carousel
    $(document).ready(function() {
        $("#owl-slider").owlCarousel({
            navigation : true,
            slideSpeed : 300,
            paginationSpeed : 400,
            singleItem : true

        });
    });

    //custom select box

    $(function(){
        $('select.styled').customSelect();
    });

    /* ---------- Map ---------- */
    $(function(){
        $('#map').vectorMap({
            map: 'world_mill_en',
            series: {
                regions: [{
                    values: gdpData,
                    scale: ['#000', '#000'],
                    normalizeFunction: 'polynomial'
                }]
            },
            backgroundColor: '#eef3f7',
            onLabelShow: function(e, el, code){
                el.html(el.html()+' (GDP - '+gdpData[code]+')');
            }
        });
    });



</script>
</body>
</html>