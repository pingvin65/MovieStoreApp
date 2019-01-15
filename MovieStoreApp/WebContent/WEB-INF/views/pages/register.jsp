<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">

	<div class="row justify-content-md-center">
		<div class="col col-lg-7 col-md-6 col-sm-8">
			<div class="form-group">
				<img class="mb-4"
					src="<%=request.getContextPath()%>/images/logo.svg" alt=""
					width="72" height="72">

				<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
				<c:if test="${not empty userregistrited}">
					<div class="alert alert-warning" role="alert">${userregistrited }</div>

				</c:if>

			</div>
			<form:form method="POST" modelAttribute="userkey">
				<div class="form-group row">
					<label for="inputEmail3" class="col-sm-3 col-form-label">Email</label>
					<div class="col-sm-8">
						<form:input type="email" cssClass="form-control" id="inputEmail3"
							placeholder="Email" path="email" />
						<form:errors path="email" cssClass="errormsg invalid-feedback" />
						<c:if test="${not empty emailvaliderror}">
							<span class="errormsg invalid-feedback">${emailvaliderror}</span>
						</c:if>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-3 col-form-label">Password</label>
					<div class="col-sm-8">
						<form:input type="password" cssClass="form-control"
							id="inputPassword3" placeholder="Password" path="password" />
						<form:errors path="password" cssClass="errormsg invalid-feedback" />
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPasswordrep3" class="col-sm-3 col-form-label">Confirm
						Password</label>
					<div class="col-sm-8">
						<form:input type="password" cssClass="form-control"
							id="inputPasswordrep3" placeholder="Password" path="password2" />
						<c:if test="${not empty password2error}">
							<span class="errormsg invalid-feedback">${password2error}</span>
						</c:if>

					</div>
				</div>

				<div class="form-group row">
					<label for="inputFirstName" class="col-sm-3 col-form-label">First
						name</label>
					<div class="col-sm-8">
						<form:input type="text" cssClass="form-control"
							id="inputFirstName" placeholder="First name" path="frstName" />
						<form:errors path="frstName" cssClass="errormsg invalid-feedback" />
					</div>
				</div>
				<div class="form-group row">
					<label for="lastName" class="col-sm-3 col-form-label">Last
						name</label>
					<div class="col-sm-8">
						<form:input type="text" cssClass="form-control" id="lastName"
							placeholder="Last name" path="lastName" />
						<form:errors path="lastName" cssClass="errormsg invalid-feedback" />
					</div>
				</div>
				<div class="form-group row">
					<div class="col-sm-10">
						<button type="submit" class="btn btn-primary">Sign in</button>
					</div>
				</div>

			</form:form>
			<div class="form-group">
				<a class="nav-link" href="<%=request.getContextPath()%>">Go to
					Home Page</a>
			</div>
		</div>
	</div>

</div>