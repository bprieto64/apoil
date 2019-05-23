package frontend.model;

public class Utilisateur {
	
	private int id;
	private String nom;
	private String prenom;
	private int anneeNaissance;
	private String adresse;
	private String ville;
	private String codePostal;
	
	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAnneeNaissance() {
		return anneeNaissance;
	}
	public String getAdresse() {
		return adresse;
	}
	public String getVille() {
		return ville;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setAnneeNaissance(int anneeNaissance) {
		this.anneeNaissance = anneeNaissance;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", anneeNaissance=" + anneeNaissance
				+ ", adresse=" + adresse + ", ville=" + ville + ", codePostal=" + codePostal + "]";
	}
}