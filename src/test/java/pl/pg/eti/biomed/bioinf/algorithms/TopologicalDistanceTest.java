package pl.pg.eti.biomed.bioinf.algorithms;

import org.junit.*;

import pl.pg.eti.biomed.bioinf.algorithms.TopologicDistance;
import pl.pg.eti.biomed.bioinf.dao.Tree;
import pl.pg.eti.biomed.bioinf.parsers.ClusterParser;

public class TopologicalDistanceTest {

    @Test
    public void trees_RF_4(){
        Tree tree = ClusterParser.getOneTreeFromFile("Tests/TopologicalDistanceTests/Tree_1_RF_4.txt");
        Tree tree2 = ClusterParser.getOneTreeFromFile("Tests/TopologicalDistanceTests/Tree_2_RF_4.txt");
        Assert.assertEquals(4, TopologicDistance.calculateTopologicDistanceBetweenTrees(tree, tree2));
    }
    @Test
    public void trees_RF_0(){
        Tree tree = ClusterParser.getOneTreeFromFile("Tests/TopologicalDistanceTests/Tree_1_RF_0.txt");
        Tree tree2 = ClusterParser.getOneTreeFromFile("Tests/TopologicalDistanceTests/Tree_2_RF_0.txt");
        Assert.assertEquals(0, TopologicDistance.calculateTopologicDistanceBetweenTrees(tree, tree2));
    }
    @Test
    public void trees_RF_null(){
        Tree tree = ClusterParser.getOneTreeFromFile("Tests/TopologicalDistanceTests/Tree_1_RF_null.txt");
        Tree tree2 = ClusterParser.getOneTreeFromFile("Tests/TopologicalDistanceTests/Tree_2_RF_null.txt");
        Assert.assertEquals(-1, TopologicDistance.calculateTopologicDistanceBetweenTrees(tree, tree2));
    }



}
