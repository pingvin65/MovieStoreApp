<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<div class="row justify-content-md-center">
		<div class="col col-lg-5 col-md-6 col-sm-8">

			<c:if test="${not empty errorMessage}">
				<div class="alert alert-warning" role="alert">${errorMessage }
				</div>

			</c:if>
			<form action="<%=request.getContextPath()%>/login_confirm"
				method="post" class="form-signin">
				<div class="form-group">
				<img class="mb-4"
					src="<%=request.getContextPath()%>/images/logo.svg" alt=""
					width="72" height="72">
					
				<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
				</div>
				<div class="form-group">
				<label for="inputEmail">Email address</label> <input
					type="email" id="inputEmail" class="form-control"
					placeholder="Email address" name="email" aria-describedby="emailHelp" required autofocus>
					 <small
							id="emailHelp" class="form-text text-muted">We'll never
							share your email with anyone else.</small>
							</div>
							<div class="form-group">
				<label for="inputPassword">Password</label> <input
					type="password" id="inputPassword" class="form-control"
					name="password" placeholder="Password" required>
					</div>
				<div class="form-group">
					<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
						in</button>
				</div>
				<div class="form-group">
				<a class="nav-link"
					href="<%=request.getContextPath()%>">Go to Home Page</a>
				</div>
			

				<p class="mt-5 mb-3 text-muted">&copy; 2017-${serverTime}</p>
			</form>
		</div>
	</div>
</div>