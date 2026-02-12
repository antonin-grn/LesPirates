package jeu;

public class Joueur {
	private int coeurs = 5;
	private Pion pion;
	
	public Joueur(Pion pion) {
		this.pion = pion;
	}
	
	public void perdreCoeur(int coeurs) {
		coeurs --;
	}
	
	public void deplacerPion(int nbCases) {
		Case caseActuelle = pion.getCaseActuelle();
		caseActuelle.setNumero(caseActuelle.getNumero() + nbCases);
	}
	
	public Pion getPion() {
		return pion;
	}
	
}
