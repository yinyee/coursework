package person.util;

import person.Person;

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
	
	public String getAddress(Person person) {
		StringBuilder fullAddress = new StringBuilder();
		fullAddress.append(houseNumberOrName + ", " + street + ", " + city + ", " + postalCode + ", " + country);
		return fullAddress.toString();
	}
}