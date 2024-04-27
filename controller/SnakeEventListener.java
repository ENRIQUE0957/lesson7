package controller;

import model.SnakeNode;
import model.StrategyPattern.SnakeObserver;

/**
 * Implements the observer for snake events such as hitting food, a wall, or itself.
 * It updates the game state and user interface accordingly based on the event.
 */
public class SnakeEventListener implements SnakeObserver {

    /**
     * Responds to the snake hitting food by increasing the score and adding a new node to the snake.
     */
    @Override
    public void hitFood() {
        increaseScoreAndGrowSnake();
    }

    /**
     * Responds to the snake hitting a wall by setting a game over message and changing the game state.
     */
    @Override
    public void hitWall() {
        setGameOverMessage("Hit the wall - Press <Restart>");
    }

    /**
     * Responds to the snake hitting itself by setting a game over message and changing the game state.
     */
    @Override
    public void hitSelf() {
        setGameOverMessage("Hit self body - Press <Restart>");
    }

    /**
     * Increases the score by 10 points and adds a new node to the snake at an off-screen position.
     */
    private void increaseScoreAndGrowSnake() {
        App.model.score += 10;
        App.model.snake.nodes.add(new SnakeNode(-100, -100));
    }

    /**
     * Sets the game over message and updates the game state to indicate a restart is needed.
     * @param message the game over message to be displayed
     */
    private void setGameOverMessage(String message) {
        App.model.messages = message;
        App.win.goNextState();
    }
}
