package miniAventura.backEnd.clases;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import miniAventura.backEnd.excepciones.NoDescriptionValidException;
import miniAventura.backEnd.excepciones.NoNameValidException;

/**
 * Enumerarciones implementar las nuevas modificaciones por tamaños.
 * Detallar implementacion de interfaces.
 * Explicar el flujo de uso de datos.
 * Implementar dos busquedas.
 * Añadir busqueda de objetos.
 * @author d16genod
 *
 */
public class PrincipalObject implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int id = 0;;
	private int identify;
	private String name;
	private String description;
	private LocalDate creationDate;
	Pattern patternName = Pattern.compile("^[A-Z].*");
	Pattern patternDescription = Pattern.compile("\\w+");
	
	public int getIdentify() {
		return identify;
	}
	private void setIdentify(int identify) {
		this.identify = identify;
		id++;
	}
	public String getName() {
		return name;
	}
	private void setName(String name) throws NoNameValidException {
		Matcher mat = patternName.matcher(name);
		if(!mat.matches())
			throw new NoNameValidException("El nombre no es válido");
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	private void setDescription(String description) throws NoDescriptionValidException {
//		Matcher mat = patternDescription.matcher(description);
//		if(!mat.matches())
//			throw new NoDescriptionValidException("La descripcion no es válida");
		this.description = description;
	}
	
	
	public PrincipalObject(String name, String description) throws NoNameValidException, NoDescriptionValidException {
		setName(name);
		setDescription(description);
		setIdentify(id);
		setCreationDate(LocalDate.now());
	}
	
	public PrincipalObject(int identify) {
		setIdentify(identify);
	}
	
	
	public PrincipalObject(String objname) throws NoNameValidException {
		setName(objname);
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrincipalObject other = (PrincipalObject) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	@Override
	public String toString() {
		return "[identify=" + identify + ", name=" + name + ", description=" + description
				+ ", creationDate=" + creationDate;
	}
	

}
