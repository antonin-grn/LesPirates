package jeu;

public class Plateau {
	private De de1;
	private De de2;
	private Case[] cases = new Case[30];
	
	public Plateau (De de1, De de2, Case[] cases) {
		this.de1 = de1;
		this.de2 = de2;
		this.cases = cases;
	}
	
	public int lancerDes() {
		return de1.lancerDe() + de2.lancerDe();
	}
}
