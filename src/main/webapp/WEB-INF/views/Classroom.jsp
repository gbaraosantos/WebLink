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

    <script src="<c:url value="/resources/js/SweetAlerts/sweetalert-dev.js" />" type="text/javascript"></script>
    <link href="<c:url value="/resources/css/SweetAlerts/sweetalert.css" />" rel="stylesheet">

</head>

<body style="background-color: #414141; max-height: calc(100vh); " >
        <div class="col-lg-12" style="height: calc(5vh)">
            <div class="col-lg-12" style="text-align: center">
                <h1 style="font-size:xx-large; color: #ff5500"><i class="fa fa-graduation-cap"></i> <b>Sala de aula</b> </h1>
            </div>


        </div>

        <div class="col-lg-12" style="height: calc(95vh)">
            <div class="col-lg-3" style="height: 100%; padding-top: 0; padding-bottom: 0; margin-bottom: 0; margin-top: 0">
                <div class="col-lg-12" style="padding-top: 0; padding-bottom: 0; margin-bottom: 0; margin-top: 0">
                    <h2 style="color: #efefef; margin-bottom: 20px"><b>Online Users</b></h2>

                    <hr style="color: white">

                    <ul id="listUsers" style="border-right: solid thick whitesmoke">

                    </ul>

                </div>
            </div>



            <div class="col-lg-6" style="height: 100%; margin-top: 60px" >
                <div class="col-lg-12" style="height: 60%">
                    <div id="subscriberDiv"></div>
                </div>

                <div class="col-lg-12" style="text-align: center">
                    <h4 style="color: #efefef" id="classClock"></h4>
                </div>

                <div class="col-lg-12" style="height: 50%">
                    <div class="col-lg-12" >
                        <sec:authorize access="hasRole('Admin')">
                            <div class="col-lg-12" style="text-align: center;  margin-top: 30px">
                                <a onclick="changeStreams()" href="#" class="btn btn-large btn-info">Mudar Stream</a>
                            </div>
                        </sec:authorize>
                        <div class="col-lg-12" style="text-align: center;  margin-top: 30px">
                            <a href="<c:url value="/weblink/inCourse?action=${mpa.getAction().getId()}" />" class="btn btn-large btn-danger">Sair</a>
                        </div>
                    </div>



                </div>


            </div>
            <div class="col-lg-3" style="height: 100%">
                <div class="col-lg-12" style="padding-top: 0; padding-bottom: 0; margin-bottom: 0; margin-top: 0; height: 80%;">
                    <h2 style="color: #efefef; margin-bottom: 20px"><b>Online Chat</b></h2>

                    <hr style="color: whitesmoke;">

                    <div id="chat" style="border-left: solid thick whitesmoke; height: 65%; background-color: #353535;  overflow-y: auto">
                        <ul style="color:#d8d8d8" id="chatPlace">

                        </ul>
                    </div>

                    <div class="col-lg-12" style="height: 20%; margin-top: 10px">
                        <form id="formChat">
                            <div class="col-lg-12">
                                <input type="text" class="form-control" name="msgTxt" id="msgTxt" autocomplete="off" placeholder="Write your message here!">
                            </div>
                            <div class="col-lg-12" style="text-align: center">
                                <button id="send" class="btn-default"> Envio </button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>

        <script src="<c:url value="https://static.opentok.com/v2/js/opentok.js"/>" charset="utf-8"></script>
        <script>
            var stream = false;
            var sessionId = '${sessionId}';
            var tokenId = '${tokenId}';
            var apiKey = '${apiKey}';
            var publishDiv, subDiv;
            var connectionCount = 0;

            var session = OT.initSession(apiKey, sessionId);


            session.on({
                connectionCreated: function (event) {
                    connectionCount++;
                    if (event.connection.connectionId != session.connection.connectionId) {
                        console.log('Another client connected. ' + connectionCount + ' total.');
                        setTimeout(function(){
                            updateList('${mpa.getId()}');
                        }, 3000);

                    }
                    else{
                        getAllMessages();
                        addUser(event.connection.data, '${mpa.getId()}');
                    }
                },
                connectionDestroyed: function connectionDestroyedHandler(event) {
                    connectionCount--;
                    removeUser(event.connection.data, '${mpa.getId()}');
                    console.log('A client disconnected. ' + connectionCount + ' total.');

                }
            });


            session.on('streamCreated', function(event) {
                session.subscribe(event.stream, 'subscriberDiv', {
                    resolution: '1280x720',
                    width: '100%',
                    height: '100%'
                });
            });

            session.on('sessionDisconnected', function(event) {
                console.log('You were disconnected from the session.', event.reason);
            });

            session.on('signal:chat', function(event) {
                setTimeout(function(){
                    getAllMessages();
                }, 500);
            });



            session.connect(tokenId, function(error) {
                // If the connection is successful, initialize a publisher and publish to the session
                if (!error) {
                    var publisher = OT.initPublisher('subscriberDiv', {
                        resolution: '1280x720',
                        width: '100%',
                        height: '100%'
                    });

                    session.publish(publisher);
                } else {
                    console.log('There was an error connecting to the session: ', error.code, error.message);
                }
            });

            OT.registerScreenSharingExtension("chrome", "pfkofnaekbboegekpeocdciibaplnokn", 2);

            function changeStreams(){
                if(stream){
                    var publisher = OT.initPublisher('subscriberDiv', {
                        resolution: '1280x720',
                        width: '100%',
                        height: '100%'
                    });

                    session.publish(publisher);

                    stream = false;
                }
                else{
                    stream = true;
                    OT.checkScreenSharingCapability(function(response) {
                        if (!response.supported || response.extensionRegistered === false) {
                            alert('This browser does not support screen sharing.');
                        } else if (response.extensionInstalled === false) {
                            alert('Please install the screen sharing extension and load your app over https.');
                        } else {
                            // Screen sharing is available. Publish the screen.
                            var screenSharingPublisher = OT.initPublisher('subscriberDiv', {
                                videoSource: 'screen',
                                resolution: '1280x720',
                                width: '100%',
                                mirror: false,
                                height: '100%'

                            });
                            session.publish(screenSharingPublisher, function(error) {
                                if (error) {
                                    alert('Could not share the screen: ' + error.message);
                                }
                            });
                        }
                    });
                }

            }
            function addUser(dataId, id){
                $.ajax({
                    type : "GET",
                    url : "/weblink/classroomUsers?id=" + id + "&data=" + dataId,
                    dataType: "text",

                    error:function(){
                        alert("Ajax Error Ocurred");
                    },

                    success:function(data) {
                        updateList('${mpa.getId()}');
                    }

                });
            }

            function removeUser(dataId, id){
                $.ajax({
                    type : "GET",
                    url : "/weblink/classroomUsersRemove?id=" + id + "&data=" + dataId,
                    dataType: "text",

                    error:function(){
                        alert("Ajax Error Ocurred");
                    },

                    success:function(data) {
                        updateList('${mpa.getId()}');
                    }

                });
            }

            function startClass(){
                var today = new Date();
                var h = today.getHours();
                var m = today.getMinutes();
                var s = today.getSeconds();
                m = checkTime(m);
                s = checkTime(s);
                document.getElementById('classClock').innerHTML = "<b>Horas:</b>" + h + ":" + m+ ":" +s;
                var t = setTimeout(startClass, 500);

            }

            function checkTime(i) {
                if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
                return i;
            }

            function updateList(mpaId){
                $.ajax({
                    type : "GET",
                    url : "/weblink/getUsers?data=" + mpaId,
                    dataType: "text",

                    error:function(){
                        alert("Ajax Error Ocurred");
                    },

                    success:function(data) {
                        updateOnlineList(data);
                    }

                });

            }

            function updateOnlineList(data){
                var unloadedResponse = jQuery.parseJSON(data);
                document.getElementById("listUsers").innerHTML = "";
                for(var i = 0; i < unloadedResponse.length; i++){
                    prepareList(unloadedResponse[i], i, unloadedResponse.length)
                }
            }

            function prepareList(user, i, number){
                var place = document.getElementById("listUsers");
                var li = document.createElement("li");
                var img = document.createElement("img");
                var span = document.createElement("span");

                img.style.marginRight = "5px";
                img.style.width = '40px';
                img.style.height = '40px';
                img.src = "${pageContext.request.contextPath}/customImgLoader?dir=" + user['avatarLocation'];

                span.innerHTML = user['name'];

                li.style.marginTop = "5px";

                li.appendChild(img);
                li.appendChild(span);

                place.appendChild(li);

            }

            document.getElementById("send").onclick = function(event){
                var msgTxt = document.querySelector('#msgTxt');
                var data= [];

                event.preventDefault();

                data[0] = '${User.name}';
                data[1] = msgTxt.value;
                data[2] = '${User.avatarLocation}';
                data[3] = '${User.id}';

                console.log("--->" + data[3]);

                session.signal({
                            type: 'chat',
                            data: data
                        },
                        function(error) {
                            if (!error) {
                                msgTxt.value = '';

                                persistMessage(data[1], data[3]);
                            }
                            else{
                            }
                        }
                )};


            function persistMessage(data, userId){

                $.ajax({
                    type : "GET",
                    url : "/weblink/classroomMessageAdd?data=" + data + "&userId="+userId,
                    dataType: "text",

                    error:function(){
                        alert("Ajax Error Ocurred");
                    },

                    success:function(data) {

                    }

                });

            }

            function getAllMessages(){
                $.ajax({
                    type : "GET",
                    url : "/weblink/classroomMessageGet",
                    dataType: "text",

                    error:function(){
                        alert("Ajax Error Ocurred");
                    },

                    success:function(data) {
                        var unloadedResponse = jQuery.parseJSON(data);
                        document.getElementById("chatPlace").innerHTML = "";
                        for(var i = 0; i < unloadedResponse.length; i++){
                            updateChat(unloadedResponse[i], i, unloadedResponse.length)
                        }
                    }

                });

            }

            function updateChat(message, i , n){
                var chatPlace = document.getElementById("chatPlace");

                var li = document.createElement("li");
                var img = document.createElement("img");
                var span = document.createElement("span");

                img.style.marginRight = "5px";
                img.style.width = '40px';
                img.style.height = '40px';
                img.src = "${pageContext.request.contextPath}/customImgLoader?dir=" + message['user']['avatarLocation'];

                span.innerHTML = message['message'];

                li.style.marginTop = "5px";

                li.appendChild(img);
                li.appendChild(span);

                chatPlace.appendChild(li);
                li.scrollIntoView(false);

            }


        </script>

</body>


</html>