<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Customers List"/>



<%@include file="common/header.jspf"%>

<form method="GET" action="customerSearchResults">

	<label for="customerName">Customer Name: </label>
	<input name="customerName" type="text" placeholder="Tom!"/> 

	<label for="sortBy">Customer Name: </label>
	<select name="sortBy" >
		<option value="lastName">Last Name</option>
		<option value="email">Email</option>
		<option value="active">Is Active</option>
	</select> 

	<input type="submit"/>
</form>

<c:if test="${not empty customers}">
	<table border=2>
		<tr>
			<th>First</th>
			<th>Last</th>
			<th>Email</th>
			<th>Active</th>
		</tr>
	
		<c:forEach var="customer" items="${customers}" >
		<tr>
			<td>${customer.firstName }</td>
			<td>${customer.lastName }</td>
			<td>${customer.email }</td>
			<td>${customer.active }</td>
		</tr>
		</c:forEach>
	</table>
</c:if>

<%@include file="common/footer.jspf"%>