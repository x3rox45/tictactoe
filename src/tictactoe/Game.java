package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Game {
	// constant(s)
	private static final String SIGN_1 = "X";
	private static final String SIGN_2 = "O";
	private static final int NUMBER_OF_PLAYERS = 2;
	
	// variable declaration
	private Player[] players;
	private Board board;
	private int startingPlayer;
	private int currentPlayer;
	
	Game() {
		this.players = new Player[NUMBER_OF_PLAYERS];
		this.players[0] = new Player(SIGN_1);
		this.players[1] = new Player(SIGN_2);
		this.startingPlayer = new Random().nextInt(players.length);
		this.board = new Board();
	}
	
	int readInput(Scanner scanner) {
		int input = 0;
		do {
			System.out.printf("Where do you want to place your sign, player %d(%s)? ", currentPlayer + 1, players[currentPlayer].getSign());
			if (scanner.hasNextInt()) {
				input = scanner.nextInt();
			}
			scanner.nextLine();
		} while (input < 1 || input > 9);
		return input;
	}
	
	int[] parseInput(int input) {
		int row = 2 - ((input - 1) / 3);
		int col = (input - 1) % 3;
		int[] parsedInput = {row, col};
		return parsedInput;
	}
	
	boolean isOver() {
		return (board.isFull() || board.hasWon(players[0].getSign()) || board.hasWon(players[1].getSign()));
	}
	
	private void start() {
		currentPlayer = startingPlayer;
		board.print();
		while (!isOver()) {
			currentPlayer = (currentPlayer + 1) % 2;
			
			int[] coordinates;
			do {
				Scanner inputScanner = new Scanner(System.in);
				int input = readInput(inputScanner);
				coordinates = parseInput(input);
			} while (!board.isSquareEmpty(coordinates[0], coordinates[1]));
			
			board.placeSign(coordinates[0], coordinates[1], players[currentPlayer].getSign());
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
