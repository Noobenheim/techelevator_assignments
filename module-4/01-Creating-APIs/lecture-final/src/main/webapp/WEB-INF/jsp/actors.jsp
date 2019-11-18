<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Of Actors</title>
</head>
<body>

	<h2>ACTORS</h2>
	<table border=3>
	
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
	</tr>
	
	<c:forEach items="${actors}" var="actor">
	<tr>
		<td>${actor.firstName }</td>
		<td>${actor.lastName }</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>