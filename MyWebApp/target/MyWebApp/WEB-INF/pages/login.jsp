<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<c:set var="context" value="${pageContext.request.contextPath}" />
		<script type="text/javascript" src="${context}/resources/scripts/bootstrap.js"></script> 
		<link href="${context}/resources/css/bootstrap/bootstrap.css" rel="stylesheet"> 
		<link href="${context}/resources/css/custom/login.css" rel="stylesheet">
		<title>Members Login</title>
	</head>
	<body>
		<div class="container">
		    <div class="row">
		        <div class="col-sm-6 col-md-4 col-md-offset-4">
		            <h1 class="text-center login-title">Sign in to continue to website</h1>
					<div class="account-wall">
		                <img class="profile-img" src="${context}/resources/images/LoginPhoto.jpg"
		                    alt="">
		                <%-- <form:form class="form-signin" action="${context}/login" method="POST" modelAttribute="loginBean"> --%>
		                <form class="form-signin" action="<c:url value='j_spring_security_check'/>" method="POST">
			                <input type="text" name="j_username" class="form-control" placeholder="Email"/>
			                <input type="password" name="j_password" class="form-control" placeholder="Password" />
			                <input type="submit" class="btn btn-lg btn-primary btn-block" type="submit" value="Sign in" />
			                <label class="checkbox pull-left">
			                    <input type="checkbox" value="remember-me">
			                    Remember me
			                </label>
			                <a href="#" class="pull-right need-help">Need help? </a><span class="clearfix"></span>
			                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		                </form>
		            </div>		            
		            <a href="#" class="text-center new-account">Create an account </a>
		        </div>
		    </div>
		</div>
	</body>
</html>