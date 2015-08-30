import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class ReadWriteJob implements Runnable{
	private String filePath;
	private String writePath;
	ReadWriteJob(String filePath,String writePath){
		this.filePath = filePath;
		this.writePath = writePath;
	}
	@Override
	public  void run(){
		System.out.println(Thread.currentThread().getName()+" Running ");
	/*	for(int i = 1 ; i<=5 ; i++)
		{		
			System.out.println("I is "+i+" "+Thread.currentThread().getName());
		}*/
		FileOutputStream fo  = null;
		FileInputStream fi = null;
		try {
			fo = new FileOutputStream(writePath,true);
			fi = new FileInputStream(filePath);
			int singleByte = fi.read();
			while(singleByte!=-1){
				fo.write(singleByte);
				singleByte = fi.read();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(fo!=null){
				try {
					fo.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fi!=null){
				try {
					fi.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	System.out.println(Thread.currentThread().getName()+" Going to End ");
	}
}
public class FileReadDemo {

	public static void main(String[] args) throws InterruptedException {
		ReadWriteJob job1 = new ReadWriteJob("D:\\Java12to2WeekEnd\\Files\\Test1.txt", "D:\\Java12to2WeekEnd\\Files\\Write1.txt");
		ReadWriteJob job2 = new ReadWriteJob("D:\\Java12to2WeekEnd\\Files\\Test2.txt", "D:\\Java12to2WeekEnd\\Files\\Write2.txt");
		//ReadWriteJob job3 = new ReadWriteJob("D:\\Java12to2WeekEnd\\Files\\Test3.txt", "D:\\Java12to2WeekEnd\\Files\\Write3.txt");
		/*Thread worker1 = new Thread(job1,"Worker1");
		Thread worker2 = new Thread(job2,"Worker2");
		Thread worker3 = new Thread(job3,"Worker3");
		worker1.start();
		worker2.start();
		worker3.start();*/
		Thread worker1 = new Thread(job1,"Worker1");
		Thread worker2 = new Thread(job1,"Worker2");
		//Thread worker3 = new Thread(job1,"Worker3");
		worker1.start();
		worker2.start();
		/*worker1.join();
		worker2.start();
		worker3.start();*/
		
		
	}

}
