package jeu;

import java.util.Scanner;

public class Jeu {
	private Joueur joueur1;
	private Joueur joueur2;
	private Joueur gagnant;
	private Affichage journal;
	private Plateau plateau;
	private boolean mort;
	
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
		joueur1.setDes(de1, de2);
		joueur2.setDes(de1, de2);
		
		plateau.placerEffets();
		
		journal.annonceDebutJeu();
		
		Scanner scanner = new Scanner(System.in);
		
		while (!verifierFinJeu()) {
		    debutTour(joueur1);
		    if (!verifierFinJeu()) {
		    	journal.passerTourSuivant();
			    scanner.nextLine();
		    }

		    if (!verifierFinJeu()) {
		        debutTour(joueur2);
		        if (!verifierFinJeu()) {
			    	journal.passerTourSuivant();
				    scanner.nextLine();
			    }
		    }
		    
		}
		
		if (joueur1.estMort() == true) {
			journal.annonceMort(joueur1);
		} else if (joueur2.estMort()) {
			journal.annonceMort(joueur2);
		}
		
		journal.annonceGagnant(gagnant);
	}
	
	
	public void debutTour(Joueur joueur) {
		journal.annonceDebutTour(joueur);
		int deplacement;
		Effets effet = joueur.getEffet();
		
		switch(effet) {
		case Effets.RHUM:
			deplacement = joueur.boireRhum();
			break;
		case Effets.PACTE:
			deplacement = joueur.pactiser();
			break;
		default:
			deplacement = joueur.lancerDes();
			break;
		}
		
		journal.annonceResultatsDes(joueur, joueur.getEffet());
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
		
		if (joueur1.getCoeurs() <= 0) {
	        gagnant = joueur2;
	        return true;
	        
	    } else if (joueur2.getCoeurs() <= 0) {
	        gagnant = joueur1;
	        return true;
	        
	    }
		
		return (casePion1 == 29 || casePion2 == 29);
	}
	
}
