<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true"%>
<%@ page session="false"%>
<jsp:include page="templet/headererror.jsp" />
<header>
<jsp:include page="templet/navbarerror.jsp" />
</header>
<div role="main" id="main" class="container movie-container">
	<jsp:include page="${pagebody}" />
</div>
<jsp:include page="templet/footererror.jsp" />
