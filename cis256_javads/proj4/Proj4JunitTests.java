package cis256.proj4;

import junit.framework.TestCase;

public class Proj4JunitTests extends TestCase{

	
	public void test1() {
		StringEditor se = new StringEditor();
		System.out.println(se.toString());
		assertEquals(se.toString(), "[^]");
	}
	
	public void test2() {
		StringEditor se = new StringEditor("a","");
		System.out.println(se.toString());
		assertEquals(se.toString(), "[a^]");
	}
	
	public void test3() {
		StringEditor se = new StringEditor("","b");
		System.out.println("test3:"+se.toString());
		System.out.println("test3:"+se.toString().equals("^b"));
		assertEquals(se.toString(), "[^b]");
	}
	
	public void test4() {
		StringEditor se = new StringEditor("a","b");
		System.out.println("test4:"+se.toString());
		assertEquals(se.toString(), "[a^b]");
	}
	
	public void test5() {
		StringEditor se = new StringEditor("abc","def");
		System.out.println(se.toString());
		assertEquals(se.toString(), "[abc^def]");
	}
	
	public void test6() {
		StringEditor se = new StringEditor("","def");
		System.out.println(se.toString());
		assertEquals(se.isCursoratfront(), true);
	}

	public void test7() {
		StringEditor se = new StringEditor("","");
		System.out.println(se.toString());
		assertEquals(se.isCursoratfront(), true);
	}

	public void test8() {
		StringEditor se = new StringEditor("a","");
		System.out.println(se.toString());
		assertEquals(se.isCursoratfront(), false);
	}

	public void test9() {
		StringEditor se = new StringEditor("abc","");
		System.out.println(se.toString());
		assertEquals(se.isCursoratend(), true);
	}

	public void test10() {
		StringEditor se = new StringEditor("","");
		System.out.println(se.toString());
		assertEquals(se.isCursoratend(), true);
	}

	public void test11() {
		StringEditor se = new StringEditor("","d");
		System.out.println(se.toString());
		assertEquals(se.isCursoratend(), false);
	}

	public void test12() {
		StringEditor se = new StringEditor("","");
		se.insertChar('a');
		System.out.println(se.toString());
		assertEquals(se.toString(), "[a^]");
	}
	
	public void test13() {
		StringEditor se = new StringEditor("ab","def");
		se.insertChar('x');
		System.out.println(se.toString());
		assertEquals(se.toString(), "[abx^def]");
	}

	public void test14() {
		StringEditor se = new StringEditor("ab","cd");
		se.deleteChar();
		System.out.println(se.toString());
		assertEquals(se.toString(), "[ab^d]");
	}
	
	public void test15() {
		StringEditor se = new StringEditor("ab","cd");
		se.deleteChar();
		System.out.println(se.toString());
		assertEquals(se.toString(), "[ab^d]");
	}
	
	public void test16() {
		StringEditor se = new StringEditor("ab","cd");
		se.backspace();
		System.out.println(se.toString());
		assertEquals(se.toString(), "[a^cd]");
	}
	
	public void test17() {
		StringEditor se = new StringEditor("","cd");
		se.backspace();
		System.out.println(se.toString());
		assertEquals(se.toString(), "[^cd]");
	}
	
	public void test18() {
		StringEditor se = new StringEditor("abc","fed");
		System.out.println("Test18: "+se.toString());
		se.moveCursorRight();
		System.out.println("Test18: "+se.toString());
		assertEquals(se.toString(), "[abcf^ed]");
	}
	
	public void test19() {
		StringEditor se = new StringEditor("","cd");
		se.moveCursorRight();
		System.out.println(se.toString());
		assertEquals(se.toString(), "[c^d]");
	}

	public void test20() {
		StringEditor se = new StringEditor("ab","");
		se.moveCursorRight();
		System.out.println(se.toString());
		assertEquals(se.toString(), "[ab^]");
	}
	
	public void test21() {
		StringEditor se = new StringEditor("ab","dc");
		se.moveCursorLeft();
		System.out.println(se.toString());
		assertEquals(se.toString(), "[a^bdc]");
	}
	
	public void test22() {
		StringEditor se = new StringEditor("","dc");
		se.moveCursorLeft();
		System.out.println(se.toString());
		assertEquals(se.toString(), "[^dc]");
	}

	public void test23() {
		StringEditor se = new StringEditor("ab","");
		se.moveCursorLeft();
		System.out.println(se.toString());
		assertEquals(se.toString(), "[a^b]");
	}

	
	public void test24() {
		StringEditor se = new StringEditor("ba","");
		se.frontOfString();
		System.out.println(se.toString());
		assertEquals(se.toString(), "[^ba]");
	}
	
	public void test25() {
		StringEditor se = new StringEditor("ab","cd");
		se.frontOfString();
		System.out.println(se.toString());
		assertEquals(se.toString(), "[^abcd]");
	}
	
	public void test26() {
		StringEditor se = new StringEditor("ab","");
		se.endOfString();
		System.out.println(se.toString());
		assertEquals(se.toString(), "[ab^]");
	}
	
	public void test27() {
		StringEditor se = new StringEditor("ab","dc");
		se.endOfString();
		System.out.println(se.toString());
		assertEquals(se.toString(), "[abdc^]");
	}

}
