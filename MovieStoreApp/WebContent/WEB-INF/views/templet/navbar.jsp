<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String name = (String) session.getAttribute("sessname");
%>
<%
	String userlogin = (String) session.getAttribute("userlogin");
	String fname = (String) session.getAttribute("fname");
	String cusiden = (String) session.getAttribute("cusiden");
%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark bg-dark-movie">
	<div class="container">
		<a class="navbar-brand" href="<%=request.getContextPath()%>"> <img
			src="<%=request.getContextPath()%>/images/logo.svg" width="auto"
			height="30" class="d-inline-block align-top" alt=""> MS
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
			<!--form class="form-inline my-2 my-md-0">
                    <input class="form-control" type="text" placeholder="Search" aria-label="Search">
                </form-->
			<c:if
				test="${userlogin == 'login'  || session.getValue('userlog') == 'login'}">
				<!--  ul class="navbar-nav ml-auto">
					<li class="nav-item"><a
						href="<%=request.getContextPath() + "/logout"%>"
						class="btn btn-light logbutton" role="button">Logout</a></li>
				</ul-->
				<ul class="navbar-nav ml-auto">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> Hello. <%=fname%>
					</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item"
								href="<%=request.getContextPath() + "/article/customer/" + cusiden%>">favorite movies</a>
								<a class="dropdown-item"
								href="<%=request.getContextPath() + "/purchase/movie"%>">My chart</a>
							<a class="dropdown-item"
								href="<%=request.getContextPath() + "/logout"%>">Logout</a>
						</div></li>
				</ul>
			</c:if>
			<c:if
				test="${userlogin == 'logout'  || session.getValue('userlog') == 'logout'}">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> Hello. Sign in </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item"
								href="<%=request.getContextPath() + "/login"%>">Login</a> <a
								class="dropdown-item"
								href="<%=request.getContextPath() + "/register"%>">Register
							</a>
						</div></li>
				</ul>

			</c:if>
		</div>
	</div>
</nav>