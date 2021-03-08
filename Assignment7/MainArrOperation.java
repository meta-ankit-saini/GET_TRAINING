package Assignment7;

public class MainArrOperation {
	public static void main(String []args){
		ArrOperation arrOperation = new ArrOperation();
//		System.out.println("Enter");
		int[] arr = {1, 2, 3, 8, 9, 3, 2, 1};
		System.out.print(arrOperation.maxMirror(arr));
		int[] arr2 = {1, 1 ,1, 1, 1, 1};
		System.out.print(arrOperation.countClumps(arr2));
		int[] arr3 = {5, 4, 9, 4, 9, 5};
		System.out.print(arrOperation.fixXY(arr3, 4, 5));
		int[] arr4 = {1, 1, 1, 2, 1};
		System.out.print(arrOperation.splitArray(arr4));
	}
}
