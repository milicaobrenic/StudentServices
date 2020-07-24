<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prijava ispita</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<div class="content">
		<form action="/Fakultet/skontroler/potvrdaPrijavaIspita" method="post">
			<div class="text">Izaberite predmete koje zelite da prijavite:</div><br><br>
			<ol type="1">
				<c:forEach items="${predmetiS }" var="ps">
				<label class="container2">${ps.naziv}
  					<input type="checkbox" name="cbox" value="${ps.idPredmet}">
  					<span class="checkmark"></span>
				</label>
<%-- 					<input type="checkbox" name="cbox" value="${ps.idPredmet}">${ps.naziv}<br> --%>
				</c:forEach>
			</ol>
			<input type="submit" value="Potvrdi"><br><br>
		</form>
		<div class="poruka">
			${porukaI}<br>
			${porukaG}
		</div>
	</div>
</body>
</html>