<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete User</title>
        	<%@ include file="links.jsp"%>

</head>
<body>

	<!-- Modal -->
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">Confirm Delete User</h4>
			</div>
			<div class="modal-body">
				<p>Are you sure you want to delete the following User ?</p>
				<p>First Name: ${firstName}</p>
				<p>Last Name: ${lastName}</p>
				<p>Email: ${email}</p>
			</div>
			<div class="modal-footer row">
			
			
			
				<div class="col-xs-6 text-left">
				<form
					action="${pageContext.request.contextPath}/showUsers">
					<input class="btn btn-default" type="submit"
						value="Cancel" data-dismiss="modal" />
				</form>
				</div>
				<div class="col-xs-6 text-right">
				<form
					action="${pageContext.request.contextPath}/removeUser/${email}">
					<input class="btn btn-danger" type="submit"
						value="Delete" data-dismiss="modal" />
				</form>
				</div>
				
				
			</div>
			</div>

		</div>
	<!-- End of Delete Confirmation Modal -->

</body>
</html>