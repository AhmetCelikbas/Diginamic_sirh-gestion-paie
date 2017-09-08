<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
 
<%@include file="../../header.jsp" %>

<div class="container">


	<h1><i class="fa fa-users" aria-hidden="true"></i> • Liste des employés</h1>
	<br />
	
	<a class="btn btn-primary btn-sm" href="<%=request.getContextPath()%>/mvc/employes/creer"><i class="fa fa-plus" aria-hidden="true"></i> Ajouter un employé</a>
	<br /><br />
   	<table class="table table-striped">
	    <thead>
	      <tr>
	        <th>Matricule</th>
	        <th>Entreprise</th>
	        <th>Profil</th>
	        <th>Grade</th>
	        
	      </tr>
	    </thead>
	    <tbody>
	    
	    		<c:forEach var="employe" items="${employes}">
				<tr>
					<td>${employe.matricule}</td>
					<td>${employe.entreprise.denomination}</td>
					<td>${employe.profilRemuneration.code}</td>
					<td>${employe.grade.code}</td>
				</tr>
			</c:forEach>
	    </tbody>
 	</table>
 	
 	
</div>

<%@include file="../../footer.jsp" %>