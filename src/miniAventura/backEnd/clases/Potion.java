package miniAventura.backEnd.clases;

import java.io.Serializable;

import miniAventura.backEnd.enums.PotionContainer;
import miniAventura.backEnd.enums.PotionType;
import miniAventura.backEnd.excepciones.NoDescriptionValidException;
import miniAventura.backEnd.excepciones.NoNameValidException;
import miniAventura.backEnd.interfaces.Valorable;

public class Potion extends PrincipalObject implements Valorable, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected PotionType potion;
	protected PotionContainer container;
	private Integer price;
	private int quantity = 0;
	
	public Integer getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Potion(String name, String description, PotionType potion, PotionContainer container) throws NoNameValidException, NoDescriptionValidException {
		super(name, description);
		setPotionType(potion);
		setContainer(container);
		setPrice(calculatePrice());
		
	}
	public Potion(String string) throws NoNameValidException {
		super(string);
	}
	private void setPotionType(PotionType potion) {
		this.potion = potion;
		
	}
	
	public PotionType getPotionType() {
		return potion;
		
	}
	public PotionContainer getContainer() {
		return container;
	}
	public void setContainer(PotionContainer container) {
		this.container = container;
	}
	
	private int totalPrice(){
		return potion.getPrice() + container.getPrice();
	}
	@Override
	public int calculatePrice() {
		switch(potion){
		default:
			return totalPrice();
		}
		
	}
	@Override
	public String toString() {
		return getClass().getSimpleName()+" "+ super.toString()+" potion=" + potion + ", container=" + container + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}
	@Override
	public int compareTo(Valorable o) {
		if(getPrice() > o.calculatePrice())
			return 1;
		else if(getPrice() < o.calculatePrice())
			return -1;
		return 0;
	}
	
}
