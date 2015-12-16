package pl.pg.eti.biomed.bioinf.parsers;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.pg.eti.biomed.bioinf.dao.Leaf;
import pl.pg.eti.biomed.bioinf.dao.Node;

public class RootParserTest {
	private Node temp;
	
	@Before
	public void setup(){
		String treeString = FileParser.readFileAsString("Tests/TreeFormat/TreeParserTests/SingleTree.txt");
		temp = TreeParser.getRootNode(treeString);
	}
	
	@Test
	public void verifyFirstChildLine(){
		ArrayList<Node> firstChildNodes = temp.getChildren();
		Assert.assertEquals("Nieoczekiwana liczba dzieci roota", 2, firstChildNodes.size());
		Node firstNode = firstChildNodes.get(0);
		ArrayList<Leaf> leaves = firstNode.getLeaves();
		Assert.assertEquals("Nieoczekiwana liczba liœci",3, leaves.size());
		Assert.assertEquals("A", leaves.get(0).toString());
		Assert.assertEquals("B", leaves.get(1).toString());
		Assert.assertEquals("C", leaves.get(2).toString());
		Node secondNode = firstChildNodes.get(1);
		leaves = secondNode.getLeaves();
		Assert.assertEquals("Nieoczekiwana liczba liœci",  1, leaves.size());
		Assert.assertEquals("E", leaves.get(0).toString());
	}
}
