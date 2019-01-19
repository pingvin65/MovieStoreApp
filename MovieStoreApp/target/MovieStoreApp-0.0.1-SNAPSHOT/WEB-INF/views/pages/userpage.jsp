<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="container">
	<div class="row justify-content-md-center">
		<div class="col col-lg-5 col-md-6 col-sm-8">
			<form action="<%=request.getContextPath()%>/userinfo_confirm" method="post" class="form-signin">
				<img class="mb-4"
					src="<%=request.getContextPath()%>/images/logo.svg"
					alt="" width="72" height="72">
				<h1 class="h3 mb-3 font-weight-normal">Please sign in Confirm</h1>
				<label for="inputEmail" class="sr-only">Email address</label> 
				<input type="email" id="inputEmail" class="form-control" placeholder="Email address" name="email" value="${email}" required autofocus> 
				<label for="inputPassword" class="sr-only">Password</label> 
				<input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" value="${password}" required>
				<div class="checkbox mb-3">
					<label> <input type="checkbox" value="remember-me">
						Remember me
					</label>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
					in</button>
				<p class="mt-5 mb-3 text-muted">&copy; 2017-${serverTime}</p>
			</form>
		</div>
	</div>
</div>