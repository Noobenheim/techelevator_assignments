<!-- Registration -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="pageTitle" value="Home Page"/>
<%@include file="../common/header.jspf" %>

<h2>New User Registration</h2>

<form:form action="register" method="POST" modelAttribute="registration">
	<div class="form-group">
		<form:label path="firstName">First Name</form:label>
		<form:input type="text" path="firstName" placeholder="enter first name" required="required" class="form-control" />
		<form:errors path="firstName" cssClass="error" />
	</div>
	<div class="form-group">
		<form:label path="lastName">Last Name</form:label>
		<form:input type="text" path="lastName" placeholder="enter last name" required="required" class="form-control" />
		<form:errors path="lastName" cssClass="error" />
	</div>
	<div class="form-group">
		<form:label path="email">Email</form:label>
		<form:input type="email" path="email" placeholder="enter email" required="required" class="form-control" />
		<form:errors path="email" cssClass="error" />
	</div>
	<div class="form-group">
		<form:label path="confirmEmail">Confirm Email</form:label>
		<form:input type="email" path="confirmEmail" placeholder="confirm email address" required="required" class="form-control" />
		<form:errors path="emailMatching" cssClass="error" />
	</div>
	<div class="form-group">
		<form:label path="password">Password</form:label>
		<form:input type="password" path="password" placeholder="enter password" required="required" class="form-control" />
		<form:errors path="password" cssClass="error" />
	</div>
	<div class="form-group">
		<form:label path="confirmPassword">Confirm Password</form:label>
		<form:input type="password" path="confirmPassword" placeholder="confirm password" required="required" class="form-control" />
		<form:errors path="passwordMatching" cssClass="error" />
	</div>
	<div class="form-group">
		<form:label path="birthDate">Birthday</form:label>
		<form:input type="date" path="birthDate" placeholder="enter birth date" required="required" class="form-control" />
		<form:errors path="birthDate" cssClass="error" />
	</div>
	<div class="form-group">
		<form:label path="numberOfTickets"># of Tickets</form:label>
		<form:input type="number" path="numberOfTickets" min="1" max="10" placeholder="enter number of tickets" required="required" class="form-control" />
		<form:errors path="numberOfTickets" cssClass="error" />
	</div>
	<div class="form-group">
		<input type="submit" value="Submit" class="btn btn-primary" />
	</div>
</form:form>

<%@include file="../common/footer.jspf" %>
