/**
 * Fixed-capacity collection that supports adding to one end and
 * removing from the other.
 */
public class BoundedQueue<T> {
    private T[] myQueue;
    private int capacity;
    boolean dropOldest;
    private int count;

     static int instance;
     static int drop;
    /**
     * Constructs an empty BoundedQueue with the given capacity.
     *
     * The parameter dropOldest specifies what will happen when put()
     * is called and the queue is full. If dropOldest is true, the
     * oldest item (which would be returned by get()) is dropped. If
     * dropOldest is false, the new item is dropped.
     */
    public BoundedQueue(int capacity, boolean dropOldest) {
        /*throw new RuntimeException("Not yet implemented");*///this line should be deleted after implement the constructor
        myQueue = makeArray(capacity);
        this.capacity = capacity;
        this.dropOldest = dropOldest;
    }

    /**
     * Returns the number of items in the queue.
     */
    public int count() {
//        throw new RuntimeException("Not yet implemented");
//        int count =0;
//        for(int i=0;i<capacity;i++){
//            if(myQueue[i]!=null) { count++; }
//            //while null OR while null and till one index, break
//        }
        return count;
    }

    /**
     * Returns true if the queue does not contain any items.
     */
    public boolean empty() {
//        throw new RuntimeException("Not yet implemented");
//        if (myQueue[0]==null){
//            return true;
//        }
        if (count==0){
            return true;
        }
        else
            return false;
    }

    /**
     * Returns true if the queue has reached its capacity.
     */
    public boolean full() {
//        throw new RuntimeException("Not yet implemented");
//        if(myQueue[capacity-1]!=null){
//            return true;
//        }
        if(count==capacity){
            return true;
        }
        else
            return false;
    }

    /**
     * Adds the item to the queue.
     *
     * If the queue is full, an item is dropped as described in the
     * constructor.
     */
    public void put(T item) {
//        throw new RuntimeException("Not yet implemented");
        if (!full()){
            myQueue[count]=item;
            count++;
            instance++;
        }
        else if(dropOldest==true) {
            for(int i=0;i<(capacity-1);i++){
                myQueue[i]=myQueue[i+1];
            }
            myQueue[capacity-1]=item;
            drop++;
        }
        else {
            myQueue[capacity-1]=item;
            drop++;
        }
    }

    /**
     * Retrieves and removes the oldest item in the queue.
     *
     * If the queue is empty, returns null.
     */
    public T get() {
//        throw new RuntimeException("Not yet implemented");
        if(empty()==true){
            return null;
        }
        else {
            T oldest = myQueue[0];
            for(int i=0;i<(capacity-1);i++){
                myQueue[i]=myQueue[i+1];
                //while myQueue[i]==null and until one index, break;
            }
            count--;
            instance--;
            return oldest;
        }
//        else{
//            T newest = myQueue[count-1];
//            myQueue[count-1]=null;
//            count--;
//            return newest;
//        }
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

    /*the number of BoundedQueue instances that have been created
the total number of items dropped from BoundedQueue instances due to a full queue*/
    public static void reportStats(){
        System.out.println("number of BoundedQueue instances: "+(instance-drop));
        System.out.println("number of dropped items: "+drop);
    }
//    number of BoundedQueue instances: 2
//    number of dropped items: 1

}
