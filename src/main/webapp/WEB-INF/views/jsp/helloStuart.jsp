<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page isELIgnored="false" %>

<html>
	<head>
		<script src="./js/jquery.core/jquery-1.8.0.min.js" type="text/javascript"></script>
		<script>
			$(document).ready(function(){
				alert("Hello Stuart");
			});
		</script>
	</head>
	<body>
		<form>
			<c:out value="${dynamicContent}" escapeXml="false" />
			<input type="submit" value="submitHtml" id="submitHtml" />
			<input type="submit" value="submitXml" id="submitXml" />
			<input type="submit" value="submitJson" id="submitJson" />
		</form>
	</body>
</html>
