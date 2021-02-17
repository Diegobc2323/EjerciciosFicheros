package binarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
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

	
	
	public static Password[] leerDatos(String rutaFichero) {
		
		int cont = 0;
		
		File f = new File(rutaFichero);
		
		Password vPas[] = new Password[10];
		
		if (!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		try(FileInputStream fi = new FileInputStream(f);
			DataInputStream leer = new DataInputStream(fi)) {
			
			
			while (true) {
				String usuario = leer.readUTF();
				int pass = leer.readInt();
				boolean segura = leer.readBoolean();
				
				vPas[cont] = new Password(usuario, pass, segura);
				cont++;
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Fin de lectura del fichero");
		}
		
		
		
		
		return vPas;
	}
	
	
}
