package jeu;

public class Joueur {
	private String nom;
	private int coeurs = 5;
	private Pion pion;
	
	public Joueur(String nom, Pion pion) {
		this.nom = nom;
		this.pion = pion;
	}
	
	public void perdreCoeur(int coeurs) {
		coeurs --;
	}
	
	public void deplacerPion(int nbCases) {
		
	}
}
