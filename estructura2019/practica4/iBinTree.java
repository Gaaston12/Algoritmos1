public interface iBinTree<T extends Comparable> {
    public void insert (T x);
    public void delete (T x) throws RuntimeException;
    public T search(T x) throws RuntimeException;
    public int size();
    public int height();
    public Boolean belongs(T x);
    public void printPreOrder();
    public void printInOrder();
}