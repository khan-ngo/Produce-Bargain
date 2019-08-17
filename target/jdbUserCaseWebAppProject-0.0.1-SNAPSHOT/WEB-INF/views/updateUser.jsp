<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
        	<%@ include file="links.jsp"%>


<!-- Start of NavBar -->
<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark">
	<div>
		<a class="navbar-brand d-none d-lg-block" href="welcome">Produce
			Bargain</a>
	</div>
</nav>
<!-- End of NavBar -->

<!-- Start of Modal -->
<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<h4 class="modal-title text-xs-center">Update User </h4>
		</div>
		<div class="modal-body">
			<form role="form"			
				action="${pageContext.request.contextPath}/updateuser"
				method="POST">
				<input type="hidden" name="_token" value="">

				<div class="form-group">
					<label class="control-label">First Name</label>
					<div>
						<input type="text" class="form-control input-lg" name="firstName"
							placeholder="${user.uFirstName}" value="${user.uFirstName}" >
					</div>
				</div>
				<div class="form-group">
					<label class="control-label">Last Name</label>
					<div>
						<input type="text" class="form-control input-lg" name="lastName"
							placeholder="${user.uLastName}" value="${user.uLastName}" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label">E-Mail</label>
					<div>
						<input type="email" class="form-control input-lg" name="email"
							placeholder="${user.uEmail}" value="${user.uEmail}" readonly/>
					</div>				
					</div>

				<div class="form-group">
					<label class="control-label">Password</label>
					<div>
						<input type="password" class="form-control input-lg"
							name="password" placeholder="Enter New Password"
							value="${user.uPassword}" />
					</div>
				</div>
				<div class="modal-footer text-lg-center">
						<div>
							<button id="register-btn-click" type="submit"
								class="btn btn-info btn-block btn-lg">Update User</button>
						</div>
				</div>

			</form>
		</div>

	</div>
	<!-- /.modal-content -->
</div>
<!-- /.modal-dialog -->
<!-- /.modal -->
