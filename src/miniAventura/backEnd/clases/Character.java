package miniAventura.backEnd.clases;

import java.time.LocalDate;

import miniAventura.backEnd.enums.Magic;
/**
 * Clase del jugador EN DESARROLLO
 * @author d16genod
 *
 */
/////// EN DESARROLLO ///////
public class Character {

	private String name;
	private int health;
	private int mana;
	private int stamina;
	private LocalDate birthdate;
	protected Inventory inventory;
	protected Magic magic;
	protected Weapon weapon;
	private int lifes;
	private int money;

	public Character(String name, LocalDate birthdate) {
		setName(name);
		setBirthdate(birthdate);
		setHealth(100);
		setMana(100);
		setStamina(100);
		inventory = new Inventory();
		setLifes(3);
		setMoney(200);

	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	private void setHealth(int health) {
		this.health = health;
	}

	public int getMana() {
		return mana;
	}

	private void setMana(int mana) {
		this.mana = mana;
	}

	public int getStamina() {
		return stamina;
	}

	private void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	private void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public Magic getMagic() {
		return magic;
	}

	@SuppressWarnings("unused")
	private void setMagic(Magic magic) {
		this.magic = magic;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	@SuppressWarnings("unused")
	private void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public int getLifes() {
		return lifes;
	}

	private void setLifes(int lifes) {
		this.lifes = lifes;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}
