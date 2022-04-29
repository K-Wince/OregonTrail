package World;

public class Supplies {

	public Supplies() {};
	
	// Supplies Variables
	private int money = 1000;
	private int food = 0;
	private int clothing = 0;
	private int ammo = 0;
	private int oxen = 0;
	private int wheel = 0;
	private int axle = 0;
	private int tongue = 0;
	private int medBox = 0;
	
	
	// Getters 

	public int getMoney() {
		return money;
	}

	public int getFood() {
		return food;
	}

	public int getClothing() {
		return clothing;
	}

	public int getAmmo() {
		return ammo;
	}

	public int getOxen() {
		return oxen;
	}

	public int getWheel() {
		return wheel;
	}

	public int getAxle() {
		return axle;
	}

	public int getTongue() {
		return tongue;
	}

	public int getMedBox() {
		return medBox;
	}
	
	// Consume Supplies
	
	public boolean spendMoney(int n) {
		if (n > money && money != 0) {
			money -= n;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean eatFood(int n) {
		if (n > food && food != 0) {
			food -= n;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean loseClothing(int n) {
		if (n > clothing && clothing != 0) {
			clothing -= n;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean loseOxen() {
		if (oxen != 0) {
			oxen--;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean consumeAmmo() {
		if (ammo != 0) {
			ammo--;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean consumeWheel() {
		if (wheel != 0) {
			wheel--;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean consumeAxle() {
		if (axle != 0) {
			axle--;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean consumeTongue() {
		if (tongue != 0) {
			tongue--;
			return true;
		} else {
			return false;
		}
	}

	public boolean consumeMedBox() {
		if (medBox != 0) {
			medBox--;
			return true;
		} else {
			return false;
		}
	}
	// Add Supplies
	
	public void addMoney(int n) {
		money += n;
	}
	
	public void addFood(int n) {
		food += n;
	}
	
	public void addClothing(int n) {
		clothing += n;
	}
	
	public void addAmmo(int n) {
		ammo += n;
	}
	
	public void addOxen(int n) {
		oxen += n;
	}
	
	public void addWheel(int n) {
		wheel += n;
	}
	
	public void addAxle(int n) {
		axle += n;
	}
	
	public void addTongue(int n) {
		tongue += n;
	}
	
	public void addMedBox(int n) {
		medBox += n;
	}
}
