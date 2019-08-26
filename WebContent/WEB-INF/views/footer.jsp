
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp"%>

<%@ include file="links.jsp"%>

<%@ page import="java.util.Date" session="true"%>

<!-- Footer -->
<div class="jumbotron p-0">

	<footer class="page-footer  ">
		<div class="container-fluid text-center text-md-left">
			<div class="row">

				<!-- Left Grid column -->
				<div class="col-md-6 mt-md-0 mt-3">

					<div>

						<c:set var="scheme" value="${pageContext.request.scheme}" />
						<c:set var="serverPort" value="${pageContext.request.serverPort}" />
						<c:set var="port" value=":${serverPort}" />

						<c:if test="${not empty sUser.uEmail}">

							<br> LoginStaus >> sUser: ${sUser.uFirstName} ${sUser.uLastName} | ${sUser.uEmail} 
						<br> Session ID:  <%=session.getId()%>
							<br> ${session.getID() }
							</c:if>

						<br> Session created at
						<%=new Date(session.getCreationTime())%>

						<br> Last time of activity
						<%=new Date(session.getLastAccessedTime())%>

<%-- 						<br> myURL: ${myUrl } 
						<br> baseURL:
						${scheme}://${pageContext.request.serverName}${port}; 
--%>

					</div>
				</div>

				<!-- Middle Grid column -->
				<hr class="clearfix w-100 d-md-none pb-3">
				<!-- Grid column -->
				<div class="col-md-3 mb-md-0 mb-3">

					<!-- Links -->
					<h5 class="text-uppercase">Links</h5>

					<ul class="list-unstyled">
						<li><a href="#">Home</a></li>
						<li><a href="#">About Us</a></li>
					</ul>

				</div>

				<!-- Right Grid column -->

				<!-- Grid column -->
				<div class="col-md-3 mb-md-0 mb-3">

					<h5 class="text-uppercase">Links</h5>
					<ul class="list-unstyled">
						<li><a href="http://lenaparkcdc.org/ourevents/fair-foods/">Lena
								Park: Fair Food</a></li>
					</ul>

				</div>
				<!-- Grid column -->

			</div>
			<!-- Grid row -->

		</div>

		<!-- Copyright -->
		<div
			class="footer-copyright text-center special-color-dark font-small blue pt-4">
			Boston Java Web Developer - UseCase Project <br>© 2019
			Copyright: <a
				href="https://www.platformbyps.org/boston/java-developer">
				Platform By PerScholas Boston</a>
		</div>
		<!-- Copyright -->

	</footer>
	<!-- Footer -->
</div>