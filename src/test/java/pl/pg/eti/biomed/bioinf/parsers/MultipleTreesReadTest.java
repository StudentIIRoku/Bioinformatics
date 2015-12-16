package pl.pg.eti.biomed.bioinf.parsers;
import java.util.ArrayList;

import org.junit.*;

import pl.pg.eti.biomed.bioinf.dao.Edge;
import pl.pg.eti.biomed.bioinf.dao.Leaf;
import pl.pg.eti.biomed.bioinf.dao.Tree;


public class MultipleTreesReadTest {
	private ArrayList<Tree> twoTrees;
	private ArrayList<Tree> threeTrees;
	
	@Before
	public void setup(){
		twoTrees = ClusterParser.getTreesFromFile("Tests/MultipleTreesTests/MultipleTreesRead_Sample1.txt", "####");
		threeTrees  = ClusterParser.getTreesFromFile("Tests/MultipleTreesTests/MultipleTreesRead_Sample2.txt", "####");
	}
	
	@Test
	public void testNumberOfLoadedTrees(){
		Assert.assertEquals(2, twoTrees.size());
		Assert.assertEquals(3, threeTrees.size());
	}
	
	@Test
	public void testNumberOfEdgesInFirstTree(){
		Tree first = twoTrees.get(0);
		Assert.assertEquals(8, first.getNumberOfEdges());
		first = threeTrees.get(0);
		Assert.assertEquals(8, first.getNumberOfEdges());
	}
	
	@Test
	public void testNumberOfEdgesInSecondTree(){
		Tree second = twoTrees.get(1);
		Assert.assertEquals(7, second.getNumberOfEdges());
		second = threeTrees.get(1);
		Assert.assertEquals(6, second.getNumberOfEdges());
	}
	
	@Test
	public void testNumberOfEdgesInThirdTree(){
		Tree third = threeTrees.get(2);
		Assert.assertEquals(10, third.getNumberOfEdges());
	}
	
	@Test
	public void displayTrees(){
		for(int i=0; i<2; i++){
			System.out.println("Tree number "+i);
			System.out.println(twoTrees.get(i).getTreeVisualisation());
			System.out.println("======================");
		}
		
	}
	
	
}
