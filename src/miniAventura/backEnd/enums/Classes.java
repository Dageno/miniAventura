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
	
	public static String[] getOpciones(){
		int i = 0;
		String[] opciones = new String[Classes.values().length];
		for(Classes elemento : Classes.values())
			opciones[i++]= elemento.getName();
		return opciones;
		
	}

}
