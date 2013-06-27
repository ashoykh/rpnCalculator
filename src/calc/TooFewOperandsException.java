package calc;

public class TooFewOperandsException extends RuntimeException {
	public TooFewOperandsException(Exception e) {
		super(e);
	}
}
