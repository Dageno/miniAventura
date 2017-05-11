package miniAventura.backEnd.enums;

import miniAventura.backEnd.clases.Potion;

public enum PotionType {
	HEALTH(30, 10), MANA(30, 10), STRENGTH(10, 50), MAGICIAN(20, 50);
	
	/**
	 * Valor base que restaura o modifica.
	 */
	private int valor;
	/**
	 * Precio base del objeto
	 */
	private int price;
	
	PotionType(int valor, int price){
		setValor(valor);
		setPrice(price);
		
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
