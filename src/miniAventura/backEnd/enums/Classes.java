package miniAventura.backEnd.enums;
/**
 * Enumeración de cada tipo de clase usada en GUI
 * @author d16genod
 *
 */
public enum Classes {
	WEAPON("Armas"), POTION("Pociones"), KEY_OBJECT("Objetos Clave"), FINAL_OBJECT("Objeto Final");
	
	private String name;
	
	Classes(String name){
		
		setName(name);
	
	}
	/**
	 * Setter de nombre de la clase
	 * @param name
	 */
	private void setName(String name) {
		this.name = name;
	}
	/**
	 * obtiene el nombre del elemento
	 * @return
	 */
	String getName(){
		return name;
	}
	/**
	 * devuelve las clases por nombre como opciones de combobox en GUI
	 * @return
	 */
	public static String[] getOpciones(){
		int i = 0;
		String[] opciones = new String[Classes.values().length];
		for(Classes elemento : Classes.values())
			opciones[i++]= elemento.getName();
		return opciones;
		
	}

}
