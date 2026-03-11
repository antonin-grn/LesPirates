package jeu;

public interface Affichage {
	void annonceDebutJeu();
	void annonceDebutTour(Joueur joueur);
	void annonceGagnant(Joueur joueur);
	void annonceDeplacement(Joueur joueur, Pion pion, int valeur);
	void annonceArriverCase(Pion pion, int caseActuelle);
	void annonceEffetCase(int caseActuelle, Effets effetCase, Joueur joueur);
	void annonceCoeursPerdus(Joueur joueur, int valeur);
	void annonceMort(Joueur joueur);
}
