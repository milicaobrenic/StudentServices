<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Studentska sluzba</title>
</head>
<body>
	<%@ include file="header.jsp" %>

	<div class="container py-5">
		<form class="text-center p-5" action="/Fakultet/lkontroler/register" method="post">
		
		    <h2 class="mb-3 display-4 text-center">Napravite nalog</h2>
		
		    <div class="form-row mb-4">
		        <div class="col">
		            <!-- First name -->
		            <input type="text" name="ime" id="id" class="form-control" placeholder="First name">
		        </div>
		        <div class="col">
		            <!-- Last name -->
		            <input type="text" name="prezime" id="id" class="form-control" placeholder="Last name">
		        </div>
		    </div>
		
		    <!-- E-mail -->
		    <input type="text" name="korisnickoIme" id="id" class="form-control mb-4" placeholder="Username">
		
		    <!-- Password -->
		    <input type="password" name="lozinka" id="id" class="form-control" placeholder="Password" aria-describedby="defaultRegisterFormPasswordHelpBlock">
		  
		    <!-- Sign up button -->
		   <input type = "submit" class="btn btn-primary" value="Registruj se">
			<br><br>
			<c:if test="${! empty k }">
			<div class="poruka">
				Novi korisnik je dodat. ID >> ${k.idKorisnik }
			</div>
			
			</c:if>
		</form>
	</div>
</body>
</html>