package miniAventura.backEnd.enums;

public enum Magic {
	FIRE(10), LIGHTNING(10), ICE(10);
	
	private int damage;
	
	Magic(int damage){
		setDamage(damage);
		
		
	}

	public int getDamage() {
		return damage;
	}

	private void setDamage(int damage) {
		this.damage = damage;
	}

}
