import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

class SortById implements Comparator<Employee>{
	public int compare(Employee obj1 , Employee obj2){
		return obj1.getId().compareTo(obj2.getId());
	}
}

class SortByName implements Comparator<Employee>{
	public int compare(Employee obj1 , Employee obj2){
		return obj1.getName().compareTo(obj2.getName());
	}
}

public class SortingDemo {

	public static void main(String[] args) {
		ArrayList<Employee> empList = new ArrayList<>();
		Employee ram = new Employee(1001, "ram");
		empList.add(ram);
		empList.add(new Employee(1002, "Shyam"));
		empList.add(new Employee(1003, "anil"));
		empList.add(new Employee(1004, "Mike"));
		//System.out.println(empList);
		// 1st Way of Traverse
		/*for(int i = 0 ; i<empList.size(); i++){
			System.out.println(empList.get(i));
		}*/
		// 2nd Way of Traverse
		/*Iterator<Employee> i = empList.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
			//i.remove();
		}*/
		// 3rd Way
		/*ListIterator<Employee> i = empList.listIterator();
		while(i.hasNext()){
			System.out.println(i.next());
			//i.remove();
		}
		while(i.hasPrevious()){
			System.out.println(i.previous());
			//i.remove();
		}*/
		// 4th Way
		/*for(Employee e : empList){
			System.out.println(e);
		}*/
		// 5th Way
		empList.forEach((e)->System.out.println(e));
		
		SortById id = new SortById();
		Collections.sort(empList,id);
		Collections.sort(empList,new SortByName());
		Comparator<Employee> sortByName = new Comparator<Employee>() {
			@Override
			public int compare(Employee obj1 , Employee obj2){
			return obj1.getName().compareTo(obj2.getName());
			}
		};
		Collections.sort(empList,sortByName);
		Collections.sort(empList,new Comparator<Employee>() {
			@Override
			public int compare(Employee obj1 , Employee obj2){
			return obj1.getName().compareTo(obj2.getName());
			}
		});
		
		Comparator<Employee> comp = (obj1,obj2)-> obj1.getName().compareTo(obj2.getName());
		Collections.sort(empList,comp);
		
		Collections.sort(empList,(obj1,obj2)->obj1.getName().compareTo(obj2.getName()));
		
		
		
		
		System.out.println("After Sort ");
		empList.forEach((e)->System.out.println(e));
	}

}
