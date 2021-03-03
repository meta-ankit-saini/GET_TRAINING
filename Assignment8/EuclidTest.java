package Assignment8;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test Class for Euclid
 * @author ankit.saini_metacube
 *
 */
public class EuclidTest {
	Euclid euclid = new Euclid();
	/**
	 * test for LCM
	 */
	@Test
	public void testLCM() {
    	
    	int lcmResult1 = euclid.lcm(30, 40);
	    assertEquals(120, lcmResult1);
	    
	    int lcmResult2 = euclid.lcm(10, 20);
	    assertEquals(20, lcmResult2);
	    
	    int lcmResult3 = euclid.lcm(1, 10);
	    assertEquals(10, lcmResult3);
	    
	    int lcmResult4 = euclid.lcm(0, 10);
	    assertEquals(0, lcmResult4);  
	}
	
	/**
	 * test for HCF
	 */
	@Test
	public void testHCF() {
		
	    int hcfResult1 = euclid.gcd(18, 9);
	    assertEquals(9, hcfResult1);
	    
	    int hcfResult2 = euclid.gcd(8, 32);
	    assertEquals(8, hcfResult2);
	    
	    int hcfResult3 = euclid.gcd(10, 10);
	    assertEquals(10, hcfResult3);
	    
	    int hcfResult4 = euclid.gcd(0, 40);
	    assertEquals(40, hcfResult4);
	}

}
