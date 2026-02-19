package jeu;

public class Plateau {
	private De de1;
	private De de2;
	private Effets[] cases = new Effets[30];
	
	public Plateau (De de1, De de2) {
		this.de1 = de1;
		this.de2 = de2;
	}
	
	public Effets[] getCases(){
		return cases;
	}
}
