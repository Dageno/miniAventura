package miniAventura.backEnd.enums;
/**
 * Enumeración del material del arma
 * @author d16genod
 *
 */
public enum Material {
	WOOD(3, 10), IRON(6, 30), STEEL(9, 60);
	
	private int addedDamage;
	private int price;
	
	Material(int valor, int price){
		setAddedDamage(valor);
		setPrice(price);
		
	}
	/**
	 * Añade daño a la base segun el material elegido
	 * @return
	 */
	public int getAddedDamage() {
		return addedDamage;
	}
	
	/**
	 * Setter del daño añadido segun el material
	 * @param addedDamage
	 */
	public void setAddedDamage(int addedDamage) {
		this.addedDamage = addedDamage;
	}
	
	/**
	 * devuelve el precio según el tipo de material
	 * @return
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * Setter del precio según el material.
	 * @param price
	 */
	private void setPrice(int price) {
		this.price = price;
	}
}
