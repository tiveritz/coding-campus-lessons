package src.com.dcv.jan.day46.generators;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import src.com.dcv.jan.day46.models.ArtPiece;


public abstract class ArtPieceGenerator {
	// base code von Daniel kopiert!
	private static String[] types = new String[]{"Gemälde", "Skulptur", "Plastik", "Moderne Kunst"};
	private static String[] artists = new String[]{"aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii", "jj", "kk", "ll", "mm", "nn", "oo"};
	private static Date startDate = new Date(-11676096000L);
	private static Date endDate = new Date(1577836800L);
	private static Random random = new Random(System.currentTimeMillis());

	// -- METHODS ----------------------------------------------------------------------------------
	public static ArtPiece createArtPiece() {
		String type = types[random.nextInt(types.length-1)];
		String title = getRandomString(5 + random.nextInt(5));
		String artist = artists[random.nextInt(artists.length-1)];
		Date createdDate = getRandomDate(startDate, endDate);
		Integer price = 100 + random.nextInt(900);
		
		return new ArtPiece(type, title, artist, createdDate, price);
	}

	// -- HELPER -----------------------------------------------------------------------------------
	private static String getRandomString(int length){
		String generatedString = "";
		for (int i = 0; i < length; i++) {
			generatedString += (char)('A' + random.nextInt((byte)'Z'-(byte)'A'));
		}
		return generatedString;
	}

	private static Date getRandomDate(Date startInclusive, Date endExclusive) {
		long startMillis = startInclusive.getTime();
		long endMillis = endExclusive.getTime();
		long randomMillisSinceEpoch = ThreadLocalRandom
				.current()
				.nextLong(startMillis, endMillis);

		return new Date(randomMillisSinceEpoch);
	}
}
