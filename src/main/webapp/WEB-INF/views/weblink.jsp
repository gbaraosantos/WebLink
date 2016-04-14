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

                    <li>
                        <a class="" href="<c:url value="/weblink/myCourses" />">
                            <i class="fa fa-unlock-alt"></i>
                            <span>&nbsp; Meus Cursos</span>
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

            <div class="row">
                <div class="col-md-8 portlets">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Global Chat
                        </div>
                        <div class="panel-body">
                            <div style="height: 100%">
                                <div class = "col-lg-2" style="border: solid 3px #e0e0e0; overflow-y: visible">
                                    <div class="col-lg-12" style="margin-bottom: 10px"> <center> <h4><b>Online Users</b> </h4></center></div>
                                    <!--
                                    <d:forEach var="user" items="${Online}">
                                        <div style=" width: 100%">
                                            <img alt="" style= "float:left; height:25px; width: 25px; margin-top: 5px " src = "<c:url value="${pageContext.request.contextPath}/customImgLoader?dir=${user.avatarLocation}" />">
                                            <h5 style=" float: right; margin-top: 5px; font-size: x-small">${user.getName()}</h5>

                                        </div>
                                    </d:forEach>
                            </div>
-->

                            </div>

                            <div class="col-lg-10">
                                <div class="col-lg-12">
                                    <div class="col-lg-12" style="height: 350px; overflow-y: auto; border: solid 3px #e0e0e0; background-color: #fbfbfb; margin-bottom: 5px" >
                                        <center>
                                            <p id="history">
                                            </p>
                                        </center>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <form id="formChat">
                                        <div class="col-lg-11">
                                            <div class="form-group">
                                                <div class="col-lg-12">
                                                    <input type="text" class="form-control" name="msgTxt" id="msgTxt" autocomplete="off" placeholder="Write your message here!">
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-lg-1">
                                            <button id="myButton" class="btn btn-info">Send!</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </section>
    </section>
</section>





























































<script>
    var sessionId = '${sessionId}';
    var tokenId = '${tokenId}';
    var apiKey = '${apiKey}';
    var username = '${User.getName()}';
    var form = document.getElementById('formChat');
    var session;

    document.getElementById("myButton").onclick = function(event){
        var msgTxt = document.querySelector('#msgTxt');
        event.preventDefault();

        session.signal({
                    type: 'chat',
                    data: msgTxt.value
                },
                function(error) {
                    if (!error) {
                        console.log("Success Sending");
                        msgTxt.value = '';
                    }
                    else{
                        console.log("Error Sending");
                    }
                }
        )};


    jQuery(document).ready(function () {
        var msgHistory = document.getElementById('history');
        session = OT.initSession(apiKey, sessionId);

        session.on('signal:chat', function(event) {
            var msg = document.createElement('p');
            var footingText = document.createElement('p');
            var bubble = document.createElement('div');
            var bubbleWrapper = document.createElement('div');
            var footing = document.createElement('div');

            bubbleWrapper.className = 'bubbleWrapper';
            footing.className = 'footing';

            msg.innerHTML = event.data;
            bubble.className = event.from.connectionId === session.connection.connectionId ? 'mine' : 'theirs';

            var date = new Date().toString();



            var dayStart = ("0" +  new Date().getDate()).slice(-2);
            var monthStart = ("0" + (new Date().getMonth() +1)).slice(-2);



            footingText.innerHTML = "De: " + username +  " Em: " + dayStart + "-" + monthStart + "-" + new Date().getFullYear();
            footing.appendChild(footingText);
            bubble.appendChild(msg);

            bubbleWrapper.appendChild(bubble);
            bubble.appendChild(footing);

            msgHistory.appendChild(bubbleWrapper);
            msg.scrollIntoView();

        });


        session.on('signal:chatInfo', function(event) {
            var msg = document.createElement('p');
            var greetingDiv = document.createElement('div');
            var greetingWrapper = document.createElement('div');

            greetingDiv.className = 'greetingDiv';
            greetingWrapper.className = 'greetingWrapper';
            msg.innerHTML = event.data;

            greetingDiv.appendChild(msg);
            greetingWrapper.appendChild(greetingDiv);
            msgHistory.appendChild(greetingWrapper);

            msg.scrollIntoView();
        });

        session.connect(tokenId, function(error) {
            if (!error) {
                welcomeSignal();
            }
            else{
                console.log("Error Connecting");
            }
        });

    });


    function welcomeSignal(){
        var username = '${User.getName()}';
        session.signal({
                    type: 'chatInfo',
                    data: username + " entrou online"
                },
                function(error) {
                    if (!error) {
                        console.log("Success Sending Greeting");
                    }
                    else{
                        console.log("Error Sending Greeting");
                    }
                });
    }
</script>







</body>
</html>