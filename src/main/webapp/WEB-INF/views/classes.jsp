<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	th{
		background-color:yellowgreen;
	}
	td{
		text-align:center;
	}
</style>
</head>
<body>
<form>
		<table border="1">
			<tr>
				<th>년도</th>
				<th>학기</th>
				<th>교과목명</th>
				<th>교과구분</th>
				<th>담당교수</th>
				<th>학점</th>
			</tr>
			<c:forEach var="offer" items="${offers}">
				<tr>
					<td><c:out value="${offer.year}"></c:out></td>
					<td><c:out value="${offer.semester}"></c:out></td>
					<td><c:out value="${offer.className}"></c:out></td>
					<td><c:out value="${offer.classification}"></c:out></td>
					<td><c:out value="${offer.profName}"></c:out></td>
					<td><c:out value="${offer.grade}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>