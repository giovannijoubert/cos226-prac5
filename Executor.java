//Program entry point
//Creates and starts threads

import java.util.LinkedList;
import java.util.ListIterator;

public class Executor {
	
	public static void main (String[] args) {
		int threadCount = Integer.parseInt(args[0]);
		LockTester tester = new LockTester();
		
		//Creates thread that will successfully access the lock 		
		TThread first_thread = new TThread(threadCount, tester);
		first_thread.start();

		// Create the threads that will query the lock
		LinkedList<TThread> query_threads = new LinkedList<TThread>();

		for (int i = 0; i < (threadCount - 1); i++)
		{
			query_threads.add(new TThread(threadCount, tester));
		}

		// Start the query threads
		ListIterator<TThread> iterator = query_threads.listIterator();
    
		while (iterator.hasNext())
			iterator.next().start();
    
		// Wait for all of the threads to finish executing
		try
		{
			first_thread.join();

			while (iterator.hasPrevious())
			{
				iterator.previous().join();
			}    
		} catch (InterruptedException exception) { }
		
	}
}