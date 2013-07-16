package cis256.proj3;

import junit.framework.TestCase;

public class TestCharNode extends TestCase{

	
	public void test1() {
		CharNode charNode = new CharNode('a', null);
		
		charNode.addNodeAfter('b');
		charNode.addNodeAfter('c');
		assertEquals("acb", charNode.toString());
		
		charNode = CharNode.listTailRemove(charNode);
		assertEquals("ac", charNode.toString());

		charNode = CharNode.listTailRemove(charNode);
		assertEquals("a", charNode.toString());

		charNode = CharNode.listTailRemove(charNode);
		assertEquals(null, charNode);

	}

	public void test2() {
		CharNode cN = new CharNode('a', null);
		cN.addNodeAfter('b');
		cN.addNodeAfter('c');
		System.out.println("cNode allNodes = "+cN);
		assertEquals("acb", cN.toString());
		

		CharNode lastNode = CharNode.getLast(cN);
		System.out.println("cNode lastNode = "+lastNode);
		assertEquals("b", lastNode.toString());
	}

	
	public void test3() {
		CharNode cN1 = new CharNode('x', null);
		cN1.addNodeAfter('y');
		cN1.addNodeAfter('z');
		CharNode.outList(cN1);

		assertEquals("xzy", cN1.toString());
	}
	
	public void test4() {
		CharNode cN = new CharNode('a', null);
		cN.addNodeAfter('b');
		cN.addNodeAfter('c');

		CharNode lastNode = CharNode.listTailRemove(cN);
		assertEquals("ac", lastNode.toString());
	}
	
	public void test5() {
		CharNode cN = new CharNode('a', null);
		cN.addNodeAfter('b');
		cN.addNodeAfter('c');

		CharNode lastNode = CharNode.listTailInsert(cN, 'm');
		assertEquals("acbm", lastNode.toString());
	}
	
	public void testS1(){
		StringEditor se = new StringEditor();
		assertTrue(se.isCursoratfront());
		assertTrue(se.isCursoratend());
	}
	
	public void testS2(){
		StringEditor se = new StringEditor("", "monkey");
		assertTrue(se.isCursoratfront());
		assertFalse(se.isCursoratend());
	}
	
	public void testS3(){
		StringEditor se = new StringEditor("monkey", "");
		assertFalse(se.isCursoratfront());
		assertTrue(se.isCursoratend());
	}
	
	public void testS4(){
		StringEditor se = new StringEditor("monkey", "man");
		se.insertChar('s');
		System.out.println(se.toString());
		assertEquals("monkeys^man",se.toString());
	}

	public void testS5(){
		StringEditor se = new StringEditor("monkey", "man");
		se.deleteChar();
		System.out.println(se.toString());
		assertEquals("monkey^an",se.toString());
	}

	public void testS6(){
		StringEditor se = new StringEditor("monkey", "man");
		se.backspace();
		System.out.println(se.toString());
		assertEquals("monke^man",se.toString());
	}
	
	public void testS7(){
		StringEditor se = new StringEditor("monkey", "man");
		se.frontOfString();
		System.out.println(se.toString());
		assertEquals("^monkeyman",se.toString());
	}
	
	public void testS8(){
		StringEditor se = new StringEditor("monkey", "man");
		se.endOfString();
		System.out.println(se.toString());
		assertEquals("monkeyman^",se.toString());
	}
	
	public void testS9(){
		StringEditor se = new StringEditor("monkey", "man");
		se.moveCursorLeft();
		System.out.println(se.toString());
		assertEquals("monke^yman",se.toString());
	}

	public void testS10(){
		StringEditor se = new StringEditor("monkey", "man");
		se.moveCursorRight();
		System.out.println(se.toString());
		assertEquals("monkeym^an",se.toString());
	}
	
	
}
