package src.com.dcv.jan.day46.models;

public class ArtPiece {
	private String type;
	private String title;
	private String creator;
	private String creationDate;
	private Integer price;
 
	public ArtPiece(String type, String title, String creator, String creationDate, Integer price) {
		this.type = type;
		this.title = title;
		this.creator = creator;
		this.creationDate = creationDate;
		this.price = price;
	}

	public String getInfo() {
		return "ArtPiece: " + title + " from " + creator;
	}
	
}
