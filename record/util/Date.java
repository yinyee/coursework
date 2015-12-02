package record.util;

public class Date {

	private int date;
	private int month;
	private int year;
	
	public Date(int date, int month, int year) {
		this.date = date;
		this.month = month;
		this.year = year;
	}
	
	public String getFormattedDate() {
		return date + "/" + month + "/" + year;
	}
	
	public int getDate() {
		return date;
	}
	
	public void setDate(int newDate) {
		this.date = newDate;
	}
	
	public int getMonth() {
		return month;
	}
	
	public void setMonth(int newMonth) {
		this.month = newMonth;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int newYear) {
		this.year = newYear;
	}
}
