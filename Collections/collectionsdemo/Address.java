package collectionsdemo;

import java.util.Comparator;

class SortByState implements Comparator<Address>{

	@Override
	public int compare(Address o1, Address o2) {
		// TODO Auto-generated method stub
		return o1.getState().compareToIgnoreCase(o2.getState());
	}
	
	
	public static int stateCompare(Address o1, Address o2) {
		// TODO Auto-generated method stub
		return o1.getState().compareToIgnoreCase(o2.getState());
	}
	
	
}

public class Address implements Comparable<Address>{
	private String city;
	private String state;
	private String pinCode;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", pinCode="
				+ pinCode + "]";
	}
	@Override
	public int compareTo(Address o) {
		// TODO Auto-generated method stub
		return this.city.compareToIgnoreCase(o.city);
	}
	

}
