/**
 * Fixed-capacity collection that supports adding to one end and
 * removing from the other.
 */
public class BoundedQueue<T> {

    /**
     * Constructs an empty BoundedQueue with the given capacity.
     *
     * The parameter dropOldest specifies what will happen when put()
     * is called and the queue is full. If dropOldest is true, the
     * oldest item (which would be returned by get()) is dropped. If
     * dropOldest is false, the new item is dropped.
     */
    public BoundedQueue(int capacity, boolean dropOldest) {
        throw new RuntimeException("Not yet implemented");
    }

    /**
     * Returns the number of items in the queue.
     */
    public int count() {
        throw new RuntimeException("Not yet implemented");
    }

    /**
     * Returns true if the queue does not contain any items.
     */
    public boolean empty() {
        throw new RuntimeException("Not yet implemented");
    }

    /**
     * Returns true if the queue has reached its capacity.
     */
    public boolean full() {
        throw new RuntimeException("Not yet implemented");
    }

    /**
     * Adds the item to the queue.
     *
     * If the queue is full, an item is dropped as described in the
     * constructor.
     */
    public void put(T item) {
        throw new RuntimeException("Not yet implemented");
    }

    /**
     * Retrieves and removes the oldest item in the queue.
     *
     * If the queue is empty, returns null.
     */
    public T get() {
        throw new RuntimeException("Not yet implemented");
    }

    /**
     * Helper for creating an array with T as the element type. The
     * elements are initialized to null.
     */
    private T[] makeArray(int size) {
        // We would normally use "new T[size]", but we can't because T
        // is a type parameter and Java does not support generic array
        // creation. The following is an imperfect workaround.
        @SuppressWarnings("unchecked")
        T[] array = (T[]) new Object[size];
        return array;
    }
}
