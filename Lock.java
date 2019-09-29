public interface Lock
{
  void lock(long id);
  void unlock(long id);

  boolean isLocked();
}