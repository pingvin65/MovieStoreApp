<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<%@ page session="false"%>
    <footer class="footer">
        <div class="container navbar-dark bg-dark bg-dark-movie">
        <div class="row">
         <div class="col"><span class="text-muted2">&copy; Movie Store App</span></div>
          <div class="col text-right"> <span class="pull-right">Powered by <a href="https://spring.io/projects/spring-framework" rel="external" class="power">Spring Framework</a></span></div>
          </div>  
            
        </div>
    </footer>
	<script src="<%= request.getContextPath() %>/resources/js/jquery/jquery-3.3.1.min.js"></script>
	<script src="<%= request.getContextPath() %>/resources/js/popper.js-1.14.6/dist/umd/popper.js"></script>
    <script src="<%= request.getContextPath() %>/resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%= request.getContextPath() %>/resources/js/theme/plum.js"></script>
</body>
</html>