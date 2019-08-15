<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ include file="links.jsp"%>


</head>
<body>

	<%@ include file="navBar.jsp"%>



	<section class="container">
		<div class="row">
			<div class="col col-lg-md-12 col-sm-12 col-xs-4">
				<h2>Select From Available Packages</h2>
				<div class="row">

					<div class="row">

						<article class="col  col-sm-12 col-md-6 col-lg-4 item">
							<div class="card">
								<img class="card-img-top img-fluid" alt="Fruit Packages"
									src="<c:url value="/resources/images/veggies.jpg" /> "
									height="150" width="150" />
								<div class="card-body">
									<h3 class="card-title" style="color: #ac2925;">Fruits</h3>
									<p class="card-text">All the fruit you could ever want!
										This box is ideal for snacking, baking, and juicing.</p>
									<a href="${pageContext.request.contextPath}/product/fruit"
										class="btn btn-danger">Fruit Packages</a>
								</div>
							</div>
						</article>

						<article class="col  col-sm-12 col-md-6 col-lg-4 item">
							<div class="card">
								<img class="card-img-top img-fluid" alt="Vegetable Packages"
									src="<c:url value="/resources/images/veggies.jpg" /> "
									height="150" width="150" />
								<div class="card-body">
									<h3 class="card-title" style="color: #398439;">Vegetables</h3>
									<p class="card-text">All veggies, all the time! Great for
										weekly meal planning and stocking up on staples.</p>
									<a href="${pageContext.request.contextPath}/product/vegetables"
										class="btn btn-success">Vegetables Packages</a>
								</div>
							</div>
						</article>


						<article class="col  col-sm-12 col-md-6 col-lg-4 item">
							<div class="card">
								<img class="card-img-top img-fluid" alt="Mixed Packages"
									src="<c:url value="/resources/images/veggies.jpg" /> "
									height="150" width="150" />
								<div class="card-body">
									<h3 class="card-title" style="color: #d58512;">Mixed</h3>
									<p class="card-text">A mix of delicious fruits and
										vegetables. Great for saving money and eating healthy.</p>
									<a href="${pageContext.request.contextPath}/product/Mixed"
										class="btn btn-warning">Mixed Packages</a>
								</div>
							</div>
						</article>
						
					</div>
				</div>

			</div>
	</section>

<hr>


	<%@ include file="footer.jsp"%>


</body>
</html>