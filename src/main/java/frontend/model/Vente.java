package frontend.model;

public class Vente {

	private int id;
	private int anneeVente;
	private Utilisateur utilisateur;
	private Voiture voiture;
	private String moyenPaiement;
	
	
	public int getId() {
		return id;
	}
	public int getAnneeVente() {
		return anneeVente;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public Voiture getVoiture() {
		return voiture;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setAnneeVente(int anneeVente) {
		this.anneeVente = anneeVente;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
	public String getMoyenPaiement() {
		return moyenPaiement;
	}
	public void setMoyenPaiement(String moyenPaiement) {
		this.moyenPaiement = moyenPaiement;
	}
	@Override
	public String toString() {
		return "Vente [id=" + id + ", anneeVente=" + anneeVente + ", utilisateur=" + utilisateur.toString() + ", voiture="
				+ voiture.toString() + ", moyenPaiement=" + moyenPaiement + "]";
	}
}