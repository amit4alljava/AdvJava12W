import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;


public class Demo1 {

	public static void main(String[] args) {
		// 1. No Duplicate
		// 2. Sorted
		TreeSet<String> songs = new TreeSet<String>();
		songs.add("I got the Power");
		songs.add("It's My Life");
		songs.add("Boom Boom");
		songs.add("It's My Life");
		songs.add("Boom Boom");
		songs.add("I got the Power");
		/*songs.add(100);
		songs.add(90.20);
		songs.add(true);*/
		System.out.println(songs);
		
		
		HashMap<String,ArrayList<Integer>> map = new HashMap<>();
		ArrayList<Integer> phonelist = new ArrayList<>();
		phonelist.add(2222);
		phonelist.add(3222);
		phonelist.add(4222);
		map.put("amit",phonelist);
		//map.put("ram",3333);
		System.out.println(map.get("amit").get(0));
		
		
		
		
	}

}
