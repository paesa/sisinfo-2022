public class InvalidUserException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mess = "Usuario no válido\n";
	
	public InvalidUserException() {
		
	}
	public String toString() {
		return mess;
	}

}