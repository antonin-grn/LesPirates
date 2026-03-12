package jeu;

public class Pion {
	private Couleur couleur;
	private int caseActuelle = 0;
	
	public Pion (Couleur couleur) {
		this.couleur = couleur;
	}
	
	public void setCaseActuelle(int caseActuelle) {
		if (caseActuelle < 1) {
	        this.caseActuelle = 0;
	    } else {
	        this.caseActuelle = caseActuelle;
	    }
	}
	
	public int getCaseActuelle() {
		return caseActuelle;
	}
	
	public Couleur getCouleur() {
		return couleur;
	}
	
	
}
