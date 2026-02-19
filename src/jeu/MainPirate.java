package jeu;

public class MainPirate {
	public static void main(String[] arg) {
		Affichage journal = new Journal();
		Jeu jeu = new Jeu(journal);
		jeu.commencerJeu();
	}
			
	
}
