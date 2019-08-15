<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="taglib.jsp" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produce</title>
<%@ include file="links.jsp"%>
	<link type="text/css" href="<c:url value='/resources/css/producebargain.css' />" rel="stylesheet" />
<style>
.jumbotron{
   position: relative;
   overflow: hidden;
   height: 250px;
}

.container {
  position: relative;
  color: #ffffff;
  z-index: 2; /* Show content above video */
}

#video-background{ 
  position: absolute;
  height: auto;
  width: auto;
  min-height: 100%;
  min-width: 100%;
  left: 50%;
  top: 50%;
  -webkit-transform: translate3d(-50%, -50%, 0);
  transform: translate3d(-50%, -50%, 0);
  z-index: 1;
}
</style>


</head>
<body>
	<%@ include file="navBar.jsp"%>
	


	<div class="jumbotron">
		<video id="video-background" preload muted autoplay loop>
			<source src="<spring:url value="/resources//images/backyard.MOV"/> "
				type="video/mp4">
		</video>
		<div class="container">
			<div class="col-md-10 col-md-offset-1" data-form-type="formoid">
				<h2 class="styled"> ${sUser.uFirstName}, together we can make a Difference.</h2>
				<p>Lets take steps to reduce food waste, overcome hunger, and improve access to healthy
					food to our local communities.</p>
			</div>
		</div>
	</div>




	
		<%@ include file="footer.jsp"%>
	
</body>
</html>