<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${not empty errorMessage}">
	<div class="alert alert-warning" role="alert">
		<c:out value="${errorMessage}" escapeXml="false" />
	</div>
</c:if>
<c:set var="evenCount" value="0" />
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
				<c:set var="evenCount" value="${evenCount+1}" />
					<tr>
						<th scope="row">${evenCount}</th>
						<td>${name.moviesID}</td>
						<td>${name.title}</td>
						<td>${name.runtime}</td>
						<td>${name.score}</td>
						<td align="right"><a type="button"
							class="btn btn-light movie-price2" role="button"> add to list</a>
							<a type="button" class="float-rightw btn btn-light movie-price"
							role="button"> <img
								src="<%=request.getContextPath()%>/images/icons8-shopping-cart-80.png"
								width="auto" height="22" class="d-inline-block align-top" alt="">$
								${name.price}
						</a></td>

					</tr>
				</c:forEach>


			</tbody>
		</table>
	</c:when>
</c:choose>