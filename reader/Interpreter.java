package reader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Interpreter {
	
	private final static File database = new File("/data/database.xml");
	
	
	public ArrayList<Node> search(File file, String searchField, String searchText) {
		
		ArrayList<Node> searchResults = new ArrayList<Node>();
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = factory.newDocumentBuilder();
			Document doc = docBuilder.parse(file);
			doc.getDocumentElement().normalize();
			
			NodeList searchSpace = doc.getElementsByTagName("username");
			
			if (searchSpace.getLength() == 0) {
				/* Do nothing */ ;
			} else {
				for (int i = 0; i < searchSpace.getLength(); i++) {
					if (searchText.equals(searchSpace.item(i).getFirstChild().getTextContent())) {
						searchResults.add(searchSpace.item(i));
						}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchResults;
	}
	
	public void read(File input) {
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = factory.newDocumentBuilder();
			Document doc = docBuilder.parse(input);
			doc.getDocumentElement().normalize();
//			outputDOMTree(doc.getDocumentElement());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void write() {
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(database));
//			wysiwyg.write(writer); // Reference: http://stackoverflow.com/questions/9690686/save-a-the-text-from-a-jtextarea-ie-save-as-into-a-new-txt-file
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
