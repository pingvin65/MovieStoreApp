<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<%
        request.getSession().removeAttribute("moviesDel");
%>
<c:choose>
	<c:when test="${not empty listCustomerFavMovies}">
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

				<c:forEach items="${listCustomerFavMovies}" var="name">
					<tr>
						<th scope="row">1</th>
						<td>${name.moviesID}</td>
						<td>${name.title}</td>
						<td>${name.runtime}</td>
						<td>${name.score}</td>
						<td align="right">
							<a type="button" class="btn btn-light movie-price2" role="button" href="<%=request.getContextPath()%>/remove/list/${name.moviesID}">
								- </a>
							<a type="button"
								class="float-rightw btn btn-light movie-price" role="button" href="<%=request.getContextPath()%>/purchase/movie/${name.moviesID}">
								<img
									src="<%=request.getContextPath()%>/images/icons8-shopping-cart-80.png"
									width="auto" height="22" class="d-inline-block align-top"
									alt="">$ ${name.price} 
							</a>
						</td>

					</tr>
				</c:forEach>


			</tbody>
		</table>
	</c:when>
	<c:when test="${ empty listCustomerFavMovies}">
	<h4>Your list is empty. </h4>
	</c:when>
</c:choose>