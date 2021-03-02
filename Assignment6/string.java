package Assignment6;

public class string {
	public static boolean compare(String str1 , String str2){
		if ( str1.length() == str2.length() ){
			for (int i = 0 ; i < str1.length() ; i++ ) {
				if (str1.charAt(i) != str2.charAt(i) ){
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	public static String reverse(String str){
		int len = str.length();
		char temp;
		char[] tempCharArray = str.toCharArray(); 
		for (int i = 0 ; i < (int) (len / 2) ; i++ ){
			temp = tempCharArray[i];
			tempCharArray[i] = tempCharArray[len - i - 1];
			tempCharArray[len - i - 1] = temp;
		}
		return new String(tempCharArray);
	}
	
	public static String reverseCase(String str){
		int len = str.length();
		char[] tempCharArray = str.toCharArray(); 
		for (int i = 0 ; i < len  ; i++ ){
			if (tempCharArray[i] >= 'a' && tempCharArray[i] <= 'z' ){
				tempCharArray[i] = (char)(tempCharArray[i] - 32);
			}
			else if (tempCharArray[i] >= 'A' && tempCharArray[i] <= 'Z' ){
				tempCharArray[i] = (char) (tempCharArray[i] + 32);
			}
			else {
				System.out.println("Not a Alphabate");
			}
		}
		return new String(tempCharArray);
	}
	
	
	public static String largestWordInString(String str){
		int maxLength = 0;
		String wordWithMaxLength = "";
		String[] words = str.split("\\s+");
		
		for ( String word : words){
			if( word.length() >= maxLength) {
				maxLength = word.length();
				wordWithMaxLength = word;
			}
		}
		return wordWithMaxLength;
	}
	
}
