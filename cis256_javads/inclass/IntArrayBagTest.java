package inclass;

import junit.framework.TestCase;

public class IntArrayBagTest extends TestCase{

	IntArrayBag bag1;
	
	protected void setUp() throws Exception {
		bag1 = new IntArrayBag();
		bag1.add(5);
		bag1.add(5);
		bag1.add(7);
		
	}
	
	
	public void testSample1() {
		assertEquals(3, bag1.size());
		
		assertEquals(5, bag1.getNextItem());
		assertEquals(5, bag1.getNextItem());
		assertEquals(7, bag1.getNextItem());
		bag1.reset();
		assertEquals(5, bag1.getNextItem());
		assertEquals(5, bag1.getNextItem());
		bag1.reset();
		assertEquals(5, bag1.getNextItem());
		assertEquals(5, bag1.getNextItem());
		assertEquals(7, bag1.getNextItem());
//		assertEquals(7, bag1.getNextItem());

		bag1.remove(5);
		
		assertEquals(2, bag1.size());

		
		
	}
	
	
	
	
}
