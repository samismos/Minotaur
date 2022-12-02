//Samouil Mosios , 9970 , samouilm@ece.auth.gr
//Nikolaos Kousis, 10102 , nkousisp@ece.auth.gr
//					Team 30

import java.util.ArrayList;

public class MinMaxPlayer extends Player{
	ArrayList<Integer[]> path;			//Initialization of variable Path
	HeuristicPlayer opponent;
	public MinMaxPlayer(){								//Constructor
		super();
		path = new ArrayList<Integer[]>();
	}
	
	public MinMaxPlayer(int id, String n, Board b, int s, int px, int py, HeuristicPlayer opponent) {		//Constructor
		super(id, n, b, s, px, py);
		this.opponent = opponent;
		path = new ArrayList<Integer[]>(200);
	}

	double[] evaluate(int currentPos, int dice, Board board, int opponentTile) {	//Function that evaluates, similar to evaluate() in HeuristicPlayer
																					//We adjusted the evaluation algorithm to work as a MinMaxPlayer
		 double pPoints = 0;										
		 double nPoints = 0;                                
		 int check = 0;
		 if(dice == 1) {							
			 for(int j = 1; j < 4; j++) {
				 if(check == 1) break;
				 check = 0;
				 if(board.tiles[currentPos].getUp() == true) { 		
					 pPoints=-1; 
					 nPoints=2;
					 break;
				 }
				 for(int i = 0; i < board.supplies.length; i++) {						
					 if(board.tiles[currentPos].getUp() == true) break;  						
					 if(board.supplies[i].getSupplyTileId() == currentPos+(board.N*j)) {		
						 if(j == 1) {
							 pPoints = 1;
							 check = 1;
							 break;
						 }
						 if(j == 2) {
							 pPoints = 0.5;
							 check = 1;
							 break;
						 }
						 if(j == 3) {
							 pPoints = 0.3;
							 check = 1;
							 break;
						 }
					 }
			 }
				 if(opponentTile == currentPos+(board.N*j)) {			
					 if(j == 1) {
						 nPoints = 1;
						 check = 1;
						 break;
					 }
					 if(j == 2) {
						 nPoints = 0.5;
						 check = 1;
						 break;
					 }
					 if(j == 3) {
						 nPoints = 0.3;
						 check = 1;
						 break;
					 }
				 }															
			 }
		 }
		 if(dice == 3) {
			 for(int j = 1; j < 4; j++) {
				 if(check == 1) break;
				 if(board.tiles[currentPos].getRight() == true) { 
					 pPoints=-1; 
					 nPoints=2;  
					 break;
				 }
				 for(int i = 0; i < board.supplies.length; i++) {
					 if(board.tiles[currentPos].getRight() == true) break;
					 if(board.supplies[i].getSupplyTileId() == currentPos+j) {
						 if(j == 1) {
							 pPoints = 1;
							 check = 1;
							 break;
						 }
						 if(j == 2) {
							 pPoints = 0.5;
							 check = 1;
							 break;
						 }
						 if(j == 3) {
							 pPoints = 0.3;
							 check = 1;
							 break;
						 }
					 }
			 }
				 if(opponentTile == currentPos+j) {
					 if(j == 1) {
						 nPoints = 1;
						 check = 1;
						 break;
					 }
					 if(j == 2) {
						 nPoints = 0.5;
						 check = 1;
						 break;
					 }
					 if(j == 3) {
						 nPoints = 0.3;
						 check = 1;
						 break;
					 }
				 }
			 }
		 }
		 if(dice == 5) {
			 for(int j = 1; j < 4; j++) {
				 if(check == 1) break;
				 if(board.tiles[currentPos].getDown() == true) { 
					 pPoints=-1; 
					 nPoints=2; 
					 break;
				 }
				 for(int i = 0; i < board.supplies.length; i++) {
					 if(board.tiles[currentPos].getDown() == true) break;
					 if(board.supplies[i].getSupplyTileId() == currentPos-(board.N*j)) {
						 if(j == 1) {
							 pPoints = 1;
							 check = 1;
							 break;
						 }
						 if(j == 2) {
							 pPoints = 0.5;
							 check = 1;
							 break;
						 }
						 if(j == 3) {
							 pPoints = 0.3;
							 check = 1;
							 break;
						 }
					 }
			 }
				 if(opponentTile == currentPos-(board.N*j)) {
					 if(j == 1) {
						 nPoints = 1;
						 check = 1;
						 break;
					 }
					 if(j == 2) {
						 nPoints = 0.5;
						 check = 1;
						 break;
					 }
					 if(j == 3) {
						 nPoints = 0.3;
						 check = 1;
						 break;
					 }
				 }
			 }
		 }
		 if(dice == 7) {
			 for(int j = 1; j < 4; j++) {
				 if(check == 1) break;
				 if(board.tiles[currentPos].getLeft() == true) { 
					 pPoints=-1; 
					 nPoints=2;  
					 break;
				 }
				 for(int i = 0; i < board.supplies.length; i++) {
					 if(board.tiles[currentPos].getLeft() == true) break;
					 if(board.supplies[i].getSupplyTileId() == currentPos-j) {
						 if(j == 1) {
							 pPoints = 1;
							 check = 1;
							 break;
						 }
						 if(j == 2) {
							 pPoints = 0.5;
							 check = 1;
							 break;
						 }
						 if(j == 3) {
							 pPoints = 0.3;
							 check = 1;
							 break;
						 }
					 }
			 }
				 if(opponentTile == currentPos-j) {
					 if(j == 1) {
						 nPoints = 1;
						 check = 1;
						 break;
					 }
					 if(j == 2) {
						 nPoints = 0.5;
						 check = 1;
						 break;
					 }
					 if(j == 3) {
						 nPoints = 0.3;
						 check = 1;
						 break;
					 }
				 }
			 }
		 }																			
		 double[] a= {pPoints*5-nPoints, nPoints};							
		 return a; 
	 }
	
