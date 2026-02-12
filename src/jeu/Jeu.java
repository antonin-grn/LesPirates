package jeu;

public class Jeu {
	private Joueur joueur1;
	private Joueur joueur2;
	private Joueur gagnant;
	private Affichage journal;
	private Plateau plateau;
	
	public Jeu (Joueur joueur1, Joueur joueur2, Affichage journal, Plateau plateau) {
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.journal = journal;
		this.plateau = plateau;
	}
	
	public void commencerJeu(){
		Pion pion1 = new Pion(Couleur.BLEU);
		Pion pion2 = new Pion(Couleur.ROUGE);
		
		Joueur joueur1 = new Joueur(pion1);
		Joueur joueur2 = new Joueur(pion2);
		
		journal.annonceDebutJeu();
		
		while (!verifierFinJeu()) {
			debutTour(joueur1);
			debutTour(joueur2);
		}
		
		journal.annonceGagnant(gagnant);
	}
	
	
	public void debutTour(Joueur joueur) {
		journal.annonceDebutTour(joueur);
		int deplacement = plateau.lancerDes();
		journal.annonceDeplacement(joueur, joueur.getPion(), deplacement);
		joueur.deplacerPion(deplacement);
		journal.annonceArriverCase(joueur.getPion(), joueur.getPion().getCaseActuelle());	
		}
	
	public boolean verifierFinJeu(){
		Pion pion1 = joueur1.getPion();
		Pion pion2 = joueur2.getPion();
		
		Case casePion1 = pion1.getCaseActuelle();
		Case casePion2 = pion2.getCaseActuelle();
		
		if (casePion1.getNumero() == 29) {
			gagnant = joueur1;
		}
		else if (casePion2.getNumero() == 29) {
			gagnant = joueur2;
		}
		
		return (casePion1.getNumero() == 29 || casePion2.getNumero() == 29);
	}
}
