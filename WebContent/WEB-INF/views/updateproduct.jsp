<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="taglib.jsp"%>
	
        	<%@ include file="links.jsp"%>

<!-- Start of NavBar -->
<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark">
	<div>
		<a class="navbar-brand d-none d-lg-block" href="${pageContext.request.contextPath}/welcome">Produce
			Bargain</a>
	</div>
</nav>
<!-- End of NavBar -->

<!-- Start of Modal -->
<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<h4 class="modal-title text-xs-center">Update Product </h4>
		</div>
		<div class="modal-body">
			<form role="form"			
				action="${pageContext.request.contextPath}/updateproductform/${product.pId}"
				method="POST">
				<input type="hidden" name="_token" value="">

				<div class="form-group">
					<label class="control-label">Id:</label>
					<div>
						<input type="text" class="form-control input-lg" name="id"
							placeholder="${product.pId}" value="${product.pId}" readonly />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label">Category</label>
					<div>
						<input type="text" class="form-control input-lg" name="category"
							placeholder="${product.pCategory}" value="${product.pCategory}" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label">Name:</label>
					<div>
						<input type="text" class="form-control input-lg" name="name"
							placeholder="${product.pName}" value="${product.pName}" />
					</div>				
					</div>

				<div class="form-group">
					<label class="control-label">Size:</label>
					<div>
						<input type="text" class="form-control input-lg"
							name="size" placeholder="${product.pSize}"
							value="${product.pSize}" />
					</div>
				</div>
				
								<div class="form-group">
					<label class="control-label">Weight:</label>
					<div>
						<input type="text" class="form-control input-lg"
							name="weight" placeholder="${product.pWeight}"
							value="${product.pWeight}" />
					</div>
				</div>
				
				
								<div class="form-group">
					<label class="control-label">Serving:</label>
					<div>
						<input type="text" class="form-control input-lg"
							name="serving" placeholder="${product.pServing}"
							value="${product.pServing}" />
					</div>
				</div>
				
								<div class="form-group">
					<label class="control-label">Summary:</label>
					<div>
						<input type="text" class="form-control input-lg"
							name="summary" placeholder="${product.pSummary}"
							value="${product.pSummary}" />
					</div>
				</div>
				
				<div class="form-group" >
					<label class="control-label">Description:</label>
							<input type="text" class="form-control input-lg"
							name="description" placeholder="${product.pDescription}"
							value="${product.pDescription}" /> 

				</div>
				
				
				<div class="form-group">
					<label class="control-label">Price:</label>
					<div>
						<input type="text" class="form-control input-lg"
							name="price" placeholder="${product.pPrice}"
							value="${product.pPrice}" />
					</div>
				</div>
	
				
				
				<div class="modal-footer text-lg-center">
						<div>
							<button id="register-btn-click" type="submit"
								class="btn btn-info btn-block btn-lg">Update Product</button>
						</div>
				</div>

			</form>
		</div>

	</div>
	<!-- /.modal-content -->
</div>
<!-- /.modal-dialog -->
<!-- /.modal -->
