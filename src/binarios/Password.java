package binarios;

public class Password {

	private String usuario;
	private int password;
	private boolean segura;
	
	
	public Password(String usuario, int password, boolean segura) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.segura = segura;
	}
	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public boolean isSegura() {
		return segura;
	}
	public void setSegura(boolean segura) {
		this.segura = segura;
	}
	
	
	@Override
	public String toString() {
		return "Password [usuario=" + usuario + ", password=" + password + ", segura=" + segura + "]";
	}
	
	
	
}
