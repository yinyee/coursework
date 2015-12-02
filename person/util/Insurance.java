package person.util;

public class Insurance {

	private String insurer;
	private String policyNumber;
	
	public Insurance (String insurer, String policyNumber) {
		this.insurer = insurer;
		this.policyNumber = policyNumber;
	}
	
	public String getInsurer() {
		return insurer;
	}
	
	public String getPolicyNumber() {
		return policyNumber;
	}
}
