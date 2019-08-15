<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Product</title>
        	<%@ include file="links.jsp"%>

</head>
<body>

	<!-- Modal -->
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">Confirm Delete Product</h4>
			</div>
			<div class="modal-body">
				<p>Are you sure you want to delete the following Product ?</p>

				<p>Category: ${category}</p>
				<p>Name: ${name}</p>
				<p>Weight: ${weight}</p>
				<p>Serving: ${serving}</p>
				<p>Summary: ${summary}</p>
				<p>Description: ${description}</p>
				<p>Price: ${price}</p>
			</div>
			
			
			<div class="modal-footer row">
			
				<div class="col-xs-4 text-left">
				
				<form
					action="${pageContext.request.contextPath}/showProducts">
					<input class="btn btn-default" type="submit"
						value="Cancel" data-dismiss="modal" />
				</form>
				</div>
				<div class="col-xs-4 text-right">
				<form
					action="${pageContext.request.contextPath}/removeProduct/${id}">
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