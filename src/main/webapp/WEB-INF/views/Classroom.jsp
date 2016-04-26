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

<body style="background-color: #414141; max-height: calc(100vh); overflow-y: auto">
        <div class="col-lg-12" style="height: calc(20vh)">
            <div class="col-lg-12" style="text-align: center">
                <h1 style="font-size:xx-large; color: #ff5500"><i class="fa fa-graduation-cap"></i> <b>Sala de aula</b> </h1>
            </div>

            <div class="col-lg-12" style="text-align: center">
                <h4 style="color: #efefef"><b>Running for:</b> 32min</h4>
            </div>
        </div>

        <div class="col-lg-12" style="height: calc(80vh)">
            <div class="col-lg-3" style="height: 100%">
                hello
            </div>
            <div class="col-lg-6" style="height: 100%" >
                <div class="col-lg-12" style="height: 60%">
                    <div id="subscriberDiv"></div>
                </div>

                <div class="col-lg-12" style="height: 50%">

                    <div class="col-lg-12" style="margin-top: 30px; text-align: center">
                        <a onclick="changeStreams()" href="#" class="btn btn-large btn-info">Change Stream</a>
                    </div>

                    <div class="col-lg-12" >
                        <div class="col-lg-6" style="text-align: center;  margin-top: 10px">
                            <a href="#" class="btn btn-large btn-success">Start class</a>
                        </div>
                        <div class="col-lg-6" style="text-align: center">
                            <a href="#" class="btn btn-large btn-danger">Leave class</a>
                        </div>
                    </div>



                </div>


            </div>
            <div class="col-lg-3" style="height: 100%">
                hello
            </div>
        </div>


    <script src="<c:url value="https://static.opentok.com/v2/js/opentok.js"/>" charset="utf-8"></script>
    <script>
        var stream = false;
        var sessionId = '${sessionId}';
        var tokenId = '${tokenId}';
        var apiKey = '${apiKey}';
        var publishDiv, subDiv;


        console.log('---->' + '${isTeacher}');

        var session = OT.initSession(apiKey, sessionId);



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

    </script>

</body>


</html>