package pl.pg.eti.biomed.bioinf.algorithms;

import org.junit.*;
import pl.pg.eti.biomed.bioinf.dao.Edge;
import pl.pg.eti.biomed.bioinf.dao.Leaf;
import pl.pg.eti.biomed.bioinf.dao.Tree;
import pl.pg.eti.biomed.bioinf.parsers.ClusterParser;

import java.util.ArrayList;

public class ConsensusTreesTests {
    private ArrayList<Tree> trees;
    private Tree firstConsensusTreeStrictConsensus;
    private Tree firstConsensusTreeMajorConsensus;


    @Before
    public void setup(){
        trees = ClusterParser.getTreesFromFile("Tests/MultipleTreesTests/ConsensusTrees_Sample1.txt", "####");
        firstConsensusTreeStrictConsensus = ConsensusTreeBuilder.getConsensusTree(trees, 100);
        firstConsensusTreeMajorConsensus = ConsensusTreeBuilder.getConsensusTree(trees, 50);
    }
    @Test
    public void checkFirstNodeStrictConsensus(){
        Edge first = firstConsensusTreeStrictConsensus.getEdgeAt(0);
        ArrayList<Leaf> leaves = first.getLeaves();
        Assert.assertEquals(5,leaves.size());
        Assert.assertEquals("A", leaves.get(0).getId());
        Assert.assertEquals("B", leaves.get(1).getId());
        Assert.assertEquals("C", leaves.get(2).getId());
        Assert.assertEquals("D", leaves.get(3).getId());
        Assert.assertEquals("E", leaves.get(4).getId());
    }
    @Test
    public void checkFirstNodeMajorConsensus(){
        Edge first = firstConsensusTreeMajorConsensus.getEdgeAt(0);
        ArrayList<Leaf> leaves = first.getLeaves();
        Assert.assertEquals(5,leaves.size());
        Assert.assertEquals("A", leaves.get(0).getId());
        Assert.assertEquals("B", leaves.get(1).getId());
        Assert.assertEquals("C", leaves.get(2).getId());
        Assert.assertEquals("D", leaves.get(3).getId());
        Assert.assertEquals("E", leaves.get(4).getId());
    }
    @Test
     public void checkSecondNodeStrictConsensus(){
        Edge second = firstConsensusTreeStrictConsensus.getEdgeAt(1);
        ArrayList<Leaf> leaves = second.getLeaves();
        Assert.assertEquals(1, leaves.size());
        Assert.assertEquals("A", leaves.get(0).getId());

    }
    @Test
    public void checkSecondNodeMajorConsensus(){
        Edge second = firstConsensusTreeMajorConsensus.getEdgeAt(1);
        ArrayList<Leaf> leaves = second.getLeaves();
        Assert.assertEquals(2, leaves.size());
        Assert.assertEquals("C", leaves.get(0).getId());
        Assert.assertEquals("D", leaves.get(1).getId());

    }
    @Test
    public void checkThirdNodeStrictConsensus(){
        Edge third = firstConsensusTreeStrictConsensus.getEdgeAt(2);
        ArrayList<Leaf> leaves = third.getLeaves();
        Assert.assertEquals(1, leaves.size());
        Assert.assertEquals("B", leaves.get(0).getId());

    }
    
    
    @Test
    public void checkThirdNodeMajorConsensus(){
        Edge third = firstConsensusTreeMajorConsensus.getEdgeAt(2);
        ArrayList<Leaf> leaves = third.getLeaves();
        Assert.assertEquals(1, leaves.size());
        Assert.assertEquals("A", leaves.get(0).getId());
    }
    
    @Test
    public void displayMajor(){
    	System.out.println(firstConsensusTreeMajorConsensus.getTreeVisualisation());
    }
}
