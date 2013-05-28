
public class Address {

	private String street;
	private long number;
	private String city;
	
	public Address(){
		street = RandomData.street();
		number = RandomData.number();
		city = "Campana";
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String toString(){
		return street + " " + number + " - " + city;
	}
	
	public boolean near(Address address){
		return sameStreet(address.getStreet()) && nearNumber(address.getNumber());
	}

	
	
	
	private boolean nearNumber(long number2) {
		long dif = this.number - number2;
		return dif>0 ? dif<200 : dif>-200 ;
	}

	public boolean sameStreet(String street2) {
		return this.street.equalsIgnoreCase(street2);
	}
}














