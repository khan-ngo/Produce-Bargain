<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>

        	<%@ include file="links.jsp"%>

<style>
.message {
	float: right;
	color: ${textColor};
}
</style>
</head>
<body>

	<%@ include file="navBar.jsp"%>

	<div class="container">
		<div class="col-md-offset-1 col-md-10">

			<form action="addproduct">
				<input class="btn btn-primary" type="submit" value="Add Product" />
			</form>

			<br /><br />
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">
						Product List <span class="message">${messageResult}</span>
					</div>
				</div>
				<div class="panel-body">


					<table class="table table-striped table-hover table-bordered">

						<tr>
							<th>Category</th>
							<th>Name</th>

							<th>Serving</th>
							<th>Price</th>
							<th>Update</th>
							<th>Delete</th>
						</tr>

						<c:forEach var="product" items="${productList}">
							<tr>
								<td>${product.pCategory}</td>
								<td>${product.pName}</td>
 								<td>${product.pServing}</td>
								<td>${product.pPrice}</td>

								<!-- display the update link -->
								<td><a
									href="${pageContext.request.contextPath}/updateproduct/${product.pId}">Update</a></td>

								<!-- display the Delete link -->
								<td><a
									href="${pageContext.request.contextPath}/confirmdeleteproduct/${product.pId}">Delete</a></td>


							</tr>
						</c:forEach>
					</table>
					    </div>
   </div>
  </div>

 </div>
 	<%@ include file="footer.jsp"%>
 
</body>
</html>