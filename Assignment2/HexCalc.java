package Assignment2;
import java.util.Scanner;

public class HexCalc {
	/**
	 * function to convert HexDecimal value into Decimal Value
	 * @param hex -> hexadecimal value
	 * @return -> decimal value
	 */
	public static int HexaDecimalToDecimal(String hex){
		int len = hex.length();
		int base = 1 , decimal = 0; 
		for (int i = len-1; i >= 0 ; i-- ){
			if ( hex.charAt(i) >= '0' &&  hex.charAt(i) <= '9' ) {
				decimal += (  hex.charAt(i) - 48 ) * base;
			}
			else if (hex.charAt(i) >= 'A' && hex.charAt(i) <= 'F' ) {
				decimal += ( hex.charAt(i) - 55 ) * base;
			}
			base *= 16;
		}
		return decimal;
	}
	
	/**
	 * function to convert Decimal value into HexaDecimal value
	 * @param decimal
	 * @return -> HexaDecimal Value
	 */
	public static String DecimalToHexaDecimal(int decimal){
		String hex = "";
		int reminder;
		
		while(decimal > 0){
			reminder = decimal % 16;
			if (reminder < 10 ){
				hex = (char) ( reminder + 48 ) + hex;
			}
			else {
				hex = (char) ( reminder + 55 ) + hex;
			}
			decimal = decimal / 16;
		}
		return hex;
	}
	/**'
	 * function to add two HexaDecimal Value
	 * @param hex1
	 * @param hex2
	 * @return -> HexaDecimal Value after addition
	 */
	public static String addHexaDecimal(String hex1 , String hex2){ 
		int tempResult;
		String finalResult;
		tempResult =  HexaDecimalToDecimal(hex1) + HexaDecimalToDecimal(hex2);
		finalResult = DecimalToHexaDecimal(tempResult);
		return finalResult;
	}
	
	/**
	 * function to subtract two HexaDecimal Value
	 * @param hex1
	 * @param hex2
	 * @return
	 */
	public static String subtractHexaDecimal(String hex1 , String hex2){ 
		int tempResult;
		String finalResult;
		tempResult =  HexaDecimalToDecimal(hex1) - HexaDecimalToDecimal(hex2);
		finalResult = DecimalToHexaDecimal(tempResult);
		return finalResult;
	}
	
	/**
	 * function to multiply two HexaDecimal Value
	 * @param hex1
	 * @param hex2
	 * @return
	 */
	public static String multiplyHexaDecimal(String hex1 , String hex2){ 
		int tempResult;
		String finalResult;
		tempResult =  HexaDecimalToDecimal(hex1) * HexaDecimalToDecimal(hex2);
		finalResult = DecimalToHexaDecimal(tempResult);
		return finalResult;	
	}
	
	/**
	 * function to add divide HexaDecimal Value
	 * @param hex1
	 * @param hex2
	 * @return
	 */
	public static String divideHexaDecimal(String hex1 , String hex2){ 
		if (hex2.equals("0")){
			return "Not Possible";
		}
		int tempResult;
		String finalResult;
		tempResult =  HexaDecimalToDecimal(hex1) / HexaDecimalToDecimal(hex2);
		finalResult = DecimalToHexaDecimal(tempResult);
		return finalResult;
	}
	
	/**
	 * function to check hex1 == hex2
	 * @param hex1
	 * @param hex2
	 * @return
	 */
	public static boolean isEqual(String hex1 , String hex2){
		return hex1.equals(hex2);
	}
	
	/**
	 * function to check hex1 > hex2
	 * @param hex11
	 * @param hex2
	 * @return
	 */
	public static boolean isGratterThan(String hex1 , String hex2){
		if (hex1.length() > hex2.length()){
			return true;
		}
		else if (hex1.length() < hex2.length()){
			return false;
		}
		else{
			for (int i = hex1.length() - 1; i > 0; i-- ){
				if ( hex1.charAt(i) > hex2.charAt(i) ){
					return true;
				}
				if ( hex1.charAt(i) < hex2.charAt(i) ){
					return false;
				}
			}
			return false;
		}
	}
	
	/**
	 * function to check if hex1 < hex2
	 * @param hex1
	 * @param hex2
	 * @return
	 */
	public static boolean isLessThan(String hex1 , String hex2){
		if (hex1.length() < hex2.length()){
			return true;
		}
		else if (hex1.length() > hex2.length()){
			return false;
		}
		else{
			for (int i = hex1.length() - 1; i > 0; i-- ){
				if ( hex1.charAt(i) < hex2.charAt(i) ){
					return true;
				}
				if ( hex1.charAt(i) > hex2.charAt(i) ){
					return false;
				}
			}
			return false;
		}
	}
	
	public static boolean isHexaDecimal(String hex) {
		int len = hex.length();
		for (int i = len-1; i >= 0 ; i-- ){
			if ( hex.charAt(i) >= '0' &&  hex.charAt(i) <= '9' ) {
			}
			else if (hex.charAt(i) >= 'A' && hex.charAt(i) <= 'F' ) {
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	public static String inputHexaDecimal(Scanner scan ) {
		String hex;
		hex = scan.next();
		if ( !isHexaDecimal(hex) ) {
			System.out.println("not a HexaDecimal number enter again : ");
			hex = scan.next();
		}
		return hex;
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String hex1,hex2;
		System.out.println("enter two hexadecimal numbers : ");
		hex1 = inputHexaDecimal(scan );
		hex2 = inputHexaDecimal(scan );
		char operation = 'a';
	
		while (operation != 'x'){
			System.out.println("enter + for addition - for subtraction * for multiplication and / for devision and x for close : ");
			operation = scan.next().charAt(0);
			if (operation == '+'){
				System.out.println(addHexaDecimal(hex1,hex2));
			}
			else if (operation == '-'){
				System.out.println(subtractHexaDecimal(hex1,hex2));
			}
			else if (operation == '*'){
				System.out.println(multiplyHexaDecimal(hex1,hex2));
			}
			else if (operation == '/'){
				System.out.println(divideHexaDecimal(hex1,hex2));
			}
			else if (operation == 'x'){
				System.out.println("calculator closed");
			}
			else {
				System.out.println("Invalid Choice");
			}
		}
		
		
		System.out.println(isGratterThan(hex1,hex2));
		System.out.println(isLessThan(hex1,hex2));
		System.out.println(isEqual(hex1,hex2));
	}
	
	
}
