package Assignment1_DSA;

import java.util.Scanner;

/**
 * class implements multivariate polynomial using nested linked list
 * @author ankit.saini_metacube
 *
 */
public class Polynomial2 {
	public PolyNode polyHead , polyLast ;
	public int size = 0;
	
	/**
	 * method to add polynomial term in Linked list PolyNode by sing nested linked list of term node
	 * @param term -> single term of polynomial in string
	 * @param sign -> 1 if term is positive else -1
	 */
	public void addPolynomialTerm(String term , int sign){
		int indexOfTerm = 0;
		String number = "";
		PolyNode polyNode ;
		//inserting coefficient in PolyNode
		if (term.charAt(indexOfTerm) >= '1' && term.charAt(indexOfTerm) <= '9'){
			while( (indexOfTerm < term.length()) && (term.charAt(indexOfTerm ) >= '0' && term.charAt(indexOfTerm) <= '9')){
				number += term.charAt(indexOfTerm);
				indexOfTerm += 1;
			}
			polyNode = new PolyNode( Integer.parseInt(number) * sign );
			number = "";
		}
		
		else {
			polyNode = new PolyNode(1 * sign);
		}	
		size += 1;
		
		//inserting TermNodeList in PolyNode
		TermNodeList termNodeList = new TermNodeList();
		while(indexOfTerm < term.length()){
			if ( (term.charAt(indexOfTerm) >= 'a' && term.charAt(indexOfTerm) <= 'z' ) ||  (term.charAt(indexOfTerm) >= 'A' && term.charAt(indexOfTerm) <= 'Z' )){
				char var = term.charAt(indexOfTerm);
				if( ((indexOfTerm + 1) < term.length()) && term.charAt(indexOfTerm + 1) == '^'){
					indexOfTerm += 2;
					while( (indexOfTerm < term.length()) && ( term.charAt(indexOfTerm ) >= '0' && term.charAt(indexOfTerm) <= '9') ){
						number += term.charAt(indexOfTerm);
						indexOfTerm += 1;
					}
					indexOfTerm -= 1;
					termNodeList.insert(var, Integer.parseInt(number)); 
					number ="";
				}
				else {
				termNodeList.insert(term.charAt(indexOfTerm),1);
				}
			}
			else{
				continue;
			}
			indexOfTerm += 1;
		}
		
		polyNode.termNodeList = termNodeList;
		
		if(polyHead == null){
			polyHead = polyNode;
			polyLast = polyNode;
			return ;
		}
		polyLast.next = polyNode;
		polyLast = polyLast.next;
	}
	
	/**
	 * method for printing polynomial
	 */
	public void showPolynomial(){
		if(polyHead == null){
			System.out.print("no term in polynomial");
			return;
		}
		PolyNode currNode = polyHead;
		
		while (currNode != null){
			System.out.print(currNode.coeff);
			currNode.termNodeList.printTermNode();;
			if (currNode.next != null){
				System.out.printf(" + ");
			}
			currNode = currNode.next;
		}
	}
	
	/**
	 * method for computing degree of polynomial  
	 * @return -> integer , degree of polynomial
	 */
	public int degree(){
		int tempDegree = 0,degree = 0;
		PolyNode currPolyNode = polyHead;
		TermNode currTermNode;
		while( currPolyNode != null){
			currTermNode = currPolyNode.termNodeList.getHead();
			while (currTermNode != null){
				tempDegree += currTermNode.degree;
				currTermNode = currTermNode.next;
			}
			if(tempDegree > degree){
				degree = tempDegree;
			}
			currPolyNode = currPolyNode.next;
			tempDegree = 0;
		}
		return degree;
	}
	
	/**
	 * method to create polynomial
	 * @return -> polynomial of Polynomial2 type
	 * 1000X^100Y^20Z^30 + 20X^12Y^3 + 5Y^4Z + X + Y + Z + 1 -> can use as input polynomial which is string
	 */
	public static Polynomial2 createPoly2(){
		Scanner scan = new Scanner(System.in);
		Polynomial2 poly = new Polynomial2();
		System.out.print("enter polynomial : ");
		String polyString = scan.nextLine();
		polyString = polyString.replaceAll("\\s", ""); 
		if (polyString.length() == 0) {
			System.out.print("no polynomial entered");
		}
		
		String currTerm = "";
		int sign = 1;
		for (int indexOfString = 0 ; indexOfString < polyString.length() ; indexOfString++){
			
			if( polyString.charAt(indexOfString) == '-'){
				poly.addPolynomialTerm(currTerm , sign);
				sign = -1;
				currTerm = "";
			}
			else if (polyString.charAt(indexOfString) == '+'){
          		poly.addPolynomialTerm(currTerm , sign);
				sign = 1;
				currTerm = "";
			}
			else {
				currTerm += polyString.charAt(indexOfString);
			}
		}
		poly.addPolynomialTerm(currTerm , sign);
		return poly;
	}
	
	public static void main(String[] args){
		Polynomial2 poly = createPoly2();
		
		System.out.println("Polynomial is :");
		poly.showPolynomial();
		
		System.out.println("Degree of Polynomial : "+poly.degree());
		
	}
}

