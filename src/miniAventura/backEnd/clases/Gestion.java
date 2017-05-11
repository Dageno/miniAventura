package miniAventura.backEnd.clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import miniAventura.frontEnd.gui.FrontPanel;


public class Gestion {
	public static File archivo;
	static boolean modificado;
	public static Drop drop = new Drop();
	
	public static JFileChooser fileChooser;
	/**
	 * Bloque estático para iniciar el filechooser
	 */
	static {
		fileChooser = new JFileChooser();
		FileNameExtensionFilter extension = new FileNameExtensionFilter("Base de datos Butcher", "db");
		fileChooser.setFileFilter(extension);
	}
	
	
	public static void setModificado(boolean modify) {
		modificado = modify;

	}
	
	public static void nuevo(File archivo, Drop concesionario) throws FileNotFoundException, IOException {
		if (Gestion.modificado) {
			if (deseaGuardar("Se han hecho modificaciones, Desea guardar los cambios ? (y/n)")) {
				Fichero.escribir(archivo, concesionario);
			}
		}
		concesionario.clearDrop();
		archivo = null;
		setModificado(false);
	}
	public static boolean deseaGuardar(String string) {
		int confirmado = JOptionPane.showConfirmDialog(
				   null,
				   string);
		if(JOptionPane.OK_OPTION == confirmado)
			return true;
		return false;
	}

	public static Drop abrir(File archivo, Drop concesionario) throws FileNotFoundException, ClassNotFoundException, IOException{
		return Fichero.leer(archivo, concesionario);
	}

	public static void guardar(Drop concesionario) throws FileNotFoundException, IOException {
		if(getFile()==null){
			File archivo = FrontPanel.leerArchivo();
			guardarComo(archivo, concesionario);
		}
		else
			Fichero.guardar(getFile(), concesionario);
		
		
	}
	public static File ficheroNuevo(){
		
		return new File(JOptionPane.showInputDialog(
				   null,
				   "Nombre del fichero:"));
		
	}
	public static File getFile() {
		
		return archivo;
	}

	public static void guardarComo(File archivo, Drop concesionario) throws FileNotFoundException, IOException {
		Fichero.escribir(archivo, concesionario);
		
	}

	public static boolean getModificado() {
		
		return modificado;
	}
	
	
	

}
