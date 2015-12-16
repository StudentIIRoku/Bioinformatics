package pl.pg.eti.biomed.bioinf.parsers;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.pg.eti.biomed.bioinf.dao.Tree;

public class TreeParserTest {
	private ArrayList<Tree> trees;
	private final String pathToTxtFile="Tests/TreeFormat/TreeParserTests/MultipleTree1.txt";
	
	@Before
	public void setup(){
		trees = TreeParser.getTreesFromFile(pathToTxtFile);
	}
	
	@Test
	public void testNumberOfReadTrees(){
		Assert.assertEquals("Nieprawid³owa liczba otrzymanych drzew!", 3, trees.size());
	}
	
	@Test
	public void testClustersFromTree1(){
		Tree firstTree = trees.get(0);
		Assert.assertEquals("Liczba klastrów dla drzewa 1 siê nie zgadza!", 15, firstTree.getNumberOfEdges());
		Assert.assertEquals("Nieoczekiwany zbiór liœci w roocie","ABCDEFGH",firstTree.getEdgeAt(0).getLeavesAsString());
		ArrayList<String> edgesAsString = new ArrayList<String>();
		for(int i=0;i<firstTree.getNumberOfEdges(); i++)
			edgesAsString.add(firstTree.getEdgeAt(i).getLeavesAsString());
		Assert.assertTrue("Brak klastra ABCD!", edgesAsString.contains("ABCD"));
		Assert.assertTrue("Brak klastra ABC!", edgesAsString.contains("ABC"));
		Assert.assertTrue("Brak klastra BC!", edgesAsString.contains("BC"));
		Assert.assertTrue("Brak klastra EFGH!", edgesAsString.contains("EFGH"));
		Assert.assertTrue("Brak klastra EF!", edgesAsString.contains("EF"));
		Assert.assertTrue("Brak klastra GH!", edgesAsString.contains("GH"));
	}
	
	@Test
	public void testClustersFromTree2(){
		Tree secondTree = trees.get(1);
		Assert.assertEquals("Liczba klastrów dla drzewa 2 siê nie zgadza!", 13, secondTree.getNumberOfEdges());
		Assert.assertEquals("Nieoczekiwany zbiór liœci w roocie","ABCDEFG",secondTree.getEdgeAt(0).getLeavesAsString());
		ArrayList<String> edgesAsString = new ArrayList<String>();
		for(int i=0;i<secondTree.getNumberOfEdges(); i++)
			edgesAsString.add(secondTree.getEdgeAt(i).getLeavesAsString());
		Assert.assertTrue("Brak klastra AB!", edgesAsString.contains("AB"));
		Assert.assertTrue("Brak klastra CDEFG!", edgesAsString.contains("CDEFG"));
		Assert.assertTrue("Brak klastra DEFG!", edgesAsString.contains("DEFG"));
		Assert.assertTrue("Brak klastra EFG!", edgesAsString.contains("EFG"));
		Assert.assertTrue("Brak klastra FG!", edgesAsString.contains("FG"));
	}
	
	@Test
	public void testClustersFromTree3(){
		Tree thirdTree = trees.get(2);
		Assert.assertEquals("Liczba klastrów dla drzewa 3 siê nie zgadza!", 22, thirdTree.getNumberOfEdges());
		Assert.assertEquals("Nieoczekiwany zbiór liœci w roocie","ABCDEFGHIJKL",thirdTree.getEdgeAt(0).getLeavesAsString());
		ArrayList<String> edgesAsString = new ArrayList<String>();
		for(int i=0;i<thirdTree.getNumberOfEdges(); i++)
			edgesAsString.add(thirdTree.getEdgeAt(i).getLeavesAsString());
		Assert.assertTrue("Brak klastra ABCD!", edgesAsString.contains("ABCD"));
		Assert.assertTrue("Brak klastra AB!", edgesAsString.contains("AB"));
		Assert.assertTrue("Brak klastra CD!", edgesAsString.contains("CD"));
		Assert.assertTrue("Brak klastra EFGH!", edgesAsString.contains("EFGH"));
		Assert.assertTrue("Brak klastra EF!", edgesAsString.contains("EF"));
		Assert.assertTrue("Brak klastra GH!", edgesAsString.contains("GH"));
		Assert.assertTrue("Brak klastra IJKL!", edgesAsString.contains("IJKL"));
		Assert.assertTrue("Brak klastra IJ!", edgesAsString.contains("IJ"));
		Assert.assertTrue("Brak klastra KL!", edgesAsString.contains("KL"));
	}
	
	
	
	
}
