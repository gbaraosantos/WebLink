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

    <!-- JS -->
    <script src="<c:url value="/resources/js/jQuery/jquery-1.10.2.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/main/bootstrap.js" />" type="text/javascript"></script>
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

    <style>
        input[type=range]{
            -webkit-appearance: none;
        }

        input[type=range]::-webkit-slider-runnable-track {
            width: 300px;
            height: 5px;
            background: #ddd;
            border: none;
            border-radius: 3px;
        }

        input[type=range]::-webkit-slider-thumb {
            -webkit-appearance: none;
            border: none;
            height: 16px;
            width: 16px;
            border-radius: 50%;
            background: #06548d;
            margin-top: -4px;
        }

        input[type=range]:focus {
            outline: none;
        }

        input[type=range]:focus::-webkit-slider-runnable-track {
            background: #ccc;
        }
    </style>

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
            <!-- sidebar mendu end-->
        </div>
    </aside>

    <!-- Center Content -->
    <section id="main-content">
        <section class="wrapper">

            <!--            ADD A COURSE            -->


            <div class="row">
                <div aria-hidden="true" aria-labelledby="myModelLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                    <div class="modal-dialog" style = "width: 800px; margin:0 -400px; height: auto; position: absolute; overflow: visible;" >
                        <div class="modal-content">
                            <div class="modal-header">
                                <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                                <h4 class="modal-title">Criação de Cursos e Acções</h4>
                            </div>

                            <div class="modal-body">
                                <ul class="nav nav-tabs nav-justified">
                                    <li class="active"><a href="#Course" aria-controls="Course" role="tab" data-toggle="tab"><h5 style="color: #3870bc" class="modal-title"><b>Criação de Curso</b></h5></a></li>
                                    <li><a href="#Actions" aria-controls="Actions" role="tab" data-toggle="tab"><h5 style="color: #3870bc" class="modal-title"><b>Criação de Acção</b> </h5></a></li>
                                    <li><a href="#Modules" aria-controls="Modules" role="tab" data-toggle="tab"><h5 style="color: #3870bc" class="modal-title"><b>Criação de Módulos</b> </h5></a></li>
                                </ul>

                                <div class="tab-content">
                                    <div role="tabpanel" class="tab-pane active" id="Course">
                                        <div class="panel-body bio-graph-info">

                                            <form class="form-horizontal" role="form" action="<c:url value="/coord/addCourse"/>" method="post">
                                                <div class="form-group" >
                                                    <div class="col-lg-12">
                                                        <label class="col-lg-2 control-label" style="text-align: left">Área: </label>
                                                        <div class="col-lg-9">
                                                            <input type="text" class="form-control" name="area" id="area" autocomplete="off" placeholder="Área do Curso">
                                                        </div>
                                                    </div>

                                                </div>
                                                <div class="form-group">
                                                    <div class="col-lg-12">
                                                        <label class="col-lg-2 control-label" style="text-align: left">Nome: </label>
                                                        <div class="col-lg-9">
                                                            <input type="text" class="form-control" name="courseName" id="courseName" autocomplete="off" placeholder="Nome do Curso">
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-lg-12">
                                                        <label class="col-lg-2 control-label" style="text-align: left">Descrição: </label>
                                                        <div class="col-lg-9">
                                                            <textarea class="form-control" name="description" id="description" placeholder="Descrição do Curso"></textarea>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-lg-12">
                                                        <label class="col-lg-2 control-label" style="text-align: left">Número de Módulos </label>
                                                        <div class="col-lg-9">
                                                            <input type="number" class="form-control" name="nModules" id="nModules" autocomplete="off" placeholder="Número de Módulos">
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-lg-12">
                                                        <div class="col-lg-6" style="padding-left: 0">
                                                            <label class="col-lg-5 control-label" style="text-align: left" >Tipo de Aulas</label>
                                                            <div class="col-lg-7">
                                                                <div class="radio">
                                                                    <label>
                                                                        <input type="radio" name="optionsRadios" id="Synch" value="1" checked>
                                                                        Assincronas
                                                                    </label>
                                                                </div>
                                                                <div class="radio">
                                                                    <label>
                                                                        <input type="radio" name="optionsRadios" id="Assynch" value="2">
                                                                        Sincronas
                                                                    </label>
                                                                </div>
                                                                <div class="radio">
                                                                    <label>
                                                                        <input type="radio" name="optionsRadios" id="Blended" value="3">
                                                                        Blended
                                                                    </label>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-lg-6" style="padding-left: 0">
                                                            <label  class="col-lg-5 control-label" style="text-align: left" >Icon do Curso</label>
                                                            <div class="col-lg-7">
                                                                <button id = "IconSelect" name = "IconSelect" class="btn btn-default form-control" data-iconset="fontawesome" data-icon="fa-wifi" role="iconpicker"></button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class = "col-lg-12">
                                                        <div class="col-lg-6" style="padding-left: 0">
                                                            <label class="col-lg-5 control-label" style="text-align: left">Data Inicio: </label>
                                                            <div class="col-lg-7">
                                                                <input type="date" class="form-control" name="startDate" id="startDate" autocomplete="off" placeholder="mm/dd/yyyy">
                                                            </div>
                                                        </div>

                                                        <div class="col-lg-6">
                                                            <label class="col-lg-5 control-label" style="text-align: left">Preço </label>
                                                            <div class="col-lg-7">
                                                                <input type="number" class="form-control" name="price" id="price" autocomplete="off" placeholder="Preço">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-lg-12">
                                                        <div class="col-lg-6" style="padding-left: 0">
                                                            <label class="col-lg-5 control-label" style="text-align: left">Número Aulas </label>
                                                            <div class="col-lg-7">
                                                                <input type="number" class="form-control" name="nClasses" id="nClasses" autocomplete="off" placeholder="Número de Aulas">
                                                            </div>
                                                        </div>

                                                        <div class="col-lg-6">
                                                            <label class="col-lg-5 control-label" style="text-align: left">Tempo por Aula </label>
                                                            <div class="col-lg-7">
                                                                <input type="number" class="form-control" name="tClass" id="tClass" autocomplete="off" placeholder="Time">
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


                                    <!--        END OF COURSE ADD       -->

                                    <!--            ADD an Action  START           -->

                                    <div role="tabpanel" class="tab-pane" id="Actions">
                                        <div class="panel-body bio-graph-info">

                                            <form class="form-horizontal" role="form" action="<c:url value="/coord/addCourse"/>" method="post">
                                                <div class="form-group">
                                                    <div class = "col-lg-12">
                                                        <div class="col-lg-6" style="padding-left: 0">
                                                            <label class="col-lg-5 control-label" style="text-align: left">Curso:</label>
                                                            <div class="col-lg-7" style="padding-left: 0">
                                                                <select class="form-control m-bot15" id="courseID" name="CourseID">
                                                                    <option value = "1">Option 1</option>
                                                                    <option value = "2">Option 2</option>
                                                                    <option value = "3">Option 3</option>
                                                                </select>
                                                            </div>
                                                        </div>

                                                        <div class="col-lg-6" style="padding-left: 0">
                                                            <label class="col-lg-5 control-label" style="text-align: left">Data Inicio: </label>
                                                            <div class="col-lg-7" style="padding-left: 0px">
                                                                <input type="date" class="form-control" name="startDateAction" id="startDateAction" autocomplete="off" placeholder="mm/dd/yyyy">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-lg-12">
                                                        <label class="col-lg-2 control-label" style="text-align: left">Observações:</label>
                                                        <div class="col-lg-9" style="padding-left: 20px">
                                                            <textarea class="form-control" name="descriptionAction" id="descriptionAction" placeholder="Observações"></textarea>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class = "col-lg-12">
                                                        <div class="col-lg-6" style="padding-left: 0">
                                                            <label class="col-lg-5 control-label" style="text-align: left">Desconto:</label>
                                                            <div class="col-lg-7" style="padding-left: 0">
                                                                <input type="number" class="form-control" name="discount" id="discount" autocomplete="off" placeholder="Desconto">
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

                                    <!--            ADD an Action  END           -->

                                    <!--            ADD Modules  START           -->

                                    <div role="tabpanel" class="tab-pane" id="Modules">


                                    </div>

                                    <!--            ADD Modules  END           -->


                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>





            <!--        BREADCRUMBS START       -->

            <div class="row">
                <div class="col-lg-12">
                    <h3 class="page-header" style="float: left;"><i class="fa fa-lightbulb-o"></i> Courses </h3>

                    <sec:authorize access="hasRole('Coordinator')">
                        <a data-toggle="modal" href="<c:url value="#myModal" />" style="float: right; color: #384dd1; margin-right: 20px; ">
                            <i style="color: green;" class="fa fa-plus-circle fa-4x"></i>
                        </a>
                    </sec:authorize>

                    <div style="clear: both;"></div>



                    <ol class="breadcrumb">
                        <li><i class="fa fa-home"></i><a href="<c:url value="/" />">Home</a></li>
                        <li><i class="fa fa-laptop"></i><a href="<c:url value="/weblink" />">Dashboard</a></li>
                        <li><i class="fa fa-lightbulb-o"></i>Courses</li>
                    </ol>

                </div>
            </div>


            <!--        BREADCRUMBS  END      -->


            <!--        Filter  Start      -->

            <div class="row">
                <div class="col-lg-12" >
                    <div class="panel" >
                        <form:form action="/weblink/filterCourse"  method="post" class="form-horizontal">
                            <div class = "panel-heading" style="padding-top: 3px; height: 42px" data-toggle="collapse" data-target="#filters">
                                <div class="col-lg-11">
                                    <h4>Filter</h4>
                                </div>
                            </div>

                            <div class="collapse" id="filters">
                                <div class = "panel-body" >
                                    <div class="form-group">
                                        <div class="col-lg-12">
                                            <div class="col-lg-6">
                                                <label class = "col-lg-3 control-label" for="name" style="text-align: left" ><b>Curso:</b></label>
                                                <div class="col-lg-9">
                                                    <input type="text" class="form-control" name="name" id="name" autocomplete="off" placeholder="Nome do Curso">
                                                </div>
                                            </div>

                                            <div class="col-lg-6">
                                                <label class = "col-lg-3 control-label" for="areafilter" style="text-align: left" ><b>Área: </b></label>
                                                <div class="col-lg-9">
                                                    <input type="text" class="form-control" name="area" id="areafilter" autocomplete="off" placeholder="Área">
                                                </div>

                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-lg-12">
                                            <div class="col-lg-6">
                                                <label class = "col-lg-3 control-label" for="pricerange" style="text-align: left" ><b>Preço: </b></label>
                                                <div class="col-lg-9">
                                                    <div class="col-lg-9" style="margin-right: 0; padding-right: 0; padding-left: 0">
                                                        <input onchange="updateTextInput(this.value);" class="form-control" id= "pricerange" type="range" name="pricerange" min="0" max="200" step="5">
                                                    </div>
                                                    <div class="col-lg-3" style="margin-left: 0; padding-left: 5px;margin-right: 0; padding-right: 0">
                                                        <input  class="form-control" type="text" id="textInput" name = "pricerangeValue" value="100">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-lg-6">
                                                <label class = "col-lg-3 control-label" for="date" style="text-align: left" ><b>Data de inicio: </b></label>
                                                <div class="col-lg-9">
                                                    <input type="date" class="form-control" name="date" id="date" autocomplete="off" placeholder="3/10/2016">
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <sec:authorize access="hasRole('Coordinator')">
                                        <div class="form-group">
                                            <div class="col-lg-12">
                                                <div class="col-lg-6">
                                                    <label class = "col-lg-3 control-label" for="isvisible" style="text-align: left" ><b>Is visible:</b></label>
                                                    <div class="col-lg-9">
                                                        <select id="isvisible" name="isvisible" class="form-control">
                                                            <option value="any">Any</option>
                                                            <option value="no">No</option>
                                                            <option value="yes">Yes</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </sec:authorize>

                                    <div class="form-group">
                                        <div class="col-lg-12">
                                            <center>
                                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                                <button type="submit" onclick="return verify_profileUpdate();" class="btn btn-primary" >Save</button>
                                            </center>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>


            <!--        Filter  END      -->

            <!--        Course  Listing Start      -->
            <div class="row">

                <div class="col-lg-4" >
                    <div class="panel" >
                        <div class="panel-heading">
                            <div class="col-lg-12">
                                <div class="col-lg-8">
                                    <sec:authorize access="hasRole('Coordinator')">
                                        <a href="#"  style="color: #d11c12; float:left;" >
                                            <i class="fa fa-eye"></i>
                                        </a>
                                    </sec:authorize>

                                    <span style="float:left"><h4>Informática</h4></span>
                                </div>

                                <div class="col-lg-4">
                                    <sec:authorize access="hasRole('Coordinator')">
                                        <div class="col-lg-2" style="padding-right: 30px">
                                            <a href="#"  style="color: #384dd1">
                                                <i class="fa fa-cog">Edit</i>
                                            </a>
                                        </div>

                                        <div class="col-lg-2" style="padding-right: 30px">
                                            <a href="#" style=" color: #ad0e01">
                                                <i class="fa fa-times">Remove</i>
                                            </a>
                                        </div>
                                    </sec:authorize>
                                </div>
                            </div>
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


                <div class="col-lg-4" >
                    <div class="panel" >
                        <div class="panel-heading" style="border-bottom: #000000">
                            <div class="col-lg-8">
                                <sec:authorize access="hasRole('Coordinator')">
                                    <a href="#"  style="color: #247000; float:left" >
                                        <i class="fa fa-eye"></i>
                                    </a>
                                </sec:authorize>

                                <span style="float:left"><h4>Informática</h4></span>
                            </div>

                            <div class="col-lg-4">
                                <sec:authorize access="hasRole('Coordinator')">
                                    <div class="col-lg-2" style="padding-right: 30px">
                                        <a href="#"  style="color: #384dd1">
                                            <i class="fa fa-cog">Edit</i>
                                        </a>
                                    </div>

                                    <div class="col-lg-2" style="padding-right: 30px">
                                        <a href="#" style=" color: #ad0e01">
                                            <i class="fa fa-times">Remove</i>
                                        </a>
                                    </div>
                                </sec:authorize>
                            </div>


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















































<script src="<c:url value="/resources/js/iconpicker/iconset/iconset-fontawesome-4.2.0.min.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/js/iconpicker/bootstrap-iconpicker.min.js" />" type="text/javascript"></script>


<script>
    console.log(${SuccessCreating})
</script>

<script type="text/javascript">
    function updateTextInput(val) {
        document.getElementById('textInput').value=val;
    }
</script>

<script>

    //knob
    $(".knob").knob();

</script>

</body>
</html>