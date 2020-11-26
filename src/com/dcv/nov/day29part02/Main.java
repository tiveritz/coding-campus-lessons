package src.com.dcv.nov.day29part02;


 /* Create a camera object and implement get and set methods for the values.
  * name (set / get)
  * resolution (set / get)
  * focal length (set / get)
  * country of origin (set / get)
  * functions (multiple) (set / get)
  * owner (set / get)
  * product data sheet (get) -> add values and return formatted String
  */

public class Main {
	public static void main (String[] args) {
		
		// Construction Cameras
		String[] cam1Features = {"Autofocus", "4K Video", "Nuclear Blast Protection"};
		Camera cam1 = new Camera("Panasonic DC-LX100M2", 17.0, 10.9, "China", cam1Features, "Blassmoyr");

		String[] cam2Features = {"Autofocus", "Roflcopter Animation", "5x Optical Zoom"};
		Camera cam2 = new Camera("Sony Alpha 5100", 24.3, 16.0, "Bangladesh", cam2Features, "Markmayr");

		// Test if cam1 worked
		System.out.println("-----------------------------------");
		System.out.println(cam1.getName() + ", " +
						   cam1.getResolution() + ", " +
						   cam1.getFocalLength() + ", " +
						   cam1.getCountryOfOrigin() + ", " +
						   cam1.getOwner());
	
		for (String feature : cam1.getFeatures()) {
			System.out.print(feature + ", ");
		}
		System.out.println();

		// Test if cam2 worked
		System.out.println("-----------------------------------");
		System.out.println(cam2.getName() + ", " +
						   cam2.getResolution() + ", " +
						   cam2.getFocalLength() + ", " +
						   cam2.getCountryOfOrigin() + ", " +
						   cam2.getOwner());
	
		for (String feature : cam2.getFeatures()) {
			System.out.print(feature + ", ");
		}
		System.out.println();

		// Change some values in cam 1 and print product sheet:
		cam1.setResolution(55.0);
		cam1.addFeature("8K Movie");
		cam1.addFeature("RAW Images");
		System.out.println(cam1.getProductSheet());

	}
}
