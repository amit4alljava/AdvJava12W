// 1. Inherit the Thread Class
// 2. Implements the Runnable Interface
class Job implements Runnable{
	// Logic of the Job
	public void run(){
		for(int i = 1; i<=5 ; i++){
			System.out.println("I is "+i+" Name "+Thread.currentThread().getName());
		}
	}
}
public class ThreadDemo1 {

	public static void main(String[] args) {
		Job firstjob = new Job();
		Job secondJob = new Job();
		Thread worker1 = new Thread(firstjob, "Ram");
		Thread worker2 = new Thread(secondJob, "Shyam");
		worker1.run();
		worker2.start();
		
		
		
		
		
		
		
		
		
		/*Thread.currentThread().setName("My Main ");
		System.out.println("Main Starts "+Thread.currentThread());*/

	}

}
