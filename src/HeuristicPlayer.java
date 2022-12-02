// Samouil Mosios , 9970  |  Nikolaos Kousis , 10102

import java.util.ArrayList;

public class HeuristicPlayer extends Player{         
	
	// HeuristicPlayer is a class that implements methods in order to make a "smart" player. Based on whether the player sees a nearby supply or 
	// the Minotaur, he decides where to move.

	ArrayList<Integer[]> path;			//Initialization of variable Path
		
	public HeuristicPlayer(){								//Constructor
		super();
		path = new ArrayList<Integer[]>();
	}
	
	public HeuristicPlayer(int id, String n, Board b, int s, int px, int py) {				//Constructor
		super(id, n, b, s, px, py);
		path = new ArrayList<Integer[]>(200);
	}
	
	 double[] evaluate(int currentPos, int dice, int minotaurTile) {	//Method that evaluates the given move, and returns an arbitrary point value for the move.
		 double pPoints = 0;											//The move data consists of the current position and the dice.
		 double nPoints = 0;                                
		 int check = 0;
		 if(dice == 1) {							//A check is performed for each dice
			 for(int j = 1; j < 4; j++) {
				 if(check == 1) break;
				 check = 0;
				 if(board.tiles[currentPos].getUp() == true) { 		//check for wall, if true the method sets the value of the move to a negative number
					 pPoints=-1; 
					 nPoints=2;
					 break;
				 }
				 for(int i = 0; i < board.supplies.length; i++) {						//check for supplies, if a supply is seen, points are given based on the distance
					 if(board.tiles[currentPos].getUp() == true) break;  						//player can't see through walls
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
				 if(minotaurTile == currentPos+(board.N*j)) {			//check for Minotaur, if he is seen, negative points are given based on the distance
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
				 }															//The exact same process is repeated for each dice
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
				 if(minotaurTile == currentPos+j) {
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
				 if(minotaurTile == currentPos-(board.N*j)) {
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
				 if(minotaurTile == currentPos-j) {
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
		 }																			//The method returns an array that contains the total point value of the move
		 double[] a= {pPoints*0.46-nPoints*0.54, nPoints};							// as well as only the negative points, to be used as a condition later
		 return a; 
	 }
	 
	 int getNextMove(int currentPos, int minotaurTile) {						//This is a method that determines the next move of the player
		 double[][] plex;
		 plex = new double[4][2];						//We create a two-dimensional array that contains the dice as well as the evaluation for every possible move.
		 int dice = 1;
		 for(int j = 0; j<4; j++) {
			plex[j][0] = dice;
			plex[j][1] = evaluate(currentPos, dice, minotaurTile)[0];
			dice+=2;
		 }
		 double max = -1;									//The move with the highest point value is selected.
		 int nDice = 0 , index = 0;							//If there is no move with points > 0 , a move out of the ones available is selected randomly.
		 int[] randMove = new int[4];
		 for(int k = 0; k < 4; k++) {				
			 if(plex[k][1] > max) {   
				 max = plex[k][1];
				 nDice = (int) plex[k][0];
			 }
			 if( k == 0 && plex[k][1] == 0) {				//We use an array to store all moves that have neutral points (0). 
				 randMove[index] = 1;
				 index++;
			 }
			 if( k == 1 && plex[k][1] == 0) {
				 randMove[index] = 3;
				 index++;
			 }
			 if( k == 2 && plex[k][1] == 0) {
				 randMove[index] = 5;
				 index++;
			 }
			 if( k == 3 && plex[k][1] == 0) {
				 randMove[index] = 7;
			 }
	}
		 if(max == 0) {										// If max = 0 , meaning there is no move with positive points, a move is chosen from the array above randomly.
			  int rand = (int) (Math.random()*index);
			  nDice = randMove[rand];						//The dice is set
		 }
		 
		 
		 int newPos=0, sGet = 0, sDis = 0, mDis = 0;			//Initializing variables of Path
		 if(nDice == 1) {										//Based on the dice chosen above, the variables of Path are calculated.
			 newPos = currentPos + board.getN();
			 if(max == 0.46) {                                  //The positive value of max indicates a supply nearby   		                  
				 sGet = 1;                               		//Based on the specific value, the distance from the supply is set.
				 sDis = 0;										//If the value is maximum, it means the supply has been picked up (sGet = 1)
			 }
			 else if(max == 0.23) {
				 sGet = 0;
				 sDis = 1;
			 }
			 else if(max == 0.138) {
				 sGet = 0;
				 sDis = 2;
			 }
			 else {
				 sGet = 0;
				 sDis = 0;
		     }
			 for(int d = 1; d<8; d+=2) {
			 if(evaluate(currentPos, d, minotaurTile)[1] == 1) {			//Theseus' distance from the Minotaur is calculated based on the 
				 mDis = 1;													//negative points returned by evaluate()
			 }
			 else if(evaluate(currentPos, d, minotaurTile)[1] == 0.5) {
				 mDis = 2;
			 }
			 else if(evaluate(currentPos, d, minotaurTile)[1] == 0.3){
				 mDis = 3;
			 }
			 else mDis = 0;
			 }
		 }																
		 											//The same process is used for every possible move
		 if(nDice == 3) {
			 newPos = currentPos + 1;
			 if(max == 0.46) {           		                            
				 sGet = 1;                  
				 sDis = 0;
			 }
			 else if(max == 0.23) {
				 sGet = 0;
				 sDis = 1;
			 }
			 else if(max == 0.138) {
				 sGet = 0;
				 sDis = 2;
			 }
			 else {
				 sGet = 0;
				 sDis = 0;
		     }
			 for(int d = 1; d<8; d+=2) {
				 if(evaluate(currentPos, d, minotaurTile)[1] == 1) {
					 mDis = 1;
				 }
				 else if(evaluate(currentPos, d, minotaurTile)[1] == 0.5) {
					 mDis = 2;
				 }
				 else if(evaluate(currentPos, d, minotaurTile)[1] == 0.3){
					 mDis = 3;
				 }
				 else mDis = 0;
				 }
		 }
		 
		 if(nDice == 5) {
			 newPos = currentPos - board.getN();
			 if(max == 0.46) {            		                            
				 sGet = 1;                  
				 sDis = 0;
			 }
			 else if(max == 0.23) {
				 sGet = 0;
				 sDis = 1;
			 }
			 else if(max == 0.138) {
				 sGet = 0;
				 sDis = 2;
			 }
			 else {
				 sGet = 0;
				 sDis = 0;
		     }
			 for(int d = 1; d<8; d+=2) {
				 if(evaluate(currentPos, d, minotaurTile)[1] == 1) {
					 mDis = 1;
				 }
				 else if(evaluate(currentPos, d, minotaurTile)[1] == 0.5) {
					 mDis = 2;
				 }
				 else if(evaluate(currentPos, d, minotaurTile)[1] == 0.3){
					 mDis = 3;
				 }
				 else mDis = 0;
				 }
		 }
		 
		 if(nDice == 7) {
			 newPos = currentPos -1;
			 if(max == 0.46) {            		                            
				 sGet = 1;                  
				 sDis = 0;
			 }
			 else if(max == 0.23) {
				 sGet = 0;
				 sDis = 1;
			 }
			 else if(max == 0.138) {
				 sGet = 0;
				 sDis = 2;
			 }
			 else {
				 sGet = 0;
				 sDis = 0;
		     }
			 for(int d = 1; d<8; d+=2) {
				 if(evaluate(currentPos, d, minotaurTile)[1] == 1) {
					 mDis = 1;
					 break;
				 }
				 else if(evaluate(currentPos, d, minotaurTile)[1] == 0.5) {
					 mDis = 2;
					 break;
				 }
				 else if(evaluate(currentPos, d, minotaurTile)[1] == 0.3){
					 mDis = 3;
					 break;
				 }
				 else mDis = 0;
				 }
		 }
		 do {
				nDice = (int) (Math.random()*8);
			}while(nDice % 2 != 1);							//Minotaur moves randomly
		 Integer[] array = {nDice, sGet, sDis, mDis};		//An Integer array is created since Path is a list of Integer arrays.
		 path.add(array);									//The array is added to Path
	     move(currentPos, 0, nDice);						//move() is used to change the position of the player
		 return newPos;										//the new position is returned
	 }
	 
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

	 


