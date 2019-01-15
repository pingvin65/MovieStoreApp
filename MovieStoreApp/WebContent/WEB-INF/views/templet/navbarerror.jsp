<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark bg-dark-movie">
	<div class="container">
		<a class="navbar-brand" href="<%=request.getContextPath()%>"> <img
			src="<%=request.getContextPath()%>/images/logo.svg"
			width="auto" height="30" class="d-inline-block align-top" alt="">
			MS
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExample07" aria-controls="navbarsExample07"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarsExample07">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="<%=request.getContextPath()%>">Home</a></li>
					<li class="nav-item active"><a class="nav-link"
					href="<%=request.getContextPath()%>/moviesByDate">New</a></li>
					<li class="nav-item active"><a class="nav-link"
					href="<%=request.getContextPath()%>/moviesByScore">By Score</a></li>
					
			
			</ul>


		</div>
	</div>
</nav>