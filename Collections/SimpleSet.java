import java.util.HashSet;


public class SimpleSet {

	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("mike");
		hs.add("tim");
		hs.add("mike");
		hs.add("tim");
		System.out.println(hs);
	}

}
