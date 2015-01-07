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
		Assert.assertEquals("Nieprawid�owa liczba otrzymanych drzew!", 3, trees.size());
	}
	
	@Test
	public void testClustersFromTree1(){
		Tree firstTree = trees.get(0);
		Assert.assertEquals("Liczba klastr�w dla drzewa 1 si� nie zgadza!", 7, firstTree.getNumberOfEdges());
		Assert.assertEquals("Nieoczekiwany zbi�r li�ci w roocie","ABCDEFGH",firstTree.getEdgeAt(0).getLeavesAsString());
	}
	
	
	
	
}
