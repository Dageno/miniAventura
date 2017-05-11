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
import java.util.ArrayList;

public class FileLog {
	 
	static File checkExtend(File file) {
		String path = file.getPath();
		if (!path.endsWith(".obj"))
			return new File(path + ".obj");
		return file;
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<String> leer(File file, ArrayList<String> log) throws IOException, ClassNotFoundException{
		file = checkExtend(file);
		try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
			return (ArrayList<String>) ois.readObject();

		}catch(FileNotFoundException e){
			System.err.println("El fichero introducido no existe.");
		}
		return log;
		

	}

	public static void save(File file, ArrayList<String> log) throws FileNotFoundException, IOException {
		file = checkExtend(file);
		
		try (ObjectOutputStream ous = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
			ous.writeObject(log);
			
		}

	}
	

}
