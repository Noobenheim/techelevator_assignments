<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="showSideSlider" value="false" />
</c:import>

<div id="write-review">
<h1>Write a Review!</h1>
<c:import url="/WEB-INF/jsp/common/reviewForm.jsp" />
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />