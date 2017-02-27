import java.util.Random;

public class Thread {
	
	private int priority;

	private int duration;
	
	public Thread(Random rnd){
		this.priority = rnd.nextInt(10) + 1;
		this.duration = rnd.nextInt(20) + 1; //max duration 20 ticks
		System.out.println("Thread is created. Priority " + this.priority + " Duration " + this.duration);
	}
	
	public int getPriority() {
		return priority;
	}

	public int getDuration() {
		return duration;
	}
	
	public boolean perform(){
		duration--;
		
		System.out.println("duration in thread " + duration);
		
		if(duration == 0)
			return false;
		return true;
	}

}
