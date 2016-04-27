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
        <h1 style="font-size:xx-large; color: #ff5500"><i class="fa fa-monitor"></i> <b>Sala de conferências</b> </h1>
        <div class="col-lg-12" style="text-align: center;  margin-top: 30px">
            <a href="<c:url value="/weblink/inCourse?action=${mpa.getAction().getId()}" />" class="btn btn-large btn-danger">Sair</a>
        </div>
    </div>


</div>

<div class="col-lg-12" style="height: calc(95vh)">

    <div class="col-lg-12" style="height: 100%; margin-top: 60px" >
        <div class="col-lg-12" style="height: 20%">
            <div class="col-lg-5"></div>
            <div class="col-lg-2" style="height: 100%">
                <div id="publisherDiv" style="height: 100%"></div>
            </div>
            <div class="col-lg-5"></div>
        </div>

        <div class="col-lg-12" id="subscriberDiv" style="height: 80%; margin-top: 30px;"></div>



    </div>

</div>

<script src="<c:url value="https://static.opentok.com/v2/js/opentok.js"/>" charset="utf-8"></script>
<script>
    var count = 0;
    var stream = false;
    var sessionId = '${sessionId}';
    var tokenId = '${tokenId}';
    var apiKey = '${apiKey}';
    var publishDiv, subDiv;
    var connectionCount = 0;

    var session = OT.initSession(apiKey, sessionId);

    session.on('streamCreated', function(event) {
        var div = document.createElement("div");
        var divParent = document.getElementById("subscriberDiv");
        div.id = "div" + count;
        div.className = "col-lg-4";
        div.marginBottom = "300px";

        divParent.appendChild(div);


        session.subscribe(event.stream, "div" + count, {
            resolution: '640x480',
            insertMode: 'append',
            width: '400px',
            height: '250px'
        });

        count++;


    });

    session.connect(tokenId, function(error) {
        // If the connection is successful, initialize a publisher and publish to the session
        if (!error) {
            var publisher = OT.initPublisher('publisherDiv', {
                resolution: '640x480',
                width: '100%',
                height: '100%'
            });

            session.publish(publisher);
        } else {
            console.log('There was an error connecting to the session: ', error.code, error.message);
        }
    });

</script>

</body>


</html>