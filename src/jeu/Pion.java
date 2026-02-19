package jeu;

public class Pion {
	private Couleur couleur;
	private int caseActuelle = 0;
	
	public Pion (Couleur couleur) {
		this.couleur = couleur;
	}
	
	public void setCaseActuelle(int caseActuelle) {
		this.caseActuelle = caseActuelle;
	}
	
	public int getCaseActuelle() {
		return caseActuelle;
	}
	
	public Couleur getCouleur() {
		return couleur;
	}
	
	
}
