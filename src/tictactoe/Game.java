package tictactoe;

import java.io.PrintStream;
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
	private PrintStream out;
	
	Game() {
		this.players = new Player[NUMBER_OF_PLAYERS];
		this.players[0] = new Player(SIGN_1);
		this.players[1] = new Player(SIGN_2);
		this.board = new Board();
		this.startingPlayer = new Random().nextInt(players.length);
		out = new PrintStream(System.out);
	}
	
	void printBoard(Board board, PrintStream out) {
		String boardString = "";
		for (int row = 0; row < board.getHeight(); row++) {
			for (int col = 0; col < board.getWidth(); col++) {
				boardString += " " + board.getSquare(row, col) + " ";
				if (col != board.getWidth() - 1) {
					boardString += "|";
				}
			}
			boardString += "\n";
			if (row != board.getHeight() - 1) {
				boardString += "-----------\n";
			}
		}
		out.printf(boardString);
	}
	
	int readInput(Scanner scanner, PrintStream out) {
		int input = 0;
		do {
			out.printf("Where do you want to place your sign, player %d(%s)? ", currentPlayer + 1, players[currentPlayer].getSign());
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
		printBoard(board, out);
		while (!isOver()) {
			currentPlayer = (currentPlayer + 1) % 2;
			
			int[] coordinates;
			do {
				Scanner inputScanner = new Scanner(System.in);
				int input = readInput(inputScanner, out);
				coordinates = parseInput(input);
			} while (!board.getSquare(coordinates[0], coordinates[1]).equals(Board.EMPTY));
			
			board.placeSign(coordinates[0], coordinates[1], players[currentPlayer].getSign());
			printBoard(board, out);
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
