package jeu;

public class Joueur {
	private int coeurs = 5;
	private Pion pion;
	private De de1;
	private De de2;
	private Effets effet = null;
	
	public Joueur(Pion pion) {
		this.pion = pion;
	}
	
	public void setEffet(Effets effet) {
		this.effet = effet;
	}
	
	public void deplacerPion(int nbCases) {
		int caseActuelle = pion.getCaseActuelle();
		pion.setCaseActuelle(caseActuelle + nbCases);
	}
	
	public void boireRhum() {
		if (coeurs < 5) {
			coeurs ++;
		}
		int resultat = lancerDes();
		deplacerPion(-resultat);
	}
	
	public void pactiser() {
		if (coeurs > 0) {
			coeurs --;
		}
		De de3 = new De(6);
		int resultat = lancerDes() + de3.lancerDe();
		deplacerPion(resultat);
	}
	
	public int lancerDes() {
		return de1.lancerDe() + de2.lancerDe();
	}
	
	public Pion getPion() {
		return pion;
	}
	
	public Effets getEffet() {
		return effet;
	}
	
	
	
}
