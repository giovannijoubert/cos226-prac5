import java.util.Random;

public class TThread extends Thread {
	public static TASLock myLock = new TASLock();
	int numThreads;
	LockTester tester;
	long totalTime;

	public TThread(int threadCount, LockTester test) {
		numThreads = threadCount;
		tester = test;
	}
	
	public void run() {

		try{
		Thread.sleep((long)(Math.random() * 300)); }
		catch (InterruptedException exception)	{
			//handleit
		}

		
		long startTime = System.currentTimeMillis();
		
		System.out.println(ThreadID.get() + " tries lock");
		if(myLock.isLocked()){
			System.out.println("Lock is held by thread " + myLock.holderOfLock);
		}

		//Lock it
		try {
			myLock.lock(ThreadID.get());
			System.out.println(ThreadID.get() + " acquires lock");

			//Critical Section
			try	{
				Thread.sleep(500);
			}
			catch (InterruptedException exception)	{
				//handleit
			}

		} finally {
			System.out.println(ThreadID.get() + " unlocks");
			myLock.unlock(ThreadID.get());
		}

		long endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;

		tester.outputRuntime("Total execution time of " + ThreadID.get() + " : " + totalTime + " milliseconds", numThreads);
	}
}