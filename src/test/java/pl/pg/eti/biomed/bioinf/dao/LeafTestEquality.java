package pl.pg.eti.biomed.bioinf.dao;

import org.junit.*;


public class LeafTestEquality {

	@Test
	public void testInequality(){
		Leaf A = new Leaf("A");
		Leaf B = new Leaf("B");
		Assert.assertFalse(A.equals(B));
	}
	
	@Test
	public void testEquality(){
		Leaf A = new Leaf("A");
		Leaf Aa = new Leaf("A");
		Assert.assertTrue(A.equals(Aa));
	}
	
	@Test
	public void differentObjectTest(){
		Leaf A = new Leaf("");
		String s = "";
		Assert.assertFalse(A.equals(s));
	}

}
