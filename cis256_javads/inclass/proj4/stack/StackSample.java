package inclass.proj4.stack;

import javax.swing.*;

public class StackSample {

	// This program provides decimal to binary conversion
	// For stack demo purposes only --> console output
//	public class out_base{
	public static void main (String [] args) {
		ObjStack stack = new ObjStack(); //remainder stack
		final int base = 2; //base for conversion
		String temp; //user input string
		int value; //value to be converted
		//accept value to be converted
		temp = JOptionPane.showInputDialog("enter value to convert");
		value = Integer.parseInt(temp);
		
		//convert to new base by repeated division
		//pushing each remainder on the stack to
		//be popped later for converted value
		
		while (value != 0){
			if (value % base == 1)
				stack.push(new Integer(1));
			else
				stack.push(new Integer(0));
			
			value = value / base;
		}
		
		//pop the converted value
		while (! stack.isEmpty()){
			System.out.print(stack.pop());
		}
		
		System.exit(0);
	}	
}
