<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
<c:forEach items="${moviekeys}" var="namebeans">
<c:set var="evenCount" value="${evenCount+1}" />
<c:choose>
    <c:when test="${evenCount=='1'}">
 	<div class="col-sm-8">
		<div class="card">
			<div class="card-body">
				<h5 class="card-title">${namebeans.title}</h5>
				<p class="card-text">${namebeans.description}
					</p>${namebeans.mediaPath} 
					
				<a href="<%=request.getContextPath()%>/article/movie/${namebeans.moviesID}" class="btn btn-primary">more ...</a>
			</div>
		</div>
	</div>
    </c:when>    
    <c:otherwise>
	<div class="col-sm-4">
		<div class="card">
			<div class="card-body">
				<h5 class="card-title">${namebeans.title}</h5>
				<p class="card-text">${namebeans.description}</p>
				${namebeans.mediaPath}  
				<a href="<%=request.getContextPath()%>/article/movie/${namebeans.moviesID}" class="btn btn-primary">more ...</a>
			</div>
		</div>
	</div>
    </c:otherwise>
</c:choose>

	
</c:forEach>
</div>
 
      <div class="row mb-2">
        <div class="col-md-8">
          <div class="card flex-md-row mb-4 shadow-sm h-md-280">
            <div class="card-body d-flex flex-column align-items-start">
              <strong class="d-inline-block mb-2 text-primary">World</strong>
              <h3 class="mb-0">
                <a class="text-dark" href="#">Featured post</a>
              </h3>
              <div class="mb-1 text-muted">Nov 12</div>
              <p class="card-text mb-auto">This is a wider card with supporting text below as a natural lead-in to additional content.</p>
              <a href="#">Continue reading</a>
            </div>
            <img class="card-img-right flex-auto d-none d-lg-block" data-src="holder.js/200x250?theme=thumb" alt="Card image cap">
          </div>
        </div>
        <div class="col-md-4">
          <div class="card flex-md-row mb-4 shadow-sm h-md-280">
            <div class="card-body d-flex flex-column align-items-start">
              <strong class="d-inline-block mb-2 text-success">Design</strong>
              <h3 class="mb-0">
                <a class="text-dark" href="#">Post title</a>
              </h3>
              <div class="mb-1 text-muted">Nov 11</div>
              <p class="card-text mb-auto">This is a wider card with supporting text below as a natural lead-in to additional content.</p>
              <a href="#">Continue reading</a>
            </div>
            <img class="card-img-right flex-auto d-none d-lg-block" data-src="holder.js/200x250?theme=thumb" alt="Card image cap">
          </div>
        </div>
      </div>

<h1>Hello world! fgfgfg</h1>
http://localhost:8080/MovieStoreApp/article/movie/6
<P>The time on the server is ${serverTime}.</P>

<a href="<%=request.getContextPath() + "/article/movie/1"%>"
	class="btn btn-light logbutton" role="button">Mission: Impossible -
	Fallout</a>



