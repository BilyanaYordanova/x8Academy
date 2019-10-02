package exceptions;

@SuppressWarnings("serial")
public class MyException extends Exception {
	public MyException(String errorMessage) {
		super(errorMessage);
	}
}
