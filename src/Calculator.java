// exception used for Q5
class CalculateException extends RuntimeException{    
	public CalculateException(String err) {
		super(err);
	}
}

public class Calculator {

	/**
	 * Method utilizes the support methods as well as the reverse() method to calculate
	 * the String array of polish notation fed into the method.
	 * 
	 * @param cmds is the polish notation of commands that will be calculated.
	 * @return the final calculation of the polish notation.
	 */
	public static int calculate(String [] cmds){
		
		Stack pstack = new Stack(cmds.length);
		
		//Reverses all elements of cmds.
		Reverse.reverse(cmds);
		
		//Loop that calculates the polish notation.
		for(int i = 0; i < cmds.length; i++)
		{
			//If the element is a number, it is put on the stack.
			if(isNumber(cmds[i]))
			{
				pstack.push(cmds[i]);
			}
			//If the element is an operation, it rips the next 2 numbers off the stack, calculates them using the op,
			//and then pops it back on the stack.
			else
			{
				String fst = (String)pstack.pop();
				String snd = (String)pstack.pop();
				String op = cmds[i];
				pstack.push(String.valueOf(applyOp(fst, op, snd)));
			}
		}
		
		//Turns pstack.top() from an object into a String, into an Integer and finally into an int.
		return (int) Integer.parseInt((String)pstack.top());
	}	

	
	/**
	 * Converts a string into an Integer, and finally into an int using the Integer class'
	 * method parseInt().
	 * 
	 * @param s the string that will be converted.
	 * @return the int that the string was converted to.
	 */
	public static int convert(String s) {
		
		//Returns S, converted into an Integer, and finally converted into an int.
		return (int) Integer.parseInt(s);
		
	}

	/**
	 * Method checks if the string is a number by attempting to convert it into an Integer.
	 * If it fails, it throws and exception and is not an Integer. If it passes the try/catch,
	 * it is a number.
	 * 
	 * @param s string that will be checked if it is a number.
	 * @return boolean that will return true if the string is a number, and false if it is not.
	 * @throws NumberFormatException if the try/catch fails if the string is not a number.
	 */
	public static boolean isNumber(String s) throws NumberFormatException{
		
		//Tries to convert String into an Integer. Will work if it is a digit.
		try {
			Integer.parseInt(s);
		}
		
		//If it fails, it will be caught by this statement and return false.
		catch(NumberFormatException e){
			return false;
		}
		
		//If it does not fail, the method inevitably returns true.
		return true;
		
	}

	/**
	 * Method takes 2 numbers and an operation, converts the numbers into ints, uses
	 * a switch case to decide which operation to use, and puts both the numbers together
	 * using the operation. It then returns the final, calculated int.
	 * 
	 * @param fst is the first number that will be calculated
	 * @param op is the operator that will be used to calculated
	 * @param snd is the second number that will be calculated
	 * @return the final calculated number.
	 */
	public static int applyOp(String fst,String op,String snd){
		
		//Returns calculations depending on which operator op holds.
		switch(op) {
		
		case "+":
			return (convert(fst) + convert(snd));

		case "-":
			return (convert(fst) - convert(snd));
			
		case "*":
			return (convert(fst) * convert(snd));
			
		default:
			return (convert(fst) / convert(snd));
		}
			
	}

	// main operation to calculate using Polish notation directly
    public static int calculatePolish(String [] cmds){
    	//Returns polish calculation given a string of polish notation.
    	return calculate(cmds);
    }
}
