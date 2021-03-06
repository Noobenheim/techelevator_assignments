<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="common/header.jsp">
	<c:param name="title" value="FizzBuzz"></c:param>
</c:import>

<nav id="page-options">
	<ul>
		<c:set var="numberOfItems" value="20" />
		<c:url var="fizzBuzzRoute" value="fizzBuzz.jsp">
			<c:param value="${ numberOfItems }" name="number" />
		</c:url>
		<li><a href="<c:out value="${ fizzBuzzRoute }" />"><c:out value="${ numberOfItems }" /></a></li>

		<c:set var="numberOfItems" value="50" />
		<c:url var="fizzBuzzRoute" value="fizzBuzz.jsp">
			<c:param value="${ numberOfItems }" name="number" />
		</c:url>
		<li><a href="<c:out value="${ fizzBuzzRoute }" />"><c:out value="${ numberOfItems }" /></a></li>

		<c:set var="numberOfItems" value="100" />
		<c:url var="fizzBuzzRoute" value="fizzBuzz.jsp">
			<c:param value="${ numberOfItems }" name="number" />
		</c:url>
		<li><a href="<c:out value="${ fizzBuzzRoute }" />"><c:out value="${ numberOfItems }" /></a></li>
	</ul>
</nav>


<main>
	<ul id="fizzbuzz">
	<c:forEach begin="1" end="${ param.number }" var="i">
	<c:set var="clazz" value="" />
		<c:set var="output" value="${ i }" />
		<c:choose>
			<c:when test="${ i%3==0 && i%5==0 }">
				<c:set var="output" value="FizzBuzz!" />
				<c:set var="clazz" value="fizzbuzz" />
			</c:when>
			<c:when test="${ i%3==0 }">
				<c:set var="output" value="Fizz!" />
				<c:set var="clazz" value="fizz" />
			</c:when>
			<c:when test="${ i%5==0 }">
				<c:set var="output" value="Buzz!" />
				<c:set var="clazz" value="buzz" />
			</c:when>
		</c:choose>
		<li class="${ clazz }">${ output }</li>
	</c:forEach>
	</ul>
</main>

<c:import url="common/footer.jsp"></c:import>