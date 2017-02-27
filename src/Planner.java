import java.util.ArrayList;
import java.util.Random;

public class Planner {
	
	private ArrayList<Process> processes = new ArrayList<>();
	
	private boolean isWork;
	
	private Process curProc;
	
	public Planner(Random rnd){
		System.out.println("In Planner");
		//Random generating processes
		int n = rnd.nextInt(5) + 1;
		System.out.println(n);
		for(int i = 0; i < n; i++){
			processes.add(new Process(rnd));
			
			//System.out.println("Create process " + i);
		}

	}
	
	public void perform(){
		while(true){
			if(!isWork){
				System.out.println("chooseProcess in planner");
				curProc = chooseProcess();
			}
			System.out.println("perform process in planner");
			isWork = curProc.perform();
			
			if(!isWork){
				System.out.println("remove process from list in planner");
				processes.remove(curProc);
			}
			
			if(processes.isEmpty()){
				System.out.println("no process in planner");
				return;
			}
		}
	}
	
	private Process chooseProcess() {
		Process proc = processes.get(0);
		
		for(int i = 1; i < processes.size(); i++){
			if(proc.getPriority() > processes.get(i).getPriority()){
				proc = processes.get(i);
			}
		}
		
		return proc;
	}
}
