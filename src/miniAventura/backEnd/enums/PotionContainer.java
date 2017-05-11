package miniAventura.backEnd.enums;

public enum PotionContainer {
	LITTLE(30, 10), MEDIUM(50, 20), HIGH(100, 40);
	
	private int valor;
	private int price;
	
	PotionContainer(int valor, int price){
		setValor(valor);
		setPrice(price);
		
	}

	private void setValor(int valor) {
		this.valor = valor;
		
	}
	
	protected int getValor(){
		
		double numRandom = Math.random();
		if(numRandom<0.33)
			return LITTLE.valor;
		else if(numRandom>0.33 && numRandom <0.66)
			return MEDIUM.valor;
		else
			return HIGH.valor;
			
		
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public static PotionContainer getContainer(PotionContainer container) {
		
		return container;
	}
}
