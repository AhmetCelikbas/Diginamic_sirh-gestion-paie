<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
 
<%@include file="../../header.jsp" %>

<div class="container">


	<h1><a class="btn btn-primary" href="<%=request.getContextPath()%>/mvc/bulletins/lister"><i class="fa fa-arrow-left" aria-hidden="true"></i></a> • Bulletin de salaire</h1>
	<br />
	<br /><br />
	
	<div style="float:right;">
		<h5>Période</h5>
		Du ${bulletin.periode.dateDebut} au ${bulletin.periode.dateFin}
	</div>
	
	<br /><br />
	
	<h5>Entreprise</h5>
	${bulletin.remunerationEmploye.entreprise.denomination}<br />
	SIRET : ${bulletin.remunerationEmploye.entreprise.siret}
	
	<br /><br />
	
	<h5 style="float:right;margin-right:50px;">Matricule : ${bulletin.remunerationEmploye.matricule}</h5>
	
	<br /><br />
	
	<h4>Salaire</h4>
   	<table class="table table-striped table-bordered">
	    <thead>
	      <tr>
	        <th>Rubrique</th>
	        <th>Base</th>
	        <th>Taux Salarial</th>
	        <th>Montant Salarial</th>
	        <th>Taux patronal</th>
	        <th>Cot. patronales</th>
	      </tr>
	    </thead>
	    <tbody>
	    		<tr>
				<td>Salaire de base</td>
				<td>${bulletin.remunerationEmploye.grade.nbHeuresBase}</td>
				<td>${bulletin.remunerationEmploye.grade.tauxBase}</td>
				<td>${bulletin.remunerationEmploye.grade.nbHeuresBase*bulletin.remunerationEmploye.grade.tauxBase}</td>
				<td></td>
				<td></td>
			</tr>
			
			<tr>
				<td>Prime except.</td>
				<td></td>
				<td></td>
				<td>${bulletin.primeExceptionnelle}</td>
				<td></td>
				<td></td>
			</tr>
			
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			
			<tr>
				<td>Salaire brut</td>
				<td></td>
				<td></td>
				<td>${bulletin.remunerationEmploye.grade.nbHeuresBase*bulletin.remunerationEmploye.grade.tauxBase+bulletin.primeExceptionnelle}</td>
				<td></td>
				<td></td>
			</tr>
	    </tbody>
 	</table>
 	
 	<br /><br />
 	
	<h4>Cotisations</h4>
   	<table class="table table-striped table-bordered">
	    <thead>
	      <tr>
	        <th>Rubrique</th>
	        <th>Base</th>
	        <th>Taux Salarial</th>
	        <th>Montant Salarial</th>
	        <th>Taux patronal</th>
	        <th>Cot. patronales</th>
	      </tr>
	    </thead>
	    <tbody>
	    		<c:forEach var="cotisationNonImposable" items="${bulletin.remunerationEmploye.profilRemuneration.cotisationsNonImposables}">
				<tr>
					<td>${cotisationNonImposable.code} ${cotisationNonImposable.libelle}</td>
					<td>${bulletin.remunerationEmploye.grade.nbHeuresBase*bulletin.remunerationEmploye.grade.tauxBase}</td>
					<td>${cotisationNonImposable.tauxSalarial}</td>
					<td>${bulletin.remunerationEmploye.grade.nbHeuresBase*bulletin.remunerationEmploye.grade.tauxBase*cotisationNonImposable.tauxSalarial}</td>
					<td>${cotisationNonImposable.tauxPatronal}</td>
					<td>${bulletin.remunerationEmploye.grade.nbHeuresBase*bulletin.remunerationEmploye.grade.tauxBase*cotisationNonImposable.tauxPatronal}</td>
				</tr>
			</c:forEach>
	    		<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
	    		<tr>
				<td><b>Total retenue</b></td>
				<td></td>
				<td></td>
				<td>${bulletin.resultatCalculRemuneration.totalRetenueSalarial}</td>
				<td></td>
				<td>${bulletin.resultatCalculRemuneration.totalCotisationsPatronales}</td>
			</tr>
	    		
	    </tbody>
 	</table>
 	
 	<br /><br />
 	
 	<h4>NET Imposable : ${bulletin.resultatCalculRemuneration.netImposable} €</h4>
   	<table class="table table-striped table-bordered">
	    <thead>
	      <tr>
	        <th>Rubrique</th>
	        <th>Base</th>
	        <th>Taux Salarial</th>
	        <th>Montant Salarial</th>
	        <th>Taux patronal</th>
	        <th>Cot. patronales</th>
	      </tr>
	    </thead>
	    <tbody>
	    		<c:forEach var="cotisationImposable" items="${bulletin.remunerationEmploye.profilRemuneration.cotisationsImposables}">
				<tr>
					<td>${cotisationImposable.code} ${cotisationImposable.libelle}</td>
					<td>${bulletin.remunerationEmploye.grade.nbHeuresBase*bulletin.remunerationEmploye.grade.tauxBase}</td>
					<td>${cotisationImposable.tauxSalarial}</td>
					<td>${bulletin.remunerationEmploye.grade.nbHeuresBase*bulletin.remunerationEmploye.grade.tauxBase*cotisationImposable.tauxSalarial}</td>
					<td>${cotisationImposable.tauxPatronal}</td>
					<td>${bulletin.remunerationEmploye.grade.nbHeuresBase*bulletin.remunerationEmploye.grade.tauxBase*cotisationImposable.tauxPatronal}</td>
				</tr>
			</c:forEach>	    		
	    </tbody>
 	</table>
 	
 	<br /><br />
 	
 	<h4 style="float:right;">NET A PAYER : ${bulletin.resultatCalculRemuneration.netAPayer} €</h4>
 	<br /><br />
 	<br /><br />
</div>

<%@include file="../../footer.jsp" %>