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


	<div class="container mt-4">
		<div class="row">
			<!-- Grid column -->
			<div class="col-md-6 mb-4">
				<div class="container">
					<div class="page-header">
						<h1>Who Are We</h1>
					</div>

					<div></div>
					<p>While volunteering at a local community center, I was
						invited to join the mission of caring individuals to collect near
						expiring produce from nearby super markets at a discount and
						passing that discount to low income individuals and families.</p>
					<br>
					<p>

						While participating in the Java Web Developer cohort through <a
							href="https://www.platformbyps.org/boston/java-developer">
							Platforms&#8482; By PerScholas Boston</a>, I began to explore several
						options for his UseCase project. My thought returned to the
						efforts of those at the community center. Perhaps I can build web
						application to help streamline the community increase their
						productivity and also broaden the reach to serving many more
						communities in the hope to healthy fruits and vegetables products
						a viable option for low income families.
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<!-- Grid column -->
			<div class="col-md-6 mb-4">

				<!--Card-->
				<div class="card">
					<!--Card image-->
					<div class="view overlay hm-white-slight">
						<img
							src="<spring:url value="/resources//images/trash.jpg"/>" style="width:100%" alt="trash"
							class="img-fluid" alt="photo">
							<div class="mask"></div>
						</a>
					</div>
					<!--Card content-->
					<div class="card-body">
						<!--Title-->
						<h4 class="card-title">What a Waste!</h4>
						<hr>
						<!--Text-->
						<p class="card-text">Although Supermarkets only accept the
							highest quality products from farms, the shelf life for fruits
							and vegetable are quite low. As a whole, our nation throws away
							40% of the food we produce. This waste ends up in landfills where
							it turns to methane, which is a greenhouse gas 100 times more
							potent than carbon monoxide. It is difficult to imagine that 80%
							of our drinking water, 40% of our land and 10% of our energy is
							used to grow our country’s food, that’s an awful lot of resources
							goes into growing these produce, only to be thrown away, while 41
							million Americans do not have enough to eat.</p>
						</p>
					</div>
				</div>
				<!--/.Card-->
			</div>
			<!-- Grid column -->
			<!-- Grid column -->
			<div class="col-md-6 mb-4">
				<!--Card-->
				<div class="card">
					<!--Card image-->
					<div class="view overlay hm-white-slight">
						<img src="<spring:url value="/resources//images/trash2.jpg"/>" style="width:100%" alt="trash"
"
							class="img-fluid" alt="photo"> <a href="#!">
							<div class="mask"></div>
						</a>
					</div>
					<!--Card content-->
					<div class="card-body">
						<!--Title-->
						<h4 class="card-title">Our Mission</h4>
						<!--Text-->
						<p class="card-text"><hr>
						We aim to help reduce food waste and improve access to healthy
						food to our local communities.

					</div>
				</div>
				<!--/.Card-->
			</div>
			<!-- Grid column -->
		</div>
	</div>

	<%@ include file="footer.jsp"%>


</body>
</html>