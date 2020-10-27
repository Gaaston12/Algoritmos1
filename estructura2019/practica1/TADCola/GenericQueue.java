public interface GenericQueue<T>{
    public Boolean isEmpty();
    public void empty();
    public void enqueue (T x);
    public void dequeue () throws RuntimeException;
    public T front() throws RuntimeException;
}