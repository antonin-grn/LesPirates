package jeu;

public class Jeu {
	private Joueur joueur1;
	private Joueur joueur2;
	private Joueur gagnant;
	private Affichage journal;
	private Plateau plateau;
	
	public Jeu (Affichage journal) {
		this.journal = journal;
	}
	
	public void commencerJeu(){
		
		Pion pion1 = new Pion(Couleur.BLEU);
		Pion pion2 = new Pion(Couleur.ROUGE);
		
		joueur1 = new Joueur(pion1);
		joueur2 = new Joueur(pion2);
		
		De de1 = new De(6);
		De de2 = new De(6);
		
		plateau = new Plateau(de1, de2);
		
		journal.annonceDebutJeu();
		
		while (!verifierFinJeu()) {
			debutTour(joueur1);
			debutTour(joueur2);
		}
		
		journal.annonceGagnant(gagnant);
	}
	
	
	public void debutTour(Joueur joueur) {
		journal.annonceDebutTour(joueur);
		
		Effets effet = joueur.getEffet();
		switch(effet) {
		case Effets.RHUM:
			joueur.boireRhum();
		case Effets.PACTE:
			joueur.pactiser();
		}
		
		int deplacement = plateau.lancerDes();
		journal.annonceDeplacement(joueur, joueur.getPion(), deplacement);
		joueur.deplacerPion(deplacement);
		journal.annonceArriverCase(joueur.getPion(), joueur.getPion().getCaseActuelle());
		
		joueur.setEffet(plateau.getCases()[joueur.getPion().getCaseActuelle()]);	
		journal.annonceEffetCase(joueur.getPion().getCaseActuelle(), joueur.getEffet(), joueur);
		
		}
	
	public boolean verifierFinJeu(){
		Pion pion1 = joueur1.getPion();
		Pion pion2 = joueur2.getPion();
		
		int casePion1 = pion1.getCaseActuelle();
		int casePion2 = pion2.getCaseActuelle();
		
		if (casePion1 == 29) {
			gagnant = joueur1;
		}
		else if (casePion2 == 29) {
			gagnant = joueur2;
		}
		
		return (casePion1 == 29 || casePion2 == 29);
	}
}
