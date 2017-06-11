package miniAventura.backEnd.clases;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 * Caja de texto informativa de los sucesos EN DESARROLLO
 * @author d16genod
 *
 */
///////// EN DESARROLLO /////////
public class Chatlog {

	ArrayList<String> chatlog =new ArrayList<String>();
	private static final String LOG = "LogFile";
	void add(String message){
		LocalDate date = LocalDate.now();
		if(chatlog.size() == 10){
			chatlog.remove(0);
			chatlog.add(message + date);
			try {
				FileLog.save(new File(LOG), chatlog);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	

}
