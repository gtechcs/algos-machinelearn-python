package cis256.proj5;

import junit.framework.TestCase;

public class IntTreeBagJUnitTest extends TestCase{

	
	public void test1() {
		IntTreeBag intTreeBag = new IntTreeBag();
	   	intTreeBag.add(78);
	   	intTreeBag.add(101);
	   	intTreeBag.add(79);
	   	
//		System.out.println(intTreeBag.countOccurrences(78));
//		System.out.println(intTreeBag.countOccurrences(101));
	
//		intTreeBag.print();
	   	assertEquals(intTreeBag.countOccurrences(78), 1);
	   	assertEquals(intTreeBag.countOccurrences(101), 1);
	}	
	
	public void test2() {
		IntTreeBag intTreeBag = new IntTreeBag();
	   	intTreeBag.add(5);
	   	intTreeBag.add(4);
	   	intTreeBag.add(4);
	   	intTreeBag.add(4);
	   	
//		System.out.println(intTreeBag.countOccurrences(4));
//		System.out.println(intTreeBag.countOccurrences(101));
	
//		intTreeBag.print();
	   	assertEquals(intTreeBag.countOccurrences(4), 3);
	   	assertEquals(intTreeBag.countOccurrences(101), 0);
	   	assertEquals(intTreeBag.countOccurrences(5), 1);
	}	

	public void test3() {
		IntTreeBag intTreeBag = new IntTreeBag();
	   	intTreeBag.add(5);
	   	intTreeBag.add(4);
	   	intTreeBag.add(4);
	   	intTreeBag.add(4);
	   	intTreeBag.add(6);
	   	intTreeBag.add(8);
	   	intTreeBag.add(7);
	   	intTreeBag.add(9);
	   	intTreeBag.add(10);
	   	
//		System.out.println(intTreeBag.countOccurrences(4));
//		System.out.println(intTreeBag.countOccurrences(101));
	
//		intTreeBag.print();
	   	assertEquals(intTreeBag.countOccurrences(4), 3);
	   	assertEquals(intTreeBag.countOccurrences(101), 0);
	   	assertEquals(intTreeBag.countOccurrences(5), 1);
	}	

	public void test4() {
		IntTreeBag intTreeBag = new IntTreeBag();
	   	intTreeBag.add(5);
	   	intTreeBag.add(4);
	   	intTreeBag.add(6);
	   	intTreeBag.add(8);
	   	
//		System.out.println(intTreeBag.countOccurrences(4));
//		System.out.println(intTreeBag.countOccurrences(101));
	
//		intTreeBag.print();
	   	assertEquals(intTreeBag.countOccurrences(4), 1);
	}	

	
	public void test6() {
		IntTreeBag intTreeBag = new IntTreeBag();
	   	intTreeBag.add(4);
	   	intTreeBag.add(2);
	   	intTreeBag.add(3);
	   	intTreeBag.add(7);
	   	intTreeBag.add(8);
	   	intTreeBag.add(6);

//	   	intTreeBag.print();
	   	assertEquals(intTreeBag.countOccurrences(4), 1);
	}
	
	public void test7() {
		IntTreeBag intTreeBag = new IntTreeBag();
	   	intTreeBag.add(4);
	   	intTreeBag.add(2);
	   	intTreeBag.add(3);

//	   	intTreeBag.print();
	   	intTreeBag.remove(4);
//	   	intTreeBag.print();
	   	assertEquals(intTreeBag.countOccurrences(4), 0);
	}
	
	public void test8() {
		IntTreeBag intTreeBag = new IntTreeBag();
	   	intTreeBag.add(4);
	   	intTreeBag.add(2);
	   	intTreeBag.add(3);

//	   	intTreeBag.print();
	   	intTreeBag.remove(2);
//	   	intTreeBag.print();
	   	assertEquals(intTreeBag.countOccurrences(4), 1);
	   	assertEquals(intTreeBag.countOccurrences(2), 0);
	}
	
	public void test9() {
		IntTreeBag intTreeBag = new IntTreeBag();
	   	intTreeBag.add(4);

	   	intTreeBag.print();
	   	intTreeBag.remove(2);
	   	intTreeBag.print();
	   	assertEquals(intTreeBag.countOccurrences(4), 1);
	   	assertEquals(intTreeBag.countOccurrences(2), 0);
	}
	
	public void test10() {
		IntTreeBag intTreeBag = new IntTreeBag();
	   	intTreeBag.add(4);

//	   	intTreeBag.print();
	   	intTreeBag.remove(4);
//	   	intTreeBag.print();
	   	assertEquals(intTreeBag.countOccurrences(4), 0);
	   	assertEquals(intTreeBag.countOccurrences(2), 0);
	}

