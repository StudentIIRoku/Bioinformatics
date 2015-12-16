package pl.pg.eti.biomed.bioinf.parsers;
import java.util.ArrayList;

import org.junit.*;

import pl.pg.eti.biomed.bioinf.dao.Edge;
import pl.pg.eti.biomed.bioinf.dao.Leaf;
import pl.pg.eti.biomed.bioinf.dao.Tree;


public class ClusterParserTest {
	private Tree tree;
	
	@Before
	public void setup(){
		tree = ClusterParser.getOneTreeFromFile("Tests/testData1.txt");
	}
	
	@Test
	public void checkNumberOfNodes(){
		Assert.assertEquals(7,tree.getNumberOfEdges());
	}
	
	@Test
	public void checkFirstNode(){
		Edge first = tree.getEdgeAt(0);
		ArrayList<Leaf> leaves = first.getLeaves();
		Assert.assertEquals(3,leaves.size());
		Assert.assertEquals("A", leaves.get(0).getId());
		Assert.assertEquals("B", leaves.get(1).getId());
		Assert.assertEquals("C", leaves.get(2).getId());
	}
	
	@Test
	public void checkSecondNode(){
		Edge second = tree.getEdgeAt(1);
		ArrayList<Leaf> leaves = second.getLeaves();
		Assert.assertTrue(leaves.size()==2);
		Assert.assertEquals(leaves.get(0).getId(), "D");
		Assert.assertEquals(leaves.get(1).getId(), "E");
	}
	
	@Test
	public void visualizeTree(){
		System.out.println(tree.getTreeVisualisation());
	}
}
