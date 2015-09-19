package collectionsdemo;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Customer {
private int id;
private String name;
private int age;
private String phone;
private Map<String,TreeSet<Address>> addressMap = new HashMap<>();
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public Map<String, TreeSet<Address>> getAddressMap() {
	return addressMap;
}
public void setAddressMap(Map<String, TreeSet<Address>> addressMap) {
	this.addressMap = addressMap;
}
@Override
public String toString() {
	return "Customer [id=" + id + ", name=" + name + ", age=" + age
			+ ", phone=" + phone + ", addressMap=" + addressMap + "]";
}

}
