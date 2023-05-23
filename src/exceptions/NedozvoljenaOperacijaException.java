package exceptions;

public class NedozvoljenaOperacijaException extends Exception{
	
	public NedozvoljenaOperacijaException(String linija) {
		    super("Nedozvoljenan operacija. Greska u liniji: " + linija);
	}
	
	public NedozvoljenaOperacijaException(String linija,String msg) {
	    super(msg + linija);
	}

}
