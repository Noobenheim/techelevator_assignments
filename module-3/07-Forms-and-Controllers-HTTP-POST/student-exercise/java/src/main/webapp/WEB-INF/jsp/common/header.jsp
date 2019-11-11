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
		<c:if test="${ newReviewID != null }">
			<div id="top-banner">
				Your review has been submitted!
			</div>
		</c:if>
		<div>The #1 Source for Squirrel Cigar Parties!</div>
		<aside>Have your squirrel cigar parties go from novice to professional!</aside>
		<aside>Every squirrel will want to come back!</aside>
		<c:if test="${ param.showSideSlider != false }">
		<input type="checkbox" id="slide-controller" name="slide-controller" />
		<div id="new-slider">
			<label for="slide-controller" id="slider-popout">
				<div id="arrow">WRITE A REVIEW!</div>
				<i class="fas fa-feather-alt"></i>
			</label>
			<label for="slide-controller" id="slider-x"><i class="fas fa-times-circle"></i></label>
			<c:import url="/WEB-INF/jsp/common/reviewForm.jsp" />
		</div>
		</c:if>
	</div>