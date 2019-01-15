<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!--  %@ page trimDirectiveWhitespaces="true" % -->

<div class="card mscard">
	<div class="card-header">
		<div class="row">
			<div class="col">
				<h4>${movieskey.title }</h4>
			</div>
			<div class="col-md-auto">
				<c:forEach items="${genreskey}" var="name">
					<c:set var="evenCount" value="${evenCount+1}" />
					<c:if test="${evenCount !=1}">, </c:if>
					<b>${name.genres}</b>
				</c:forEach>
				<c:set var="evenCount" value="0" />
			</div>
			<div class="col-md-auto">
				<small>release date :</small> <b>${movieskey.releaseDate }</b>
			</div>
			<div class="col col-lg-2 text-right">
				<img class="d-inline-block align-top" style="margin-right: 10px;"
					src="<%=request.getContextPath()%>/images/star.svg" alt=""
					width="24" height="24"><b>${movieskey.score }<small>/10</small></b>
			</div>
		</div>
	</div>
	<div class="card-body row" id="moviecard">
		<div class="col-sm-5 col-xs-12">
			<c:choose>
				<c:when test="${not empty pictures}">
					<c:set var="evenCount" value="0" />
					<div id="carouselPicturesIndicators" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<c:forEach items="${pictures}" var="name">
								<c:choose>
									<c:when test="${evenCount == 0 }">
										<li data-target="#carouselPicturesIndicators"
											data-slide-to="${evenCount}" class="active"></li>
									</c:when>
									<c:otherwise>
										<li data-target="#carouselPicturesIndicators"
											data-slide-to="${evenCount}"></li>
									</c:otherwise>
								</c:choose>
								<c:set var="evenCount" value="${evenCount+1}" />
							</c:forEach>
						</ol>
						<c:set var="evenCount" value="0" />
						<div class="carousel-inner">
							<c:forEach items="${pictures}" var="name">
								<c:choose>
									<c:when test="${evenCount == 0 }">
										<div class="carousel-item active">
											<img class="d-block w-100" src="${name.mediaPath}" alt="">
										</div>
									</c:when>
									<c:otherwise>
										<div class="carousel-item">
											<img class="d-block w-100" src="${name.mediaPath}" alt="">
										</div>
									</c:otherwise>
								</c:choose>
								<c:set var="evenCount" value="${evenCount+1}" />
							</c:forEach>
						</div>
						<a class="carousel-control-prev"
							href="#carouselPicturesIndicators" role="button"
							data-slide="prev"> <span class="carousel-control-prev-icon"
							aria-hidden="true"></span> <span class="sr-only">Previous</span>
						</a> <a class="carousel-control-next"
							href="#carouselPicturesIndicators" role="button"
							data-slide="next"> <span class="carousel-control-next-icon"
							aria-hidden="true"></span> <span class="sr-only">Next</span>
						</a>
					</div>
				</c:when>
				<c:when test="${not empty picture}">
					<img class="col-sm-11" src="${picture.mediaPath}" alt="">
				</c:when>
				<c:otherwise>
        			var1 is NOT empty or null.
    		</c:otherwise>
			</c:choose>

		</div>
		<div class="col-sm-7 col-xs-12">
			<p class="card-text">${movieskey.description }</p>
			<p class="card-text">
				Director:
				<c:forEach items="${personRolesInMovieskey}" var="name">
					<c:if test="${name.roulesID == 1}">
						<c:set var="evenCount" value="${evenCount+1}" />

						<c:if test="${evenCount !=1}">, </c:if>
						${name.personFname}<%=" "%> ${name.personLname}

					</c:if>
				</c:forEach>
				<c:set var="evenCount" value="0" />
			</p>
			<p class="card-text">
				Writers:
				<c:forEach items="${personRolesInMovieskey}" var="name">
					<c:if test="${name.roulesID == 3}">
						<c:set var="evenCount" value="${evenCount+1}" />
						<c:if test="${evenCount !=1}">, </c:if>
						${name.personFname}<%=" "%> ${name.personLname}
					</c:if>
				</c:forEach>
				<c:set var="evenCount" value="0" />
			</p>

			<p class="card-text">
				Stars:
				<c:forEach items="${personRolesInMovieskey}" var="name">

					<c:if test="${name.roulesID == 2}">
						<c:set var="evenCount" value="${evenCount+1}" />
						<c:if test="${evenCount !=1}">, </c:if>
								${name.personFname}<%=" "%> ${name.personLname} ${name.personLname}
					</c:if>
				</c:forEach>
			</p>
		</div>
	</div>

	<div class="card-footer text-right">
		<c:if
			test="${userlogin == 'login'  || session.getValue('userlog') == 'login'}">
			<a type="button" class="btn btn-light movie-price2" role="button" href="<%=request.getContextPath()%>/add/list/${id}">
				add to list
			</a>
		</c:if>
		<a type="button" class="float-right btn btn-light movie-price" role="button" href="<%=request.getContextPath()%>/purchase/movie/${id}">
			<img
				src="<%=request.getContextPath()%>/images/icons8-shopping-cart-80.png"
				width="auto" height="30" class="d-inline-block align-top" alt="">$
			${movieskey.price }
		</a>
	</div>
</div>
