package Assignment2_DSA;
import java.util.Stack;

/**
 * Class to compute value of Infix expression
 * @author ankit.saini_metacube
 *
 */
public class InfixExpression {
	
	/**
	 * method returns precedence of operator
	 * @param op
	 * @return -> precedence
	 */
	public int precedence(String op) {
		 switch (op) {
		 	case "||": return 1;
		 	case "&&": return 2;
		 	case "==": return 3;
		 	case "!=": return 3;
		 	case "<": return 4;
		 	case ">": return 4;
	        case "<=": return 4;
	        case ">=": return 4;
		 	case "+": return 5;
		 	case "-": return 5;
	        case "*": return 6;
	        case "/": return 6;
	        case "%": return 6;
	        case "^": return 7; 
	        case "!": return 8;
	        default: return 0; //precedence for '('
	      }
	 }
	
	 /**
	  * method to check if token is operator
	  * @param op
	  * @return -> true if operator else false
	  */
	 public boolean isOperator(String op) {
		 switch (op) {
		 	case "||" : 
		 	case "&&" : 
		 	case "==" : 
		 	case "!=" : 
		 	case "<"  : 
		 	case ">"  : 
	        case "<=" : 
	        case ">=" : 
		 	case "+"  :
		 	case "-"  : 
	        case "*"  : 
	        case "/"  : 
	        case "%"  : 
	        case "^"  :  
	        case "!"  : return true;
	        default: return false; 
	     }
	}
	 
	/**
	 * method to perform operation
	 * @param num1
	 * @param num2
	 * @param op
	 * @return -> result after performing operation
	 */
	public Double performOperation(Double num1 , Double num2, String op){
		switch (op) {
		case "||" : if ( (num1 != 0 || num1 != 1) || ( num1 !=2 || num2 != 0) )
						throw new AssertionError("Invalid numbers");
					if (num1 == 1 || num2 == 1)
						return 1.;
					return 0.;
			
	 	case "&&" :	if ( (num1 != 0 || num1 != 1) || ( num1 !=2 || num2 != 0) )
	 					throw new AssertionError("Invalid numbers");
	 				if (num1 == 1 && num2 == 1)
	 						return 1.;
	 				return 0.;
	 	
	 	case "==" : if(num1 == num2)
	 					return 1.0;
	 				return 0.0;
	 				
	 	case "!=" : if(num1 != num2)
						return 1.0;
					return 0.0;
					
	 	case "<"  : if(num1 < num2)
	 					return 1.0;
	 				return 0.0;
	 				
	 	case ">"  : if(num1 > num2)
						return 1.0;
					return 0.0;
       case "<=" : if(num1 <= num2)
						return 1.0;
					return 0.0;
       case ">=" : if(num1 >= num2)
						return 1.0;
					return 0.0;
       	
		case "+"  : return (num1 + num2);
		
		case "-"  : return (num1 - num2); 
		
		case "*"  : return (num1 * num2); 
		
		case "/"  : if(num2 == 0)
						throw new AssertionError("Can't divide by zero");
					return (num1 / num2);
					
		case "%"  : if(num2 == 0)
						throw new AssertionError("Can't divide by zero");
					return (num1 % num2);
					
		case "^"  : return Math.pow(num1, num2);
       
		case "!"  : if ( (num1 != 0 || num1 != 1) )
						throw new AssertionError("Invalid numbers");
					if (num1 == 0)
						return 1.;
					return 1.;
					
		default : throw new AssertionError("Invalid choice");
		}
	}
		
