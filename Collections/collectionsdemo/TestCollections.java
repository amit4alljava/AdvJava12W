package collectionsdemo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

public class TestCollections {

	public static void main(String[] args) {
		Customer ram = new Customer();
		ram.setId(1001);
		ram.setName("Ram Kumar");
		ram.setAge(21);
		ram.setPhone("2222");
		//SortByState stateSort = new SortByState();
		//TreeSet<Address> officeAddressSet = new TreeSet<>(stateSort);
		/*TreeSet<Address> officeAddressSet = new TreeSet<>(new Comparator<Address>() {
		public int compare(Address o1 , Address o2){
			return o1.getState().compareToIgnoreCase(o2.getState());
		}
		});*/
		//TreeSet<Address> officeAddressSet = new TreeSet<>((o1,o2)->o1.getState().compareToIgnoreCase(o2.getState()));
		TreeSet<Address> officeAddressSet = new TreeSet<>(SortByState::stateCompare);
		Address first  = new Address();
		first.setCity("Delhi");
		first.setPinCode("110007");
		first.setState("Delhi");
		officeAddressSet.add(first);
		first  = new Address();
		first.setCity("Delhi");
		first.setPinCode("110007");
		first.setState("B");
		officeAddressSet.add(first);
		
		first  = new Address();
		first.setCity("Mumbai");
		first.setPinCode("2110007");
		first.setState("A");
		officeAddressSet.add(first);
		
		TreeSet<Address> resAddressSet = new TreeSet<>();
		
		Address res = new Address();
		res.setCity("NY");
		res.setPinCode("1111");
		res.setState("NY");
		resAddressSet.add(res);
		
		
		res = new Address();
		res.setCity("NY");
		res.setPinCode("1111");
		res.setState("NY");
		resAddressSet.add(res);
		
		Map<String,TreeSet<Address>> addressMap = new HashMap<>();
		addressMap.put("office",officeAddressSet);
		addressMap.put("res",resAddressSet);
		ram.setAddressMap(addressMap);
		
		System.out.println("Office Address****************");
		Iterator<Address> addressIterator = ram.getAddressMap().get("office").iterator();
		while(addressIterator.hasNext()){
			System.out.println(addressIterator.next());
		}
		System.out.println("Res Address *********************");
		 addressIterator = ram.getAddressMap().get("res").iterator();
		while(addressIterator.hasNext()){
			System.out.println(addressIterator.next());
		}
		
		Customer shyam = new Customer();
		
	}

}
