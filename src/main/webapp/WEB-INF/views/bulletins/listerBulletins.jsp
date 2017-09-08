<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
 
<%@include file="../../header.jsp" %>

<div class="container">


	<h1><i class="fa fa-list-alt" aria-hidden="true"></i> • Liste des bulletins</h1>
	<br />
	
	<a class="btn btn-primary btn-sm" href="<%=request.getContextPath()%>/mvc/bulletins/creer"><i class="fa fa-plus" aria-hidden="true"></i> Ajouter un bulletin</a>
	<br /><br />
   	<table class="table table-striped">
	    <thead>
	      <tr>
	        <th>Date/heure création</th>
	        <th>Période</th>
	        <th>Matricule</th>
	        <th>Salaire brut</th>
	        <th>Net Imposable</th>
	        <th>Net A Payer</th>
	        <th></th>
	      </tr>
	    </thead>
	    <tbody>
	    
	    		<c:forEach var="bulletin" items="${bulletins}">
				<tr>
					<td>${bulletin.dateCreation}</td>
					<td>${bulletin.periode.dateDebut} - ${bulletin.periode.dateFin}</td>
					<td>${bulletin.remunerationEmploye.matricule}</td>
					<td>${bulletin.resultatCalculRemuneration.salaireBrut} €</td>
					<td>${bulletin.resultatCalculRemuneration.netImposable} €</td>
					<td>${bulletin.resultatCalculRemuneration.netAPayer} €</td>
					<td><a class="btn btn-primary btn-sm" href="<%=request.getContextPath()%>/mvc/bulletins/afficher/${bulletin.id}"><i class="fa fa-info-circle" aria-hidden="true"></i></a></td>
				</tr>
	      		
	      		
	      		
			</c:forEach>
	    </tbody>
 	</table>
 	
 	
</div>

<%@include file="../../footer.jsp" %>