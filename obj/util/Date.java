package obj.util;

public class Date {

	private String date;
	private String month;
	private String year;
	
	public Date(String date, String month, String year) {
		this.date = date;
		this.month = month;
		this.year = year;
	}
	
	public String getFormattedDate() {
		return date + ", " + month + ", " + year;
	}
	
	public String getFormalFormattedDate() {
		return month + " " + date + ", " + year;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String newDate) {
		this.date = newDate;
	}
	
	public String getMonth() {
		return month;
	}
	
	public void setMonth(String newMonth) {
		this.month = newMonth;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String newYear) {
		this.year = newYear;
	}
}
