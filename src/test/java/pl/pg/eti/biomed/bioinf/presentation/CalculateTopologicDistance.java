package pl.pg.eti.biomed.bioinf.presentation;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import pl.pg.eti.biomed.bioinf.algorithms.TopologicDistance;
import pl.pg.eti.biomed.bioinf.dao.Tree;
import pl.pg.eti.biomed.bioinf.parsers.TreeParser;

public class CalculateTopologicDistance {
	private ArrayList<Tree> loadedPairOfTrees;
	private int topologicalDistance;
	
	@Before
	public void loadPairOfTrees(){
		loadedPairOfTrees = TreeParser.
				getTreesFromFile("Tests/PresentationData/TreesToCalculateTopologicalDistance.txt");
		topologicalDistance = TopologicDistance.
				calculateTopologicDistanceBetweenTrees(loadedPairOfTrees.get(0), loadedPairOfTrees.get(1));
	}
	
	@Ignore
	@Test
	public void displayTreesAndDistance(){
		for(int i=0; i<loadedPairOfTrees.size(); i++){
			System.out.println("====Wczytane drzewo nr "+(i+1)+"=======");
			System.out.println(loadedPairOfTrees.get(i).getTreeVisualisation());
		}
		System.out.println("Dystans pomiêdzy drzewami wynosi "+topologicalDistance);
	}
}
