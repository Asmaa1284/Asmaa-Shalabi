
public class InvalidCharacterException extends Exception{
	private static final String MESSAGE = "Invalid Character @";
	public InvalidCharacterException() {
		super(MESSAGE);
	}
	public InvalidCharacterException(String message) {
		super(message);
	}

}
