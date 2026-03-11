package jeu;

import java.security.SecureRandom;
import java.util.Random;

public class Plateau {
	private De de1;
	private De de2;
	private Effets[] cases = new Effets[30];
	private Random random;
	
	public Plateau (De de1, De de2) {
		this.de1 = de1;
		this.de2 = de2;
		
		for(int i = 0; i < 30 ; i++) {
			cases[i] = Effets.AUCUN;
		}
	}
	
	public Effets[] getCases(){
		return cases;
	}
	
	public De getDe1() {
		return de1;
	}
	
	public De getDe2() {
		return de2;
	}
	
	public void placerEffets() {
	    try {
	        random = SecureRandom.getInstanceStrong();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    int caseRhum = 3;
	    int casePacte = 3;

	    do {
	        if (caseRhum != 0) {
	            int numCaseRhum = random.nextInt(1, 29);
	            if (cases[numCaseRhum] == Effets.AUCUN) {
	                cases[numCaseRhum] = Effets.RHUM;
	                caseRhum--;
	            }
	        }

	        if (casePacte != 0) {
	            int numCasePacte = random.nextInt(1, 29);
	            if (cases[numCasePacte] == Effets.AUCUN) {
	                cases[numCasePacte] = Effets.PACTE;
	                casePacte--;
	            }else {
	                System.out.println("Case " + numCasePacte + " déjà occupée par : " + cases[numCasePacte]);
	            }
	        }

	    } while (caseRhum != 0 || casePacte != 0);
	}
}
