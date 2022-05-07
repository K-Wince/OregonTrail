package World;

public class Person {
	private int health;
	private String name;
	private boolean alive;

	// Constructor for Person Class
	public Person(String Name) {
		name = Name;
		health = 2;
		alive = true;
	}
	
	// Get the name of the person
	public String getName() {
		return name;
	}
	
	// Get the health of the person
	public int getHealth() {
		return health;
	}
	
	// Remove some health of the person
	public void LooseHealth() {
		health -= 1;
		if (health == 0) { alive = false;}
	}
	
	// Add health to the person
	public void gainHealth() {
		health += 1;
	}
	
	// Check to see if the person is dead
	public boolean checkDeath() { //returns true if they are dead otherwise returns false
		if(alive) { return false;}
		else {return true;}
	}
	
	// Check the overall health of the person
	public String checkHealth(){
		String status;
		if(health == 0) { status = name + " is dead. ";}
		else if(health == 1) { status = name + " is injured. ";}
		else { status = name + " is healthy. ";}
		return status;
	}
	
	// Set whether they are alive or dead
	public void setAlive(boolean x) {
		alive = x;
	}
}