import java.util.ArrayList;




class Employee implements Comparable<Employee>
{
	private Integer id;
	private String name;
	Employee(int id , String name){
		this.id = id;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Employee o ){
		//Employee e = (Employee)o;
		//return this.id.compareTo(o.id);
		return this.name.compareToIgnoreCase(o.name);
		//return o.name.compareTo(this.name);
	}
	
	/*@Override
	public boolean equals(Object o){
		boolean isFound = false;
		Employee e = (Employee)o;
		if(this.id>0 && e.id>0){
			if(this.id ==e.id){
				isFound = true;
			}
		}
		if(this.name!=null && e.name!=null){
			if(this.name.trim().length()>0 && e.name.trim().length()>0){
				if(this.name.equals(e.name)){
					isFound = true;
				}
				else
				{
					isFound = false;
				}
			}
		}
		if(this.id==e.id && this.name.equals(e.name)){
			return true;
		}
		else
		{
			return false;
		}
		return isFound;	
	}*/
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
}

public class CRUDDemo {

	public static void main(String[] args) {
		ArrayList<Employee> empList = new ArrayList<Employee>();
		Employee ram = new Employee(1001, "Ram");
		empList.add(ram);
		Employee shyam = new Employee(1002, "Shyam");
		empList.add(shyam);
		System.out.println(empList);
		int id = 1001;
		Employee ramSearch = new Employee(id, "Ram");
		if(empList.contains(ramSearch)){
			System.out.println("Found...");
			empList.set(empList.indexOf(ramSearch),ram);
			//empList.remove(empList.indexOf(ramSearch));
			
		}
		else
		{
			System.out.println("Not Found...");
		}
		

	}

}
