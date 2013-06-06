import java.util.Date;

public class Customer {
	
	private long id;
	private String name;
	private Address address;
	private Date lastVisit;
	private Date birthday;
	
	
	private static long lastId = 0;
	
	public Customer(){
		id = lastId++;
		name = RandomData.name();
		address = new Address();
		lastVisit = new Date();
	}

	public String toString(){
		return id + "- " + name + " - Domicilio: " + address;
	}
	
	public boolean equals(Customer c){
		return (this.id == c.getId());
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Date getLastVisit() {
		return lastVisit;
	}
	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public boolean neighbor(Customer c2) {
		
		return this.address.near( c2.address );
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}