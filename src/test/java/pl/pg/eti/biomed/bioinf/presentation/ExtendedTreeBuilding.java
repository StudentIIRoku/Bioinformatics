package pl.pg.eti.biomed.bioinf.presentation;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import pl.pg.eti.biomed.bioinf.algorithms.ExtendedTree;
import pl.pg.eti.biomed.bioinf.dao.Tree;
import pl.pg.eti.biomed.bioinf.parsers.TreeParser;

public class ExtendedTreeBuilding {
	private ArrayList<Tree> loadedTrees;
	private Tree extendedTree;
	
	@Before
	public void loadTrees(){
		loadedTrees = TreeParser.getTreesFromFile("Tests/PresentationData/TreesToBuildExtendedTree");
		extendedTree = ExtendedTree.calculateExtendedTree(loadedTrees);
	}
	
	@Ignore
	@Test
	public void displayTrees(){
		System.out.println("=======Wczytane drzewa :======");
		for(int i=0;i<loadedTrees.size();i++){
			System.out.println("Drzewo nr "+(i+1));
			System.out.println(loadedTrees.get(i).getTreeVisualisation());
		}
	}
	
	@Ignore
	@Test
	public void displayExtendedTree(){
		System.out.println("=========Drzewo rozszerzone : =========");
		System.out.println(extendedTree.getTreeVisualisation());
	}
}