	public int chooseMinMaxMove(Node root) {		//Function that uses the other functions to select the best possible move
		 createMySubtree(getX()*board.getN()+getY(), opponent.getX()*board.getN()+opponent.getY() , root, 1);
	     return root.getNodeMove()[2];
	}
	
	int getNextMove (int currentPos, int opponentCurrentPos) {		//Function that executes all the needed procedures to perform the next move 
		Node root = new Node();
        root.setNodeDepth(0);
        root.setParent(null);
        root.setNodeBoard(this.board);
        createMySubtree(currentPos, opponentCurrentPos, root, root.getNodeDepth()+1);
        int dice = chooseMinMaxMove(root);
        
        														//These processes that handle the variables of path are similar to HeuristicPlayer's corresponding function, altered to 
        														// better fit the MinMaxPlayer.
        int sGet = 0, sDis = 0, mDis = 0;						//Initializing variables of Path
        double c = evaluate(currentPos, dice, board, opponentCurrentPos)[0];
		 if(dice == 1) {										//Based on the dice chosen above, the variables of Path are calculated.
			 if(c == 1) {                                 		  		                  
				 sGet = 1;                               		
				 sDis = 0;										
			 }
			 else if(c == 0.5) {
				 sGet = 0;
				 sDis = 1;
			 }
			 else if(c == 0.3) {
				 sGet = 0;
				 sDis = 2;
			 }
			 else {
				 sGet = 0;
				 sDis = 0;
		     }
			 for(int d = 1; d<8; d+=2) {
			 if(evaluate(currentPos, d, board, opponentCurrentPos)[1] == 1) {			 
				 mDis = 1;													
			 }
			 else if(evaluate(currentPos, d, board, opponentCurrentPos)[1] == 0.5) {
				 mDis = 2;
			 }
			 else if(evaluate(currentPos, d, board, opponentCurrentPos)[1] == 0.3){
				 mDis = 3;
			 }
			 else mDis = 0;
			 }
		 }																
		 											//The same process is used for every possible move
		 if(dice == 3) {
			 if(c == 1) {           		                            
				 sGet = 1;                  
				 sDis = 0;
			 }
			 else if(c == 0.5) {
				 sGet = 0;
				 sDis = 1;
			 }
			 else if(c == 0.3) {
				 sGet = 0;
				 sDis = 2;
			 }
			 else {
				 sGet = 0;
				 sDis = 0;
		     }
			 for(int d = 1; d<8; d+=2) {
				 if(evaluate(currentPos, d, board, opponentCurrentPos)[1] == 1) {
					 mDis = 1;
				 }
				 else if(evaluate(currentPos, d, board, opponentCurrentPos)[1] == 0.5) {
					 mDis = 2;
				 }
				 else if(evaluate(currentPos, d,  board, opponentCurrentPos)[1] == 0.3){
					 mDis = 3;
				 }
				 else mDis = 0;
				 }
		 }
		 
		 if(dice == 5) {
			 if(c == 1) {            		                            
				 sGet = 1;                  
				 sDis = 0;
			 }
			 else if(c == 0.5) {
				 sGet = 0;
				 sDis = 1;
			 }
			 else if(c== 0.3) {
				 sGet = 0;
				 sDis = 2;
			 }
			 else {
				 sGet = 0;
				 sDis = 0;
		     }
			 for(int d = 1; d<8; d+=2) {
				 if(evaluate(currentPos, d,  board, opponentCurrentPos)[1] == 1) {
					 mDis = 1;
				 }
				 else if(evaluate(currentPos, d,  board, opponentCurrentPos)[1] == 0.5) {
					 mDis = 2;
				 }
				 else if(evaluate(currentPos, d,  board, opponentCurrentPos)[1] == 0.3){
					 mDis = 3;
				 }
				 else mDis = 0;
				 }
		 }
		 
		 if(dice == 7) {
			 if(c == 1) {            		                            
				 sGet = 1;                  
				 sDis = 0;
			 }
			 else if(c == 0.5) {
				 sGet = 0;
				 sDis = 1;
			 }
			 else if(c == 0.3) {
				 sGet = 0;
				 sDis = 2;
			 }
			 else {
				 sGet = 0;
				 sDis = 0;
		     }
			 for(int d = 1; d<8; d+=2) {
				 if(evaluate(currentPos, d, board, opponentCurrentPos)[1] == 1) {
					 mDis = 1;
					 break;
				 }
				 else if(evaluate(currentPos, d, board, opponentCurrentPos)[1] == 0.5) {
					 mDis = 2;
					 break;
				 }
				 else if(evaluate(currentPos, d,  board, opponentCurrentPos)[1] == 0.3){
					 mDis = 3;
					 break;
				 }
				 else mDis = 0;
				 }
		 }
		 Integer[] array = {dice, sGet, sDis, mDis};		//An Integer array is created since Path is a list of Integer arrays.
		 path.add(array);									//The array is added to Path
        move(currentPos, 0, dice);							//The player is moved 
        int newPos = move(currentPos, 0, dice)[0];
        return newPos;										//The new position is returned
        
	}
	void createMySubtree(int currentPos, int opponentCurrentPos, Node root, int depth) {	//Function that creates a tree of the player's possible moves
		int possibleMoves = 0;
		 int[] possMove = new int[4];							//Calculating how many and which moves are possible for the MinMaxPlayer
		 int index = 0;				
			 if(board.tiles[currentPos].getUp() == false) {   //Checking for walls 
				possibleMoves++;
				possMove[index]=1;
				index++;
			 }
			 if( board.tiles[currentPos].getRight() == false) {
				 possibleMoves++;
				 possMove[index] = 3;
				 index++;
			 }
			 if( board.tiles[currentPos].getDown() == false) {
				 possibleMoves++;
				 possMove[index] = 5;
				 index++;
			 }
			 if( board.tiles[currentPos].getLeft() == false) {
				 possibleMoves++;
				 possMove[index] = 7;
				 
			 }
	        for (int counter = 0; counter < possibleMoves; counter++) {

	            //Deep copy of the board to clone it and simulate movement
	            Board b = new Board(root.getNodeBoard());
	            int nDice = possMove[counter];
	            //Return new int[] {newPosition, newX, newY };
	            int[] moveData = virtualMove(currentPos, 0, nDice);
	            //Creation of the tree's branches
	            Node child = new Node();
	            child.setNodeEvaluation(evaluate(currentPos, nDice , b, opponentCurrentPos)[0]);
	            child.setNodeBoard(b);
	            child.setNodeDepth(depth);
	            child.setNodeMove(new int[] { moveData[1], moveData[2], nDice });
	            child.setParent(root);
	            root.addChild(child);
	            //Creating opponent's subtree
	            createOpponentSubtree(moveData[0], moveData[1], child, depth+1, child.getNodeEvaluation() );

	        }
	        //Algorithm to choose the best move
	        double maxEvaluation = root.getChildren().get(0).getNodeEvaluation();
	        root.setNodeMove(root.getChildren().get(0).getNodeMove());

	        for (Node n : root.getChildren()) {
	            if (maxEvaluation < n.getNodeEvaluation()) {
	                root.setNodeMove(n.getNodeMove());
	                maxEvaluation = n.getNodeEvaluation();
	                root.setNodeEvaluation(maxEvaluation);
	            }
	        }
		
	}
	
