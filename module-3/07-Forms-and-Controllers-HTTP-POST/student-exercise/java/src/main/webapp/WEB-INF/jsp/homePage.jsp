<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
</c:import>

<div id="reviews">
<c:forEach items="${ reviews }" var="review">
<c:set var="newReviewClass" value="" />
<c:if test="${ newReviewID eq review.id }">
	<c:set var="newReviewClass" value=" new-review" />
</c:if>
<div class="reviewItem${ newReviewClass }">
	<div class="title"><c:out value="${ review.title }" escapeXml="true" /></div>
	<div class="username"><c:out value="${ review.username }" escapeXml="true" /></div>
	<fmt:parseDate value="${ review.dateSubmitted }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
	<fmt:formatDate pattern="MMM d, y" value="${ parsedDateTime }" var="formattedDate"/>
	<div class="date">${ formattedDate }</div>
	<div class="rating">
		<c:forEach begin="1" end="5" var="i">
			<c:if test="${ i <= review.rating }">
				<img src="<c:url value="/img/star.png" />" />
			</c:if>
		</c:forEach>
	</div>
	<div class="text"><c:out value="${ review.text }" escapeXml="true" /></div>
</div>
</c:forEach>
<c:if test="${ reviews.size() == 0 }">
<div id="noReviews">
	No reviews yet. <a href="<c:url value="/writeReview" />">Be the first!</a>
</div>
</c:if>
</div>
<h1><a href="<c:url value="/writeReview" />">Write A Review!</a></h1>

<c:import url="/WEB-INF/jsp/common/footer.jsp">
</c:import>