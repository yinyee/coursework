package obj;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * The Diseases class is a helper class that contains information about the rare cancers that 
 * are being treated by this medical facility.
 * @author yinyee
 */
public class Diseases {
	
	private static HashMap<String, URL>diseases;
	private final static String common = "https://en.wikipedia.org/wiki/";
	private final static String[] list = {"Acanthoma", "Adamantinoma", "Angiosarcoma", "Cholangiocarcinoma", "Chondrosarcoma",
			"Ependymoma", "Esthesioneuroblastoma", "Ganglioglioma", "Germinoma", "Leiomyosarcoma", 
			"Mesothelioma", "Myelofibrosis", "Nesidioblastoma", "Neuroblastoma", "Pheochromocytoma",
			"Somatostatinoma", "Teratoma", "Thymoma", "VIPoma"};
	
	public Diseases() {
		diseases = new HashMap<String, URL>();
		for (String item : list) {
			try {
				diseases.put(item, new URL(common + item));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * The getDiseases() method returns a map of the name of the disease to its Wikipedia URL
	 * @return Map of disease names to their Wikipedia URLs
	 */
	public HashMap<String, URL> getDiseases() {
		return diseases;
	}
	
	/**
	 * The getList() method returns the list of diseases as a String array
	 * @return List of diseases
	 */
	public String[] getList() {
		return list;
	}
	
	/**
	 * The getDiseaseAsInt() method helps to set the JComboBox to the disease corresponding
	 * to the patient's record.
	 * @param disease Name of the disease
	 * @return Index of the disease in the JComboBox
	 */
	public int getDiseaseAsInt(String disease) {
		int index = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i].equals(disease)) {
				index = i;
				break;
			}
		}
		return index;
	}

}