	void createOpponentSubtree(int currentPos, int opponentCurrentPos, Node parent, int depth, double parentEval) {
		int possibleMoves = 0;
		 int[] possMove = new int[4];							//Calculating how many and which moves are possible for the opponent
		 int index = 0;				
			 if(board.tiles[opponentCurrentPos].getUp() == false) {   //Checking for walls 
				possibleMoves++;
				possMove[index]=1;
				index++;
			 }
			 if( board.tiles[opponentCurrentPos].getRight() == false) {
				 possibleMoves++;
				 possMove[index] = 3;
				 index++;
			 }
			 if( board.tiles[opponentCurrentPos].getDown() == false) {
				 possibleMoves++;
				 possMove[index] = 5;
				 index++;
			 }
			 if( board.tiles[opponentCurrentPos].getLeft() == false) {
				 possibleMoves++;
				 possMove[index] = 7;
				 
			 }
        for (int counter = 0; counter < possibleMoves; counter++) {		
        	int nDice = possMove[counter];

            //Deep copy of the board to clone it and simulate movement.
            Board newB = new Board(parent.getNodeBoard());

            //Return new int[] {newPosition, newX, newY };
            int[] moveData = virtualMove(opponentCurrentPos, 1,  nDice);
            //Creation of the opponent's branches		
            Node child = new Node();
            child.setNodeEvaluation(parentEval - opponent.evaluate(opponentCurrentPos, nDice,currentPos)[1]);
            child.setNodeBoard(newB);
            child.setNodeDepth(depth);
            child.setNodeMove(new int[] { moveData[1], moveData[2], nDice });
            child.setParent(parent);
            parent.addChild(child);
        }
        //Algorithm to choose the opponent's best move
        double minEvaluation = parent.getChildren().get(0).getNodeEvaluation();

        for (Node n : parent.getChildren()) {
            if (minEvaluation > n.getNodeEvaluation()) {
                minEvaluation = n.getNodeEvaluation();
                parent.setNodeEvaluation(minEvaluation);
            }
        }
	}
	//Copies of the functions WhereTo() and move() from the class Player, but the movement is simulated and not actually performed on the board
	public int virtualWhereTo(int dice, int id) {
		int res = id;
		if (dice == 1 && board.getTiles()[id].up == false) {
			res = id + board.getN();
		}else if (dice == 3 && board.getTiles()[id].right == false) {
			res = id + 1;
		}else if (dice == 5 && board.getTiles()[id].down == false) {
			res = id - board.getN();
		}else if (dice == 7 && board.getTiles()[id].left == false) {
			res = id - 1;
		}
		return res;
	}
	
