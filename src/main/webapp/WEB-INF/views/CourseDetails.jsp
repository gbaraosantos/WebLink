<%--@elvariable id="_csrf" type="org.springframework.security.web.csrf.CsrfAuthenticationStrategy.SaveOnAccessCsrfToken"--%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
    <script src="<c:url value="/resources/js/course/delete_confirmation.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/course/module_handler.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/course/teacher_handler.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/course/action_validation.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/course/course_validation.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/SweetAlerts/sweetalert-dev.js" />" type="text/javascript"></script>



    <link href="<c:url value="/resources/css/SweetAlerts/sweetalert.css" />" rel="stylesheet">

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

    <style>
        @import "compass/css3";

        .table-editable {
            position: relative;
        }

        .glyphicon {
            font-size: 20px;

        }

        .table-remove {
            color: #700;
            cursor: pointer;
        }

        .table-up, .table-down {
            color: #007;
            cursor: pointer;
        }


        .table-add {
            color: #070;
            cursor: pointer;
            position: absolute;
            top: 8px;
            right: 0;
        }

    </style>

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
                    <h3 class="page-header"><i class="fa fa-laptop"></i>${action.getCourse().getName()}</h3>
                    <ol class="breadcrumb">
                        <li><i class="fa fa-home"></i><a href="<c:url value="/" />">Home</a></li>
                        <li><i class="fa fa-laptop"></i><a href="<c:url value="/weblink" />">Dashboard</a></li>
                        <li><i class="fa fa-lightbulb-o"></i><a href="<c:url value="/weblink/courses" />">Courses</a></li>
                        <li><i class="fa fa-book"></i>${action.getCourse().getName()}</li>
                    </ol>
                </div>
            </div>

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
                                    <li class="active"><a href="#module" aria-controls="module" role="tab" data-toggle="tab"><h5 style="color: #3870bc" class="modal-title"><b>Alterar Modulo desta Acção</b></h5></a></li>
                                    <d:choose>
                                        <d:when test="${courses.size() != 0}">
                                            <li><a href="#teacher" aria-controls="teacher" role="tab" data-toggle="tab"><h5 style="color: #3870bc" class="modal-title"><b>Adicionar Formador</b> </h5></a></li>
                                        </d:when>
                                    </d:choose>
                                </ul>

                                <div class="tab-content">
                                    <div role="tabpanel" class="tab-pane active" id="module">
                                        hello
                                    </div>
                                    <div role="tabpanel" class="tab-pane" id="teacher">
                                        <form class="form-horizontal" role="form" action="<c:url value="/coord/addTeacher"/>" method="post">
                                            <div class="form-group">
                                                <div class = "col-lg-12" style="background-color: #f3f3f3">
                                                    <d:forEach var="teachP" items="${listPossibleTeachers}">
                                                        <center>
                                                            <div class="col-lg-10" style="padding-top: 10px; padding-right: 5px; margin: 10px 10px 10px 60px; background-color: #f0f0f0; border-style:double ; border-width: 2px; border-color: #dadada" >
                                                                <div class="col-lg-1">
                                                                    <input type="checkbox" name = "teacherList[]" value="" style="margin-top: 50px">
                                                                </div>

                                                                <div class="col-lg-7" style="text-align: left;">
                                                                    <p><b>Número de Utilizador: </b> ${teachP.getId()}</p>
                                                                    <p><b>Nome: </b>${teachP.getName()}</p>
                                                                    <p><b>Email: </b>${teachP.getEmail()}</p>
                                                                    <p><b>Email: </b>${teachP.getState()}</p>
                                                                </div>

                                                                <div class="col-lg-4">
                                                                    <span class="profile-ava">
                                                                        <img alt="" style= "height:100px; width: 100px; " src = "<c:url value="${pageContext.request.contextPath}/customImgLoader?dir=${teachP.avatarLocation}" />">
                                                                    </span>

                                                                </div>
                                                            </div>
                                                        </center>
                                                    </d:forEach>
                                                </div>
                                            </div>
                                            <div style="padding-top: 20px">
                                                <center>
                                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                                    <button type="submit" onclick="return verify_newAction();" class="btn btn-primary">Save</button>
                                                </center>
                                            </div>

                                        </form>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>




            <div class="col-lg-12">
                <div class="profile-widget profile-widget-info">
                    <div class="panel-body">
                        <div class="col-lg-2 col-sm-2">
                            <h4>${action.getCourse().getName()}</h4>
                            <a href="<c:url value="/weblink/action?action=${action.getId()}"/>" class="rotate-box-2 square-icon text-center wow zoomIn" data-wow-delay="0">
                                <span class="rotate-box-icon"><i class="fa ${action.getCourse().getIcon()}"></i></span>
                            </a>
                        </div>



                        <div class="col-lg-3 col-sm-3 follow-info">
                            <p><b>Nome:</b>&nbsp;${action.getCourse().getName()}</p>
                            <p><b>Data de Inicio:</b>&nbsp; <fmt:formatDate pattern="yyyy-MM-dd" type="DATE" value="${action.getStartDate()}"/></p>
                            <p><b>Data de fim:</b>&nbsp; <fmt:formatDate pattern="yyyy-MM-dd" type="DATE" value="${action.getEndDate()}"/></p>
                            <p><b>Tipo de Ensino: </b>&nbsp; ${action.getCourse().getSynch()}</p>

                            <h6>
                                <span><i class="fa fa-eye"></i>${action.isVisible()}</span>
                                <span><i class="icon_calendar"></i><fmt:formatDate pattern="yyyy-MM-dd" type="DATE" value="${action.getCreationDate()}"/></span>

                            </h6>
                        </div>

                        <div class="col-lg-3 col-sm-3 follow-info">
                            <p><b>Tempo por aula:</b>&nbsp;${action.getCourse().gettClass()} Min</p>
                            <p><b>Preço:</b>&nbsp; ${action.getFinalPrice()}$</p>
                            <p><b>Tipo de Avaliação:</b>&nbsp; ${action.getEvaluationType()}</p>
                            <p><b>Preço re-Tentar: </b>&nbsp; ${action.getCourse().getReTryPrice()}$</p>

                            <h6>
                                <span><i class="fa fa-eye"></i>${action.isVisible()}</span>
                                <span><i class="fa fa-user"></i>${action.getCreatedBy().getEmail()}</span>
                            </h6>
                        </div>

                        <div class="col-lg-3 col-sm-6 follow-info weather-category" style="text-align: center; height: 175px;">
                            <div style="padding-top: 40px; padding-left: 70px">
                                <div style="text-align: center; width: 200px; height: 50px; padding-top: 8px">
                                    <button formaction = "#" class="btn btn-error btn-lg"><i class="fa fa-money fa-2x"> Comprar </i></button>
                                </div>


                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <script>
                function recalculateHeight(){
                    document.getElementById('container').style.display = 'none';
                    document.getElementById('container').style.display = 'block';
                    document.body.appendChild(document.createTextNode('teste!'));
                }
            </script>


            <div class="row">
                <div class="col-lg-12" >
                    <div class="panel-body bio-graph-info" >

                        <section class="panel">
                            <table class="table table-striped table-advance table-hover">
                                <tbody>
                                <tr>
                                    <th>&nbsp;</th>
                                    <th><i class="icon_key"></i>Id</th>
                                    <th><i class="icon_profile"></i> Nome </th>
                                    <th><i class="icon_calendar"></i> Posição </th>
                                    <th><i class="icon_pin_alt"></i> Percentagem </th>
                                    <th><i class="icon_mail_alt"></i> Data de Inicio </th>
                                    <th><i class="icon_pin_alt"></i> Data de Fim </th>

                                    <sec:authorize access="hasRole('Coordinator')">
                                        <th><i class="fa fa-cog"></i> Acções </th>
                                    </sec:authorize>

                                </tr>


                                <d:forEach var="mpa" items="${MPAList}">


                                    <tr id="tog" data-toggle="collapse" data-target="#demo${mpa.getModule().getId()}" class="accordion-toggle" aria-expanded="true" aria-controls="demo${mpa.getModule().getId()}">
                                        <td><button class="btn btn-default btn-xs"><span class="glyphicon glyphicon-eye-open"></span></button></td>
                                        <td>${mpa.getModule().getId()}</td>
                                        <td>${mpa.getModule().getName()}</td>
                                        <td>${mpa.getModule().getPosition()}</td>
                                        <td>${mpa.getModule().getPercentage()}</td>
                                        <td><fmt:formatDate pattern="yyyy-MM-dd" type="DATE" value="${mpa.getStartDate()}"/></td>
                                        <td><fmt:formatDate pattern="yyyy-MM-dd" type="DATE" value="${mpa.getEndDate()}"/></td>
                                        <sec:authorize access="hasRole('Coordinator')">
                                            <td>
                                                <span> <a onclick="setId(${mpa.getModule().getId()})" class="btn btn-info" data-toggle="modal" href="<c:url value="#myModal" />"><i class="fa fa-cog"></i> Edit</a></span>
                                                <span> <a class="btn btn-danger" onclick="deleteModuleTrigger2(${mpa.getModule().getId()})"><i class="fa fa-times"></i> Remove</a></span>
                                            </td>
                                        </sec:authorize>

                                    </tr>


                                    <tr>
                                        <td colspan="12" style="padding: 0;  background-color:rgba(75, 75, 100, 0.14);" id="accordion" >
                                            <div  class="accordian-body collapse" id="demo${mpa.getModule().getId()}" style="background-color:rgba(0, 0, 0, 0);">
                                                <table class="table" style="background-color:rgba(0, 0, 0, 0);">
                                                    <thead>
                                                    <tr>
                                                        <th>Descrição</th>
                                                        <th>Data de Criação</th>
                                                        <th>Data de Alteração</th>
                                                        <th>Criado Por</th>
                                                        <th>Lista de Professores</th>

                                                    </tr>
                                                    </thead>

                                                    <tbody>
                                                        <tr>
                                                            <td style="max-width: 350px"> ${mpa.getModule().getDescription()}</td>
                                                            <td><fmt:formatDate pattern="yyyy-MM-dd" type="DATE" value="${mpa.getModule().getCreationDate()}"/></td>
                                                            <td><fmt:formatDate pattern="yyyy-MM-dd" type="DATE" value="${mpa.getModule().getLastChangeDate()}"/></td>
                                                            <td>${mpa.getModule().getCreatedBy().getEmail()}</td>

                                                            <td>
                                                                <table class="table" style="background-color:rgba(0, 0, 0, 0); " >
                                                                    <thead>
                                                                    <tr>
                                                                        <th>Nome</th>
                                                                        <th>Email</th>
                                                                        <th>Ações</th>
                                                                    </tr>
                                                                    </thead>
                                                                    <tr>

                                                                    <d:forEach var="teach" items="${mpa.getTeacherList()}">
                                                                        <d:choose>
                                                                            <d:when test="${teach.getTeacher()!= null}">
                                                                                <td>${teach.getTeacher().getName()}</td>
                                                                                <td>${teach.getTeacher().getEmail()}</td>

                                                                                <sec:authorize access="hasRole('Coordinator')">
                                                                                    <td><a class="btn btn-danger" href="<c:url value="/admin/remPermission?user_id=${user.id}&perm=Admin" />"><i class="icon_close_alt2"></i></a></td>
                                                                                </sec:authorize>
                                                                            </d:when>
                                                                        </d:choose>
                                                                    </d:forEach>
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
            </div>

            <div style="text-align: center">
                <h3 style="color: #8e0d01;">
                    ${noMPA}
                </h3>
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

</script>
</body>
</html>