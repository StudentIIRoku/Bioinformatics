package pl.pg.eti.biomed.bioinf.core;
import org.junit.*;

import pl.pg.eti.biomed.bioinf.dao.Tree;
import pl.pg.eti.biomed.bioinf.parsers.ClusterParser;

public class BuildableTreeTest {
	@Test
	public void buildableTestSample_1(){
		Tree tree = ClusterParser.getOneTreeFromFile("Tests/BuildableTreesTests/BuildableTest_Sample1.txt");
		Assert.assertNotNull(tree);
		Assert.assertNotEquals("Drzewo o zadanych parametrach nie istnieje", tree.getTreeVisualisation());
	}
	
	@Test
	public void buildableTestSample_2(){
		Tree tree = ClusterParser.getOneTreeFromFile("Tests/BuildableTreesTests/BuildableTest_Sample2.txt");
		Assert.assertNotNull(tree);
		Assert.assertNotEquals("Drzewo o zadanych parametrach nie istnieje", tree.getTreeVisualisation());
	}
	
	@Test
	public void unbuildableTestSample_1(){
		Tree tree = ClusterParser.getOneTreeFromFile("Tests/BuildableTreesTests/UnbuildableTest_Sample1.txt");
		Assert.assertNotNull(tree);
		Assert.assertEquals("Drzewo o zadanych parametrach nie istnieje", tree.getTreeVisualisation());
	}
	
	@Test
	public void unbuildableTestSample_2(){
		Tree tree = ClusterParser.getOneTreeFromFile("Tests/BuildableTreesTests/UnbuildableTest_Sample2.txt");
		Assert.assertNotNull(tree);
		Assert.assertEquals("Drzewo o zadanych parametrach nie istnieje", tree.getTreeVisualisation());
	}
	
	
	
	
	
}
