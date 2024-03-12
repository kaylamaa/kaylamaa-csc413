public interface PriorityQueueInterface<T> {
    void add(T element);
    T peek();
    int size();
    boolean isEmpty();
    T poll();

}