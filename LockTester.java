import java.util.*; 
public class LockTester {
	
	//to be completed	
	

	Vector times = new Vector(); 
	public void outputRuntime(String totalTime, int numThreads){
		times.add(totalTime);

		if(times.size() == numThreads){
			for(int i = 0; i<times.size(); i++)
				System.out.println(times.get(i));
		}
	}
}