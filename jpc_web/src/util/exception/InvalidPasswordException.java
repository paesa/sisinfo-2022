public class InvalidPasswordException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mess = "Constraseña no válida\n";
	
	public InvalidPasswordException() {
		
	}
	public String toString() {
		return mess;
	}

}