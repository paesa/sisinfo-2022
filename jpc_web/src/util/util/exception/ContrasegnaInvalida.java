public class ContrasegnaInvalida extends Exception{
	private String mess = "Error en login: contraseña incorrecta\n";
	public ContrasegnaInvalida() {
	}
	public String toString() {
		return mess;
	}
}