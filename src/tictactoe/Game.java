package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Game {
	// constant(s)
	final static String SIGN_1 = "X";
	final static String SIGN_2 = "O";
	final static char[] validInputs = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
	
	Player[] players;
	int startingPlayer;
	int currentPlayer;
	Board board;
	
	Game() {
		this.players = new Player[2];
		this.players[0] = new Player(SIGN_1);
		this.players[1] = new Player(SIGN_2);
		this.startingPlayer = new Random().nextInt(players.length);
		this.board = new Board();
	}
	
	int[] readInput() {
		int row, col, input;
		do {
			do {
				System.out.printf("Where do you want to place your sign, player %d(%s)? ", currentPlayer + 1, players[currentPlayer].getSign());
				Scanner scanner = new Scanner(System.in);
				input = scanner.next().charAt(0);
			} while (input < '1' || input > '9');
			input -= '0';
			row = 2 - ((input - 1) / 3);
			col = (input - 1) % 3;
		} while (!board.isSquareEmpty(row, col));
		
		int[] output = {row, col};
		return output;
	}
	
	private void start() {
		currentPlayer = startingPlayer;
		board.print();
		while (!board.isFull() && !board.hasWon(players[0].getSign()) && !board.hasWon(players[1].getSign())) {
			currentPlayer = (currentPlayer + 1) % 2;
			int[] input = readInput();
			board.placeSign(input[0], input[1], players[currentPlayer].getSign());
			board.print();
		}
		
		if (board.hasWon(players[currentPlayer].getSign())) {
			System.out.printf("Game over! Player %d(%s) won!", currentPlayer + 1, players[currentPlayer].getSign());
		} else {
			System.out.printf("Game over! It is a tie!");
		}
	}
	
	public static void main(String[] args) {
		new Game().start();
	}
}
