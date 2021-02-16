package binarios;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOData {

	
	public static void guardarDatos(String rutaFichero, Password[] vPas) {
		
		File f = new File(rutaFichero);
		
		if (!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		try (FileOutputStream fo = new FileOutputStream(f);
			DataOutputStream escribir = new DataOutputStream(fo);){
			
			for (Password p : vPas) {
				if (p!=null) {
					escribir.writeUTF(p.getUsuario());
					escribir.writeInt(p.getPassword());
					escribir.writeBoolean(p.isSegura());
				}
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}
	
	
}
