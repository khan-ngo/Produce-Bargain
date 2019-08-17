<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="links.jsp"%>

<style>
body {
margin:0;
}
</style>
</head>

<body>
	<header class="sticky-top">
		<!-- Start of NavBar -->

		<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
			<a href="${pageContext.request.contextPath}" class="navbar-brand">Produce
				Bargain</a>

			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarsExample03" aria-controls="navbarsExample03"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarsExample03">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item "><a class="nav-link"
						href="${pageContext.request.contextPath}/aboutus">AboutUs</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/products">Products</a></li>
				</ul>

				<ul class="navbar-nav navbar-right">

					<c:if test="${not empty sUser.uEmail}">

						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/showUsers">Users</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/showProducts">Inventory</a>
						</li>

						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" id="navDropDownLink"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								<i class="fa fa-user"></i> ${sUser.uFirstName}
						</a>
							<ul class="dropdown-menu" aria-labelledby="navDropDownLink">
								<li><a class="dropdown-item"
									href="${pageContext.request.contextPath}/profile"
									class="glyphicon glyphicon-cog">My Profile</a></li>

								<li><a class="glyphicon glyphicon-log-out"
									class="dropdown-item" href="logout">LogOut</a></li>
							</ul>
						<li class="nav-item"><a
							class="nav-link glyphicon glyphicon-shopping-cart"
							href="${pageContext.request.contextPath}/cart"> MyCart</a></li>
					</c:if>

					<c:if test="${empty sUser.uEmail}">

						<li><a href="<c:url value="/login" />"
							class="glyphicon glyphicon-log-in nav-link"> LogIn</a></li>

						<li><a href="<c:url value="/register" />"
							class="glyphicon glyphicon-user nav-link"> Register</a></li>
					</c:if>
				</ul>
			</div>
		</nav>
		<!-- End of NavBar -->


	</header>
	<script>
	//onclick addClass to make active
	</script>


</body>
</html>