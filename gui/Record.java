package gui;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import obj.util.Diseases;

/**
 * The Record class has been declared abstract to prevent it from being instantiated.
 * It has two subclasses -- NewRecord and ViewEditRecord.
 * @author yinyee
 *
 */
public abstract class Record extends JFrame {
	
	private static final long serialVersionUID = 1L;
	protected final static Dimension DIMENSION = new Dimension(450, 500);
	protected final static Insets STANDARDINSETS = new Insets(5, 5, 5, 5);
	protected final static String[] MONTHS = {"---", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	protected final JFileChooser fChooser = new JFileChooser(); 
			
	protected Diseases diseases;
	
	protected JLabel lPatient,lRecordDate, lDoctor, lDiagnosis, lNotes, lAttachment;
	protected JComboBox<String> cboxRecordDate, cboxRecordMonth, cboxRecordYear, cboxDiagnosis;
	protected JSeparator sHorizontal;
	
	protected GridBagConstraints clPatient, cl2Patient, clRecordDate, ccboxRecordDate, ccboxRecordMonth, ccboxRecordYear, 
	clDoctor, cl2Doctor, csHorizontal, clDiagnosis, ccboxDiagnosis, cbGet, clNotes, cl2Notes, clAttachment, cl2Attachment,
	cbEditSave, cbCancel, cbDelete, cbUpload;
	
	/**
	 * The constructor defines the common GUI elements and attributes.
	 */
	public Record() {
		
		lPatient = new JLabel("Patient");
		lRecordDate = new JLabel("Date");
		lDoctor = new JLabel("Doctor");
		lDiagnosis = new JLabel("Diagnosis");
		lNotes = new JLabel("Notes");
		lAttachment = new JLabel("Attachment");
		
		String[] dates = new String[32];
		dates[0] = "---";
		for (int i = 0; i < 31; i++) {
			dates[i + 1] = Integer.toString(i + 1);
		}
		cboxRecordDate = new JComboBox<String>(dates);

		cboxRecordMonth = new JComboBox<String>(MONTHS);
		
		String[] years = new String[101];
		years[0] = "---";
		for (int i = 0; i < 100; i++) {
			years[i + 1] = Integer.toString(i + 1950);
		}
		cboxRecordYear = new JComboBox<String>(years);
		
		sHorizontal = new JSeparator(JSeparator.HORIZONTAL);
		
		diseases = new Diseases();
		cboxDiagnosis = new JComboBox<String>(diseases.getList());
		
		clPatient = new GridBagConstraints();
		cl2Patient = new GridBagConstraints();
		clRecordDate = new GridBagConstraints();
		ccboxRecordDate = new GridBagConstraints();
		ccboxRecordMonth = new GridBagConstraints();
		ccboxRecordYear = new GridBagConstraints();
		clDoctor = new GridBagConstraints();
		cl2Doctor = new GridBagConstraints();
		csHorizontal = new GridBagConstraints();
		clDiagnosis = new GridBagConstraints();
		ccboxDiagnosis = new GridBagConstraints();
		cbGet = new GridBagConstraints();
		clNotes = new GridBagConstraints();
		cl2Notes = new GridBagConstraints();
		clAttachment = new GridBagConstraints();
		cl2Attachment = new GridBagConstraints();
		cbEditSave = new GridBagConstraints();
		cbCancel = new GridBagConstraints();
		cbDelete = new GridBagConstraints();
		cbUpload = new GridBagConstraints();

		cbDelete.gridx = 3;
		cbDelete.gridy = 0;
		cbDelete.gridwidth = 1;
		cbDelete.gridheight = 1;
		cbDelete.anchor = GridBagConstraints.LINE_END;
		cbDelete.insets = STANDARDINSETS;

		clPatient.gridx = 0;
		clPatient.gridy = 1;
		clPatient.gridwidth = 1;
		clPatient.gridheight = 1;
		clPatient.fill = GridBagConstraints.HORIZONTAL;
		clPatient.insets = STANDARDINSETS;

		cl2Patient.gridx = 1;
		cl2Patient.gridy = 1;
		cl2Patient.gridwidth = 1;
		cl2Patient.gridheight = 1;
		cl2Patient.fill = GridBagConstraints.HORIZONTAL;
		cl2Patient.insets = STANDARDINSETS;

		clRecordDate.gridx = 0;
		clRecordDate.gridy = 2;
		clRecordDate.gridwidth = 1;
		clRecordDate.gridheight = 1;
		clRecordDate.fill = GridBagConstraints.HORIZONTAL;
		clRecordDate.insets = STANDARDINSETS;
		
		ccboxRecordMonth.gridx = 1;
		ccboxRecordMonth.gridy = 2;
		ccboxRecordMonth.gridwidth = 1;
		ccboxRecordMonth.gridheight = 1;
		ccboxRecordMonth.fill = GridBagConstraints.HORIZONTAL;
		ccboxRecordMonth.insets = STANDARDINSETS;

		ccboxRecordDate.gridx = 2;
		ccboxRecordDate.gridy = 2;
		ccboxRecordDate.gridwidth = 1;
		ccboxRecordDate.gridheight = 1;
		ccboxRecordDate.anchor = GridBagConstraints.CENTER;
		ccboxRecordDate.insets = STANDARDINSETS;

		ccboxRecordYear.gridx = 3;
		ccboxRecordYear.gridy = 2;
		ccboxRecordYear.gridwidth = 1;
		ccboxRecordYear.gridheight = 1;
		ccboxRecordYear.anchor = GridBagConstraints.LINE_START;
		ccboxRecordYear.insets = STANDARDINSETS;		
		
		clDoctor.gridx = 0;
		clDoctor.gridy = 3;
		clDoctor.gridwidth = 1;
		clDoctor.gridheight = 1;
		clDoctor.fill = GridBagConstraints.HORIZONTAL;
		clDoctor.insets = STANDARDINSETS;

		cl2Doctor.gridx = 1;
		cl2Doctor.gridy = 3;
		cl2Doctor.gridwidth = 3;
		cl2Doctor.gridheight = 1;
		cl2Doctor.fill = GridBagConstraints.HORIZONTAL;
		cl2Doctor.insets = STANDARDINSETS;

		csHorizontal.gridx = 0;
		csHorizontal.gridy = 4;
		csHorizontal.gridwidth = 4;
		csHorizontal.gridheight = 1;
		csHorizontal.fill = GridBagConstraints.HORIZONTAL;
		csHorizontal.insets = STANDARDINSETS;

		clDiagnosis.gridx = 0;
		clDiagnosis.gridy = 5;
		clDiagnosis.gridwidth = 1;
		clDiagnosis.gridheight = 1;
		clDiagnosis.fill = GridBagConstraints.HORIZONTAL;
		clDiagnosis.insets = STANDARDINSETS;

		ccboxDiagnosis.gridx = 1;
		ccboxDiagnosis.gridy = 5;
		ccboxDiagnosis.gridwidth = 2;
		ccboxDiagnosis.gridheight = 1;
		ccboxDiagnosis.fill = GridBagConstraints.HORIZONTAL;
		ccboxDiagnosis.insets = STANDARDINSETS;

		cbGet.gridx = 3;
		cbGet.gridy = 5;
		cbGet.gridwidth = 1;
		cbGet.gridheight = 1;
		cbGet.anchor = GridBagConstraints.LINE_END;
		cbGet.insets = STANDARDINSETS;
		
		clNotes.gridx = 0;
		clNotes.gridy = 6;
		clNotes.gridwidth = 1;
		clNotes.gridheight = 1;
		clNotes.fill = GridBagConstraints.HORIZONTAL;
		clNotes.insets = STANDARDINSETS;

		cl2Notes.gridx = 1;
		cl2Notes.gridy = 6;
		cl2Notes.gridwidth = 3;
		cl2Notes.gridheight = 2;
		cl2Notes.fill = GridBagConstraints.HORIZONTAL;
		cl2Notes.insets = STANDARDINSETS;

		clAttachment.gridx = 0;
		clAttachment.gridy = 8;
		clAttachment.gridwidth = 1;
		clAttachment.gridheight = 1;
		clAttachment.fill = GridBagConstraints.HORIZONTAL;
		clAttachment.anchor = GridBagConstraints.PAGE_START;
		clAttachment.insets = STANDARDINSETS;

		cl2Attachment.gridx = 1;
		cl2Attachment.gridy = 8;
		cl2Attachment.gridwidth = 2;
		cl2Attachment.gridheight = 1;
		cl2Attachment.fill = GridBagConstraints.HORIZONTAL;
		cl2Attachment.insets = STANDARDINSETS;

		cbUpload.gridx = 3;
		cbUpload.gridy = 8;
		cbUpload.gridwidth = 1;
		cbUpload.gridheight = 1;
		cbUpload.anchor = GridBagConstraints.LINE_END;
		cbUpload.insets = STANDARDINSETS;

		cbCancel.gridx = 3;
		cbCancel.gridy = 9;
		cbCancel.gridwidth = 1;
		cbCancel.gridheight = 1;
		cbCancel.anchor = GridBagConstraints.LINE_END;
		cbCancel.insets = STANDARDINSETS;
		
		cbEditSave.gridx = 3;
		cbEditSave.gridy = 10;
		cbEditSave.gridwidth = 1;
		cbEditSave.gridheight = 1;
		cbEditSave.anchor = GridBagConstraints.LINE_END;
		cbEditSave.insets = STANDARDINSETS;

	}
		
	/**
	 * The following overloaded methods to open a web page using the default browser have been
	 * directly taken from this link:
	 * >> http://stackoverflow.com/questions/10967451/open-a-link-in-browser-with-java-button
	 * @param uri
	 */
	
	protected void openWebpage(URI uri) {
	    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
	    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
	        try {
	            desktop.browse(uri);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

	protected void openWebpage(URL url) {
	    try {
	        openWebpage(url.toURI());
	    } catch (URISyntaxException e) {
	        e.printStackTrace();
	    }
	}

}
