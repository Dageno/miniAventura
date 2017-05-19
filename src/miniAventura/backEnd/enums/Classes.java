package miniAventura.backEnd.enums;

public enum Classes {
	WEAPON("Armas"), POTION("Pociones"), KEY_OBJECT("Objetos Clave"), FINAL_OBJECT("Objeto Final");
	
	private String name;
	
	Classes(String name){
		
		setName(name);
	
	}

	private void setName(String name) {
		this.name = name;
	}
	
	String getName(){
		return name;
	}

}
