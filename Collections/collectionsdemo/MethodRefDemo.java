package collectionsdemo;

import java.util.Arrays;
import java.util.List;

public class MethodRefDemo {
	 void checkEvenOdd2(int i){
		if(i%2==0){
			System.out.println("Even "+i);
		}
		else
		{
			System.out.println("Odd "+i);
		}
	
	}
	
	static void checkEvenOdd(int i){
		if(i%2==0){
			System.out.println("Even "+i);
		}
		else
		{
			System.out.println("Odd "+i);
		}
	
	}
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(100,90,3,5,7);
		MethodRefDemo obj = new MethodRefDemo();
		//for(int i : list){
		//list.forEach(MethodRefDemo::checkEvenOdd);
		list.forEach(obj::checkEvenOdd2);
		//}
		

	}

}
