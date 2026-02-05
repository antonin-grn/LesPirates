package jeu;

public class Jeu {
	private Joueur joueur1;
	private Joueur joueur2;
	private Narrateur narrateur;
	private Plateau plateau;
	
	public Jeu (Joueur joueur1, Joueur joueur2, Narrateur narrateur, Plateau plateau) {
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.narrateur = narrateur;
		this.plateau = plateau;
	}
	
}
