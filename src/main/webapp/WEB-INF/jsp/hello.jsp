<!DOCTYPE html>
<html>
	<head>
		<title>Current Person</title>
	</head>
	<body>
	    <jsp:useBean id="sessionId" class="nl.sogyo.mancala.Data" scope="request"/>
		<jsp:useBean id="sessionData" class="nl.sogyo.mancala.Data" scope="session"/>
		Session Id is: <jsp:getProperty name="sessionId" property="string"/> </br>
		The message is: <jsp:getProperty name="sessionData" property="date"/> </br>
	</body>
</html>