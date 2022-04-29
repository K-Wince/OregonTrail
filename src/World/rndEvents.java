package World;

import java.util.Random;


public class rndEvents {
	private String outcome;
	private int odds = 1000; //what the random value will be out of
	private int event;
	//private int dino = 1;
	private int mushroom = 10;
	private int predator = 20;
	private int sickness = 50;
	private int lightning = 80;
	private int abandonedW = 90;
	private int lost = 100;
	private int berries = 140;
	private int findpart = 160;
	private int dog = 170;
	
	
	public rndEvents() {
		Random rand = new Random();
		event = rand.nextInt(odds);
		if(event <= mushroom) {
			outcome = "One of your group ate a mushroom and walked off into the woods acting strangely and didn't return for 2 days"; 
		}else if(event <= predator) {
			if(getAmmo() >= 10) {
				outcome = "A mountain lion showed up and attacked but you were able to kill it with 10 shots and gained 100lbs of food";
				for(int i = 0; i > 10; i++) { consumeAmmo();}
				addFood(100);
			}else {
				outcome = "A mountain lion showed up and attacked but you were out of ammo so someone died";
				//someone is killed
			}
		}else if(event <= sickness) {
			
		}else if(event <= lightning) {
			//check weather if raining can happen and that there are at least two oxen;
			if(getOxen() > 1) {
				outcome = "During the storm one of the oxen was struck by lightning and killed another was scared and escaped into the night";
				loseOxen();
				loseOxen();
			}
		}else if(event <= abandonedW) {
				// could add the amount to outcome
				outcome = "You found a broken abandoned wagon and were able to salvage some parts";
				addWheel(rand.nextInt(3));
				addAxle(rand.nextInt(2));
				addTongue(rand.nextInt(2));
		}else if(event <= lost) {
			//someone got lost while collecting firewood
		}else if(event <= berries) {
			int x = rand.nextInt(100)+50;
			outcome = "You found " + x + "lbs of edible berries growing and were able to harvest them";
			addFood(x);
		}else if(event <= findpart) {
			int x = rand.nextInt(3)+1;
			if(x == 1) {addWheel(1);
			outcome = "You found a wheel along the trail";}
			else if(x==2) {addAxle(1);
			outcome = "You found a axle along the trail";}
			else {addTongue(1);
			outcome = "You found a Tongue along the trail";}
		}else if(event <= dog) {
			//ups food and and water consumption
		}
		//return outcome;
	};
	
	
	
	

	
	
	
}
