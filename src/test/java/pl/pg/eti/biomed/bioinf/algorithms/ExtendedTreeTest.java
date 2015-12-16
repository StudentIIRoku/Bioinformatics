package pl.pg.eti.biomed.bioinf.algorithms;

import java.util.ArrayList;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.pg.eti.biomed.bioinf.dao.Edge;
import pl.pg.eti.biomed.bioinf.dao.Tree;
import pl.pg.eti.biomed.bioinf.parsers.ClusterParser;
import pl.pg.eti.biomed.bioinf.algorithms.ExtendedTree;

public class ExtendedTreeTest {
	Tree extendedTree;
	Tree expectedExtendedTree;
	
	@Before
	public void setup(){
		ArrayList<Tree> trees = ClusterParser.
				getTreesFromFile("Tests/ExtendedTreeTests/CorrectClustersTestSet1.txt", "####");
		extendedTree = ExtendedTree.calculateExtendedTree(trees);
		expectedExtendedTree = ClusterParser.
				getOneTreeFromFile("Tests/ExtendedTreeTests/ExpectedExtendedTreeForTestSet1.txt");

	}
	
	@Test
	public void checkEdges(){
		ArrayList<Edge> expectedEdges = expectedExtendedTree.getEdges();
		ArrayList<Edge> actualEdges = extendedTree.getEdges();
		//Odkomentowaæ po dodaniu tworzenia singletonów
		//Assert.assertEquals("Liczba wierzcho³ków siê nie zgadza!", expectedEdges.size(), actualEdges.size());
		for(Edge edge:expectedEdges){
			Assert.assertThat(actualEdges, CoreMatchers.hasItem(edge));
		}
	}
	
	@Test
	public void checkBuildOfExtendedTree(){
		String str="Drzewo o zadanych parametrach nie istnieje";
		Assert.assertNotEquals("Brak wizualizacji drzewa!", str, extendedTree.getTreeVisualisation());
	}
}
