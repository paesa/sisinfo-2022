public class CorreoYaRegistrado extends Exception{
	private String mess = "Error al crear cuenta: correo en uso\n";
	public CorreoYaRegistrado() {
	}
	public String toString() {
		return mess;
	}
}