package Assignment1_DSA;

import java.util.Scanner;

public class Polynomial2 {
	public PolyNode polyHead , polyLast ;
	public int size = 0;
	
	public void addPolynomialTerm(String term , int sign){
		int indexOfTerm = 0;
		String number = "";
		PolyNode polyNode ;
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
//		System.out.print(indexOfTerm);
//		System.out.print(polyNode.coeff);
		
		size += 1;
		
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
//			System.out.print(polyHead.coeff);
			return ;
		}
		polyLast.next = polyNode;
		polyLast = polyLast.next;
	}
	
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
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		Polynomial2 poly = new Polynomial2();
		System.out.print("enter polynomial : ");
		String polyString = scan.nextLine();
		polyString = polyString.replaceAll("\\s", ""); 
		

//		poly.addPolynomialTerm("5x^2y^2", 1);
//		poly.addPolynomialTerm("5xy", 1);
//		poly.addPolynomialTerm("5", 1);
//		poly.addPolynomialTerm("5", 1);
//		poly.addPolynomialTerm("5", 1);
//		poly.showPolynomial();
//		System.out.println(poly.polyHead.coeff);
		System.out.println(polyString);
		
		
		String currTerm = "";
		int sign = 1;
		for (int indexOfString = 0 ; indexOfString < polyString.length() ; indexOfString++){
			
			if( polyString.charAt(indexOfString) == '-'){
//				System.out.println(currTerm);
				poly.addPolynomialTerm(currTerm , sign);
				sign = -1;
				currTerm = "";
			}
			else if (polyString.charAt(indexOfString) == '+'){
//				System.out.println(currTerm);
				poly.addPolynomialTerm(currTerm , sign);
				sign = 1;
				currTerm = "";
			}
			else {
				currTerm += polyString.charAt(indexOfString);
			}
		}
//		System.out.println(currTerm);
		poly.addPolynomialTerm(currTerm , sign);
		poly.showPolynomial();
		
		System.out.println(poly.degree());
		
	}
}
//1000X^100Y^20z^30 + 20X^12Y^3 + 5Y^4Z + X + Y + Z + 1
