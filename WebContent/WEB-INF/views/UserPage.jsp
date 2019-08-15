<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ include file="taglib.jsp"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
        	<%@ include file="links.jsp"%>

</head>
<body>


<% String sessionName = "";
if(session.getAttribute("u") != null){
	sessionName = session.getAttribute("u").toString();
}
%>

<div class="request_container">

<h1>Name For Request</h1>
<h3>${user_name }</h3>
</div>


<div class="request_container">

<h1>Name From Session</h1>
<h3> 
<%= session.getAttribute("u") %>
</h3>
</div>
</body>
</html>