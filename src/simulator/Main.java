package simulator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import exceptions.NedozvoljenaOperacijaException;

public class Main {

	private static final String TEST_FILE="text.txt";
	public static void main(String[] a) {
		new Operacije();
		Scanner scan = new Scanner(System.in);
		BufferedReader bf = null;
	    try {

	    	bf = new BufferedReader(new FileReader(TEST_FILE));
	    	String linija;

	    	while ((linija = bf.readLine()) != null) {
	    		String[] params=linija.split(" ");
	    		if ("ADD".equals(params[0]) || "SUB".equals(params[0])  || "AND".equals(params[0]) || "OR".equals(params[0]) || "NOT".equals(params[0])) {

	    	          Operacije.operacije(linija, params);
	    	  }
	    	  else if ("IN".equals(params[0])) {
	              long vrijednost = scan.nextLong();
	              Operacije.upisiURegistar(params[1], linija, vrijednost);         
	          } else if ("OUT".equals(params[0])) {

	          
	              Operacije.ispisi(params[1], linija);
	          } else {
				throw new NedozvoljenaOperacijaException(linija);
			}
	      }
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }finally {
	    	try {
				bf.close();
				scan.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	}
}
