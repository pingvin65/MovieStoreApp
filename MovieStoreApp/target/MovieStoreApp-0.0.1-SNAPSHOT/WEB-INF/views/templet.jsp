<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true"%>
<%
String email = request.getParameter( "email" );
session.setAttribute( "email", email );
String name = request.getParameter( "password" );
session.setAttribute( "password", name );
%>
<jsp:include page="templet/header.jsp" />
<header>
<jsp:include page="templet/navbar.jsp" />
</header>
<div role="main" id="main" class="container movie-container">
	<jsp:include page="${pagebody}" />
</div>
<jsp:include page="templet/footer.jsp" />