	/**
	 * method to convert infix expression into postfix expression
	 * @param infix
	 * @return -> postfix expression
	 */
	public String infixTOPostfix(String infix){
		Stack<String> stack = new Stack<String>(); 
		if(infix.length() == 0)
	            throw new AssertionError("Invalid Input!");
		 
		 String[] tokens = infix.trim().split(" ");
		 String postfix = "";
		 
		 for (String token : tokens) {
			 if (isNumber(token)){
	             postfix += token + " ";
	         }
			 else if("(".equals(token)){
				 stack.push(token);
	         }
	         else if(")".equals(token)) {
	        	 while(!("(".equals(stack.peek()))){
	        		 postfix += (stack.pop() + " ");
	             }
	             stack.pop();
	         }
	         else if(isOperator(token)){
	        	 if(stack.isEmpty() || "(".equals(stack.peek()) || precedence(token) > precedence(stack.peek())){
	        		 stack.push(token);
	        	 }
	             else{
	                 while(!stack.isEmpty() && !("(".equals(stack.peek())) && precedence(token) <= precedence(stack.peek())){
	                	 postfix += stack.pop() +" ";
	                 }
	                 stack.push(token);
	             }
	         }
	         
		 }
	     while(!stack.isEmpty()){
	            postfix += stack.pop() + " ";
	     }
	   
	     return postfix.trim();
	}
	
	/**
	 * method to check if token is Number
	 * @param token
	 * @return -> true if token is Number else false
	 */
	public boolean isNumber(String token){
		char[] tokenArray = token.toCharArray();
		for (int index = 0 ; index < token.length(); index++){
			if (tokenArray[index] >= '0' && tokenArray[index] <= '9')
				continue;
			else
				return false;
		}
		return true;
	}
	
	/**
	 * method to evaluate posfix expression
	 * @param postfix
	 * @return -> result of evaluation
	 */
	public Double evaluatePostfix(String postfix) {
		Stack<Double> operands = new Stack<Double>();
		String[] tokens = postfix.split(" ");
		for (String token : tokens) {
			if(isNumber(token)) { 
				operands.push(Double.parseDouble(token));
			}
			else{
				Double num2 = operands.pop();
				Double num1 = operands.pop();
				operands.push(performOperation(num1, num2 , token));
			}
			
		}
		return operands.pop();
	}
	
	/**
	 * method to evaluate infix expression
	 * @param infix
	 * @return -> result of evaluation
	 */
    public Double calculate(String infix) { 
       Stack<Double> nums = new Stack <Double>();
       Stack<String> operator = new Stack<String>(); 
       String[] tokens = infix.trim().split(" ");
       
       for (String token : tokens){
    	   if (isNumber(token)) 
    		   nums.push(Double.parseDouble(token));
           else if (token.equals("(")) 
        	   operator.push(token);
           else if (token.equals(")")){
        	   
               while (!operator.peek().equals("(")){
            	   Double num2 = nums.pop();
            	   Double num1 = nums.pop();
                   nums.push(performOperation(num1,num2,operator.pop()));
               }
               operator.pop();
           }
           else {
               while (!operator.isEmpty() &&  !operator.peek().equals("(")){
            	  Double num2 = nums.pop();
   				  Double num1 = nums.pop();
                  nums.push(performOperation(num1,num2,operator.pop()));
               }
               operator.push(token);
           }
       }
       while (!operator.isEmpty()){
    	   Double num2 = nums.pop();
    	   Double num1 = nums.pop();
           nums.push(performOperation(num1,num2,operator.pop()));
       }
       return nums.pop();
    }
   
	/**
	 * method to evaluate infix expression by converting it into postfix expression
	 * @param infix
	 * @return -> result of evaluation
	 */
	public Double evaluateInfixExpression(String infix){
		String postfix = infixTOPostfix(infix);
		return evaluatePostfix(postfix);
	}
	
   public static void main(String[] args){
   	InfixExpression i = new InfixExpression();
   	System.out.println(i.evaluateInfixExpression("1 + ( 3 * ( 4 / 2 ) ) - ( 4 / 2 ) + ( 2 ^ 3 ) "));
   	System.out.println(i.calculate("1 + ( 3 * ( 4 / 2 ) ) - ( 4 / 2 ) + ( 2 ^ 3 ) "));
   }
}
