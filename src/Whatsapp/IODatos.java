package Whatsapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IODatos {

	
	
	public static void escribirArchivo() {
		File f = new File("Telegram.txt");
		
		
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try (FileWriter fw = new FileWriter(f);
			PrintWriter pw = new PrintWriter(fw)){
			
			Mensaje vMensajes[] = leerArchivo();
			
			for (int i = 0; i < vMensajes.length; i++) {
				if (vMensajes[i]!=null) {
					
					pw.print(vMensajes[i].mensaje());
					
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public static Mensaje[] leerArchivo() {
		
		String ruta = "WhatsApp.txt", lectura="", nombre="", mensaje="";
		int cont=0, dos_puntos=0;
		
		
		Mensaje vMensajes[] = new Mensaje[20];
		
		
		File f = new File(ruta);
		
		
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try (FileReader fr = new FileReader(f);
			Scanner leer = new Scanner(fr)){
			
			while (leer.hasNext()) {
				lectura = leer.nextLine().trim();
				dos_puntos = lectura.indexOf(":");
				
				
				nombre=lectura.substring(0, dos_puntos);
				mensaje=lectura.substring(dos_puntos+1);
				
				vMensajes[cont] = new Mensaje(nombre, mensaje);
				
				cont++;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return vMensajes;
	}
	
}
