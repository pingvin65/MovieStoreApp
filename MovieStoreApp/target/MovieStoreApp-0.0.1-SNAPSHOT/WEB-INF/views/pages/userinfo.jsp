<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">

	<c:choose>
		<c:when test="${not empty createCustumer}">
			<div class="alert alert-success" role="alert">
				${createCustumer}</div>

		</c:when>
		<c:when test="${not empty createCustumererror}">
			<div class="alert alert-danger" role="alert">
			${createCustumererror }</div>

		</c:when>


	</c:choose>

</div>