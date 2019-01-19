<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="en_US" />
<c:if test="${not empty errorMessage}">
	<div class="alert alert-warning" role="alert">
		<c:out value="${errorMessage}" escapeXml="false" />
	</div>
</c:if>
<c:if test="${not empty addedMovie}">
	<div class="alert alert-success" role="alert">
		<c:out value="${addedMovie}" escapeXml="false" />
	</div>
</c:if>
<c:if test="${not empty moviesDel}">
	<div class="alert alert-success" role="alert">
		<c:out value="${moviesDel}" escapeXml="false" />
	</div>
</c:if>

<c:set var="evenCount" value="0" />
<c:set var="summovie" value="0" />
<c:choose>
	<c:when test="${not empty listCustomerPreMovies}">
		<table class="table table-striped table-sm">


			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">id movie</th>
					<th scope="col">Title</th>
					<th scope="col">Run time</th>
					<th scope="col">Score</th>
					<th scope="col" width="">Price</th>

				</tr>
			</thead>
			<tbody>

				<c:forEach items="${listCustomerPreMovies}" var="name">
					<c:set var="evenCount" value="${evenCount+1}" />
					<c:set var="summovie" value="${summovie+name.price}" />
					<tr>
						<th scope="row">${evenCount}</th>
						<td>${name.moviesID}</td>
						<td>${name.title}</td>
						<td>${name.runtime}</td>
						<td>${name.score}</td>
						<td align="right"><a type="button"
							class="btn btn-light movie-price2" role="button"
							href="<%=request.getContextPath()%>/purchase/remove/${name.consumerfmID}">
								- </a> <fmt:formatNumber value="${name.price}" type="currency" /></td>

					</tr>
				</c:forEach>
				<tr>

					<td colspan="5"></td>
					<td align="right"><a type="button"
						class="float-rightw btn btn-light movie-price" role="button"
						href="<%=request.getContextPath()%>/purchase/list/"> <img
							src="<%=request.getContextPath()%>/images/icons8-shopping-cart-80.png"
							width="auto" height="22" class="d-inline-block align-top" alt="">
							<fmt:formatNumber value="${summovie}" type="currency" />
					</a></td>
				</tr>

			</tbody>
		</table>
	</c:when>
	<c:when test="${empty listCustomerPreMovies}">
		<c:if test="${empty addedMovie}">
			<h4>Your list is empty.</h4>
		</c:if>
	</c:when>
</c:choose>
<%
	request.getSession().removeAttribute("moviesDel");
	request.getSession().removeAttribute("addedMovie");
%>
