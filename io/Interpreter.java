package io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import gui.Dashboard;

/**
 * The Interpreter class acts as the bridge between data stored in .xml files and the application itself.
 * 
 * References:
 * - http://stackoverflow.com/questions/5386991/java-most-efficient-method-to-iterate-over-all-elements-in-a-org-w3c-dom-docume
 * - http://docs.oracle.com/javase/tutorial/displayCode.html?code=http://docs.oracle.com/javase/tutorial/uiswing/examples/components/IconDemoProject/src/components/IconDemoApp.java
 * - http://www.w3schools.com/xml/dom_nodes_remove.asp
 * - https://docs.oracle.com/javase/tutorial/jaxp/xslt/writingDom.html
 * - http://www.w3schools.com/xml/dom_nodes_replace.asp
 * - https://docs.oracle.com/javase/tutorial/essential/io/pathOps.html
 * @author yinyee
 */
public class Interpreter {
	
	private NodeList searchSpace;
	
	/**
	 * The verify() method is written specifically for the Login class.
	 * It checks that:
	 * - the username exists in the database
	 * - the password matches the username provided
	 * @param domain The .xml file containing the login details
	 * @param username The username provided by the user
	 * @param password The password provided by the user
	 * @param login The instance of the Login window
	 * @return Message about the login attempt
	 */	
	public String verify(URI domain, String username, String password, JFrame login) {
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
						dWindow.setVisible(true);
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
	 * It returns the patients which match the search terms provided by the user.
	 * 
	 * @param domain The .xml file containing patient data
	 * @param searchField The field specified by the user, e.g. first name
	 * @param searchText The term specified by the user, e.g. "Alex"
	 * @return The patients which match the search terms provided
	 */
	public String[][] searchPatients(URI domain, String searchField, String searchText) {
		
		Document doc = parse(domain);
		doc.getDocumentElement().normalize();
		
		String tagName = null;
		switch (searchField) {
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
			if (searchSpace.item(i).getFirstChild().getTextContent().contains(searchText)) {
				searchResults.add(searchSpace.item(i).getParentNode());
			}
		}
		
		String[][] array;		
		if (searchResults.isEmpty()) {
			array = null;
		} else {
			
			ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();		
			int rowCount = 0;			
			for (int j = 0; j < searchResults.size(); j++) { // Loop through the number of search results
				NodeList patient = searchResults.get(j).getChildNodes(); // Load each result
				ArrayList<String> row = new ArrayList<String>();
				for (int k = 0; k < patient.getLength(); k++) { // Loop through the fields
					Node currentNode = patient.item(k);
					if (currentNode.getNodeType() == Node.ELEMENT_NODE) { // Add if node is an element
						row.add(currentNode.getFirstChild().getTextContent());
					}
				}
				table.add(row); // Add row
				rowCount++;
			}
			
			int colCount = 0;
			NodeList headerNodes = searchResults.get(0).getChildNodes();
			for (int x = 0; x < headerNodes.getLength(); x++) {
				if(headerNodes.item(x).getNodeType() == Node.ELEMENT_NODE) {
					colCount++;
				}
			}
					
			array = new String[rowCount][colCount];
			for (int y = 0; y < rowCount; y++) {
				String[] rowArray = new String[table.get(y).size()];
				table.get(y).toArray(rowArray);
				array[y] = rowArray;
			}

		}		
		return array;
	}
	
	/**
	 * The saveNewPatient() method adds a new patient to the database.
	 * @param domain The .xml file containing patient data
	 * @param newPatient Data of the new patient
	 */
	public void saveNewPatient(URI domain, String[] newPatient) {
		
		Document doc = parse(domain);
		doc.getDocumentElement().normalize();
		
		NodeList database = doc.getElementsByTagName("patient");
		
		Node newNode = doc.createElement("patient");
		NodeList tags = database.item(0).getChildNodes();
		for (int i = 0; i < tags.getLength(); i++) {
			Node element = doc.createElement(tags.item(i).getNodeName());
			element.setTextContent(newPatient[i]);
			newNode.appendChild(element);
		}
		doc.getDocumentElement().appendChild(newNode);
		write(domain, doc.getDocumentElement());

	}
	/**
	 * The saveEditedPatient() method saves edits made to the patient.
	 * @param domain The .xml file containing patient data
	 * @param original The original patient data
	 * @param edited The edited patient data
	 */
	public void saveEditedPatient(URI domain, String[] original, String[] edited) {
		
		Document doc = parse(domain);
		doc.getDocumentElement().normalize();
		
		NodeList database = doc.getElementsByTagName("patient");
		boolean check = false;
		for (int i = 0; i < database.getLength(); i++) {
			NodeList record = database.item(i).getChildNodes();
			for (int j = 0; j < record.getLength(); j++) {
				Node current = record.item(j);
				if (current.getTextContent().equals(original[j])) {
					check = true;
				} else {
					check = false;
					break;
				}
			}
			if (check) {
				Node editedNode = database.item(i);
				NodeList children = editedNode.getChildNodes();
				for (int k = 0; k < children.getLength(); k++) {
					children.item(k).setTextContent(edited[k]);
				}
				database.item(i).getParentNode().replaceChild(database.item(i), editedNode);
			}
		}
		write(domain, doc.getDocumentElement());
	}
	
	/**
	 * The deletePatient() method deletes the patient displayed in the ViewEditPatient screen.
	 * @param domain The .xml file containing patient data
	 * @param target The patient to be deleted
	 */
	public void deletePatient(URI domain, String[] target) {
		
		Document doc = parse(domain);
		doc.getDocumentElement().normalize();
				
		NodeList database = doc.getElementsByTagName("patient");
		
		boolean check = false;
		for (int i = 0; i < database.getLength(); i++) {
			NodeList record = database.item(i).getChildNodes();
			for (int j = 0; j < record.getLength(); j++) {
				Node current = record.item(j);
				if (current.getTextContent().equals(target[j])) {
					check = true;
				} else {
					check = false;
					break;
				}
			}
			System.out.println(check);
			if (check) {
				database.item(i).getParentNode().removeChild(database.item(i));
			}	
		}
		write(domain, doc.getDocumentElement());
	}
	
	/**
	 * The retrieveRecords method is written specifically for the ViewEditPatient class.
	 * It retrieves existing records associated with the specified patient.
	 * @param domain The .xml file containing record data
	 * @param firstName The patient's first name, which, together with the patient's last name, is used to match records to the patient
	 * @param lastName The patient's last name, which, together with the patient's first name, is used to match records to the patient
	 * @return The records that belong to that patient
	 */
	public String[][] retrieveRecords(URI domain, String firstName, String lastName) {
		
		Document doc = parse(domain);
		doc.getDocumentElement().normalize();
				
		NodeList searchSpace = doc.getElementsByTagName("record");
		
		ArrayList<Node> searchResults = new ArrayList<Node>();
		for (int i = 0; i < searchSpace.getLength(); i++) {
			System.out.println(searchSpace.item(i).getFirstChild().getTextContent());
			System.out.println(searchSpace.item(i).getFirstChild().getNextSibling().getTextContent());
			if (searchSpace.item(i).getFirstChild().getTextContent().equals(firstName) &&
					searchSpace.item(i).getFirstChild().getNextSibling().getTextContent().equals(lastName)) {
				searchResults.add(searchSpace.item(i));
			}
		}		
		
		String[][] array;
		if (searchResults.isEmpty()) {
			array = null;
		} else {
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
					
			array = new String[rowCount][colCount];
			for (int i = 0; i < rowCount; i++) {
				String[] rowArray = new String[table.get(i).size()];
				table.get(i).toArray(rowArray);
				array[i] = rowArray;
			}
		}
		return array;
	}
	
	/**
	 * The saveNewRecord() method adds a new record to the patient's profile.
	 * @param domain The .xml file containing record data
	 * @param newRecord Data of the new record
	 */
	public void saveNewRecord(URI domain, String[] newRecord) {
		
		Document doc = parse(domain);
		doc.getDocumentElement().normalize();
		
		NodeList database = doc.getElementsByTagName("record");
		
		Node newNode = doc.createElement("record");
		NodeList tags = database.item(0).getChildNodes();
		for (int i = 0; i < tags.getLength(); i++) {
			System.out.println(tags.item(i).getNodeName());
			System.out.println(newRecord[i]);
			Node element = doc.createElement(tags.item(i).getNodeName());
			element.setTextContent(newRecord[i]);
			newNode.appendChild(element);
		}
		doc.getDocumentElement().appendChild(newNode);
		write(domain, doc.getDocumentElement());
	}
		
	/**
	 * The saveEditedRecord() saves the edits made in the ViewEditRecord screen.
	 * @param domain The .xml file containing record data
	 * @param original The original record
	 * @param edited The edited record
	 */
	public void saveEditedRecord(URI domain, String[] original, String[] edited) {
		
		Document doc = parse(domain);
		doc.getDocumentElement().normalize();
		
		NodeList database = doc.getElementsByTagName("record");
		boolean check = false;
		for (int i = 0; i < database.getLength(); i++) {
			NodeList record = database.item(i).getChildNodes();
			for (int j = 0; j < record.getLength(); j++) {
				Node current = record.item(j);
				if (current.getTextContent().equals(original[j])) {
					check = true;
				} else {
					check = false;
					break;
				}
			}
			if (check) {
				Node editedNode = database.item(i);
				NodeList children = editedNode.getChildNodes();
				for (int k = 0; k < children.getLength(); k++) {
					children.item(k).setTextContent(edited[k]);
				}
				database.item(i).getParentNode().replaceChild(database.item(i), editedNode);
			}
		}
		write(domain, doc.getDocumentElement());
	}

	/**
	 * The deleteRecord() method deletes the record displayed in the ViewEditRecord screen.
	 * @param domain The .xml file containing record data
	 * @param target The record to be deleted
	 */
	public void deleteRecord(URI domain, String[] target) {
		
		Document doc = parse(domain);
		doc.getDocumentElement().normalize();
				
		NodeList database = doc.getElementsByTagName("record");
		
		boolean check = false;
		for (int i = 0; i < database.getLength(); i++) {
			NodeList record = database.item(i).getChildNodes();
			for (int j = 0; j < record.getLength(); j++) {
				Node current = record.item(j);
				if (current.getTextContent().equals(target[j])) {
					check = true;
				} else {
					check = false;
					break;
				}
			}
			System.out.println(check);
			if (check) {
				database.item(i).getParentNode().removeChild(database.item(i));
			}	
		}
		write(domain, doc.getDocumentElement());
	}
	
	/**
	 * The importPatients() method allows the user to import an .xml file containing
	 * patient data into the database.  The new data is appended to the existing data.
	 * @param domain The .xml file containing patient data
	 * @param file The .xml file containing additional patient data to be imported
	 */
	public void importPatients(URI domain, URI file) {
		
		Document original = parse(domain);
		original.getDocumentElement().normalize();
		
		Document additional = parse(file);
		additional.getDocumentElement().normalize();
		
		NodeList database = original.getElementsByTagName("patient");
		NodeList newPatients = additional.getElementsByTagName("patient");
		
		NodeList tags = database.item(0).getChildNodes();
		for (int a = 0; a < newPatients.getLength(); a++) {
			NodeList newPatient = newPatients.item(a).getChildNodes();
			Node newNode = original.createElement("patient");
			for (int i = 0; i < tags.getLength(); i++) {
				Node element = original.createElement(tags.item(i).getNodeName());
				if (newPatient.item(i).getNodeName().equals(tags.item(i).getNodeName())) {
					element.setTextContent(newPatient.item(i).getTextContent());
					newNode.appendChild(element);
				}
			}
			original.getDocumentElement().appendChild(newNode);
		}
		write(domain, original.getDocumentElement());
	}
	
	/**
	 * The exportPatientData() method exports selected rows from the patient search
	 * results table in the Dashboard to a file called "export.xml" in the bin folder.
	 * @param domain The .xml file containing patient data
	 * @param exportFile The "export.xml" file containing the exported data
	 * @param exportRecords The patient records to be exported
	 */
	public void exportPatientData(URI domain, URI exportFile, String[][] exportRecords) {
		
		Document original = parse(domain);
		original.getDocumentElement().normalize();
		
		Document doc = parse(exportFile);
		doc.getDocumentElement().normalize();
		
		NodeList database = original.getElementsByTagName("patient");
		NodeList tags = database.item(0).getChildNodes();
		
		for (int a = 0; a < exportRecords.length; a++) {
			Node newNode = doc.createElement("patient");
			for (int i = 0; i < tags.getLength(); i++) {
				Node element = doc.createElement(tags.item(i).getNodeName());
				element.setTextContent(exportRecords[a][i].toString());
				newNode.appendChild(element);
			}
			doc.getDocumentElement().appendChild(newNode);
		}
		write(exportFile, doc.getDocumentElement());
	}

	/**
	 * The parse() method is a helper method for the Interpreter class.  It returns
	 * a parsed XML DOM to the caller.
	 * 
	 * @param domain The URI of the .xml file to be parsed
	 * @return The parsed XML document
	 */
	
	private Document parse(URI domain) {
		Document doc = null;
		try {
			File file = new File(domain);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = factory.newDocumentBuilder();
			doc = docBuilder.parse(file);
		} catch (SAXParseException spe) {
            // Error generated by the parser
            System.out.println("\n** Parsing error"
                               + ", line " + spe.getLineNumber()
                               + ", uri " + spe.getSystemId());
            System.out.println("  " + spe.getMessage() );
  
            // Use the contained exception, if any
            Exception x = spe;
            if (spe.getException() != null)
                x = spe.getException();
            x.printStackTrace();
        }
        catch (SAXException sxe) {
            // Error generated by this application
            // (or a parser-initialization error)
            Exception x = sxe;
            if (sxe.getException() != null)
                x = sxe.getException();
            x.printStackTrace();
        }
        catch (ParserConfigurationException pce) {
            // Parser with specified options 
            // cannot be built
            pce.printStackTrace();
        }
        catch (IOException ioe) {
            // I/O error
            ioe.printStackTrace();
        }
		return doc;
	}

	/**
	 * The write() method writes to the specified file.
	 * @param domain The .xml file to be written to
	 * @param node The starting node of the XML DOM subtree
	 */
	public void write(URI domain, Node node) {

		Document document = parse(domain);
		DOMSource source = new DOMSource(node);
	    StreamResult result = new StreamResult(System.out);
	    
		TransformerFactory tFactory = TransformerFactory.newInstance();
	    Transformer transformer;
		try {
			StreamResult test = new StreamResult(new File(domain));
			transformer = tFactory.newTransformer();
			transformer.transform(source, result);
			transformer.transform(source, test);
			if (document.getDoctype() != null) {
			    String systemValue = (new File (document.getDoctype().getSystemId())).getName();
			    transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, systemValue);
			}
		} catch (TransformerConfigurationException tce) {
			tce.printStackTrace();
		} catch (TransformerException te) {
			te.printStackTrace();
		}
	}
}
