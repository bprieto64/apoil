package frontend.model;

public class Voiture {
	private Integer id;
	private String marque;
	private String modele;
	private double prix;
	private String couleur;
	private Integer anneeSortie;
	private boolean gps;
	private boolean climatisation;
	private String photo;
	private String description;
	private Integer quantiteRestante;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getId() {
		return id;
	}
	public String getMarque() {
		return marque;
	}
	public String getModele() {
		return modele;
	}
	public double getPrix() {
		return prix;
	}
	public String getCouleur() {
		return couleur;
	}
	public Integer getAnneeSortie() {
		return anneeSortie;
	}
	public boolean isGps() {
		return gps;
	}
	public boolean isClimatisation() {
		return climatisation;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public void setAnneeSortie(Integer anneeSortie) {
		this.anneeSortie = anneeSortie;
	}
	public void setGps(boolean gps) {
		this.gps = gps;
	}
	public void setClimatisation(boolean climatisation) {
		this.climatisation = climatisation;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Integer getQuantiteRestante() {
		return quantiteRestante;
	}
	public void setQuantiteRestante(Integer quantiteRestante) {
		this.quantiteRestante = quantiteRestante;
	}
	@Override
	public String toString() {
		return "Voiture [id=" + id + ", marque=" + marque + ", modele=" + modele + ", prix=" + prix + ", couleur="
				+ couleur + ", anneeSortie=" + anneeSortie + ", gps=" + gps + ", climatisation=" + climatisation
				+ ", photo=" + photo + ", description=" + description + "]";
	}	
}