package miniAventura.backEnd.enums;

public enum ClassWeapon {
	SWORD_ONE_HANDED(4, 20), BOW_TWO_HANDED(2, 40), AXE_ONE_HANDED(5, 40), FIST(1, 0);
	
	private int addedDamage;
	private int price;
	
	ClassWeapon(int valor, int price){
		setAddedDamage(valor);
		setPrice(price);
		
	}

	public int getAddedDamage() {
		return addedDamage;
	}

	public void setAddedDamage(int addedDamage) {
		this.addedDamage = addedDamage;
	}

	public int getPrice() {
		return price;
	}

	private void setPrice(int price) {
		this.price = price;
	}

}
