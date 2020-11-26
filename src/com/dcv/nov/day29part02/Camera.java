package src.com.dcv.nov.day29part02;

import java.util.Collections;
import java.util.Vector;

public class Camera {
	private String name;
	private double resolution;
	private double focalLength;
	private String countryOfOrigin;
	private Vector<String> features = new Vector<String>();
	private String owner;
	
	Camera(String name, double resolution, double focalLength, String countryOfOrigin,
		   String[] initFeatures, String owner) {
		this.name = name;
		this.resolution = resolution;
		this.focalLength = focalLength;
		this.countryOfOrigin = countryOfOrigin;
		Collections.addAll(features, initFeatures);
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public double getResolution() {
		return resolution;
	}

	public double getFocalLength() {
		return focalLength;
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

	public void setName(String name) {
		this.name = name;
	}

	public void setResolution(double resolution) {
		this.resolution = resolution;
	}

	public void setFocalLength(double focalLength) {
		this.focalLength = focalLength;
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

	public void printProductSheet() {
		System.out.println("-----------------------------------");
		System.out.println(this.name + "\n");
		System.out.printf("%-16s %-20s%n", "Resolution:", this.resolution);
		System.out.printf("%-16s %-20s%n", "Focal length:", this.focalLength);

		System.out.println("Awesome Features:");
		for (String feature : features) {
			System.out.printf("%-3s %-20s%n", "- ", feature);
		}
	}
	
}
