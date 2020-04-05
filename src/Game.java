/**
 * This file contains the Game class and Action classes
 */

/**
 * Represents the state of the game and the player.
 */
public class Game {
    private int x;
    private int y;
    private int score;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    /*Add a method process to Game that takes a BoundedQueue<Action> and runs all the actions.  super
    Then make it more general so it also accepts e.g. BoundedQueue<MoveAction> (you may find bounded wildcards useful).

Add a method generateMovements to Game that takes a BoundedQueue<MoveAction>,  extends
creates two MoveActions, and adds them to the BoundedQueue<MoveAction>.
Then make it more general so it also accepts e.g. BoundedQueue<Action> (you may find bounded wildcards useful).*/
//    public void process(BoundedQueue<? extends Action> actions) {
//        while (!actions.empty()) {  // action is not empty
//            actions.get().actOn(this);
//        }
//    }
//
//    public void generateMovements(BoundedQueue<? super MoveAction> move) {
//
//        MoveAction MoveAction1 = new MoveAction(5, 5);
//        MoveAction MoveAction2 = new MoveAction(-10, -10);
//        move.put(MoveAction1);
//        move.put(MoveAction2);
//    }

    public <T extends Action> void process(BoundedQueue<T> act){
        while (!act.empty()){
            act.get().actOn(this);
        }
        //when the act queue is not empty, Retrieves and removes the oldest element, Return new state value (new state = old state + change in generateMovements)
        //the act queue: every element can be Action type, MoveAction type, or ScoreAction type
    }
    public void generateMovements(BoundedQueue<? super MoveAction> act){
        MoveAction mAction1 = new MoveAction(6,10); //set change1
        MoveAction mAction2 = new MoveAction(-5,-15); //set change2
        act.put(mAction1); //put change1 into act queue elementA
        act.put(mAction2); //put change2 into act queue elementB
    }
    //the act queue: every element can be Action type, or MoveAction type
}

abstract class Action {
    public abstract void actOn(Game game);
}

class ScoreAction extends Action {
    private int scoreChange;

    public ScoreAction(int scoreChange) {
        this.scoreChange = scoreChange;
    }

    public void actOn(Game game) {
        int newScore = game.getScore() + scoreChange;
        game.setScore(newScore);
    }
}

//MoveAction class that inherits from Action and updates the player's location
class MoveAction extends Action{
    private int xChange;
    private int yChange;
    public MoveAction(int xChange, int yChange){
        this.xChange=xChange;
        this.yChange=yChange;
    }
    public void actOn(Game game){
        game.setX(game.getX()+xChange);
        game.setY(game.getY()+yChange);
    }
}


