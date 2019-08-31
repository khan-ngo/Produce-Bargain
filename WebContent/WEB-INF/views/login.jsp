<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%@ include file="taglib.jsp"%>
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
        	<%@ include file="links.jsp"%>


</head>
<body>

		<%@include file="navBar.jsp" %>
		
		
	<!-- Start of Registration Modal -->
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title text-xs-center" id="register-option">Login</h4>
							<p style="color:red">${messageResult}</p>
					
				</div>
				<div class="modal-body">
					<form role="form"  action="login" method="POST">
						<input type="hidden" name="_token" value="">

						<div class="form-group">
							<label class="control-label">E-Mail</label>
							<div>
								<input type="email" class="form-control input-lg" name="email"
									value="" placeholder="Enter E-Mail Address" required>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">Password</label>
							<div>
								<input type="password" class="form-control input-lg"
									name="password" value="" placeholder="Your Password" required />
							</div>
						</div>
						<div class="form-group">
							<div>
								<button id="login-btn-click" type="submit" class="btn btn-info btn-block btn-lg">Login</button>
							</div>
						</div>
					</form>
				</div>
				
				      <div class="modal-footer d-flex justify-content-center">
        <div class="signup-section">Not a member yet? 
        <a href="${pageContext.request.contextPath}/register" class="text-info"> Sign Up</a>
</div>
</div>
</div>
</div>

</body>
</html>