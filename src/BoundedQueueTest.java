import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class BoundedQueueTest {
    @Test
    public void newQueueIsEmpty() {
        BoundedQueue<String> queue = new BoundedQueue<String>(/*capacity:*/ 3, /*dropOldest:*/ false);
        assertTrue(queue.empty(), "new BoundedQueue should be empty");
    }

    @Test
    public void queueWithItemIsNotEmpty() {
        BoundedQueue<String> queue = new BoundedQueue<String>(3, false);
        queue.put("hello");
        assertTrue(!queue.empty(), "BoundedQueue should not be empty after an item is added");
    }

    @Test
    public void queueWithDropOldestFalse(){
        BoundedQueue<String> queue1 = new BoundedQueue<>(3,false);
        assertEquals(queue1.count(),0);
        queue1.put("item1");
        queue1.put("item2");
        queue1.put("item3");

        assertEquals(queue1.get(), "item1"); //item1 oldest
        assertEquals(queue1.count(), 2); //true
        queue1.put("item4");
        assertEquals(queue1.get(),"item2"); //item2
        assertEquals(queue1.count(),2);//true
    }

    @Test
    public void queueWithDropOldestTrue(){
        BoundedQueue<String> queue1 = new BoundedQueue<>(3,true);
        assertEquals(queue1.count(),0);
        queue1.put("item1");
        queue1.put("item2");
        queue1.put("item3");
        queue1.put("item4");

        assertEquals(queue1.count(),3);
        assertEquals(queue1.get(), "item2");
    }

    @AfterEach
    public void reportStats(){
        BoundedQueue<String> queue1 = new BoundedQueue<>(3,true);
        queue1.put("item1");
        queue1.put("item2");
        queue1.put("item3");
        queue1.put("item4");
        queue1.get();
        queue1.put("item5");

        queue1.reportStats();
    }
}
