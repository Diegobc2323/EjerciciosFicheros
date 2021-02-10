package Ficheros;

public class Persona {

	
	private String nombre;
	private String apellido;
	private int nip;
	
	public Persona(String nombre, String apellido, int nip) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nip = nip;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getNip() {
		return nip;
	}

	public void setNip(int nip) {
		this.nip = nip;
	}
	
	public String mostrar(int longitudLinea) {
		int puntos = (longitudLinea-this.nombre.length()-this.apellido.length()-String.valueOf(nip).length());
		String escribirPuntos="", devuelve;
		
		for (int i = 0; i < puntos; i++) {
			escribirPuntos+=".";
		}
		
		devuelve=(apellido+", "+nombre+" "+escribirPuntos+" "+nip);
		
		return devuelve;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", nip=" + nip + "]";
	}
	
}
