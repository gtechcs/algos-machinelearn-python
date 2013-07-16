package cis256.proj7;

import junit.framework.TestCase;

public class TestChainedTable extends TestCase {

	
//	public void test1(){
//		ChainedTable ct = new ChainedTable(20);
//		Customer c1 = new Customer("A", "address1", 1234567);
//		Object obj = ct.put(c1.getPhoneNumber(), c1);
//		assertNull(obj);
//			
//		boolean exists = ct.containsKey(c1.getPhoneNumber());
//		assertTrue(exists);
//		
//		Customer ret1 = (Customer)ct.get(c1.getPhoneNumber());
//		assert(ret1.equals(c1));	
//	}
	
	
	public void test2(){
		ChainedTable ct = new ChainedTable(20);
		Customer c1 = new Customer("B", "address1", 8794567);
		Object obj = ct.put(c1.getPhoneNumber(), c1);
//		System.out.println(""+ c1.toString());	
		assertNull(obj);

		boolean exists = ct.containsKey(c1.getPhoneNumber());
//		System.out.println("Exists: "+ exists);	
		assertTrue(exists);
		
		Customer ret1 = (Customer)ct.get(c1.getPhoneNumber());
//		System.out.println(""+ ret1.toString());
		assert(ret1.equals(c1));
		
		Object returned = ct.remove(c1.getPhoneNumber());
		assertNotNull(returned);
		
		System.out.println("Estimated Efficiency : "+ct.estimateEfficiency());
		System.out.println("Actual Efficiency : "+ct.actualEfficiency());
		
		exists = ct.containsKey(c1.getPhoneNumber());
		System.out.println("Exists: "+ exists);	
		assertTrue(false);
		
		
		
	}

	
}
