package cis256.proj6;

import junit.framework.TestCase;

public class HeapTest extends TestCase{

	
	public void test1() {
		Heap<Integer> heap = new Heap<Integer>(15);
		heap.add(12);
		heap.add(1);
		heap.add(2);
		heap.add(3);
	
		System.out.println(heap.toString());
		assertEquals(true, true);
	}
	
	public void test2() {
		Heap<Integer> heap = new Heap<Integer>(15);
		heap.add(12);
		heap.add(3);
		heap.add(3);
		heap.add(4);
		System.out.println(heap.toString());
		Integer top = heap.remove();

		System.out.println("top = "+ top);
		System.out.println(heap.toString());
		
		assertEquals(top, new Integer(12));
		
//		top = heap.remove();
//		assertEquals(top, new Integer(4));
	}

	public void test3() {
		Heap<Integer> heap = new Heap<Integer>(15);
		heap.add(12);
		heap.add(3);
		heap.add(3);
		heap.add(4);
		System.out.println(heap.toString());
		Integer top = heap.remove();

		System.out.println("top = "+ top);
		System.out.println("After removung 12:   "+heap.toString());
		
		assertEquals(top, new Integer(12));
		
		top = heap.remove();
		System.out.println("top = "+ top);
		assertEquals(top, new Integer(4));
		assertEquals(true, true);
	}
	
	public void test4() {
		Heap<Integer> heap = new Heap<Integer>(15);
		heap.add(12);
		heap.add(13);
		heap.add(33);
		heap.add(4);
		System.out.println(heap.toString());
		Integer top = heap.remove();

		System.out.println("top = "+ top);
		System.out.println("After removung 33:   "+heap.toString());
		
		assertEquals(top, new Integer(33));
		
		top = heap.remove();
		System.out.println("top = "+ top);
		System.out.println("Final heap :   "+heap.toString());
		assertEquals(top, new Integer(13));
		top = heap.remove();
		System.out.println("top = "+ top);
		System.out.println("Final heap :   "+heap.toString());
		assertEquals(top, new Integer(12));
	}
	
	
	
	
	
}
