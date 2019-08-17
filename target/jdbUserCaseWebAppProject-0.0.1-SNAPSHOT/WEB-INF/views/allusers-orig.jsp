<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>LIST OF USERS</h2>
<div>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
<div class="well">

<table>
     <tr>
     
     <td>First Name</td>
     <td>Last Name</td>
     <td>Email</td>
     <td>Password</td>
     <td>Role</td>
     <td>Update</td>
     <td>Delete</td>
     
     </tr>

<c:forEach var="user" items="${userList}">


              <a href="user.html"><i class="icon-pencil"></i></a>
              <a href="#myModal" role="button" data-toggle="modal"><i class="icon-remove"></i></a>
          </td>
        </tr>
        
		<tr>
			<td>${user.uFirstName}</td>
			<td>${user.uLastName}</td>
			<td>${user.uEmail}</td>
			<td>${user.uPassword}</td>
			<td>${user.uRole}</td>
			<td>
				<a href="${pageContext.request.contextPath}/updateUser/${user.uEmail}">
				<i class="icon-pencil"></i>
				</a>
			</td>
			<td>
				<a href="${pageContext.request.contextPath}/removeUser/${user.uEmail}" role="button" data-toggle="modal">
				<i class="icon-remove"></i>
				</a>
			</td>
 			</tr>
		</c:forEach>
   
      </table>
      
	</div>
 </body>
</html>