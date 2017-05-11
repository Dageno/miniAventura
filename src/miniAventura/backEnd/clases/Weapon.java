package miniAventura.backEnd.clases;

import java.io.Serializable;

import miniAventura.backEnd.enums.ClassWeapon;
import miniAventura.backEnd.enums.Material;
import miniAventura.backEnd.excepciones.NoDescriptionValidException;
import miniAventura.backEnd.excepciones.NoNameValidException;
import miniAventura.backEnd.interfaces.Valorable;

public class Weapon extends PrincipalObject implements Valorable, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int damage;
	private int durability;
	ClassWeapon classWeapon;
	Material material;
	private Integer price;

	public int getDamage() {
		return damage;
	}

	private void setDamage(int damage) {
		this.damage = damage;
	}

	public int getDurability() {
		return durability;
	}

	private void setDurability(int durability) {
		this.durability = durability;
	}

	public Integer getPrice() {
		return price;
	}

	private void setPrice(int price) {
		this.price = price;
	}
	private void setClassWeapon(ClassWeapon classWeapon){
		this.classWeapon = classWeapon;
	}
	public ClassWeapon getClassWeapon(){
		return classWeapon;
	}
	
	private void setMaterial(Material material){
		this.material = material;
	}
	public Material getMaterial(){
		
		return  material;
	}
	
	
	
	public Weapon(String name, String description, ClassWeapon classweapon, Material material) throws NoNameValidException, NoDescriptionValidException{
		super(name, description);
		setClassWeapon(classweapon);
		setMaterial(material);
		setDamage(calculateDamage());
		setDurability(100);
		setPrice(calculatePrice());
	}


	public Weapon(String string) throws NoNameValidException {
		super(string);
	}

	private int calculateDamage() {
		
		switch(classWeapon){
		case FIST:
			return classWeapon.getAddedDamage();
		default:
			return classWeapon.getAddedDamage() + material.getAddedDamage();
		}
		
		
	}
	
	@Override
	public int calculatePrice() {
		switch(classWeapon){
		case FIST:
			return 0;
		default:
			return classWeapon.getPrice() + material.getPrice();
		}
	}

	@Override
	public String toString() {
		return getClass().getSimpleName()+" "+ super.toString()+" damage=" + damage + ", durability=" + durability + ", classWeapon=" + classWeapon
				+ ", material=" + material + ", price=" + price + "]";
	}

	@Override
	public int compareTo(Valorable o) {
		if(getPrice()> o.calculatePrice())
			return 1;
		else if(getPrice()< o.calculatePrice())
			return -1;
		return 0;
	}


	
	
}
