<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html >

  <head>

        <meta charset="utf-8">
        <title>${category}</title>
        	<%@ include file="links.jsp"%>
        
        <style>
      .btn-add-cart {
        position: absolute;
        left: 15px;
        top: 0px;
      }

p {
color: black;
}
    </style>
      </head>
      
      <body>
	<%@ include file="navBar.jsp"%>

        <section>
          <div class="container">
            <div class="row">
              <div class="col col-sm-12 col-xs-4">
                <h1>${category}</h1>
                <div class="row">

						<c:forEach var="product" items="${productList}">

							<div class="col col-xs-6 col-sm-12 col-md-6 col-lg-4 item">
								<div class='img-container'>
									<c:if test="${not empty sUser.uEmail}">
										<form
											action="${pageContext.request.contextPath}/addtocart/${product.pId}"
											method="POST">
											<button class="btn ${btnClass} btn-add-cart">
												<span class="glyphicon glyphicon-shopping-cart"></span> Add
												to cart
											</button>
										</form>
									</c:if>
									<img class="card-img-top img-responsive" alt="${product.pName}"
										src="<c:url value='/resources/images/basket.jpg'/> "
										height="150" width="150" />
								</div>
								<h4 ${textColor}>${product.pName}</h4>

								<p><strong>Summary:</strong> ${product.pSummary}</p>
								<span>
								<p><strong>Weight:</strong> ${product.pWeight} lbs</p>
								<p><strong>Serves:</strong> ${product.pServing} Servings</p>
								</span>
								
								<p><strong>Description:</strong> ${product.pDescription}</p>

								<p><strong>Price:</strong> $${product.pPrice}</p>
							</div>

						</c:forEach>

					</div>
              </div>

            </div>
          </div>
          </section>
               <%@ include file="footer.jsp" %>
          
  </body>

</html>
