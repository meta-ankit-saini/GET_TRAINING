package Assignment8;

import java.util.Scanner;

/**
 * This class can be used for GCD and HCF computation
 * @author ankit.saini_metacube
 *
 */
public class Euclid {
	
	/**
	 * Computes HCF/GCD of Two numbers
	 * @param firstNumber
	 * @param secondNumber
	 * @return -> HCF/GCD of firstNumber and secondNumber
	 */
	public static int gcd(int firstNumber, int secondNumber){
		if (secondNumber == 0){
			return firstNumber;
		}
		return gcd( secondNumber , firstNumber % secondNumber );
	}
	
	/**
	 * Computes LCM of Two numbers
	 * @param firstNumber
	 * @param secondNumber
	 * @return -> LCM of firstNumber and secondNumber
	 */
	public static int lcm(int firstNumber, int secondNumber){
		return (firstNumber * secondNumber) / gcd(firstNumber , secondNumber );
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int firstNumber , secondNumber;
		System.out.println("enter two numbers");
		firstNumber = scan.nextInt();
		secondNumber = scan.nextInt();
		System.out.println("lcm = "+lcm(firstNumber, secondNumber));
		System.out.println("gcd = "+gcd(firstNumber, secondNumber));
	}
}
