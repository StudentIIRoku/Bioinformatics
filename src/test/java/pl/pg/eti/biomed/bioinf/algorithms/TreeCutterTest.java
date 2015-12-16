package pl.pg.eti.biomed.bioinf.algorithms;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.pg.eti.biomed.bioinf.dao.Edge;
import pl.pg.eti.biomed.bioinf.dao.Leaf;
import pl.pg.eti.biomed.bioinf.dao.Tree;
import pl.pg.eti.biomed.bioinf.parsers.TreeParser;

public class TreeCutterTest {
	private ArrayList<Tree> initialTrees;
	private ArrayList<Tree> cutTrees;
	private ArrayList<Tree> expectedTrees;
	
	@Before
	public void setup(){
		initialTrees = TreeParser.getTreesFromFile("Tests/TreeCutterTests/SampleInput1.txt");
		expectedTrees = TreeParser.getTreesFromFile("Tests/TreeCutterTests/ExpectedOutput1.txt");
		cutTrees = new ArrayList<Tree>();
		Tree treeWithoutB = TreeCutter.cutLeaf(new Leaf("B"), initialTrees.get(0));
		Tree treeWithoutC = TreeCutter.cutLeaf(new Leaf("C"), initialTrees.get(1));
		cutTrees.add(treeWithoutB);
		cutTrees.add(treeWithoutC);
	}
	
	@Test
	public void verifyNumberOfClustersInCuttedTrees(){
		Assert.assertEquals("Nieoczekiwana liczba klastrów w drzewie 1",  
				13, cutTrees.get(0).getNumberOfEdges());
		Assert.assertEquals("Nieoczekiwana liczba klastrów w drzewie 2",  
				11, cutTrees.get(1).getNumberOfEdges());
		
	}
	
	@Test
	public void verifyEdgesInFirstCutTreeWithExpectedOne(){
		ArrayList<Edge> cutTreeEdges = cutTrees.get(0).getEdges();
		ArrayList<Edge> expectedTreeEdges = expectedTrees.get(0).getEdges();
		for(Edge edge:expectedTreeEdges)
			Assert.assertTrue("Brak klastru "+edge.getLeavesAsString()+" w drzewie pierwszym.",
					cutTreeEdges.contains(edge));
	}
	
	@Test
	public void verifyEdgesInSecondCutTreeWithExpectedOne(){
		ArrayList<Edge> cutTreeEdges = cutTrees.get(1).getEdges();
		ArrayList<Edge> expectedTreeEdges = expectedTrees.get(1).getEdges();
		for(Edge edge:expectedTreeEdges)
			Assert.assertTrue("Brak klastru "+edge.getLeavesAsString()+" w drzewie drugim.",
					cutTreeEdges.contains(edge));
	}
}
