<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
 
<%@include file="../../header.jsp" %>

<div class="container">

	<h1>Créer un bulletin</h1>
	<br />
	<form method="POST" action="<%=request.getContextPath()%>/mvc/bulletins/creer">
	  <div class="form-group">
	    <label for="periode">Période</label>
	    <select class="form-control" id="periode" name="periodeId" required>
	    		<c:forEach var="periode" items="${periodes}"> 
	      		<option value="${periode.id}">${periode.dateDebut} - ${periode.dateFin}</option>
			</c:forEach>
	    </select>
	  </div>
	  <div class="form-group">
	    <label for="matricule">Matricule</label>
	    <select class="form-control" id="matricule" name="employeId" required>
	      	<c:forEach var="employe" items="${employes}"> 
	      		<option value="${employe.id}">${employe.matricule}</option>
			</c:forEach>
	    </select>
	  </div>
	  <div class="form-group">
	    <label for="matricule">Prime exceptionnelle</label>
	    <input type="number" class="form-control" id="primeExceptionnelle" required value="0" name="primeExceptionnelle" placeholder="Prime exceptionnelle">
	  </div>
	  <button type="submit" class="btn btn-primary">Créer nouveau bulletin</button>
	</form>
	 
    
</div>

<%@include file="../../footer.jsp" %>