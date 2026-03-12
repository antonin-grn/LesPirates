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
			System.out.println(" ");
			System.out.println("C'est au tour de " + nomJoueur1 + " (" + joueur.getCoeurs() +" coeurs) de lancer les dés.");
		}
		else {
			System.out.println(" ");
			System.out.println("C'est au tour de " + nomJoueur2 + " (" + joueur.getCoeurs() +" coeurs) de lancer les dés.");
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
	public void annonceArriverCase(Pion pion, int caseActuelle) {
		System.out.println("Le pion " + pion.getCouleur() + " est arrivé à la case " + (caseActuelle + 1) + ".");
	}

	@Override
	public void annonceEffetCase(int caseActuelle, Effets effetCase, Joueur joueur) {
		Pion pionActuel = joueur.getPion();
		
		switch (effetCase) {
		case Effets.RHUM: {
			if (joueur.getCoeurs() < 5) {
				if (pionActuel.getCouleur() == Couleur.BLEU) {
					System.out.println(nomJoueur1 + " s'est enquillé un flash. Il a récupéré 1 coeur mais il reculera de la valeur de ses dés au prochain tour.");
				}
				else {
					System.out.println(nomJoueur2 + " s'est enquillé un flash. Il a récupéré 1 coeur mais il reculera de la valeur de ses dés au prochain tour.");
				}
			}
			else if (pionActuel.getCouleur() == Couleur.BLEU) {
				System.out.println(nomJoueur1 + " s'est enquillé un flash. Il reculera de la valeur de ses dés au prochain tour. Il ne peut pas récupérer un coeur supplémentaire car il en possède déjà 5.");
			}
			else {
				System.out.println(nomJoueur2 + " s'est enquillé un flash. Il reculera de la valeur de ses dés au prochain tour. Il ne peut pas récupérer un coeur supplémentaire car il en possède déjà 5.");
			}
			break;
		}
		
		case Effets.PACTE: {		
			if (pionActuel.getCouleur() == Couleur.BLEU) {
				System.out.println(nomJoueur1 + " A DECIDE DE PACTER AVEC BAALBERITH. Ce pacte lui permet de lancer un dé supplémentaire au prochain tour.");
				annonceCoeursPerdus(joueur, 2);
			}
			else {
				System.out.println(nomJoueur2 + " A DECIDE DE PACTER AVEC BAALBERITH. Ce pacte lui permet de lancer un dé supplémentaire au prochain tour.");
				annonceCoeursPerdus(joueur, 2);
			}
			break;
		}
		
		default:
			break;
		}
	}

	@Override
	public void annonceCoeursPerdus(Joueur joueur, int valeur) {
		Pion pionActuel = joueur.getPion();
		
		if (pionActuel.getCouleur() == Couleur.BLEU) {
			System.out.println(nomJoueur1 + " a perdu " + valeur + " coeur(s).");
		}
		else {
			System.out.println(nomJoueur2 + " a perdu " + valeur + " coeur(s).");
		}
	}
	
	@Override
	public void annonceMort(Joueur joueur) {
		Pion pionActuel = joueur.getPion();
		
		if (pionActuel.getCouleur() == Couleur.BLEU) {
			System.out.println(nomJoueur1 + " est mort d'attroce souffrance car il n'était pas assez puissant pour supporter tous les PACTES !");
		}
		else {
			System.out.println(nomJoueur2 + " est mort d'attroce souffrance car il n'était pas assez puissant pour supporter tous les PACTES !");
		}
		
	}
	
	@Override
	public void annonceResultatsDes(Joueur joueur, Effets effetCase) {
		Pion pionActuel = joueur.getPion();
		
		if (effetCase != Effets.PACTE) {
			if (pionActuel.getCouleur() == Couleur.BLEU) {
				System.out.println(nomJoueur1 + " lance les dés et obtient " + joueur.getLancerDe1() + " et " + joueur.getLancerDe2() + ".");
			}
			else {
				System.out.println(nomJoueur2 + " lance les dés et obtient " + joueur.getLancerDe1() + " et " + joueur.getLancerDe2() + ".");
			}
		}
		else if (pionActuel.getCouleur() == Couleur.BLEU) {
				System.out.println(nomJoueur1 + " lance les dés et obtient " + joueur.getLancerDe1() + ", " + joueur.getLancerDe2() + " et " + joueur.getLancerDe3() + ".");
			}
			else {
				System.out.println(nomJoueur2 + " lance les dés et obtient " + joueur.getLancerDe1() + ", " + joueur.getLancerDe2() + " et " + joueur.getLancerDe3() + ".");
			} 
	}
	
	@Override
	public void passerTourSuivant() {
		System.out.println("Appuyer sur 'entrer' pour passer au tour suivant..");
	}
}
