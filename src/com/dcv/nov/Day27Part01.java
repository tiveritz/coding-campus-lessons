package src.com.dcv.nov;

import java.util.Random;

public class Day27Part01 {
	// Config single knight
	static final int START_ROW = 0;
	static final int START_COL = 0;
	static final int END_ROW = 7;
	static final int END_COL = 7;
	static Random random = new Random();

	// Config two nights
	static final int START_ROW_ONE = 0;
	static final int START_COL_ONE = 0;
	static final int START_ROW_TWO = 7;
	static final int START_COL_TWO = 7;
	static final char PLAYER_ONE = 'A';
	static final char PLAYER_TWO = 'B';

	public static void simpleChessMove() {
		int row = START_ROW;
		int col = START_COL;
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
		int rowOne = START_ROW_ONE;
		int colOne = START_COL_ONE;
		int rowTwo = START_ROW_TWO;
		int colTwo = START_COL_TWO;

		boolean isEnd = false;

		printChessField(rowOne, colOne, rowTwo, colTwo);

		// This while loop is not very beautiful, lots of duplicate stuff...
		// Also the result will be predictable (who wins) -> it would be beneficial to randomly
		// choose who starts
		while (!isEnd) {
			int[] moveOne  = moveByChance(rowOne, colOne);
			rowOne = moveOne [0];
			colOne = moveOne [1];
			isEnd = checkCollision(rowOne, colOne, rowTwo, colTwo);

			if (isEnd) {
				printChessField(rowOne, colOne, PLAYER_ONE);
				timeSleep(300);
				break;
			} else {
				printChessField(rowOne, colOne, rowTwo, colTwo);
				timeSleep(300);
			}

			int[] moveTwo  = moveByChance(rowTwo, colTwo);
			rowTwo = moveTwo [0];
			colTwo = moveTwo [1];
			isEnd = checkCollision(rowOne, colOne, rowTwo, colTwo);
			
			if (isEnd) {
				printChessField(rowTwo, colTwo, PLAYER_TWO);
				timeSleep(300);
				break;
			} else {
				printChessField(rowOne, colOne, rowTwo, colTwo);
				timeSleep(300);
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
		chessField[rowOne][colOne] = PLAYER_ONE;
		chessField[rowTwo][colTwo] = PLAYER_TWO;
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

		if (row == END_ROW && col == END_COL) {
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