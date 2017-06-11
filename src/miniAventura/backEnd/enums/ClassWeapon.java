package miniAventura.backEnd.enums;
/**
 * Enumeración que clasifica los tipos de arma
 * @author d16genod
 *
 */
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
	
	/**
	 * Devuelve el daño ya sumado segun su tipo
	 * @return
	 */
	public int getAddedDamage() {
		return addedDamage;
	}
	
	/**
	 * aplica el aumento de daño según el tipo de arma
	 * @param addedDamage
	 */
	public void setAddedDamage(int addedDamage) {
		this.addedDamage = addedDamage;
	}
	
	/**
	 * Obtiene el precio que se le añade por tipo de arma elegida
	 * @return
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * Aumento del precio base según el tipo elegido
	 * @param price
	 */
	private void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * Setter de nombre de la clase
	 * @param name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * obtiene el nombre del elemento
	 * @return
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * devuelve los tipos de arma por nombre como opciones de combobox en GUI
	 * @return
	 */
	public static String[] getOpciones(){
		int i = 0;
		String[] opciones = new String[ClassWeapon.values().length];
		for(ClassWeapon elemento : ClassWeapon.values())
			opciones[i++]= elemento.getName();
		return opciones;
		
	}

}
