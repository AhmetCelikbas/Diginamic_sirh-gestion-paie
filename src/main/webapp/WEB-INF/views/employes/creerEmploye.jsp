<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
 
<%@include file="../../header.jsp" %>

<div class="container">

	<h1>Créer un employé</h1>
	<br />
	<form method="POST" action="<%=request.getContextPath()%>/mvc/employes/creer">
	  <div class="form-group">
	    <label for="matricule">Matricule</label>
	    <input type=text class="form-control" id="matricule" required name="matricule" placeholder="Matricule de l'employé">
	  </div>
	  <div class="form-group">
	    <label for="entreprise">Entreprise</label>
	    <select class="form-control" id="entreprise" name="entrepriseId" required>
	    		<c:forEach var="entreprise" items="${entreprises}"> 
	      		<option value="${entreprise.id}">${entreprise.denomination}</option>
			</c:forEach>
	    </select>
	  </div>
	  <div class="form-group">
	    <label for="profil">Profil</label>
	    <select class="form-control" id="profil" name="profilId" required>
	      	<c:forEach var="profilRemuneration" items="${profilsRemuneration}"> 
	      		<option value="${profilRemuneration.id}">${profilRemuneration.code}</option>
			</c:forEach>
	    </select>
	  </div>
	  <div class="form-group">
	    <label for="grade">Grade</label>
	    <select class="form-control" id="grade" name="gradeId" required>
	    		<c:forEach var="grade" items="${grades}"> 
	      		<option value="${grade.id}">${grade.code} - ${grade.nbHeuresBase*grade.tauxBase*12 } €</option>
			</c:forEach>
	    </select>
	  </div>	
	  <button type="submit" class="btn btn-primary">Créer nouvel employé</button>
	</form>
	 
    
</div>

<%@include file="../../footer.jsp" %>