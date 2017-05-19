package miniAventura.backEnd.enums;

public enum ClassWeapon {
	SWORD_ONE_HANDED(4, 20, "Espada de una mano"), BOW_TWO_HANDED(2, 40, "Arco de dos manos"), AXE_ONE_HANDED(5, 40, "Hacha una mano"), FIST(1, 0, "Manos desnudas");
	
	private int addedDamage;
	private int price;
	private String name;
	
	ClassWeapon(int valor, int price, String name){
		setAddedDamage(valor);
		setPrice(price);
		setName(name);
		
		
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
