package src.com.dcv.jan.day46.models;

import java.text.SimpleDateFormat;
import java.util.Date;

import src.com.dcv.jan.day46.enums.ArtType;
import src.com.dcv.jan.day46.interfaces.IStructurePrinter;


public class ArtPiece implements IStructurePrinter {
	private ArtType type;
	private String title;
	private String creator;
	private Date creationDate;
	private Integer price;
 
	public ArtPiece(ArtType type, String title, String creator, Date creationDate, Integer price) {
		this.type = type;
		this.title = title;
		this.creator = creator;
		this.creationDate = creationDate;
		this.price = price;
	}

	// -- INTERFACE -------------------------------------------------------------------------------
	public String getStructure(int indentation) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

		String indentationString = "";
		for (int i = 0; i < indentation; i++) {
			indentationString += " ";
		}

		String structure = indentationString + "L Art Piece: " + title + " from " + creator + "\n" +
			indentationString + indentationString + "Type: " + type + "\n" +
			indentationString + indentationString + "Creation Date: "  + dateFormat.format(creationDate) + "\n" +
			indentationString + indentationString + "Price: "  + price + "€\n";
		return structure;
	}

	// -- GETTER -----------------------------------------------------------------------------------
	public String getInfo() {
		return title + " from " + creator;
	}

	public int getPrice() {
		return price;
	}
}
