package pl.pg.eti.biomed.bioinf.presentation;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import pl.pg.eti.biomed.bioinf.algorithms.TreeCutter;
import pl.pg.eti.biomed.bioinf.dao.Leaf;
import pl.pg.eti.biomed.bioinf.dao.Tree;
import pl.pg.eti.biomed.bioinf.parsers.TreeParser;

public class CuttingTree {
	private Tree loadedTree;
	private Tree cuttedTree;
	@Before
	public void loadandCutTree(){
		loadedTree = TreeParser.getTreesFromFile("Tests/PresentationData/TreeToCut.txt").get(0);
		ArrayList<Leaf> leavesToCut = new ArrayList<Leaf>();
		Leaf A = new Leaf("A");
		Leaf B = new Leaf("B");
		Leaf C = new Leaf("C");
		Leaf D = new Leaf("D");
		Leaf E = new Leaf("E");
		Leaf F = new Leaf("F");
		Leaf G = new Leaf("G");
		Leaf H = new Leaf("H");
		//Dodawanie liœci do uciêcia
		leavesToCut.add(A);
		//Ciêcie drzewa
		cuttedTree = TreeCutter.cutLeaves(leavesToCut, loadedTree);
	}
	
	@Ignore
	@Test
	public void displayLoadedTree(){
		System.out.println("======Wczytane Drzewo:======");
		System.out.println(loadedTree.getTreeVisualisation());
	}
	
	@Ignore
	@Test
	public void displayCuttedTree(){
		System.out.println("=======Drzewo po przyciêciu:=========");
		System.out.println(cuttedTree.getTreeVisualisation());
	}
}
