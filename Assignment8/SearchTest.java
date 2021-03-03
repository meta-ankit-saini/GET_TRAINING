package Assignment8;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for Search
 * @author ankit.saini_metacube
 *
 */
public class SearchTest {
	Search search = new Search();
	
	/**
	 * Test Class for testing Linear Search
	 */
	@Test
	 public void testLinearSearch1() {
		
        int indexResult1 = search.linearSearch(new int[]{11, 12, 17, 13, 14, 15}, 0, 5 , 11);
        assertEquals(0, indexResult1);
        
        int indexResult2 = search.linearSearch(new int[]{11, 12, 17, 13, 14, 15}, 0, 5 , 15);
        assertEquals(5, indexResult2);
        
        int indexResult3 = search.linearSearch(new int[]{11, 12, 17, 12, 14, 15}, 0 ,5, 17);
        assertEquals(2, indexResult3);
        
        int indexResult4 = search.linearSearch(new int[]{11, 12, 17, 12, 14, 15}, 0 ,5, 10);
        assertEquals(-1, indexResult4);
	}
	
	/**
	 * Test Class for testing Binary Search
	 */
	@Test
	 public void testBinarySearch1() {
		
       int indexResult1 = search.binarySearch(new int[]{1, 3, 5, 7, 10, 11}, 0, 5, 7);
       assertEquals(3, indexResult1);
       
       int indexResult2 = search.binarySearch(new int[]{1, 3, 5, 7, 10, 11}, 0, 5, 1);
       assertEquals(0, indexResult2);
       
       int indexResult3 = search.binarySearch(new int[]{1, 3, 5, 7, 10, 11}, 0, 5, 11);
       assertEquals(5, indexResult3);
       
       int indexResult4 = search.binarySearch(new int[]{1, 3, 5, 7, 10, 11}, 0, 5, 13);
       assertEquals(-1, indexResult4);
   }

}
