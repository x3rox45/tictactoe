package tictactoe;

import java.io.PrintStream;

public class Game {
	// constant(s)
	final static String SIGN_1 = "X";
	final static String SIGN_2 = "O";
	
	// variable initialization
	PrintStream out;
	
	Game() {
		out = new PrintStream(System.out);
	}
	
	private void start() {
		Player player1 = new Player(SIGN_1);
		Player player2 = new Player(SIGN_2);
		Board board = new Board(player1, player2);
		while (!board.isOver()) {
			
		}
	}
	
	public static void main(String[] args) {
		new Game().start();
	}
}
