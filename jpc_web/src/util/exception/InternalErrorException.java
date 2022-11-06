public class ErrorInterno extends Exception{
	private Exception exception = null;
	public ErrorInterno (Exception e) {
		this.exception = e;
	}
	public Exception getException() {
		return this.exception;
	}
}
