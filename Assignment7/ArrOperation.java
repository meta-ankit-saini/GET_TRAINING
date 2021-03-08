package Assignment7;
public class ArrOperation {
	
	public int sumOfArray(int[] arr ){
		int sum = 0;
		for(int indexOfArray = 0; indexOfArray < arr.length; indexOfArray++){
			sum += arr[indexOfArray];
		}
		return sum;
	}
	
	public int maxMirror(int[] arr){
		if(arr.length == 0 ){
			throw new AssertionError("Empty Array") ;
		}
		int maxMirrorSize = 0 ,mirrorSize;
		for (int indexFromLeft = 0 ; indexFromLeft < arr.length ; indexFromLeft++){
			mirrorSize = 0;
			for (int indexFromRight = arr.length - 1 ; indexFromRight >= 0 && indexFromRight >= indexFromLeft ; indexFromRight--){
				if(arr[indexFromLeft + mirrorSize] == arr[indexFromRight]){
					mirrorSize += 1;
				}
				else {
					if (mirrorSize > maxMirrorSize){
						maxMirrorSize = mirrorSize;
					}
					mirrorSize = 0;
				}
			
			}
			if (mirrorSize > maxMirrorSize){
				maxMirrorSize = mirrorSize;
			}
		}
		return maxMirrorSize;
	}
	

	
	public int countClumps(int[] arr){
		if(arr.length == 0 ){
			throw new AssertionError("Empty Array") ;
		}
		int noOfClumps = 0, currElement = arr[0], currElementCount = 1;
		for (int indexOfArray = 1 ; indexOfArray < arr.length ; indexOfArray++  ){
			if (arr[indexOfArray] == currElement){
				currElementCount += 1;
			}
			else {
				if(currElementCount >= 2){
					noOfClumps += 1;
				}
				currElement = arr[indexOfArray];
				currElementCount = 1;
			}
		}
		if(currElementCount >= 2){
			noOfClumps += 1;
		}
		return noOfClumps;
	}
	
	public int[] fixXY(int[] arr, int X, int Y) {
		
		if(arr.length == 0 ){
			throw new AssertionError("Empty Array") ;
		}
		if (arr[arr.length-1] == X){
			throw new AssertionError("X at last index of Array") ;
		}
		int noOfX = 0 , noOfY = 0;
		for(int indexOfArraay = 0 ; indexOfArraay < arr.length  ; indexOfArraay++){
			if(arr[indexOfArraay] == X && arr[indexOfArraay + 1] == X){
				throw new AssertionError("Adjacent X in Array") ;
			}
			
			if (arr[indexOfArraay] == X){
				noOfX += 1 ;
			}
			else if (arr[indexOfArraay] == Y){
				noOfY += 1;
			}
			else {
				continue;
			}
		}
		System.out.println(noOfX);
		System.out.println(noOfY);
		if (noOfX != noOfY){
			throw new AssertionError("Unequal Number of X abd Y") ;
		}
		
		for(int indexOfY = 0 ; indexOfY < arr.length  ; indexOfY++){
			if( arr[indexOfY] == Y && (indexOfY == 0 || arr[indexOfY-1] != X )){
				for( int indexOfX = 0 ; indexOfX < arr.length ; indexOfX ++ ){
					if(arr[indexOfX] == X && arr[indexOfX + 1] != Y ){
						int temp = arr[indexOfX + 1];
						arr[indexOfX + 1] = arr[indexOfY];
						arr[indexOfY] = temp;
						break;
					}
				}
			}
		}
		return arr;
	}
	
	public int splitArray(int[] arr) {
		if(arr.length == 0){
			throw new AssertionError("Empty Array") ;
		}
		int sum =0,  arraySum = sumOfArray(arr);
		for(int indexOfArray = 0; indexOfArray < arr.length; indexOfArray++){
			sum += arr[indexOfArray];
			if( sum == arraySum - sum){
				return indexOfArray + 1;
			}
			else if (sum > arraySum){
				return -1;
			}
			else {
				continue;
			}
		}
		return -1;
	}
	
}
