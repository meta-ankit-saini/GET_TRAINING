package Assignment9;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test Class For Screen
 * @author ankit.saini_metacube
 *
 */
public class TestScreen {

	@Test
	public void testScreen() {
		
		Shape c1 = ShapeFactory.createShape("Circle", new Point(30., 30.),new int[] {20} );
		Shape c2 = ShapeFactory.createShape("Circle", new Point(60., 60.),new int[] {30} );
		Shape s1 = ShapeFactory.createShape("Square", new Point(160., 160.),new int[] {30} );
		Shape s2 = ShapeFactory.createShape("Square", new Point(70., 70.),new int[] {50} );
		
		
		Screen screen = new Screen();
		
		assertEquals(true,screen.addShape(c1));
		assertEquals(true,screen.addShape(s1));
		assertEquals(true,screen.addShape(c2));
		assertEquals(true,screen.addShape(s2));
		
		
		assertEquals(true,screen.deleteShape(c1));
		assertEquals(false,screen.deleteShape(c1));
		
		screen.deleteAllShapesOfSpecificType("Circle");
		screen.deleteAllShapesOfSpecificType("Square");
		assertEquals(0,screen.countShapeOfSpecificType("Circle"));
		assertEquals(0,screen.countShapeOfSpecificType("Square"));
		
	}
	
	
	/**
	 * Test method For  Exception in addShape()
	 */
	@Test(expected = AssertionError.class)
	public void addShapeException(){
		Screen screen = new Screen();
		
		screen.addShape(null);
	}
	
	/**
	 * Test method for  Exception in deleteShape() 
	 */
	@Test(expected = AssertionError.class)
	public void deleteShapeException(){
		Screen screen = new Screen();
		
		screen.deleteShape(null);
	}
	
	/**
	 * Test method For  Exception in getShapesEnclosingAPoint() 
	 */
	@Test(expected = AssertionError.class)
	public void getShapesEnclosingAPointException(){
		Screen screen = new Screen();
		
		screen.getShapesEnclosingAPoint(null);
	}

	/**
	 * Test methods For  Exception in deleteShapesOfSpecificType() 
	 */
	@Test(expected = AssertionError.class)
	public void deleteShapesOfSpecificTypeException(){
		Screen screen = new Screen();
		
		screen.deleteAllShapesOfSpecificType(null);
	}

}
