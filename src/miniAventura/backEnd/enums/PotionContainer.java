package miniAventura.backEnd.enums;
/**
 * Enumeración según el contenedor de la poción
 * @author d16genod
 *
 */
public enum PotionContainer {
	LITTLE(30, 10), MEDIUM(50, 20), HIGH(100, 40);
	
	private int valor;
	private int price;
	
	PotionContainer(int valor, int price){
		setValor(valor);
		setPrice(price);
		
	}
	/**
	 * Setter de la efectividad de la poción
	 * @param valor
	 */
	private void setValor(int valor) {
		this.valor = valor;
		
	}
	/**
	 * Devuelve en el instante de dropeo un tipo de pocion aleatoria
	 * @return
	 */
	protected int getValor(){
		
		double numRandom = Math.random();
		if(numRandom<0.33)
			return LITTLE.valor;
		else if(numRandom>0.33 && numRandom <0.66)
			return MEDIUM.valor;
		else
			return HIGH.valor;
			
		
	}
	/**
	 * Devuelve el precio del contenedor
	 * @return
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * Setter del precio del contenedor
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * Devuelve el contenedor d ela pocion elegida
	 * @param container
	 * @return
	 */
	public static PotionContainer getContainer(PotionContainer container) {
		
		return container;
	}
}
