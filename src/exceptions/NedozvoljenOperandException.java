package exceptions;

public class NedozvoljenOperandException extends Exception {
	
	public NedozvoljenOperandException(String linija) {
	    super("Nedozvoljen operand. Greska u liniji: " + linija);
	}
	public NedozvoljenOperandException(String linija,String msg) {
	    super(msg + linija);
	}
}
