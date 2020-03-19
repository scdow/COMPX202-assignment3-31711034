import static org.junit.jupiter.api.Assertions.*;
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
}
