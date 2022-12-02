//Samouil Mosios , 9970 , samouilm@ece.auth.gr
//Nikolaos Kousis, 10102 , nkousisp@ece.auth.gr
//					Team 30

import java.util.ArrayList;

public class Node {			//Declaration of variables of class Node
	Node parent;
	ArrayList<Node> children;
	int nodeDepth;
	int[] nodeMove;
	Board nodeBoard;
	double nodeEvaluation;
	
	public Node() {		//Constructor
		parent = null;
		children = new ArrayList<Node>();
		nodeDepth = 0;
		nodeMove = new int[0];
		nodeBoard = null;
		nodeEvaluation = 0;
	}
	
	public Node(Node parent, int depth, Board board, double eval){		//Constructor 
		this.parent = parent;
		nodeDepth = depth;
		nodeBoard = new Board(board);
		nodeMove = new int[4];
		nodeEvaluation = eval;
		children = new ArrayList<Node>(200);
		}
	
	public void setParent(Node parent){			//Getters and setters 
		this.parent = parent;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public void setNodeDepth(int depth){
		nodeDepth = depth;
	}
	
	public int getNodeDepth(){
		return nodeDepth;
	}
	
	public void setNodeMove(int[] move) {
		nodeMove = move;
	}
	
	public int[] getNodeMove() {
		return nodeMove;
	}
	
	public void setNodeBoard(Board board) {
		nodeBoard = board;
	}
	
	public Board getNodeBoard() {
		return nodeBoard;
	}
	
	public void setNodeEvaluation(double eval) {
		nodeEvaluation = eval;
	}
	
	public double getNodeEvaluation() {
		return nodeEvaluation;
	}
    public void addChild(Node child) {		//Function to add child to children
        this.children.add(child);
    }
    public ArrayList<Node> getChildren() {		//Function that returns children
        return this.children;
    }
}

