package miniAventura.backEnd.enums;

public enum Material {
	WOOD(3, 10), IRON(6, 30), STEEL(9, 60);
	
	private int addedDamage;
	private int price;
	
	Material(int valor, int price){
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
