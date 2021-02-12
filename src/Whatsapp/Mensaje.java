package Whatsapp;

public class Mensaje {

	private String nombre;
	private  String mensaje;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String mensaje() {
		String devuelve = "";
		
		devuelve = (mensaje+":"+nombre+"\n");
		
		
		return devuelve;
	}
	
	public Mensaje(String nombre, String mensaje) {
		super();
		this.nombre = nombre;
		this.mensaje = mensaje;
	}
	
	
}
