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
	
	public String getLongFormattedDate() {
		switch (month) {
		case 1: return "January " + date + ", " + year;
		case 2:	return "February " + date + ", " + year;
		case 3:	return "March " + date + ", " + year;
		case 4:	return "April " + date + ", " + year;
		case 5:	return "May " + date + ", " + year;
		case 6:	return "June " + date + ", " + year;
		case 7: return "July " + date + ", " + year;
		case 8:	return "August " + date + ", " + year;
		case 9:	return "September " + date + ", " + year;
		case 10:return "October " + date + ", " + year;
		case 11:return "November " + date + ", " + year;
		case 12:return "December " + date + ", " + year;
		default:return " ";
		}
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
