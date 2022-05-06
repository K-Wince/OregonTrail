package World;

import java.util.Random;


public class rndEvents  {
	private String outcome;
	private final int odds = 1000; //what the random value will be out of
	private int event;
	private boolean Injury;
	private final int dino = 1;
	private final int mushroom = dino + 20;
	private final int predator = mushroom + 20;
	private final int sickness = predator + 50;
	private final int lightning = sickness + 60;
	private final int abandonedW = lightning + 60;
	private final int breakAxle = abandonedW + 30;
	private final int berries = breakAxle + 60;
	private final int findpart = berries + 90;
	private final int breakWheel = berries + 30;
	
	
	public rndEvents(Supplies s, Person P) {
		
		Random rand = new Random();
		event = rand.nextInt(odds);
		if(event <= mushroom) {
			if(P.getHealth() == 2) {
				outcome = P.getName() + " ate a mushroom and walked off into the woods acting strangely and returned in bad condtion later that day with no memory of what happened";
				Injury = true;
			}
		}else if(event <= predator) {
			if(s.getAmmo() >= 1) {
				outcome = "A mountain lion showed up and attacked " + P.getName() + ", but they were able to kill it with the gun and gained 100lbs of food";
				s.consumeAmmo();
				for(int i = 0; i > 3; i++) { s.consumeAmmo();}
				s.addFood(100);
			}else {
				outcome = "A mountain lion showed up and attacked" + P.getName() + "but they were out of ammo and were injured";
				Injury = true;
			}
		}else if(event <= sickness) {
			outcome = P.getName() + " got sick with dysentery.";
			Injury = true;
		}else if(event <= lightning) {
			
			if(s.getOxen() > 1) {
				outcome = "During a storm one of the oxen was struck by lightning and killed";
				s.loseOxen();
			}
		}else if(event <= abandonedW) {
				
				outcome = "You found a broken abandoned wagon and were able to salvage some parts";
				s.addWheel(rand.nextInt(3));
				s.addAxle(rand.nextInt(2));
				s.addTongue(rand.nextInt(2));
		}else if(event <= breakAxle) {
			outcome = "Your wagon wheel broke";
			s.consumeWheel();
		}else if(event <= berries) {
			int x = rand.nextInt(50)+50;
			outcome = "You found " + x + "lbs of edible berries growing and were able to harvest them";
			s.addFood(x);
		}else if(event <= findpart) {
			int x = rand.nextInt(3)+1;
			if(x == 1) {s.addWheel(1);
			outcome = "You found a wheel along the trail";}
			else if(x==2) {s.addAxle(1);
			outcome = "You found a axle along the trail";}
			else {s.addTongue(1);
			outcome = "You found a Tongue along the trail";}
		}else if(event <= breakWheel) {
			outcome = "Your wagon wheel broke";
			s.consumeWheel();
		}

	}


	public String PrintOutcome() { // Prints the outcome string
		return outcome;
		
	}
	
	public boolean happened() {
		if(outcome == null) { return false;}
		else {return true;}
	}
	
	public boolean getInjury() {
		boolean x = Injury;
		Injury = false;
		return x;
	}
	
	public void setInjury(boolean I) {
		 Injury = I;
		}
}
