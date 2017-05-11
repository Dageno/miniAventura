package miniAventura.backEnd.clases;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Fichero {
	static File comprobarExtend(File archivo) {
		String path = archivo.getPath();
		if (!path.endsWith(".db"))
			return new File(path + ".db");
		return archivo;
	}

	static void escribir(File archivo, Drop concesionario) throws FileNotFoundException, IOException {
		archivo = comprobarExtend(archivo);
		if (archivo.exists())
			if (!Gestion.deseaGuardar("El archivo ya existe, desea sobreescribirlo ? (y/n)"))
				return;
		try (ObjectOutputStream ous = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(archivo)))) {
			ous.writeObject(concesionario);
			Gestion.setModificado(false);
		}
	}

	public static Drop leer(File archivo, Drop concesionario) throws IOException, ClassNotFoundException{
		archivo = comprobarExtend(archivo);
		if(Gestion.modificado)
			Gestion.nuevo(archivo, concesionario);
		try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(archivo)))) {
			return (Drop) ois.readObject();

		}catch(FileNotFoundException e){
			System.err.println("El fichero introducido no existe.");
		}
		return concesionario;
		

	}

	public static void guardar(File archivo, Drop concesionario) throws FileNotFoundException, IOException {

		try (ObjectOutputStream ous = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(archivo)))) {
			ous.writeObject(concesionario);
			Gestion.setModificado(false);
		}

	}
	
	
}
