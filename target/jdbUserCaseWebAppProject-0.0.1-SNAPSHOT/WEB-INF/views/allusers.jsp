<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>

<%@ include file="links.jsp"%>

<style>
.message {
	float: right;
	color: ${textColor
}
;
}
</style>
</head>
<body>

	<%@ include file="navBar.jsp"%>


	<div class="container">
		<div class="col-md-offset-1 col-md-10">

			<form action="${pageContext.request.contextPath}/adduser">
				<input class="btn btn-primary" type="submit" value="Add User" />
			</form>

			<br />
			<br />
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">
						Customer List <span class="message">${messageResult}</span>
					</div>
				</div>
				<div class="panel-body">


					<table class="table table-striped table-hover table-bordered">
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<!-- 
							<th>Role</th>
							<th>Update</th>
							<th>Delete</th> 
							-->

						</tr>

						<!-- loop over and print our Users -->
						<c:forEach var="user" items="${userList}">

							<c:if test="${user.uEmail ne sUser.uEmail}">
								<tr>
									<td>${user.uFirstName}</td>
									<td>${user.uLastName}</td>
									<td>${user.uEmail}</td>
									<%-- 
									<td>${user.uRole}</td>
			
         							<!-- display the update link --> 
         	 						<td> <a href="${pageContext.request.contextPath}/updateUser/${user.uEmail}">Update</a></td>
         							<!-- display the Delete link -->          
        							<td><a href="${pageContext.request.contextPath}/removeUser/${user.uEmail}">Delete</a></td>
        								 --%>
								</tr>
							</c:if>
						</c:forEach>

					</table>

				</div>
			</div>
		</div>

	</div>

	<%@ include file="footer.jsp"%>

</body>
</html>