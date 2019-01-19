<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>

	<c:when test="${not empty moviekeys}">
		<div class="row">
			<c:set var="evenCount" value="0" />
			<c:if test="${not empty masagebody}">
				<div class="alert alert-success col-sm-12" role="alert">
					<h5>${masagebody}</h5>
				</div>

			</c:if>


			<c:forEach items="${moviekeys}" var="namebeans">
				<c:set var="evenCount" value="${evenCount+1}" />
				<c:choose>
					<c:when test="${evenCount=='1'}">
						<div class="col-sm-12 col-md-6">
							<div class="card border-0">

								<div class="card-body">
									<h5 class="card-title">
										<a
											href="<%=request.getContextPath()%>/article/movie/${namebeans.moviesID}">${namebeans.title}</a>
									</h5>

									<div class="col-md-auto">
										<span> <small>release date :</small> <b>${namebeans.releaseDate }</b>
										</span> <span class="float-right"> <img
											class="d-inline-block align-top" style="margin-right: 10px;"
											src="<%=request.getContextPath()%>/images/star.svg" alt=""
											width="24" height="24"><b>${namebeans.score }<small>/10</small></b>
										</span>
									</div>
									<img class="img-thumbnail" src="${namebeans.mediaPath}" />
									<p class="card-text">${namebeans.description}</p>

									<a
										href="<%=request.getContextPath()%>/article/movie/${namebeans.moviesID}"
										class="btn btn-primary">more ...</a>
								</div>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${evenCount>'2'}">
								<c:set var="row" value='4 mscol' />
							</c:when>
							<c:otherwise>
								<c:set var="row" value='6' />
							</c:otherwise>
						</c:choose>
						<div class="col-md-6 col-xl-4 col-sm-12">
							<div class="card border-0">
								<img class="card-img-top" src="${namebeans.mediaPath}" />
								<div class="card-body">
									<h5 class="card-title">
										<a
											href="<%=request.getContextPath()%>/article/movie/${namebeans.moviesID}">${namebeans.title}</a>
									</h5>
									<div class="col-md-auto">
										<span> <b>${namebeans.releaseDate }</b>
										</span> <span class="float-right"> <img
											class="d-inline-block align-top" style="margin-right: 10px;"
											src="<%=request.getContextPath()%>/images/star.svg" alt=""
											width="24" height="24"><b>${namebeans.score }<small>/10</small></b>
										</span>
									</div>
									<div>
										<p class="card-text">${namebeans.description}</p>
										<a
											href="<%=request.getContextPath()%>/article/movie/${namebeans.moviesID}"
											class="btn btn-primary">more ...</a>
									</div>
								</div>
							</div>
						</div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
	</c:when>
	<c:otherwise>

		<div class="alert alert-danger" role="alert">
			<h2>Sorry, something is wrong. Please try later.</h2>
		</div>
	</c:otherwise>
</c:choose>
