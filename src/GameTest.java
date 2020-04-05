import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Game
 */
public class GameTest {
    /**
     * This is an example test. You can delete it.
     */
//    @Test
//    public void exampleTest() {
//        assertEquals(2, 1 + 1, "1 + 1 should equal 2");
//        assertTrue(3 < 4, "3 should be less than 4");
//    }


    @Test
    public void generateMovement_processTest_Action(){
        Game game = new Game();
        BoundedQueue<Action> queue=new BoundedQueue<>(3,true);
        game.setX(10);
        game.setY(100);
        game.generateMovements(queue);
        game.process(queue); //is no this line, the state can't change in queue element successfully
        assertEquals(1+10,game.getX(),"The movement in X direction is wrong");
        assertEquals(-5+100, game.getY(), "The movement in Y direction is wrong");
    }

    @Test
    public void generateMovement_processTest_MovementAction(){
        Game game = new Game();
        BoundedQueue<MoveAction> queue = new BoundedQueue<>(3,true);
        game.generateMovements(queue);
        game.generateMovements(queue);
        game.process(queue);
        assertEquals(-4,game.getX(),"The movement in X direction is wrong");//Xall: 6 -5 6 -5, Xfinal: -5 6 -5, Xsum: -5+6-5=-4
        assertEquals(-20,game.getY(),"The movement in Y direction is wrong");//yall: 10 -15 10 -15, Yfinal: -15 10 -15, Ysum: -15+10-15=-10
//        MoveAction mAction1 = new MoveAction(6,10);
//        MoveAction mAction2 = new MoveAction(-5,-15);
    }


}