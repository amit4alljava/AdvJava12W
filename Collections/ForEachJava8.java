import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ForEachJava8 {

	public static void checkEvenOdd(Integer x){
		if(x%2==0){
			System.out.println("Even "+x);
		}
		else
		{
			System.out.println("Odd "+x);
		}
	}
	
	public static void main(String[] args) {
		List<Integer> l = Arrays.asList(10,20,90,4,3,1,100);
		l.forEach((x)->checkEvenOdd(x));
		
		Collections.sort(l);
		
	
		System.out.println("After Sort "+l);
		/*for(int i = 0 ; i<l.size(); i++){
			if(l.get(i)%2==0){
				System.out.println("Even "+l.get(i));
			}
			else
			{
				System.out.println("Odd "+l.get(i));
			}
		}*/
		
		

	}

}
