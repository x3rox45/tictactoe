package tictactoe;

public class Board {
	Player player1;
	Player player2;
	String[][] board;
	
	Board(Player player1, Player player2) {
		// initialize players
		this.player1 = player1;
		this.player2 = player2;
		
		// initialize board
		this.board = new String[3][3];
		for (int j = 0; j < board.length; j++) {
			for (int i = 0; i < board[0].length; i++) {
				board[i][j] = " ";
			}
		}
	}
	
	boolean isOver() {
		for (int j = 0; j < board.length; j++) {
			for (int i = 0; i < board[0].length; i++) {
				if (board[i][j].equals(" ")) {
					return false;
				}
			}
		}
		return true;
	}
}
