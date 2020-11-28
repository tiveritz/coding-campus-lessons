package src.com.dcv.nov.day29part02;

import java.util.Collections;
import java.util.Vector;

public class Camera {
	private String name;
	private double resolution;
	private Lens lens;
	private String countryOfOrigin;
	private Vector<String> features = new Vector<String>();
	private String owner;
	
	Camera(String name, double resolution, Lens lens, String countryOfOrigin,
		   String[] initFeatures, String owner) {
		this.name = name;
		this.resolution = resolution;
		this.lens = lens;
		this.countryOfOrigin = countryOfOrigin;
		Collections.addAll(features, initFeatures);
		this.owner = owner;
	}

	// getter --------------------------------------------------------------------------------------
	public String getName() {
		return name;
	}

	public double getResolution() {
		return resolution;
	}

	public String getFocalLengths() {
		return lens.toString();
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public String[] getFeatures() {
		return features.toArray(new String[features.size()]);
	}

	public String getOwner() {
		return owner;
	}

	public String getProductSheet() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n-----------------------------------\n")
		  .append(this.name + "\n")
		  .append(String.format("%-16s %-20s%n", "Resolution:", this.resolution))
		  .append("Current lens: " + lens.toString() + "\n");

		System.out.println("Awesome Features:");
		for (String feature : features) {
			sb.append(String.format("%-3s %-20s%n", "- ", feature));
		}
		return sb.toString();
	}

	// setter --------------------------------------------------------------------------------------
	public void setName(String name) {
		this.name = name;
	}

	public void setResolution(double resolution) {
		this.resolution = resolution;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public void addFeature(String feature) {
		features.add(feature);
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setLens(Lens lens) {
		this.lens = lens;
	}
}
