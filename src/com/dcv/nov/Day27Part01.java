package src.com.dcv.nov;

import java.util.Random;

public class Day27Part01 {
	// Config single knight
	static int startRow = 0;
	static int startCol = 0;
	static int endRow = 7;
	static int endCol = 7;
	static Random random = new Random();

	// Config two nights
	static int startRowOne = 0;
	static int startColOne = 0;
	static int startRowTwo = 7;
	static int startColTwo = 7;
	static char playerOne = 'X';
	static char playerTwo = 'Z';

	public static void simpleChessMove() {
		int row = startRow;
		int col = startCol;
		char player = 'X';
		boolean isEnd = false;

		printChessField(row, col, player);
		while (!isEnd) {
			int[] move = moveByChance(row, col);
			row = move[0];
			col = move[1];
			
			isEnd = checkEnd(row, col);
			printChessField(row, col, player);
			timeSleep(400);
		}
	}

	public static void advancedChessMove() {
		int rowOne = startRowOne;
		int colOne = startColOne;
		int rowTwo = startRowTwo;
		int colTwo = startColTwo;

		boolean isEnd = false;

		printChessField(rowOne, colOne, rowTwo, colTwo);

		// This is not very beautiful, lots of duplicate stuff...
		while (!isEnd) {
			int[] moveOne  = moveByChance(rowOne, colOne);
			rowOne = moveOne [0];
			colOne = moveOne [1];
			isEnd = checkCollision(rowOne, colOne, rowTwo, colTwo);

			if (isEnd) {
				printChessField(rowOne, colOne, playerOne);
				timeSleep(400);
				break;
			} else {
				printChessField(rowOne, colOne, rowTwo, colTwo);
				timeSleep(400);
			}

			int[] moveTwo  = moveByChance(rowTwo, colTwo);
			rowTwo = moveTwo [0];
			colTwo = moveTwo [1];
			isEnd = checkCollision(rowOne, colOne, rowTwo, colTwo);
			
			if (isEnd) {
				printChessField(rowTwo, colTwo, playerTwo);
				timeSleep(400);
				break;
			} else {
				printChessField(rowOne, colOne, rowTwo, colTwo);
				timeSleep(400);
			}
		}
	}

	private static void printChessField(int rowPosition, int colPosition, char player) {
		char[][] chessField = new char[8][8];
		chessField[rowPosition][colPosition] = player;
		printChessField(chessField);
	}

	private static void printChessField(int rowOne, int colOne, int rowTwo, int colTwo) {
		char[][] chessField = new char[8][8];
		chessField[rowOne][colOne] = playerOne;
		chessField[rowTwo][colTwo] = playerTwo;
		printChessField(chessField);
	}

	private static void printChessField(char[][] arr) {
		StringBuilder sb = new StringBuilder();

		sb.append("  -------------------------------\n");
		for (int row = 7; row >= 0; row--) {
			int userRow = row + 1;
			sb.append(userRow + "|");
			for (int col = 0; col <= 7; col++) {
				char character = arr[row][col];
				if (character == 0) {
					sb.append("   |");
				} else {
					sb.append(" " + character + " |");
				}
			}
			sb.append("\n  -------------------------------\n");
		}
		sb.append("   a   b   c   d   e   f   g   h\n");
		System.out.println(sb);
	}

	private static int[] moveByChance(int currRow, int currCol) {
		int[] newCoordinates = new int[2];
		boolean validMove = false;

		while (!validMove) {
		int moveRow = 0;
		int moveCol = 0;
		int move = random.nextInt(8);

		switch (move) {
			case 0:
				moveRow = 2;
				moveCol = 1;
				break;
			case 1:
				moveRow = 1;
				moveCol = 2;
				break;
			case 2:
				moveRow = -1;
				moveCol = 2;
				break;
			case 3:
				moveRow = -2;
				moveCol = 1;
				break;
			case 4:
				moveRow = -2;
				moveCol = -1;
				break;
			case 5:
				moveRow = -1;
				moveCol = -2;
				break;
			case 6:
				moveRow = 1;
				moveCol = -2;
				break;
			case 7:
				moveRow = 2;
				moveCol = -1;
				break;
			}

			int row = currRow + moveRow;
			int col = currCol + moveCol;

			if (onField(row, col)) {
				validMove = true;
				newCoordinates[0] = row;
				newCoordinates[1] = col;
			}
		}
		return newCoordinates;
	}

	// Helper methods --------------------------------------------------------------------------
	private static boolean checkEnd(int row, int col) {
		boolean isEnd = false;

		if (row == endRow && col == endCol) {
			isEnd = true;
		}
		return isEnd;
	}

	private static boolean onField(int row, int col) {
		boolean onField = false;

		if (row >= 0 && row <= 7 && col >= 0 && col <= 7) {
			onField = true;
		}
		return onField;
	}

	public static void timeSleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ie) {
            // I don't care about that
        }
	}
	
	public static boolean checkCollision(int rowOne, int colOne, int rowTwo, int colTwo) {
		boolean hasCollided = false;

		if (rowOne == rowTwo && colOne == colTwo) {
			hasCollided = true;
		}
		return hasCollided;
	}
}