	public void test11() {
		IntTreeBag intTreeBag = new IntTreeBag();
	   	intTreeBag.add(4);
	   	intTreeBag.add(2);

//	   	intTreeBag.print();
	   	intTreeBag.remove(4);
//	   	intTreeBag.print();
	   	assertEquals(intTreeBag.countOccurrences(4), 0);
	   	assertEquals(intTreeBag.countOccurrences(2), 1);
	}

	public void test12() {
		IntTreeBag intTreeBag = new IntTreeBag();
	   	intTreeBag.add(4);
	   	intTreeBag.add(2);
	   	intTreeBag.add(5);

//	   	intTreeBag.print();
	   	intTreeBag.remove(4);
//	   	intTreeBag.print();
	   	assertEquals(intTreeBag.countOccurrences(4), 0);
	   	assertEquals(intTreeBag.countOccurrences(2), 1);
	}

	public void test13() {
		IntTreeBag intTreeBag = new IntTreeBag();
	   	intTreeBag.add(4);
	   	intTreeBag.add(2);
	   	intTreeBag.add(1);
	   	intTreeBag.add(5);

//	   	intTreeBag.print();
	   	intTreeBag.remove(4);
//	   	intTreeBag.print();
	   	assertEquals(intTreeBag.countOccurrences(4), 0);
	   	assertEquals(intTreeBag.countOccurrences(2), 1);
	}


	public void test14() {
		IntTreeBag intTreeBag = new IntTreeBag();
	   	intTreeBag.add(5);
	   	intTreeBag.add(4);

		IntTreeBag intTreeBag2 = new IntTreeBag();
		intTreeBag2.addAll(intTreeBag);
		
	   	assertEquals(intTreeBag2.countOccurrences(4), 1);
	   	assertEquals(intTreeBag2.countOccurrences(5), 1);
	}

	/**
	 */
	public void test15() {
		IntTreeBag intTreeBag = new IntTreeBag();
	   	intTreeBag.add(5);
	   	intTreeBag.add(4);

		IntTreeBag intTreeBag2 = new IntTreeBag();
	   	intTreeBag2.add(5);
	   	intTreeBag2.add(4);
		intTreeBag2.addAll(intTreeBag);

		System.out.println("-----------------------");
	   	intTreeBag2.print();
		System.out.println("-----------------------");
	   	assertEquals(intTreeBag2.countOccurrences(4), 2);
	   	assertEquals(intTreeBag2.countOccurrences(5), 2);
	}

	/**
	 */
	public void test155() {
		IntTreeBag intTreeBag = new IntTreeBag();
	   	intTreeBag.add(5);
	   	intTreeBag.add(4);

	   	intTreeBag.add(6);
	   	intTreeBag.add(3);
	   	intTreeBag.add(5);

	   	
		System.out.println("-----------------------");
	   	intTreeBag.print();
		System.out.println("-----------------------");
		
	   	assertEquals(intTreeBag.countOccurrences(4), 1);
	   	assertEquals(intTreeBag.countOccurrences(5), 2);
	}
	
	
	public void test17() {
		IntTreeBag intTreeBag = new IntTreeBag();

		System.out.println("-----------------------");
	   	intTreeBag.print();
		System.out.println("-----------------------");
	   	assertEquals(intTreeBag.countOccurrences(4), 0);
	   	assertEquals(intTreeBag.countOccurrences(5), 0);
	}
	
/*
	public void test16() {
		IntTreeBag intTreeBag = new IntTreeBag();
	   	intTreeBag.add(5);
	   	intTreeBag.add(4);
	   	intTreeBag.add(6);

	   	IntTreeBag.Iterator iterator = intTreeBag.iterator();
	   	iterator.start();
	   	while(iterator.isCurrent()){
	   		System.out.println("Iterated Value = "+iterator.advance());
	   	}
	   	
//	   	intTreeBag2.print();
	   	assertEquals(intTreeBag.countOccurrences(4), 1);
	   	assertEquals(intTreeBag.countOccurrences(5), 1);
	}
*/	
	
	public void test20() {
		IntTreeBag intTreeBag = new IntTreeBag();
	   	intTreeBag.add(3);
	   	intTreeBag.add(1);

	   	intTreeBag.add(1);
	   	intTreeBag.add(2);
	   	intTreeBag.add(4);

	   	
		System.out.println("-----------------------");
	   	intTreeBag.print();
		System.out.println("-----------------------");
		
	   	assertEquals(intTreeBag.countOccurrences(4), 1);
	   	assertEquals(intTreeBag.countOccurrences(2), 1);
	}
	
	
	
}
