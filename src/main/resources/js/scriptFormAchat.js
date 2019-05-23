function setMaxAnnee() {
	var inputAnneeNaissance = document.getElementById("anneeNaissance");
	var anneeActuelle = parseInt(new Date().getFullYear(), 10);

	inputAnneeNaissance.setAttribute('max', anneeActuelle); 
}
