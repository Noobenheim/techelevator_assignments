<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
</c:import>

<div id="reviews">
<c:forEach items="${ reviews }" var="review">
<c:set var="newReviewClass" value="" />
<c:if test="${ param.newReviewID eq review.id }">
	<c:set var="newReviewClass" value=" new-review" />
</c:if>
<div class="reviewItem${ newReviewClass }">
	<div class="title">${ review.title }</div>
	<div class="username">${ review.username }</div>
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
	<div class="text">${ review.text }</div>
</div>
</c:forEach>
<c:if test="${ reviews.size() == 0 }">
<div id="noReviews">
	No reviews yet. <a href="<c:url value="/writeReview" />">Be the first!</a>
</div>
</c:if>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp">
</c:import>