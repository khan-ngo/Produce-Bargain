<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%@ include file="taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>

<%@include file="links.jsp"%>
<style>
.message {
	float: right;
	color: ${textColor};
}

    @media only screen and (max-width: 1000px) {
        .one{
            display: none;
        }
    }
    
</style>
</head>
<body>

	<%@ include file="navBar.jsp"%>

	<div class="container">
		<div class="col-md-offset-1 col-md-10">

			<br />
			<br />
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">
						Cart Page <span class="message">${messageResult}</span>
								<span colspan="8" align="right"><a href="${pageContext.request.contextPath }/products" class="btn btn-warning">Continue Shopping</a></span>
					</div>
				</div>
				<div class="panel-body">


					<table class="table table-striped table-hover table-condensed ">

						<tr>
							<th>Category</th>
							<th>Name</th>
							<th>Size</th>
							<th>Weight</th>
							<th>Serving</th>
							<th>Summary</th>
							<th class="one">Description</th>
							<th>Price</th>
							<th>Option</th>
						</tr>
						<c:set var="total" value="0"></c:set>
						<c:forEach var="product" items="${productList}">
							<c:set var="total" value="${total + product.pPrice}"></c:set>
							<tr>
								<td>${product.pCategory}</td>
								<td>${product.pName}</td>
								<td>${product.pSize}</td>
								<td>${product.pWeight}</td>
								<td>${product.pServing}</td>
								<td>${product.pSummary}</td>
								<td class="one">${product.pDescription}</td>
								<td>$${product.pPrice}</td>
								<td><a
									href="${pageContext.request.contextPath}/deleteitemfromcart/${product.pId}">Delete</a></td>
							</tr>
							
							<c:set var="colspanwidth" value = "8" />
						</c:forEach>
						<tr>
							<td colspan="7" align="right">SubTotal</td>
							<td>$${total}</td>
						</tr>

						<c:set var="tax" value="${0.07}"></c:set>
						<c:set var="grandTotal" value="${total + (total * tax)}"></c:set>

						<tr>
							<td colspan="7" align="right">SubTotal + Tax (7%)</td>
							<td>$${grandTotal}</td>
						</tr>

						<tfoot>
							<tr>
							<td colspan="7" class="hidden-xs"></td>
								
								<td  align="right" class="hidden-xs text-center one"><strong>Total
										$${grandTotal}</strong></td>
										
								<c:if test="${grandTotal != 0}"	>	
								<td ><a
									href="${pageContext.request.contextPath}/checkout"
									class="btn btn-success btn-block">Checkout</a></td>
									</c:if>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>

	</div>
</body>
</html>