package pl.pg.eti.biomed.bioinf.presentation;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import pl.pg.eti.biomed.bioinf.dao.Tree;
import pl.pg.eti.biomed.bioinf.parsers.ClusterParser;

public class LoadingTreeFromClusters {
	Tree loadedTree;
	
	@Before
	public void loadTree(){
		loadedTree = ClusterParser.getOneTreeFromFile("Tests/PresentationData/SingleTreeAsClusters.txt");
	}
	
	@Ignore//odkomentowaæ na potrzeby prezentacji
	@Test
	public void displayLoadedTree(){
		System.out.println(loadedTree.getTreeVisualisation());
	}
}
