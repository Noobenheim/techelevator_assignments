<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Customers List"/>

<%@include file="common/header.jspf"%>

<form method="GET" action="customerResult">
	<div>
		<input type="text" name="search" placeholder="Search" value="${ param.search }" />
	</div>
	<div>
		<label for="sort">Sort:</label>
		<c:set var="lastNameSelected" value="" />
		<c:set var="emailSelected" value="" />
		<c:set var="activeSelected" value="" />
		<c:set var="selected" value=" selected=\"selected\"" />
		<c:choose>
			<c:when test="${ param.sort eq 'last_name' }">
				<c:set var="lastNameSelected" value="${ selected }" />
			</c:when>
			<c:when test="${ param.sort eq 'email' }">
				<c:set var="emailSelected" value="${ selected }" />
			</c:when>
			<c:when test="${ param.sort eq 'active' }">
				<c:set var="activeSelected" value="${ selected }" />
			</c:when>
		</c:choose>
		<select name="sort">
			<option value="last_name"${ lastNameSelected }>Last Name</option>
			<option value="email"${ emailSelected }>Email</option>
			<option value="active"${ activeSelected }>Active</option>
		</select>
	</div>
	<div>
		<input type="submit" value="Search" />
	</div>
</form>

<table class="table">
<tr>
<th>Name</th>
<th>Email</th>
<th>Active</th>
</tr>
<c:forEach items="${customers}" var="customer">
<tr>
    <td>${ customer.firstName } ${ customer.lastName }</td>
    <td>${ customer.email }</td>
    <c:set var="yesno" value="No" />
    <c:if test="${ customer.active }">
    	<c:set var="yesno" value="Yes" />
    </c:if>
    <td>${ yesno }</td>
</tr>
</c:forEach>
</table>

<%@include file="common/footer.jspf"%>