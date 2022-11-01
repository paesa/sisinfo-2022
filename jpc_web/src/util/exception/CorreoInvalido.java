public class CorreoInvalido extends Exception{
	private String mess = "Error en login: correo incorrecto\n";
	public CorreoInvalido() {
	}
	public String toString() {
		return mess;
	}
}