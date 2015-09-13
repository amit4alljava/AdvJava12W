import java.util.HashMap;
import java.util.TreeSet;


public class MapDemo {

	public static void main(String[] args) {
		HashMap<String,Object> map = new HashMap<>();
		TreeSet<Integer> amitPhones = new TreeSet<>();
		amitPhones.add(2222);
		amitPhones.add(2222);
		amitPhones.add(3333);
		map.put("amit", amitPhones);
		//map.put("amit",3333);
		map.put("ram", 3333);
		System.out.println(map.get("amit"));
		System.out.println(map);
		

	}

}
