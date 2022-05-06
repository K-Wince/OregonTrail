package World;

public class Person {
private int health;
private String name;
private boolean alive;

public Person(String Name) {
name = Name;
health = 2;
alive = true;
}

public String getName() {
return name;
}

public int getHealth() {
return health;
}

public void LooseHealth() {
health -= 1;
if (health == 0) { alive = false;}
}

public void gainHealth() {
health += 1;
}

public boolean checkDeath() { //returns true if they are dead otherwise returns false
if(alive) { return false;}
else {return true;}
}

public String checkHealth(){
	String status;
	if(health == 0) { status = name + " is dead ";}
	else if(health == 1) { status = name + " is injured ";}
	else { status = name + " is Healthy ";}
	return status;
}

public void setAlive(boolean x) {
alive = x;
}
}