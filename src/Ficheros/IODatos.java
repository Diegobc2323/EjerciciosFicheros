package Ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class IODatos {

	public static void mostrar(String nombreFichero, int longitudLinea) {
		
		Persona vPersonas[] = leerArchivo();
		
		for (int i = 0; i < vPersonas.length; i++) {
			if (vPersonas[i]!=null)
				System.out.println(vPersonas[i].mostrar(longitudLinea));	
		}
		
	}
	
	public static String buscar() {
		Persona vPersonas[] = leerArchivo();
		Scanner leer = new Scanner(System.in);
		int busqueda=-99;
		boolean encontrado=false;
		String devuelve="";
		
		
		System.out.println("Dime el nip y te dire el nombre y los apellidos de esa persona");
		
		do {
			try {
				busqueda = leer.nextInt();
			} catch (Exception e) {
				System.out.println("Error al introducir el nip, introducelo de nuevo por favor");
				leer = new Scanner(System.in);
			}
		} while (busqueda==-99);
		
		
		
		
		for (int i = 0; i < vPersonas.length; i++) {
			if (vPersonas[i]!=null && busqueda==vPersonas[i].getNip()) {
				devuelve+=("Nombre: "+vPersonas[i].getNombre()+"\n");
				devuelve+=("Apellido: "+vPersonas[i].getApellido());
				encontrado=true;
			}
		}
		
		if (encontrado==false) {
			devuelve="No se ha encontrado nadie con ese nip";
		}
		
		return devuelve;
	}

	public static void escribir(String nombreFichero) {
		Persona vPersonas[] = leerArchivo();
		
		File f = new File(nombreFichero);
		
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try( FileWriter fw = new FileWriter(f); 
			PrintWriter pw = new PrintWriter(fw)){
			
			for (Persona persona : vPersonas) {
				if (persona!=null) {
					pw.println(persona.mostrar(50));
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void escribeBusqueda(String nombreFichero) {
		String busqueda="";
		
		busqueda=buscar();
		
		File f = new File(nombreFichero);
		
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try(FileWriter fw = new FileWriter(f);
			PrintWriter pw = new PrintWriter(fw);) {
			
			pw.print(busqueda);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static Persona[] leerArchivo() {
		
		String ruta = "alumnos.txt", nombre="", apellido="", lectura="";
		int cont=0, nip=0;
		
		File f = new File(ruta);
		Persona p[] = new Persona[20];
		
		try (FileReader fr = new FileReader(f);
			 Scanner leer = new Scanner(fr)) {
			
				
				
				while (leer.hasNext()) {
					lectura = leer.nextLine().trim();
					int coma= lectura.indexOf(",");
					
					
					
					nip = Integer.parseInt(lectura.substring(0,6));
					apellido = lectura.substring(7,coma);
					nombre = lectura.substring(coma+2);
					
					
					p[cont] = new Persona(nombre, apellido, nip);
					cont++;
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return p;
		
	}
	
}
