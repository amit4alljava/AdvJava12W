import java.util.Arrays;


public class InterviewQuestion {

	public static void main(String[] args) {
		// First Question
		//String  a = "Hello How are You I am Fine";
		//System.out.println(a.split(" ").length);
		
		// Second Question
		int highestCount = 0;
		String data = "axywghkbbmthnmbshyatpkbfhstrgcngstynbmdhjh";
		char array[] = data.toCharArray();
		Arrays.sort(array);
		//aabbbbbcdfggghhhhhhjkkmmmnnnprsssttttwxyyy
		String sortedString = new String(array);
		System.out.println(sortedString);
		char highestChar = '#';
		for(int i = 0 ; i<sortedString.length();){
			char singleChar = sortedString.charAt(i);
			int startIndex = sortedString.indexOf(singleChar);
			int lastIndex = sortedString.lastIndexOf(singleChar);
			int count  = lastIndex - startIndex;
			if(count>=highestCount){
				highestCount =count;
				highestChar = singleChar;
			}
			i = lastIndex + 1;
		}
		System.out.println(highestCount+" "+highestChar);
		
		

	}

}
