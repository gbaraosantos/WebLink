<%--@elvariable id="_csrf" type="org.springframework.security.web.csrf.CsrfAuthenticationStrategy.SaveOnAccessCsrfToken"--%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
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
    <link href="<c:url value="/resources/css/Input/component.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/Input/normalize.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/Loader/loader.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/course_icons/icons.css" />" rel="stylesheet">

    <link href="<c:url value="http://www.jqueryscript.net/css/jquerysctipttop.css" />" rel="stylesheet">
    <link href="<c:url value="https://cdnjs.com/libraries/bootstrap-slider" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/slider/bootstrap-slider.css" />" rel="stylesheet">

    <!-- JS -->
    <script src="<c:url value="/resources/js/main/jquery.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/jQuery/jquery.nicefileinput.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/bootstrap.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/jquery.scrollTo.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/jquery.nicescroll.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/jquery.knob.js" />" type="text/javascript"></script>

    <script src="<c:url value="http://code.jquery.com/jquery-1.11.3.min.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/slider/bootstrap-slider.js" />" ></script>

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
                    <h3 class="page-header" style="float: left;"><i class="fa fa-lightbulb-o"></i> Courses </h3>

                    <a href="<c:url value="/coord/addCourse" />" style="float: right; color: #384dd1; margin-right: 20px; ">
                        <i style="color: green;" class="fa fa-plus-circle fa-4x"></i>
                    </a>

                    <div style="clear: both;"></div>





                    <ol class="breadcrumb">
                        <li><i class="fa fa-home"></i><a href="<c:url value="/" />">Home</a></li>
                        <li><i class="fa fa-laptop"></i><a href="<c:url value="/weblink" />">Dashboard</a></li>
                        <li><i class="fa fa-lightbulb-o"></i>Courses</li>
                    </ol>

                </div>
            </div>

            <div class="row">
                <div class="col-lg-12" >
                    <div class="panel" >
                        <form:form action="/weblink/filterCourse"  method="post" class="form-horizontal">
                            <div class = "panel-heading" style="padding-top: 3px; height: 42px" data-toggle="collapse" data-target="#filters">
                                <div class="col-lg-11">
                                    <h4>Filter</h4>
                                </div>
                                <div class="col-lg-1" id = "savebtt">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <button type="submit" onclick="return verify_profileUpdate();" class="btn btn-primary" style="float: right">Save</button>
                                </div>
                            </div>

                            <div class="collapse" id="filters">
                                <div class = "panel-body" >
                                    <div class="col-lg-6">

                                        <div class="form-group">
                                            <label class = "col-lg-2 control-label" for="name"><b>Curso:</b></label>
                                            <div class="col-lg-5">
                                                <input type="text" class="form-control" name="name" id="name" autocomplete="off" placeholder="Nome do Curso">
                                            </div>

                                        </div>


                                        <div class="form-group">
                                            <label class = "col-lg-2 control-label" for="ex2"><b>Preço: </b></label>
                                            5€ &nbsp;
                                            <input id="ex2" type="text" name= "priceRange" class="span2" data-slider-min="5" data-slider-max="200" data-slider-step="5" data-slider-value="[250,450]"/>
                                            &nbsp; 200€
                                        </div>

                                    </div>




                                    <div class="col-lg-6" >
                                        <div class="form-group">
                                            <label class = "col-lg-2 control-label" for="name"><b>Curso: </b></label>
                                            <div class="col-lg-5">
                                                <input type="text" class="form-control" name="name" id="1" autocomplete="off" placeholder="Nome do Curso">
                                            </div>

                                        </div>


                                        <div class="form-group">
                                            <label class = "col-lg-2 control-label" for="ex2"><b>Preço: </b></label>
                                            <div class="col-lg-5">
                                                <input type="text" class="form-control" name="name" id="na2me" autocomplete="off" placeholder="Nome do Curso">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </form:form>


                    </div>
            </div>







            </div>

            <div class="row">


                <div class="col-lg-4" >
                    <div class="panel" >
                        <div class="panel-heading" style="border-bottom: #000000">
                            <h4 style="float: left">Informática</h4>

                            <sec:authorize access="hasRole('Coordinator')">
                                <a href="#" style="float: right; color: #384dd1">
                                    <i class="fa fa-cog">Edit</i>
                                </a>
                            </sec:authorize>
                            <div style="clear: both;"></div>
                        </div>

                        <div class="panel-body">
                            <a href="#" class="rotate-box-2 square-icon text-center wow zoomIn" data-wow-delay="0" style="margin-top: 5px; margin-bottom: 0px">
                                <span class="rotate-box-icon"><i class="fa fa-mobile"></i></span>
                                <div class="rotate-box-info" style="margin-top: 5px;">
                                    <h4>App Development</h4>
                                    <p>Lorem ipsum dolor sit amet set, consectetur utes anet adipisicing elit, sed do eiusmod tempor incidist.</p>
                                </div>
                            </a>

                            <a href="#" style="float: right; color: #384dd1"> More </a>
                            <div style="clear: both;"></div>

                        </div>

                        <div class="panel-footer">
                            <h5 style="float: left"> <b>Quando Começa: </b> 3/6/2014</h5>
                            <h5 style="float: right"> <b>Preço:</b> 60 <i class="fa fa-eur"></i></h5>
                            <div style="clear: both;"></div>

                        </div>
                    </div>
                </div>


                <div class="col-lg-4">
                    <div class="panel">
                        <div class="panel-heading">
                            <h4 style="float: left">Informática</h4>

                            <sec:authorize access="hasRole('Coordinator')">
                                <a href="#" style="float: right; color: #384dd1">
                                    <i class="fa fa-cog">Edit</i>
                                </a>
                            </sec:authorize>
                            <div style="clear: both;"></div>
                        </div>

                        <div class="panel-body">
                            <a href="#" class="rotate-box-2 square-icon text-center wow zoomIn" data-wow-delay="0" style="margin-top: 5px; margin-bottom: 0px">
                                <span class="rotate-box-icon"><i class="fa fa-mobile"></i></span>
                                <div class="rotate-box-info" style="margin-top: 5px;">
                                    <h4>App Development</h4>
                                    <p>Lorem ipsum dolor sit amet set, consectetur utes anet adipisicing elit, sed do eiusmod tempor incidist.</p>
                                </div>
                            </a>

                            <a href="#" style="float: right; color: #384dd1"> More </a>
                            <div style="clear: both;"></div>

                        </div>

                        <div class="panel-footer">
                            <h5 style="float: left"> <b>Quando Começa: </b> 3/6/2014</h5>
                            <h5 style="float: right"> <b>Preço:</b> 60 <i class="fa fa-eur"></i></h5>
                            <div style="clear: both;"></div>

                        </div>
                    </div>
                </div>



            </div>
        </section>
    </section>
</section>























































<script>
    $('#ex1').slider({
        formatter: function(value) {
            return 'Current value: ' + value;
        }
    });
    $("#ex2").slider({});
    $("#ex3").slider();
    $("#ex3").on("slide", function(slideEvt) {
        $("#ex3SliderVal").text(slideEvt.value);
    });
    $("#ex4").slider({
        ticks: [0, 100, 200, 300, 400],
        ticks_labels: ['0€', '50€', '100€', '150€', '200€'],
        ticks_snap_bounds: 30
    });
    $("#ex5a").slider({ id: "slider5a", min: 0, max: 10, value: 5 });
    $("#ex5b").slider({ id: "slider5b", min: 0, max: 10, range: true, value: [3, 7] });
    $("#ex5c").slider({ id: "slider5c", min: 0, max: 10, range: true, value: [3, 7] });
</script>
</body>
</html>