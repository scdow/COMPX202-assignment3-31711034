import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Game
 */
public class GameTest {
    /**
     * This is an example test. You can delete it.
     */
    @Test
    public void exampleTest() {
        assertEquals(2, 1 + 1, "1 + 1 should equal 2");
        assertTrue(3 < 4, "3 should be less than 4");
    }

    @Test
    public void gameTest(){
        Game game = new Game();
        BoundedQueue<Action> queue=new BoundedQueue<>(3,true);
        game.process(queue);
        game.generateMovements(queue);
    }
}