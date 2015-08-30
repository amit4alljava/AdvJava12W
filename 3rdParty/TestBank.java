import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestBank {
	
	@DataProvider(name="giveData")
	public Object[][] provideData(){
		Object array[][]= null;
		try {
			array = ExcelReader.readExcel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*Object array[][]= {
				{10,20,30},{100,200,300},{90,90,180}
		};*/
		return array;
	}
	
	@Test(dataProvider="giveData")
	public void testAdd(int first, int second, int expected){
		Logic logic = new Logic();
		
				int result = logic.add(first,second);
				Assert.assertEquals(result, expected);
	}
	/*
	@Test(enabled=false,timeOut=1000)
	public void testPerformance(){
		Logic logic = new Logic();
		logic.withDraw(9090);
	}
	
	@Test
	public void testWithDraw(){
		boolean expectedResult = true;
			Logic logic = new Logic();
			boolean actualResult = logic.withDraw(9090);
			Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testWithDrawNegative(){
		boolean expectedResult = false;
			Logic logic = new Logic();
			boolean actualResult = logic.withDraw(0);
			Assert.assertEquals(actualResult, expectedResult);
	}*/

}
