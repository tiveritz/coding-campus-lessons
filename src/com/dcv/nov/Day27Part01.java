package src.com.dcv.nov;

import java.util.Random;

public class Day27Part01 {
	static int startRow = 0;
	static int startCol = 0;
	static int endRow = 7;
	static int endCol = 7;
	static Random random = new Random();

	public static void simpleChessMove() {
		int row = startRow;
		int col = startCol;
		boolean isEnd = false;
		printChessField2 (row, col);
		
		while (!isEnd) {
			int[] move = moveByChance(row, col);
			row = move[0];
			col = move[1];
			
			isEnd = checkEnd(row, col) ? true : false;
			printChessField2 (row, col);
			timeSleep(400);
		}
	}

	private static void printChessField2(int rowPosition, int colPosition) {
		System.out.println("  ________________________________");
		for (int row = 7; row >= 0; row--) {
			int userRow = row + 1;
			System.out.print(userRow + "|");
			for (int col = 0; col <= 7; col++) {
				if ((col == colPosition) && (row == rowPosition)) System.out.print(" X |");
				else System.out.print("   |");
			}
			System.out.println("\n  --------------------------------");
		}
		System.out.println("   a   b   c   d   e   f   g   h");
		System.out.println();
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
}