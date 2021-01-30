package src.com.dcv.jan.day46.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ArtPiece {
	private String type;
	private String title;
	private String creator;
	private Date creationDate;
	private Integer price;
 
	public ArtPiece(String type, String title, String creator, Date creationDate, Integer price) {
		this.type = type;
		this.title = title;
		this.creator = creator;
		this.creationDate = creationDate;
		this.price = price;
	}

	public String getInfo() {
		return "ArtPiece: " + title + " from " + creator;
	}

	public String getFullInfo() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");  

		String fullInfo = "Art Piece: " + title + " from " + creator + "\n" +
			"Type: " + type + "\n" +
			"Creation Date: "  + dateFormat.format(creationDate) + "\n" +
			"Price: "  + price + "\n";
		return fullInfo;
	}
}
