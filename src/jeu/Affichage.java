package jeu;

public interface Affichage {
	void annonceDebutJeu();
	void annonceDebutTour(Joueur joueur);
	void annonceGagnant(Joueur joueur);
	void annonceDeplacement(Joueur joueur, Pion pion, int valeur);
	void annonceArriverCase(Pion pion, Case caseActuelle);
	void annonceEffetCase(Case caseActuelle);
	void annonceCoeursPerdus(Joueur joueur, int valeur);
}
