package Asssignment4_DSA;

import java.util.Scanner;
import java.util.Stack;

public class OrganicCompoundMass {

	public static int massOf(char character){
		if (character == 'C')
			return 12;
		if (character == 'H')
			return 1;
		if (character == 'O')
			return 16;
		System.out.println(character);
		throw new AssertionError("invalid input");
	}
	
	public static int computeCompoundWeight(String compound) {  
		char[] charArray = compound.toCharArray();
	    int result = 0;
	    int index = 0;
	    while(index < charArray.length){
	    	if (charArray[index] == '('){
	    		int tempResult1 =  0;
	    		index += 1;
	            while (index  < charArray.length && charArray[index] != ')'){
	            	tempResult1 += massOf(charArray[index]);
//	            	System.out.print(index);
//	            	System.out.println(" TempRes : " + tempResult);
	                index += 1;
	            }
	            if((index + 1)  < charArray.length && (charArray[index + 1] >= '0' && charArray[index + 1] <= '9') ){
	        		  String number1 = "";
	        		  index += 1;
	        		  while(index  < charArray.length && (charArray[index] >= '0' && charArray[index] <= '9')){
	        			  number1 += charArray[index];
	        			  index += 1;
	        		  }
	        		  index -= 1;
	        		  tempResult1 *= (Integer.parseInt(number1));
	        	  }
	            
	            result += tempResult1;
//	            System.out.println(" TempRes : " + tempResult);
	        }
	        else{
	        	  int tempResult2 = 0;
	        	  tempResult2 +=  massOf(charArray[index]);
//	        	  System.out.println("else : "  + index);
//	        	  System.out.println(" Res : " + result);
	        	  if((index + 1)  < charArray.length && (charArray[index + 1] >= '0' && charArray[index + 1] <= '9') ){
	        		  String number2 = "";
	        		  index += 1;
	        		  while(index  < charArray.length && (charArray[index] >= '0' && charArray[index] <= '9')){
	        			  number2 += charArray[index];
	        			  index += 1;
	        		  }
	        		  index -= 1;
	        		  tempResult2 *= (Integer.parseInt(number2));
	        	  }
	        	  result += tempResult2;
	        }
	    	index += 1;
	    }   
	    return result;
	}

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Organic compound containsonly C, H and O");
		System.out.println("Enter the compound : ");
		String compoundString = scan.next().toUpperCase();
		System.out.println(computeCompoundWeight(compoundString));
//		System.out.println(computeCompoundWeight("H22(OH)10C1010"));
	}
}
