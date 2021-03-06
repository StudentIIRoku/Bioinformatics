package pl.pg.eti.biomed.bioinf.parsers;
import pl.pg.eti.biomed.bioinf.dao.Edge;
import pl.pg.eti.biomed.bioinf.dao.Leaf;
import pl.pg.eti.biomed.bioinf.dao.Tree;

import java.util.ArrayList;

public class ClusterParser {

    public static Tree getOneTreeFromFile(String filePath) {
    	Tree tree = getTreesFromFile(filePath, "##").get(0);
    	return tree;
    }
    
    public static ArrayList<Tree> getTreesFromFile(String filePath, String separator){
    	String fileData = FileParser.readFileAsString(filePath);
    	if(fileData.length()!=0){
    		ArrayList<Tree> trees = getTreesFromString(fileData, separator);
    		return trees;
    	}else
    		return null;
    }
    
    private static Edge getEdgeFromLine(String line){
    	if(line.length()==0)
    		return null;
    	ArrayList<Leaf> leaves = new ArrayList<Leaf>();
        String[] leavesNames = line.split(",");
        for(int i=0;i<leavesNames.length; i++){
           Leaf leaf = new Leaf(leavesNames[i]);
            leaves.add(leaf);
        }
        return new Edge(leaves);
    }
    
    private static Tree getTreeFromString(String treeData){
    	String[] edgesData=treeData.split("\n");
    	ArrayList<Edge> edges = new ArrayList<Edge>();
		for(int i=0; i<edgesData.length; i++){
			Edge edge=getEdgeFromLine(edgesData[i]);
			if(edge!=null)
				edges.add(getEdgeFromLine(edgesData[i]));
		}
		return new Tree(edges);
    }
    
    private static ArrayList<Tree> getTreesFromString(String data, String separator){
    	ArrayList<Tree> trees = new ArrayList<Tree>();
    	String[] treesData = data.split(separator);
    	for(int i=0; i<treesData.length; i++){
    		trees.add(getTreeFromString(treesData[i]));
    	}
    	return trees;
    }
}




