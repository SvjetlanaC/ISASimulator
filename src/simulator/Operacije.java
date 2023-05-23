package simulator;

import java.util.HashMap;
import java.util.regex.Pattern;
import exceptions.*;

public class Operacije {
	
	public static HashMap<String, Registar> registri = new HashMap<>();
	private static final int BROJ_REGISTARA=4;
	

	static {
		for(int i=0; i<BROJ_REGISTARA; i++) {
			Registar r = new Registar();
			registri.put(r.getNaziv(),r);
		}
	}

	public static void operacije(String linija, String[] params) throws NedozvoljenaOperacijaException, NedozvoljenOperandException {

		if(registri.containsKey(params[1])) {
			if ("NOT".equals(params[0])) {
			      registri.get(params[1]).not();
			      return;
			} 
			long operand2=0;
			try {
				operand2 = provjeriOperand(params[2], linija);
			}catch(Exception e) {
				throw new NedozvoljenOperandException(linija);
			}
			switch (params[0]) {
				case "ADD":
					registri.get(params[1]).add(operand2);
					break;
				case "SUB":
					registri.get(params[1]).sub(operand2);
					break;
				case "AND":
					registri.get(params[1]).and(operand2);
					break;
				case "OR":
					registri.get(params[1]).or(operand2);
					break;
				default:
					throw new NedozvoljenaOperacijaException(linija);
			}
		}else throw new NedozvoljenaOperacijaException(linija);
	    
	  }

	  public static long provjeriOperand(String operand, String linija) throws NedozvoljenOperandException {

	    try {
	      if (Pattern.matches("[0-9]+", operand)) {
	        return Long.parseLong(operand);
	      } else if (Pattern.matches("[a-z]+[0-9]*[a-z]*", operand)) {
	        if (registri.containsKey(operand)) {
	          return registri.get(operand).getVrijednost();
	        }
	      } else {
	        throw new NedozvoljenOperandException(linija);
	      }
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return 0;
	  }

	  public static void upisiURegistar(String nazivRegistra, String linija, Long vrijednost) throws NedozvoljenOperandException {

		if (registri.containsKey(nazivRegistra)) {
	      registri.get(nazivRegistra).setVrijednost(vrijednost);
	    }
		else throw new NedozvoljenOperandException(linija);
	    
	  }

	  public static void ispisi(String nazivRegistra, String linija) throws NedozvoljenOperandException {
	     if (registri.containsKey(nazivRegistra)) {
	        System.out.println(registri.get(nazivRegistra).getVrijednost());
	      }
	     else throw new NedozvoljenOperandException(linija);
	  }
}
