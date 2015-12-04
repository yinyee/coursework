package record.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

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
	
	public HashMap<String, URL> getDiseases() {
		return diseases;
	}
	
	public String[] getList() {
		return list;
	}

}
