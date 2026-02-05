package jeu;

public interface JournalDeBord {
	String annonceDebutJeu();
	String annonceDebutTour(Joueur joueur);
	String annonceGagnant(Joueur joueur);
	String annonceDeplacement(Pion pion, int valeur);
	String annonceArriverCase(Pion pion, Case caseActuelle);
	String annonceEffetCase(Case caseActuelle);
	String annonceCoeursPerdus(Joueur joueur, int valeur);
}
