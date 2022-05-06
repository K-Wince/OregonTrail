package World;

import java.util.Random;


public class rndEvents {
	private String outcome;
	private final int odds = 1000; //what the random value will be out of
	private int event;
	private final int dino = 1;
	private final int mushroom = dino + 10;
	private final int predator = mushroom + 20;
	private final int sickness = predator + 50;
	private final int lightning = sickness + 80;
	private final int abandonedW = lightning + 90;
	private final int lost = abandonedW + 100;
	private final int berries = lost + 140;
	private final int findpart = berries + 160;
	private final int x = 170;
	
	
	public rndEvents(Supplies s) {
		
		Random rand = new Random();
		event = rand.nextInt(odds);
		if(event <= mushroom) {
		 outcome = "One of your group ate a mushroom and walked off into the woods acting strangely and didn't return for 2 days"; 
		}else if(event <= predator) {
			if(s.getAmmo() >= 10) {
				outcome = "A mountain lion showed up and attacked but you were able to kill it with 10 shots and gained 100lbs of food";
				for(int i = 0; i > 10; i++) { s.consumeAmmo();}
				s.addFood(100);
			}else {
				outcome = "A mountain lion showed up and attacked but you were out of ammo so someone died";
				//someone is killed
			}
		}else if(event <= sickness) {
			
		}else if(event <= lightning) {
			//check weather if raining can happen and that there are at least two oxen;
			if(s.getOxen() > 1) {
				outcome = "During the storm one of the oxen was struck by lightning and killed another was scared and escaped into the night";
				s.loseOxen();
				s.loseOxen();
			}
		}else if(event <= abandonedW) {
				// could add the amount to outcome
				outcome = "You found a broken abandoned wagon and were able to salvage some parts";
				s.addWheel(rand.nextInt(3));
				s.addAxle(rand.nextInt(2));
				s.addTongue(rand.nextInt(2));
		}else if(event <= lost) {
			//someone got lost while collecting firewood
		}else if(event <= berries) {
			int x = rand.nextInt(100)+50;
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
		}else if(event <= x) {
			
		}
		s.setOutcome(outcome);
		//return outcome;
	}


	public String PrintOutcome() { // Prints the outcome string
		return outcome;
		
	}
	
	
	
	

	
	
	
}
