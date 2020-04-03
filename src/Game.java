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
    public <T extends Action> void process(BoundedQueue<Action> player){
        while (!player.empty()){
            player.get().actOn(this);
        }
    }
    public <T extends Action> void generateMovements(BoundedQueue<MoveAction> player){
        MoveAction mAction1 = new MoveAction(5,10);
        MoveAction mAction2 = new MoveAction(-5,-15);
        player.put(mAction1);
        player.put(mAction2);
    }
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


