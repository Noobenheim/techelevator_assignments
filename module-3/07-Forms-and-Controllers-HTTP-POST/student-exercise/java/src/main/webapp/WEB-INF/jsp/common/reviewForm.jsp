<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

			<c:url value="/writeReview" var="newReviewURL" />
			<form method="post" action="${ newReviewURL }">
				<div>
					<label for="username">Username:</label>
					<input type="text" name="username" placeholder="Username" required="required" />
				</div>
				<div id="set-rating">
					<c:forEach begin="1" end="5" var="star">
					<span class="star" id="starNum${ 6-star }" onclick="selectRating(${ 6-star })"></span>
					</c:forEach>
					<input type="hidden" name="rating" value="1" id="newStarRating" />
					<script type="text/javascript">
						function selectRating(number) {
							document.getElementById("newStarRating").value=number;
							for( var i=1; i<=number; i++ ) {
								document.getElementById("starNum"+i).className = "star selected";
							}
							for( var i=number+1; i<=5; i++ ) {
								document.getElementById("starNum"+i).className = "star";
							}
						}
						document.getElementById("starNum1").className = "star selected";
					</script>
					<label></label>
				</div>
				<div>
					<label for="title">Title:</label>
					<input type="text" name="title" placeholder="Title" required="required" />
				</div>
				<div>
					<label for="text">Message:</label>
					<textarea name="text" required="required"></textarea>
				</div>
				<div>
					<label></label>
					<input type="hidden" name="currentURL" value="${ currentURL }" />
					<input type="submit" value="Submit Review" />
				</div>
			</form>