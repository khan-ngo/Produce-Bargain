<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%@ include file="taglib.jsp"%>
	
	
        	<%@ include file="links.jsp"%>

		<%@include file="navBar.jsp" %>

		
		
		        <style>
            .error {
                color: red
            }
        </style>
        
        
	<!-- Start of Registration Modal -->
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title text-xs-center" id="register-option">Register</h4>
				</div>
				<div class="modal-body">				
				<form:form class="register-form" action="register" method="POST" modelAttribute="userKey">
						
						<div class="form-group">
							<label class="control-label">First Name</label>
							<div>
								<form:input path="uFirstName" type="text" class="form-control input-lg" />
									<form:errors path="uFirstName" class="error"  />
							</div>
							
						</div>
						<div class="form-group">
							<label class="control-label">Last Name</label>
							<div>
								<form:input path="uLastName" type="text" class="form-control input-lg" />
									<form:errors path="uLastName" class="error"  />
							</div>
							
						</div>
						<div class="form-group">
							<label class="control-label">E-Mail</label>
							<div>
								<form:input path="uEmail" type="text" class="form-control input-lg" />
								<form:errors path="uEmail" class="error"  />
							</div>
						</div>
						
				<div class="form-group">
					<label class="control-label">Password</label>
					<div>
						<form:input path="uPassword" type="password" class="form-control input-lg" />
						<form:errors  path="uPassword" class="error" />
					</div>
				</div>
				
				<div class="form-group">
							<div>
								<button id="register-btn-click" type="submit" class="btn btn-info btn-block btn-lg">Create
									My Account</button>
							</div>
						</div>
					</form:form>
				</div>
				
          <div class="modal-footer d-flex justify-content-center">
        <div class="signup-section">Already have an Account? <a href="${pageContext.request.contextPath}/login" class="text-info"> Log In</a>.</div>
      </div>
				
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
