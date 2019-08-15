<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="taglib.jsp" %>

<%@include file="links.jsp" %>

<%@include file="navBar.jsp" %>
<!-- Start of Add New User  -->
<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<h4 class="modal-title text-xs-center" id="register-option">My Profile Information</h4>
		</div>
		<div class="modal-body">

			<form role="form" action="updateprofile" method="POST">
				<div class="form-group row">
					<label for="email" class="col-4 col-form-label">Email*</label>
					<div class="col-8">
						<input name="email" placeholder="${sUser.uEmail}"
							value="${sUser.uEmail}" class="form-control" readonly />
					</div>
				</div>
				<div class="form-group row">
					<label for="name" class="col-4 col-form-label">First Name</label>
					<div class="col-8">
						<input name="firstName" placeholder="First Name"
							value="${sUser.uFirstName}" class="form-control" />
					</div>
				</div>
				<div class="form-group row">
					<label for="lastName" class="col-4 col-form-label">Last
						Name</label>
					<div class="col-8">
						<input name="lastName" placeholder="Last Name"
							value="${sUser.uLastName}" class="form-control" />
					</div>
				</div>

				<div class="form-group row">
					<label for="pass" class="col-4 col-form-label">Password</label>
					<div class="col-8">
						<input type="password" name="password"
							placeholder="Password" value="${sUser.uPassword}"
							class="form-control" />
					</div>
				</div>

				<div class="form-group row">
					<div class="offset-4 col-8">
						<button name="submit" type="submit" class="btn btn-primary">Update
							My Profile</button>
					</div>
				</div>
				<div>
				<p>${messageResult}</p>
				</div>
			</form>



		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->
