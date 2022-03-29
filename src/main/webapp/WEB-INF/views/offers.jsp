<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	width: 320px;
	border: 1px solid;
}

td {
	text-align: center;
	width: 80px;
}

th {
	background-color: yellowgreen;
}
</style>
</head>
<body>
	<table border="1">
		<tr>
			<th>년도</th>
			<th>학기</th>
			<th>취득 학점</th>
			<th>상세보기</th>
		</tr>
		<c:forEach var="offer" items="${offers}">
			<form method="get"
				action="${pageContext.request.contextPath}/classes">
			<tr>
				<td><c:out value="${offer.year}"></c:out></td>
				<td><c:out value="${offer.semester}"></c:out></td>
				<td><c:out value="${offer.gradesum}"></c:out></td>
				<td><input type="hidden" name="year" value="${offer.year}" />
					<input type="hidden" name="semester" value="${offer.semester}" />
					<input type="submit" value="링크"></td>
			</tr>
			</form>
		</c:forEach>
		<tr>
			<th>총계</th>
			<th></th>
			<th><c:out value="${total}"></c:out></th>
			<th></th>
		</tr>
	</table>
</body>
</html>