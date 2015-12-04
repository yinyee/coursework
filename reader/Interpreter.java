package reader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import gui.Dashboard;

/**
 * References:
 * >> http://stackoverflow.com/questions/5386991/java-most-efficient-method-to-iterate-over-all-elements-in-a-org-w3c-dom-docume
 * @author yinyee
 *
 */

public class Interpreter {
	
	private NodeList searchSpace;
	
	/**
	 * The verify() method is written specifically for the Login class.
	 * It checks that:
	 * >> the username exists in the database
	 * >> the password matches the username provided
	 * @param domain
	 * @param username
	 * @param password
	 */
	
	public String verify(String domain, String username, String password) {
		String message = "";
		Document doc = parse(domain);
		doc.getDocumentElement().normalize();	
		searchSpace = doc.getElementsByTagName("username");

		if (searchSpace.getLength() == 0) {
			message = "Error in loading file; please contact administrator";
		} else {
			for (int i = 0; i < searchSpace.getLength(); i++) {
				if (username.equals(searchSpace.item(i).getFirstChild().getTextContent())) {
					if (password.equals(searchSpace.item(i).getLastChild().getTextContent())) {
						Dashboard window = Dashboard.getInstance();
					} else {
						message = "Password is incorrect";
					}
				} else {
					message = "Username does not exist";
				}
			}
		}
		return message;
	}
	
	/**
	 * The search() method is written specifically for the Dashboard class.
	 * 
	 * @param domain
	 * @param searchField
	 * @param searchTerm
	 */
	
	public JTable searchPatient(String domain, String searchField, String searchTerm) {
		
		Document doc = parse(domain);
		doc.getDocumentElement().normalize();
		NodeList searchSpace = null;
		ArrayList<Node> searchResults = new ArrayList<Node>();
		ArrayList<String> header = new ArrayList<String>();
		ArrayList<String> row = new ArrayList<String>();
		ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();
		
		switch (searchField) {
		case "First name" :
			searchSpace = doc.getElementsByTagName("firstName");
			for (int i = 0; i < searchSpace.getLength(); i++) {
				if (searchSpace.item(i).getFirstChild().getTextContent().contains(searchTerm)) {
					searchResults.add(searchSpace.item(i).getParentNode());
				}
			}
			break;
		case "Last name" :
			searchSpace = doc.getElementsByTagName("lastName");
			for (int i = 0; i < searchSpace.getLength(); i++) {
				if (searchSpace.item(i).getFirstChild().getTextContent().contains(searchTerm)) {
					searchResults.add(searchSpace.item(i).getParentNode());
				}
			}
			break;
		case "Gender" :
			searchSpace = doc.getElementsByTagName("gender");
			for (int i = 0; i < searchSpace.getLength(); i++) {
				if (searchSpace.item(i).getFirstChild().getTextContent().contains(searchTerm)) {
					searchResults.add(searchSpace.item(i).getParentNode());
				}
			}
			break;
		case "Postal code" :
			searchSpace = doc.getElementsByTagName("postalCode");
			for (int i = 0; i < searchSpace.getLength(); i++) {
				if (searchSpace.item(i).getFirstChild().getTextContent().contains(searchTerm)) {
					searchResults.add(searchSpace.item(i).getParentNode().getParentNode());
				}
			}
			break;
		case "Doctor" :
			searchSpace = doc.getElementsByTagName("doctor");
			for (int i = 0; i < searchSpace.getLength(); i++) {
				if (searchSpace.item(i).getFirstChild().getTextContent().contains(searchTerm)) {
					searchResults.add(searchSpace.item(i).getParentNode().getParentNode().getParentNode());
				}
			}
			break;
		case "Diagnosis" :
			searchSpace = doc.getElementsByTagName("diagnosis");
			for (int i = 0; i < searchSpace.getLength(); i++) {
				if (searchSpace.item(i).getFirstChild().getTextContent().contains(searchTerm)) {
					searchResults.add(searchSpace.item(i).getParentNode().getParentNode().getParentNode());
				}
			}
			break;
		}
		
		/**
		 * Start with nested ArrayLists to store the search results since
		 * number of search results returned cannot be known in advance.
		 */
		int rowCount = 0;
		for (int i = 0; i < searchResults.size(); i++) {
			NodeList patient = searchResults.get(i).getChildNodes();
			for (int j = 0; j < patient.getLength(); j++) {
				if (patient.item(j).getNodeType() == Node.ELEMENT_NODE && patient.item(j).getFirstChild().getNodeType() == Node.TEXT_NODE) {
					row.add(patient.item(j).getFirstChild().getTextContent());
				} 
			}
			table.add(row);
			rowCount++;
		}
		
		/**
		 * Get headers for Patient element.
		 */
		int colCount = 0;
		NodeList headerNodes = searchResults.get(0).getChildNodes();
		for (int i = 0; i < headerNodes.getLength(); i++) {
			if(headerNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
				header.add(headerNodes.item(i).getNodeName());
				colCount++;
			}
		}
		String[] headerArray = new String[header.size()];
		header.toArray(headerArray);
				
		/**
		 * Unpack the nested ArrayLists into a 2D Array to be output to the JTable.
		 */
		String[][] array = new String[rowCount][colCount];
		for (int i = 0; i < rowCount; i++) {
			String[] rowArray = new String[table.get(i).size()];
			table.get(i).toArray(rowArray);
			array[i] = rowArray;
		}
		System.out.println(table.size());
		for (int i = 0; i < table.size(); i++) {
		System.out.println(table.get(i));}
		JTable result = new JTable(array, headerArray);
		return result;
	}
	
	/**
	 * The parse() method is a helper method for the Interpreter class.  It returns
	 * a parsed XML DOM to the caller.
	 * @param domain
	 * @return
	 */
	
	private Document parse(String domain) {
		Document doc = null;
		try {
			File file = new File(Interpreter.class.getClassLoader().getResource(domain).toURI());
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = factory.newDocumentBuilder();
			doc = docBuilder.parse(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doc;
	}

	public void write(File output) {
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(output));
//			wysiwyg.write(writer); // Reference: http://stackoverflow.com/questions/9690686/save-a-the-text-from-a-jtextarea-ie-save-as-into-a-new-txt-file
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
