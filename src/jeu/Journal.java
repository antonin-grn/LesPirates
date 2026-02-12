package jeu;

public class Journal implements Affichage {
	private String nomJoueur1 = "Basile le tueur de Bulgare";
	private String nomJoueur2 = "Nicéphore la Mort Pâle des Sarrasins";
	

	@Override
	public void annonceDebutJeu() {
		System.out.println("Bienvenue dans le jeu des pirates ! Je suis le Maître du jeu et je vais vous guider durant toute la partie HAHAHA ! Dans ce jeu, vous allez devenir de vrai pirate impitoyable prêt à tout pour récupérer le trésor.");
	}

	@Override
	public void annonceDebutTour(Joueur joueur) {
		Pion pionActuel = joueur.getPion();
		
		if (pionActuel.getCouleur() == Couleur.BLEU) {
			System.out.println("C'est au tour de " + nomJoueur1 + " de lancer les dés.");
		}
		else {
			System.out.println("C'est au tour de " + nomJoueur2 + " de lancer les dés.");
		}
	}

	@Override
	public void annonceGagnant(Joueur joueur) {
		Pion pionActuel = joueur.getPion();
		
		if (pionActuel.getCouleur() == Couleur.BLEU) {
			System.out.println(nomJoueur1 + " a remporté le trésor HAHAHA ! Il a donc gagné la partie. GG WP");
		}
		else {
			System.out.println(nomJoueur2 + " a remporté le trésor HAHAHA ! Il a donc gagné la partie. GG WP");
		} 
	}

	@Override
	public void annonceDeplacement(Joueur joueur, Pion pion, int valeur) {
		Pion pionActuel = joueur.getPion();
		
		if (pionActuel.getCouleur() == Couleur.BLEU) {
			System.out.println(nomJoueur1 + " déplace le pion " + pion.getCouleur() + " de " + valeur + " cases.");
		}
		else {
			System.out.println(nomJoueur2 + " déplace le pion " + pion.getCouleur() + " de " + valeur + " cases.");
		} 
		
	}

	@Override
	public void annonceArriverCase(Pion pion, Case caseActuelle) {
		System.out.println("Le pion " + pion.getCouleur() + " est arrivé à la case " + caseActuelle + ".");
	}

	@Override
	public void annonceEffetCase(Case caseActuelle) {
		// TODO Auto-generated method stub
	}

	@Override
	public void annonceCoeursPerdus(Joueur joueur, int valeur) {
		// TODO Auto-generated method stub
	}
}
