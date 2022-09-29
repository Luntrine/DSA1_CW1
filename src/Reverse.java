
public class Reverse {

	// Part 2
	/**
	 * Method works by copying all elements of the array into a stack. The stack then pops
	 * all of its values, and since a stack is a LIFO architecture, it pops out the elements
	 * in reverse order to how it took them in.
	 * 
	 * @param arr the array that will be reversed.
	 */
	public static void reverse(String[] arr){ 
		
		//Creates new stack that will be used to reverse values of arr.
		Stack arrStack = new Stack(arr.length);
		
		//Loop that copies all of the elements from arr into arrStack.
		for(int i = 0; i < arr.length; i++)
		{
			arrStack.push(arr[i]);
		}
		
		//Loop that pops the top element of arrStack into arr for all elements of arrStack.
		for(int i = 0; i <arr.length; i++)
		{
			//Casts objects from the stack into strings before copying them to the array.
			arr[i] = (String) arrStack.pop();
		}
		

	}
	
}
