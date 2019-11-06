<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>
		Squirrel Cigar Party FOR DUMMIES
		<c:if test="${ param.pageSubTitle != null }">
		- ${ param.pageSubTitle }
		</c:if>
	</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz"
        crossorigin="anonymous">
</head>
<body>
	<div id="header">
		<c:if test="${ param.newReviewID != null }">
			<div id="top-banner">
				Your review has been submitted!
			</div>
		</c:if>
		<div>The #1 Source for Squirrel Cigar Parties!</div>
		<aside>Have your squirrel cigar parties go from novice to professional!</aside>
		<aside>Every squirrel will want to come back!</aside>
		<input type="checkbox" id="slide-controller" name="slide-controller" />
		<div id="new-slider">
			<label for="slide-controller" id="slider-popout">
				<div id="arrow">WRITE A REVIEW!</div>
				<i class="fas fa-feather-alt"></i>
			</label>
			<label for="slide-controller" id="slider-x"><i class="fas fa-times-circle"></i></label>
			
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
		</div>
	</div>