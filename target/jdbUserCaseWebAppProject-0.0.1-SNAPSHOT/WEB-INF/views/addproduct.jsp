<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp"%>

        	<%@ include file="links.jsp"%>


	<%@ include file="navBar.jsp"%>


<!-- Start of Add New User  -->
<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<h4 class="modal-title text-xs-center" id="register-option">Create
				New Product</h4>
		</div>
		<div class="modal-body">
			<form role="form" action="addproductform" method="POST">
				<input type="hidden" name="_token" value="">
				<div class="form-group">
					<label class="control-label">Category</label>
					<div>
						<input type="text" class="form-control input-lg" name="category"
							value="" placeholder="Product Category" required>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label">Name</label>
					<div>
						<input type="text" class="form-control input-lg" name="name"
							value="" placeholder="Product Name" required />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label">Size</label>
					<div>
						<input type="text" class="form-control input-lg" name="size"
							value="" placeholder="Product Size" required />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label">Weight</label>
					<div>
						<input type="text" class="form-control input-lg" name="weight"
							placeholder="Product Weight " value="" required />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label">Serving</label>
					<div>
						<input type="text" class="form-control input-lg" name="serving"
							placeholder="Product Serving " value="" required />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label">Summary</label>
					<div>
						<input type="text" class="form-control input-lg" name="summary"
							placeholder="Product Summary " value="" required />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label">Description</label>
					<div>
						<input type="text" class="form-control input-lg"
							name="description" placeholder="Product Description" value=""
							required />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label">Price</label>
					<div>
						<input type="number" min="1.00" max="100.00" step="0.01"
							class="form-control input-lg" name="price"
							placeholder="Product Price " value="" required />
					</div>
				</div>



				<div class="form-group">
					<div>
						<button id="register-btn-click" type="submit"
							class="btn btn-info btn-block btn-lg">Add Product</button>
					</div>
				</div>
			</form>

		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->
