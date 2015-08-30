
public class Logic {
	public int add(int x , int y){
		return x + y;
	}
	
	
	public boolean withDraw(int value){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(value<=0){
			throw new RuntimeException("Invalid Amount");
		}
		return true;
	}

}
