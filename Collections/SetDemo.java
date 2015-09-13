import java.util.HashSet;

class Customer
{
	int id;
	String name;
	Customer(int id , String name){
		this.id = id ;
		this.name = name;
	}
	public String toString(){
		return "Id "+id +" Name "+name;
	}
	
	public boolean equals(Object o){
		Customer c = (Customer) o;
		if(this.id==c.id && this.name.equals(c.name)){
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public int hashCode(){
		return name.length();
	}
}
public class SetDemo {

	public static void main(String[] args) {
		Customer ram = new Customer(1001,"Ram");
		HashSet<Customer> hashSet = new HashSet<>();
		hashSet.add(ram);
		Customer ram2 = new Customer(1001,"Ram");
		hashSet.add(ram2);
		System.out.println("Ram HashCode "+ram.hashCode());
		System.out.println("Ram2 HashCode  "+ram2.hashCode());
		System.out.println(hashSet);
		
		

	}

}
