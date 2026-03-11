package jeu;

public class Joueur {
	private int coeurs = 5;
	private Pion pion;
	private De de1;
	private De de2;
	private int lancerDe1;
	private int lancerDe2;
	private Effets effet = Effets.AUCUN;
	
	public Joueur(Pion pion) {
		this.pion = pion;
	}
	
	public void setEffet(Effets effet) {
		this.effet = effet;
	}
	
	public void setDes(De de1, De de2) {
		this.de1 = de1;
		this.de2 = de2;
	}
	
	public void deplacerPion(int nbCases) {
		int caseActuelle = pion.getCaseActuelle();
		
		if ((caseActuelle + nbCases) > 29) {
			int deplacement = 29 - caseActuelle;
			int resultat = nbCases - deplacement;
			pion.setCaseActuelle(29 - resultat);
		} else {
			pion.setCaseActuelle(caseActuelle + nbCases);
		}
		
	}
	
	public int boireRhum() {
		if (coeurs < 5) {
			coeurs ++;
		}
		int resultat = lancerDes();
		return -resultat;
	}
	
	public int pactiser() {
		if (coeurs > 0) {
			coeurs --;
		}
		De de3 = new De(6);
		int resultat = lancerDes() + de3.lancerDe();
		//System.out.println(resultat);
		return resultat;
	}
	
	public int lancerDes() {
		lancerDe1 = de1.lancerDe();
		lancerDe2 = de2.lancerDe();
		//System.out.println(lancerDe1);
		//System.out.println(lancerDe2);
		return lancerDe1 + lancerDe2;
	}
	
	public Pion getPion() {
		return pion;
	}
	
	public Effets getEffet() {
		return effet;
	}
	
	public int getCoeurs() {
		return coeurs;
	}
	
}
