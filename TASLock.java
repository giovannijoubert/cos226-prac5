import java.util.concurrent.atomic.AtomicBoolean;

public class TASLock implements Lock
{
	AtomicBoolean state = new AtomicBoolean(false);
	int holderOfLock;

	@Override
	public void lock(long id){
		

		

		while (state.getAndSet(true)) {};
	
		holderOfLock = ThreadID.get();
	
	}

	@Override
	public void unlock(long id){
		state.set(false);
	}

	@Override
	public boolean isLocked(){
		return state.get();
	}
	
  
}
