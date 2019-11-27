<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">
	</link>

	<!-- <c:url var="cssUrl" value="/css/custom-bulma.css" /> -->
	<!-- <link rel="stylesheet" href="${cssUrl}" type="text/css"></link> -->
	<c:url var="jsUrl" value="/js/app.js" />
	<script src="${jsUrl}" type="text/javascript" defer></script>
	<script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
	<meta charset="UTF-8">
</head>

<body class="has-background-light">
	<c:url var="mainImageUrl" value="/img/logo.png" />
	<section class="section has-background-primary">
		<nav id="navbar" role="navigation" class="navbar has-shadow is-spaced">
			<div class="navbar-brand">
				<figure class="image is-128x128">
					<img class="image is-3by1" src="${mainImageUrl}" />
				</figure>

				<a class="navbar-item" id="home-button">Home</a> <a class="navbar-item" id="survey-button">Survey</a>
			</div>
			<div class="navbar-menu">
				<div class="navbar-start"></div>
				<div class="navbar-end"></div>
			</div>
		</nav>
	</section>

	<section class="section">
		<div class="container">
			<nav class="breadcrumb" aria-label="breadcrumbs">
				<ul>
					<li><a href="#">Home</a></li>

				</ul>
			</nav>
		</div>
	</section>
	<section class="section">
		<div class="container" id="main-content"></div>
	</section>

	<template id="home">
		<div id="park-list" class="tile is-ancestor is-vertical"></div>
	</template>

	<template id="park-detail">
		<div class="tile is-ancestor is-vertical">
			<div id="park-info" class="tile"></div>
			<div id="park-weather" class="tile"></div>
		</div>
	</template>

	<template id="weather">
		<div class="tile is-parent">
			<div class="tile is-child">
				<figure class="image is-32x32">
					<img />
				</figure>
				<p class="high-temp"></p>
				<p class="low-temp"></p>
			</div>
		</div>
	</template>

	<template id="park-preview"> <a class="tile has-text-dark" href="#">
			<div class="tile is-parent">
				<div class="tile is-child">
					<figure class="image is-3by2">
						<img />
					</figure>

				</div>
			</div>
			<div class="tile is-parent">
				<article class="te-content tile is-child">
					<p class="title"></p>
					<p class="subtitle"></p>
					<div class="content"></div>
				</article>
			</div>
		</a> </template>


	<template id="survey">
		<form class="form">
			<div class="field">
				<label class="label">Park</label>
				<div class="control">
					<div class="select">
						<select id="park-dd" name="parkCode">
						</select>
					</div>
				</div>
			</div>

			<div class="field">
				<label class="label">Email</label>
				<div class="control has-icons-left has-icons-right">
					<input class="input" type="email" placeholder="Email input" value="email@" name="emailAddress">
					<span class="icon is-small is-left"> <i class="fas fa-envelope"></i>
					</span>
				</div>
			</div>

			<div class="field">
				<label class="label">State</label>
				<div class="control">
					<div class="select">
						<select id="state-dd" name="state">
						</select>
					</div>
				</div>
			</div>

			<div class="field">
				<label class="label">Activity Level</label>
				<div class="control">
					<label class="radio"> <input type="radio" name="activitylevel" value="inactive" checked> inactive
					</label> <label class="radio"> <input type="radio" name="activitylevel" value="sedentary"> sedentary
					</label> <label class="radio"> <input type="radio" name="activitylevel" value="active"> active
					</label> <label class="radio"> <input type="radio" name="activitylevel" value="extremely active">
						extremely
						active
					</label>
				</div>
			</div>
			<div class="field">
				<p class="control">
					<button id="survey-button" class="button is-success">Login</button>
				</p>
			</div>
		</form>
	</template>


	<c:url var="apiUrl" value="/api/" />

	<c:url var="imageUrl" value="/img/" />

	<script type="text/javascript">
		var techelevator = window.techelevator || {};
		techelevator.apiUrl = "${apiUrl}";
		techelevator.imageUrl = "${imageUrl}";
	</script>
</body>
</html>