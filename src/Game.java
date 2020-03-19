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
