package tictactoe.model;

public class Board {
	// constant(s)
	private static final int BOARD_WIDTH = 3;
	private static final int BOARD_HEIGHT = 3;
	static final String EMPTY = " ";
	
	// variable declaration
	private String[][] board;
	
	Board() {
		this.board = new String[BOARD_WIDTH][BOARD_HEIGHT];
		for (int row = 0; row < BOARD_HEIGHT; row++) {
			for (int col = 0; col < BOARD_WIDTH; col++) {
				this.board[row][col] = EMPTY;
			}
		}
	}
	
	void placeSign(int row, int col, String sign) {
		if (this.board[row][col].equals(EMPTY)) {
			this.board[row][col] = sign;
		}
	}
	
	boolean hasWon(String sign) {
		// horizontal
		for (int row = 0; row < BOARD_HEIGHT; row++) {
			if (this.board[row][0].equals(sign) && this.board[row][1].equals(sign) && this.board[row][2].equals(sign)) {
				return true;
			}
		}
		
		// vertical
		for (int col = 0; col < BOARD_HEIGHT; col++) {
			if (this.board[0][col].equals(sign) && this.board[1][col].equals(sign) && this.board[2][col].equals(sign)) {
				return true;
			}
		}
		
		// diagonal
		if (this.board[0][0].equals(sign) && this.board[1][1].equals(sign) && this.board[2][2].equals(sign)) {
			return true;
		} else if (this.board[0][2].equals(sign) && this.board[1][1].equals(sign) && this.board[2][0].equals(sign)) {
			return true;
		}
		
		return false;
	}
	
	boolean isFull() {
		for (int row = 0; row < BOARD_HEIGHT; row++) {
			for (int col = 0; col < BOARD_WIDTH; col++) {
				if (this.board[row][col].equals(EMPTY)) {
					return false;
				}
			}
		}
		return true;
	}
	
	String getSquare(int row, int col) {
		return this.board[row][col];
	}
	
	int getHeight() {
		return board.length;
	}
	
	int getWidth() {
		return board[0].length;
	}
}
