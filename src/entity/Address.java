package entity;

public class Address {

	private int id, zipcode;
	private String city;

	public Address() {}

	public Address(String city, int zipcode) {

		this.zipcode = zipcode;
		this.city = city;
	}

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public int getZipcode() { return zipcode; }

	public void setZipcode(int zipcode) { this.zipcode = zipcode; }

	public String getCity() { return city; }

	public void setCity(String city) { this.city = city; }

}
