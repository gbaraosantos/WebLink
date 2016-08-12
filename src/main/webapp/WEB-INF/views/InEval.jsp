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
    <script src="<c:url value="/resources/js/evaluation/evaluation.js" />" type="text/javascript"></script>

    <script src="<c:url value="/resources/js/SweetAlerts/sweetalert-dev.js" />" type="text/javascript"></script>
    <link href="<c:url value="/resources/css/SweetAlerts/sweetalert.css" />" rel="stylesheet">

</head>

<body style="background-color: #414141; max-height: calc(100vh); " >
    <div aria-hidden="true" aria-labelledby="myModelLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
        <div class="modal-dialog" style = "width: 800px; margin:0 -400px; height: auto; position: absolute; overflow: visible;" >
            <div class="modal-content">
                <div class="modal-header">
                    <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                    <h4 class="modal-title">Adicionar Questao</h4>
                </div>

                <div class="modal-body">
                    <div class="panel-body bio-graph-info">
                        <form class="form-horizontal" role="form" action="<c:url value="/teacher/addQuestion?evalId=${eval.getId()}"/>" method="post">

                            <div class="form-group">
                                <div class = "col-lg-12">
                                    <div class="col-lg-12" style="padding-left: 0">
                                        <label class="col-lg-5 control-label" style="text-align: left">Questao: </label>
                                        <div class="col-lg-7">
                                            <input type="text" class="form-control" name="question" id="question" autocomplete="off" placeholder="Inserir a questao">
                                        </div>
                                    </div>
                                </div>

                                <div class = "col-lg-12">
                                    <div class="col-lg-6" style="padding-left: 0">
                                        <label class="col-lg-5 control-label" style="text-align: left">Correct: </label>
                                        <div class="col-lg-7">
                                            <input type="text" class="form-control" name="correct" id="correct" autocomplete="off" placeholder="inserir opcao correcta">
                                        </div>
                                    </div>

                                    <div class="col-lg-6" style="padding-left: 0">
                                        <label class="col-lg-5 control-label" style="text-align: left">B: </label>
                                        <div class="col-lg-7">
                                            <input type="text" class="form-control" name="b" id="b" autocomplete="off" placeholder="inserir opcao b">
                                        </div>
                                    </div>
                                </div>

                                <div class = "col-lg-12">
                                    <div class="col-lg-6" style="padding-left: 0">
                                        <label class="col-lg-5 control-label" style="text-align: left">C: </label>
                                        <div class="col-lg-7">
                                            <input type="text" class="form-control" name="c" id="c" autocomplete="off" placeholder="inserir opcao c">
                                        </div>
                                    </div>

                                    <div class="col-lg-6" style="padding-left: 0">
                                        <label class="col-lg-5 control-label" style="text-align: left">D: </label>
                                        <div class="col-lg-7">
                                            <input type="text" class="form-control" name="d" id="d" autocomplete="off" placeholder="inserir opcao d">
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <center>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <button type="submit" onclick="return checkFields();" class="btn btn-primary">Save</button>
                            </center>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="col-lg-12">
        <div class="col-lg-12" style="text-align: center">
            <h1 style="font-size:xx-large; color: #ff5500"><i class="fa fa-graduation-cap"></i> <b>Quiz</b> </h1>
        </div>
        <div class="col-lg-12" style="text-align: center;  margin-top: 30px">
            <a href="<c:url value="/weblink/inCourse?action=${eval.getModulePerAction().getAction().getId()}" />" class="btn btn-primary">Save</a>
        </div>
    </div>

    <d:choose>
        <d:when test="${(isTeacher == 'true')}">
            <d:forEach var="q" items="${questions}">

                <div class="col-lg-12" style=" margin-top: 20px">
                    <hr style="border: 1px solid #d3d3d3;">
                    <div class="col-lg-8">
                        <h2 style="color: #ffffff">${q.getQuestion()}</h2>

                        <div class="col-lg-6" style="margin-left: 100px">
                            <p><h4 style="color: #2fff27">${q.getA()}</h4></p>
                            <p><h4 style="color: #ff383c">${q.getB()}</h4></p>
                            <p><h4 style="color: #ff383c">${q.getC()}</h4></p>
                            <p><h4 style="color: #ff383c">${q.getD()}</h4></p>

                        </div>
                    </div>

                    <div class="col-lg-4" style=" margin-top: 20px">
                        <center>
                            <a data-toggle="modal" onclick="return deleteQuestion(${q.getId()},${eval.getId()});" style="text-align: center; color: #384dd1; margin-right: 20px; ">
                                <i style="color: #ff4714;" class="fa fa-times-circle fa-2x"></i>
                            </a>
                        </center>
                    </div>
                </div>



            </d:forEach>


            <div class="col-lg-12" style="margin-top: 50px">
                <center>
                    <a data-toggle="modal" href="<c:url value="#myModal" />" style="text-align: center; color: #384dd1; margin-right: 20px; ">
                        <i style="color: green;" class="fa fa-plus-circle fa-4x"></i>
                    </a>
                </center>
            </div>

        </d:when>
        <d:otherwise>
            <form class="form-horizontal" role="form" action="<c:url value="/weblink/evaluation?evalId=${eval.getId()}"/>" method="post">
                <d:forEach var="q" items="${questions}">

                    <div class="col-lg-12" style=" margin-top: 20px">
                        <hr style="border: 1px solid #d3d3d3;">
                        <div class="col-lg-8">
                            <h2 style="color: #ffffff">${q.getQuestion()}</h2>

                            <d:forEach var="sQ" items="${q.getShuffled()}">

                                <div class="col-lg-12" >
                                    <div class="radio">
                                        <label>
                                            <input style="color: #2fff27" type="radio" name="q${q.getId()}" id="q${q.getId()}" value="${sQ}">
                                                ${sQ}
                                        </label>
                                    </div>

                                </div>
                            </d:forEach>
                        </div>
                    </div>
                </d:forEach>

                <center>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button type="submit"  class="btn btn-primary">Save</button>
                </center>

            </form>

        </d:otherwise>
    </d:choose>




</body>


</html>