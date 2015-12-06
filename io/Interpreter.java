package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import gui.Dashboard;

/**
 * The Interpreter class acts as the bridge between data stored in .xml files and the application itself.
 * 
 * References:
 * >> http://stackoverflow.com/questions/5386991/java-most-efficient-method-to-iterate-over-all-elements-in-a-org-w3c-dom-docume
 * @author yinyee
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
	public String verify(String domain, String username, String password, JFrame login) {
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
						Dashboard dWindow = Dashboard.getInstance();
						login.dispose();
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
	public String[][] searchPatient(String domain, String searchField, String searchTerm) {
		
		Document doc = parse(domain);
		doc.getDocumentElement().normalize();
		
		String tagName = null;
		switch(searchField) {
		case "First name" :
			tagName = "firstName";
			break;
		case "Last name" :
			tagName = "lastName";
			break;
		case "Gender" :
			tagName = "gender";
			break;
		case "Birth date" :
			tagName = "birthDate";
			break;
		case "Birth month" :
			tagName = "birthMonth";
			break;
		case "Birth year" :
			tagName = "birthYear";
			break;
		case "Email address" :
			tagName = "emailAddress";
			break;
		case "Mobile phone number" :
			tagName = "mobilePhoneNumber";
			break;
		case "Home phone number" :
			tagName = "homePhoneNumber";
			break;
		case "House number or name" :
			tagName = "numberOrName";
			break;
		case "Street" :
			tagName = "street";
			break;
		case "City" :
			tagName = "city";
			break;
		case "Postal code" :
			tagName = "postalCode";
			break;
		case "Country" :
			tagName = "country";
			break;
		}
		
		NodeList searchSpace = doc.getElementsByTagName(tagName);
		
		ArrayList<Node> searchResults = new ArrayList<Node>();
		
		for (int i = 0; i < searchSpace.getLength(); i++) {
			if (searchSpace.item(i).getFirstChild().getTextContent().contains(searchTerm)) {
				searchResults.add(searchSpace.item(i).getParentNode());
			}
		}
		
		ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();
		
		int rowCount = 0;
		
		for (int i = 0; i < searchResults.size(); i++) { // Loop through the number of search results
			NodeList patient = searchResults.get(i).getChildNodes(); // Load each result
			ArrayList<String> row = new ArrayList<String>();
			for (int j = 0; j < patient.getLength(); j++) { // Loop through the fields
				Node currentNode = patient.item(j);
				if (currentNode.getNodeType() == Node.ELEMENT_NODE) { // Add if node is an element
					row.add(currentNode.getFirstChild().getTextContent());
				}
			}
			table.add(row); // Add row
			rowCount++;
		}
		
		int colCount = 0;
		NodeList headerNodes = searchResults.get(0).getChildNodes();
		for (int i = 0; i < headerNodes.getLength(); i++) {
			if(headerNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
				colCount++;
			}
		}
				
		String[][] array = new String[rowCount][colCount];
		for (int i = 0; i < rowCount; i++) {
			String[] rowArray = new String[table.get(i).size()];
			table.get(i).toArray(rowArray);
			array[i] = rowArray;
		}
		return array;
	}
	
	/**
	 * The retrieveRecords method is written specifically for the ViewEditPatient class.
	 * It retrieves existing records associated with the specified patient.
	 * @param domain
	 * @param firstName
	 * @param lastName
	 */
	public String[][] retrieveRecords(String domain, String firstName, String lastName) {
		
		Document doc = parse(domain);
		doc.getDocumentElement().normalize();
		
		NodeList searchSpace = doc.getElementsByTagName("record");
		ArrayList<Node> searchResults = new ArrayList<Node>();
		
		for (int i = 0; i < searchSpace.getLength(); i++) {
			if (searchSpace.item(i).getFirstChild().getNextSibling().getTextContent().equals(firstName) &&
					searchSpace.item(i).getFirstChild().getNextSibling().getNextSibling().getNextSibling().getTextContent().equals(lastName)) {
				searchResults.add(searchSpace.item(i));

			}
		}
		
		ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();
		int rowCount = 0;
		
		for (int i = 0; i < searchResults.size(); i++) { // Loop through the number of search results
			NodeList record = searchResults.get(i).getChildNodes(); // Load each result
			ArrayList<String> row = new ArrayList<String>();
			for (int j = 0; j < record.getLength(); j++) { // Loop through the fields
				Node currentNode = record.item(j);
				if (currentNode.getNodeType() == Node.ELEMENT_NODE) { // Add if node is an element
					row.add(currentNode.getFirstChild().getTextContent());
				}
			}
			table.add(row); // Add row
			rowCount++;
		}
		
		int colCount = 0;
		NodeList headerNodes = searchResults.get(0).getChildNodes();
		for (int i = 0; i < headerNodes.getLength(); i++) {
			if(headerNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
				colCount++;
			}
		}
				
		String[][] array = new String[rowCount][colCount];
		for (int i = 0; i < rowCount; i++) {
			String[] rowArray = new String[table.get(i).size()];
			table.get(i).toArray(rowArray);
			array[i] = rowArray;
		}
		
		return array;
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

	/**
	 * 
	 * @param output
	 */
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
