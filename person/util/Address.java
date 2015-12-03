package person.util;

public class Address {

	private String houseNumberOrName;
	private String street;
	private String city;
	private String postalCode;
	private String country;
	
	public Address (String houseNumberOrName, String street, String city, String postalCode, String country) {
		this.houseNumberOrName = houseNumberOrName;
		this.street = street;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
	}
	
	public String getFullAddress() {
		StringBuilder fullAddress = new StringBuilder();
		fullAddress.append(houseNumberOrName + ", " + street + ", " + city + ", " + postalCode + ", " + country);
		return fullAddress.toString();
	}
	
	public String getHouseNumberOrName() {
		return houseNumberOrName;
	}
	
	public String getStreet() {
		return street;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public String getCountry() {
		return country;
	}
}
