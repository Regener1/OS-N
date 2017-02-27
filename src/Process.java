import java.util.ArrayList;
import java.util.Random;

public class Process {
	
	private int priority;

	private ArrayList<Thread> threads = new ArrayList<>();
	
	private boolean isWork;
	
	private Thread curThd;
	
	public Process(Random rnd){
		System.out.println("In Process");
		//Random generating threads
		int n = rnd.nextInt(5) + 1;
		System.out.println(n);
		for(int i = 0; i < n; i++){
			threads.add(new Thread(rnd));
			//System.out.println("Create thread " + i);
		}
		
		this.priority = rnd.nextInt(10) + 1;
		System.out.println("process priority " + this.priority);
	}
	
	public int getPriority() {
		return priority; 
	}
	
	public boolean perform(){
		//while(true){
			if(!isWork){
				System.out.println("chooseThread in process");
				curThd = chooseThread();
			}
			
			System.out.println("perform thread in process");
			isWork = curThd.perform();
			
			if(!isWork){
				System.out.println("remove thread from list in process");
				threads.remove(curThd);
			}
			
			if(threads.isEmpty()){
				System.out.println("no threads in process");
				return false;
			}
		//}
			return true;
	}

	private Thread chooseThread() {
		Thread thr = threads.get(0);
		
		for(int i = 1; i < threads.size(); i++){
			if(thr.getPriority() > threads.get(i).getPriority()){
				thr = threads.get(i);
			}
		}
		
		return thr;
	}
}
