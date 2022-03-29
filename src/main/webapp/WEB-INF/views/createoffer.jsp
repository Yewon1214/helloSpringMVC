<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" 
href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>

	<sf:form method="post" action="${pageContext.request.contextPath}/docreate" modelAttribute="offer">
		<table class="formtable">
			<tr>
				<td class="label">수강년도:</td>
				<td><sf:input class="control" type="text" path="year" /> <br/>
				<sf:errors class="error" path="year"/></td>
			</tr>
			<tr>
				<td class="label">학기:</td>
				<td><sf:input class="control" type="text" path="semester" /><br/>
				<sf:errors class="error" path="semester"/></td>
			</tr>
			<tr>
				<td class="label">교과목명:</td>
				<td><sf:input class="control" type="text" path="className" /><br/>
				<sf:errors class="error" path="className"/></td>
			</tr>
			<tr>
				<td class="label">교과구분:</td>
				<td><sf:input class="control" type="text" path="classification" /><br/>
				<sf:errors class="error" path="classification"/></td>
			</tr>
			<tr>
				<td class="label">담당교수:</td>
				<td><sf:input class="control" type="text" path="profName" /><br/>
				<sf:errors class="error" path="profName"/></td>
			</tr>
			<tr>
				<td class="label">학점:</td>
				<td><sf:input class="control" type="text" path="grade" /><br/>
				<sf:errors class="error" path="grade"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="새 제안" /></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>