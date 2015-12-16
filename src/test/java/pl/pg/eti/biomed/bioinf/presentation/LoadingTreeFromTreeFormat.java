package pl.pg.eti.biomed.bioinf.presentation;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import pl.pg.eti.biomed.bioinf.dao.Tree;
import pl.pg.eti.biomed.bioinf.parsers.TreeParser;

public class LoadingTreeFromTreeFormat {
	Tree loadedTree;
	
	@Before
	public void load(){
		loadedTree = TreeParser.getTreesFromFile("Tests/PresentationData/SingleTreeWithTreeFormat.txt").get(0);
	}
	
	@Ignore
	@Test
	public void displayTree(){
		System.out.println(loadedTree.getTreeVisualisation());
	}
}
