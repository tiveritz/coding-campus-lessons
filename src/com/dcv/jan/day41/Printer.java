package src.com.dcv.jan.day41;

public class Printer {
	public static void timeSleep(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException ie) {
			// I don't care about that
		}
	}

	public static void print(String string, int indentation) {
		indentation *= 2;
		for (int i = 0; i < indentation; i++) {
			System.out.print(" ");
		}
		System.out.println(string);
		timeSleep(100);
	}	
}
