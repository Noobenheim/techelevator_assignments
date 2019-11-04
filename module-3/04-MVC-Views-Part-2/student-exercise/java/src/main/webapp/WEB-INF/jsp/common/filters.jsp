<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Container for Filter Choices
        Each link should take the user to this current page and use any combination of the following
        querystring parameters to filter the page:
        - maxPrice (number)
        - minPrice (number)
        - minRating (number)
        - category (string) - Home, Apparel, Jewelry, Garden

        NOTE: A parameter is passed to this view that is called `baseRoute`. `baseRoute`
        refers to the page that the filters should be associated with. For instance, if you are on the products
        page, the value of the `baseRoute` should be the route for products and on the tiles page, should be the
        route for tiles.
        -->
<c:set var="appendCharPrice" value="?" />
<c:url value="${ param.baseRoute }" var="price">
	<c:if test="${ !empty param.minRating }">
		<c:set var="appendCharPrice" value="&" />
		<c:param name="minRating" value="${ param.minRating }" />
	</c:if>
	<c:if test="${ !empty param.category }">
		<c:set var="appendCharPrice" value="&" />
		<c:param name="category" value="${ param.category }" />
	</c:if>
</c:url>
<c:set var="appendCharRating" value="?" />
<c:url value="${ param.baseRoute }" var="rating">
	<c:if test="${ ! empty param.maxPrice }">
		<c:set var="appendCharRating" value="&" />
		<c:param name="maxPrice" value="${ param.maxPrice }" />
	</c:if>
	<c:if test="${ ! empty param.minPrice }">
		<c:set var="appendCharRating" value="&" />
		<c:param name="minPrice" value="${ param.minPrice }" />
	</c:if>
	<c:if test="${ ! empty param.category }">
		<c:set var="appendCharRating" value="&" />
		<c:param name="category" value="${ param.category }" />
	</c:if>
</c:url>
<c:set var="appendCharCategory" value="?" />
<c:url value="${ param.baseRoute }" var="category">
	<c:if test="${ ! empty param.maxPrice }">
		<c:set var="appendCharCategory" value="&" />
		<c:param name="maxPrice" value="${ param.maxPrice }" />
	</c:if>
	<c:if test="${ ! empty param.minPrice }">
		<c:set var="appendCharCategory" value="&" />
		<c:param name="minPrice" value="${ param.minPrice }" />
	</c:if>
	<c:if test="${ ! empty param.minRating }">
		<c:set var="appendCharCategory" value="&" />
		<c:param name="minRating" value="${ param.minRating }" />
	</c:if>
</c:url>

<div id="filter-options">
	<h3>Refine By</h3>
	<ul>
		<li><a href="${ price }${ appendCharPrice }maxPrice=25">Under $25</a></li>
		<li><a href="${ price }${ appendCharPrice }maxPrice=50&minPrice=25">$25 to $50</a></li>
		<li><a href="${ price }${ appendCharPrice }minPrice=50">$50 &amp; Above</a></li>
	</ul>
	<p>Avg. Review</p>
	<ul>
		<li>
			<a class="rating" href="${ rating }${ appendCharRating }minRating=4">
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span>&#9734;</span> &amp; Up
			</a>
		</li>
		<li>
			<a class="rating" href="${ rating }${ appendCharRating }minRating=3">
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span> &amp; Up
			</a>
		</li>
		<li>
			<a class="rating" href="${ rating }${ appendCharRating }minRating=2">
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span> &amp; Up
			</a>
		</li>
		<li>
			<a class="rating" href="${ rating }${ appendCharRating }minRating=1">
				<span class="filled">&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span> &amp; Up
			</a>
		</li>
	</ul>
	<p>Category</p>
	<ul>
		<li><a href="${ category }${ appendCharCategory }category=Home">Home</a></li>
		<li><a href="${ category }${ appendCharCategory }category=Apparel">Apparel</a></li>
		<li><a href="${ category }${ appendCharCategory }category=Jewelry">Jewelry</a></li>
		<li><a href="${ category }${ appendCharCategory }category=Garden">Garden</a></li>
	</ul>
</div>
