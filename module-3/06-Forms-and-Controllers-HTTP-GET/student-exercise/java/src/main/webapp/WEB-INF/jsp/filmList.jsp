<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Films List"/>

<%@include file="common/header.jspf"%>

<form method="GET" action="filmResult">
	<div>
		<label for="minLength">Minimum Length:</label>
		<input type="number" name="minLength" placeholder="Minutes" value="${ param.minLength }" />
	</div>
	<div>
		<label for="maxLength">Maximum Length:</label>
		<input type="number" name="maxLength" placeholder="Minutes" value="${ param.maxLength }" />
	</div>
	<div>
		<label for="genre">Genre:</label>
		<select name="genre">
		<c:forEach items="${ genres }" var="genre">
			<c:set var="selected" value="" />
			<c:if test="${ genre eq param.genre }">
				<c:set var="selected" value=" selected=\"selected\"" />
			</c:if>
			<option value="${ genre }"${ selected }>${ genre }</option>
		</c:forEach>
		</select>
	</div>
	<div>
		<input type="submit" value="Search" />
	</div>
</form>

<table class="table">
<tr>
<th>Title</th>
<th>Description</th>
<th>Release Year</th>
<th>Length</th>
<th>Rating</th>
</tr>
<c:forEach items="${films}" var="film">
<tr>
    <td>${ film.title }</td>
    <td>${ film.description }</td>
    <td>${ film.releaseYear }</td>
    <td>${ film.length }</td>
    <td>${ film.rating }</td>
</tr>
</c:forEach>
</table>

<%@include file="common/footer.jspf"%>