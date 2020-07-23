package game;

import java.security.SecureRandom;

public class Die {
	private DieFaces dieFaces;
	private final static SecureRandom random = new SecureRandom();
	
	public Die() {

	}
	
	public DieFaces rollRedDice() {
		int face;
		face = 1 +  random.nextInt(6);
		switch(face) {
		case 1:
			dieFaces = DieFaces.SKULL;
			break;
		case 2:
			dieFaces = DieFaces.SKULL;
			break;
		case 3:
			dieFaces = DieFaces.SKULL;
			break;
		case 4:
			dieFaces = DieFaces.HEROSHIELD;
			break;
		case 5:
			dieFaces = DieFaces.HEROSHIELD;
			break;
		case 6: 
			dieFaces = DieFaces.MONSTERSHIELD;
			break;
		}
		return dieFaces;
	}
	
	public int rollNumberDice() {
		int face = 1 + random.nextInt(6);
		return face;
	}
	
}

