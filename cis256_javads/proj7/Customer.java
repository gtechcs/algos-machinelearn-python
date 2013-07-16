package cis256.proj7;

/*
 * Represents  Customer data
 * 
 * @author: Puneet Kumar
 * studentId: G00905264
 * CIS 256 
 */
public class Customer {

	private String name;
	private String address;
	private Integer phoneNumber;
	
	public Customer (String name, String address, Integer phoneNumber){
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * The equals method need to be over ridden.
	 * 
	 */
	public boolean equals(Object obj){
		if(!(obj instanceof Customer)){
			return false;	
		}
		
		if(((Customer)obj).phoneNumber.equals(phoneNumber) && 
				((Customer)obj).name.equals(name)){
			return true;
		}
		
		return false;
	}
	
	/*
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Name:");	
		sb.append(name);	
		sb.append(" Address:");	
		sb.append(address);	
		sb.append(" PhonNumber:");	
		sb.append(phoneNumber);	
		
		return sb.toString();
	}
	
}
