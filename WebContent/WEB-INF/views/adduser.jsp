<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="taglib.jsp"%>
	
	<%@ include file="links.jsp"%>

		<!-- Start of NavBar -->
		
	<!-- Start of Add New User  -->
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title text-xs-center" id="register-option">Create New Account</h4>
				</div>
				<div class="modal-body">
					<form role="form"  action="adduserform" method="POST">
						<input type="hidden" name="_token" value="">
						<div class="form-group">
							<label class="control-label">First Name</label>
							<div>
								<input type="text" class="form-control input-lg"
									name="firstName" value="" placeholder="Your First Name"
									required>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">Last Name</label>
							<div>
								<input type="text" class="form-control input-lg" name="lastName"
									value="" placeholder="Your Last Name" required />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">E-Mail</label>
							<div>
								<input type="email" class="form-control input-lg" name="email"
									value="" placeholder="Enter E-Mail Address" required />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">Password</label>
							<div>
								<input type="password" class="form-control input-lg"
									name="password" placeholder="Enter Password" value="" required />
							</div>
						</div>
						<div class="form-group">
							<div>
								<button id="register-btn-click" type="submit" class="btn btn-info btn-block btn-lg">Add User</button>
							</div>
						</div>
					</form>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
