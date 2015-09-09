import java.util.ArrayList;
import java.util.Collections;


public class CRUD {

	public static void main(String[] args) {
		Integer a = new Integer(100);
		Integer b = new Integer(200);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(100);
		list.add(0,9999);
		list.add(200);
		list.add(list.get(0) + list.get(1));
		System.out.println(list.toString());
		list.remove(0);
		int index = list.indexOf(200);
		//if(list.contains(200)){
		if(index>=0){
			list.remove(index);
			System.out.println("Found...");
		}
		else
		{
			System.out.println("Not Found...");
		}
		list.set(0, 7878);
		Collections.sort(list);
		System.out.println(list);
		Collections.binarySearch(list, 200);
		/*list.add(a);
		list.add(b);
		int c = a.intValue() + b.intValue(); // UnBoxing
		Integer d = new Integer(c);  // Boxing
		list.add(d);
		*/
		/*ArrayList list = new ArrayList();
		list.add("ram");
		int y = 100;
		Integer x = new Integer (y);  // Boxing
		list.add(x);
		Integer r = (Integer)list.get(0);
		System.out.println(r);
		*/

	}

}
