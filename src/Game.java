

public class Game {
	int round;
	
	public Game() {
		round = 0;
	}
	
	public Game(int r) {
		round = r;
	}
	
	public int getRound() {
		return round;
	}
	
	public void setRound(int r) {
		this.round = r;
	}
	
	public static void main(String args[]) {
		int N = 15;
		int n = 100;
		int numsup = 4;
		int up =0,right = 0, down = 0, left = 0; 
		Game game = new Game(1);
		Board board = new Board(N, numsup, (N * N * 3 + 1) / 2 ); // (N*N*3 +1)/2
		board.createBoard();
		HeuristicPlayer Min;
		MinMaxPlayer Th;
		Min = new HeuristicPlayer(1, "Minotaur", board, 0, N/2, N/2);
		Th = new MinMaxPlayer(0, "Theseus", board, 0, 0, 0, Min);    //Initializing the smart player
		int ThCurrentPosition, MinCurrentPosition;
		int newPosition = 0;
		String winnerName = null;
		ThCurrentPosition = 0;
		MinCurrentPosition = N * N / 2;
		String[][]x = board.getStringRepresentation(ThCurrentPosition, MinCurrentPosition);
		for(int i = 0; i< 2*N + 1;i++) {
			for(int j=0; j< N;j++) {
				if(j == N - 1) {
					System.out.println(x[i][j]);
				}else {
					System.out.print(x[i][j]);
				}
			}
		}
		
		System.out.println("*********** The game begins **********");
		System.out.println();
		game.round = 0;
		boolean minFlag = false;
		boolean thFlag = false;
		
		for (;;) {
			game.round++;
			System.out.println("********************************** Round " + game.round + " **********************************");
			for (int i = 0; i < 2; i++) {
				if(i == 0) System.out.println("---------------------- Player: " + Th.getName() + " -----------------------");
				else System.out.println("---------------------- Player: " + Min.getName() + " ----------------------");
				if(i == 0) {
					newPosition = Th.getNextMove(ThCurrentPosition, MinCurrentPosition);
					 Integer[] a = Th.path.get(game.round-1);			
					if(a[0] == 1) up++;						//keeping track of the player's moves, to be used in statistics()
					 if(a[0] == 3) right++;
					 if(a[0] == 5) down++;
					 if(a[0] == 7) left++;
					if (Th.getScore() == numsup) {
						winnerName = Th.getName();
						thFlag= true;
						break;
					}
				}
				else{
					int dice = 0;
					do {
						dice = (int) (Math.random()*8);
					}while(dice % 2 != 1);
					newPosition = Min.move(MinCurrentPosition, i, dice)[0];
				} 
				if (i == 1){
					if(newPosition == ThCurrentPosition) {
						winnerName = Min.getName();
						minFlag= true;
						break;
					}
				}
				if (i == 0){
					if(newPosition == MinCurrentPosition) {
						winnerName = Min.getName();
						minFlag= true;
						break;
					}
				}
				if (i == 0) {
					System.out.println("Current Position: " + ThCurrentPosition + "\nNew Position: " + newPosition
							+ "\nPlayer Score: " + Th.getScore());
					
				}else {
					System.out.println("Current Position: " + MinCurrentPosition + "\nNew Position: " + newPosition);

				}
				if(i == 0) {
					ThCurrentPosition = newPosition;
					Th.setX(newPosition/N);
					Th.setY(newPosition%N);
				}
				else {
					MinCurrentPosition = newPosition;
					Min.setX(newPosition/N);
					Min.setY(newPosition%N);
				}
			}
			String[][]x2 = board.getStringRepresentation(ThCurrentPosition, MinCurrentPosition);
			for(int ii = 0; ii< 2*N + 1;ii++) {
				for(int j=0; j< N;j++) {
					if(j == N - 1) {
						System.out.println(x2[ii][j]);
					}else {
						System.out.print(x2[ii][j]);
					}
				}
			}
			
			if (game.round >= 2*n || minFlag || thFlag) {
				break;
			}
		}
		
		System.out.println();
		System.out.println("*********** The game is over *********");
		System.out.println();
		System.out.println("Rounds played: "+game.round);
		Th.statistics(game.getRound(), up, right, down, left);
		if(game.round >= 2*n) {
			System.out.println("The game is a tie!!!");
		}else {
			System.out.println(winnerName +" won the game!!!");
		}
	}
}