	int[] virtualMove(int id,int pid, int dice) {
		int[] result = new int[4];
		for (int i = 0; i < result.length; i++) {
			result[i] = 0;
		}
		result[0] = virtualWhereTo(dice,id);
		result[1] = result[0] / board.getN();
		result[2] = result[0] % board.getN();
		return result;
	}
	//Copy of statistics() which is implemented in HeuristicPlayer, adjusted to fit the MinMaxPlayer
	 void statistics(int round, int up, int right, int down, int left) { 
		 
		 //A method that keeps track of all the vital information of the game
		 
		  Integer[] a;														//Printing the amount of times the player moved in each direction
				 System.out.println("Theseus moved up " +up +" times");
				 System.out.println("Theseus moved right " +right +" times");
				 System.out.println("Theseus moved down " +down +" times");
				 System.out.println("Theseus moved left " +left +" times");
				 System.out.println();
			 for(int i = 0 ; i < round ; i++) {						//Using the data stored in path to print information of the smart player's moves for each round
				 a = path.get(i);
				 System.out.println("In round " +(i+1) +":");
				 System.out.println("Theseus set the dice to " +a[0]);
				 if(a[2] != 0) System.out.println("Distance to closest supply was: " +a[2]);
				 else System.out.println("No supplies could be seen");
				 if(a[3] != 0) System.out.println("The minotaur was " +a[3] +" tiles away" );
				 else System.out.println("The minotaur could not be seen");
				 System.out.println();
		 }
	 }
}
