package Assignment3;

import java.util.Scanner;

public class MainPoly {
	/**
	 * method for taking input for polynomial
	 * @return matrix representing polynoomial
	 */
	public static int[][] createPoly(){
		Scanner scan = new Scanner(System.in);
		int noOfTerms ;
		
		System.out.println("Enter no of terms in polynomial : ");
		noOfTerms = scan.nextInt();
		int[][] poly = new int[noOfTerms][2];
				
		for (int i = 0 ; i < noOfTerms ; i++){
			System.out.println("Enter degree : ");
			poly[i][0] = scan.nextInt();
			System.out.println("Enter coefficient : " );
			poly[i][1] = scan.nextInt();
		}
		return poly;
	}
	
	public static void main(String[] args){
		int[][] pA = createPoly();
		int[][] pB =  createPoly();
		Poly p1 = new Poly(pA);
		Poly p2 = new Poly(pB);
		System.out.println("poly 1 ");
		p1.printPoly();
		System.out.println("poly 2 ");
		p2.printPoly();
		System.out.println( "value of poly2 at 1.8 : " + p2.evaluate(1.8));
		System.out.println("degree of poly1 : "+p1.degree());
		
		System.out.println("Addition result : ");
		p1.addPoly(p2).printPoly();
		
		System.out.println("multiplication result : ");
		p1.multiplyPoly(p2).printPoly();;
	}
}
