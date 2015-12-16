package pl.pg.eti.biomed.bioinf.dao;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.*;


public class EdgeCompatibleFamily {
	private Edge ABC;
	private Edge AB;
	private Edge AD;
	private Edge DE;
	
	@Before
	public void setup(){
		Leaf a = new Leaf("A");
		Leaf b = new Leaf("B");
		Leaf c = new Leaf("C");
		Leaf d = new Leaf("D");
		Leaf e = new Leaf("E");
		ABC = new Edge(new ArrayList<Leaf>(Arrays.asList(a, b, c)));
		AB = new Edge(new ArrayList<Leaf>(Arrays.asList(a, b)));
		AD = new Edge(new ArrayList<Leaf>(Arrays.asList(a, d)));
		DE = new Edge(new ArrayList<Leaf>(Arrays.asList(d,e)));
	}
	
	@Test
	public void notAllLeavesIncluded(){
		Assert.assertFalse(AB.isCompatible(AD));
		Assert.assertFalse(AD.isCompatible(AB));
	}
	
	@Test
	public void allLeavesIncluded(){
		Assert.assertTrue(AB.isCompatible(ABC));
		Assert.assertTrue(ABC.isCompatible(AB));
	}
	
	@Test
	public void totallyDifferentLeaves(){
		Assert.assertTrue(DE.isCompatible(AB));
		Assert.assertTrue(AB.isCompatible(DE));
		Assert.assertTrue(ABC.isCompatible(DE));
		Assert.assertTrue(DE.isCompatible(ABC));
	}

}
