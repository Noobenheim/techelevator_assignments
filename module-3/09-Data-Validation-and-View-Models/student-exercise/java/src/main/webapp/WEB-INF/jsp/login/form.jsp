<!-- Login -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="pageTitle" value="Home Page"/>
<%@include file="../common/header.jspf" %>

<h2>Login</h2>
<form:form action="login" method="POST" modelAttribute="login">
	<div class="required form-group">
		<form:label path="email">Email</form:label>
		<form:input type="email" path="email" placeholder="enter email" required="required" class="form-control" />
		<form:errors path="email" cssClass="error" />
	</div>
	<div class="required form-group">
		<form:label path="password">Password</form:label>
		<form:input type="password" path="password" placeholder="enter password" required="required" class="form-control" />
		<form:errors path="password" cssClass="error" />
	</div>
	<div class="form-group">
		<input type="submit" value="Submit" class="btn btn-primary" />
	</div>
</form:form>

<%@include file="../common/footer.jspf" %>
