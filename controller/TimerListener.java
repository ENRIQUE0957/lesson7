package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.StrategyPattern.SnakeEvent;
import view.statePattern.GameState;
import view.statePattern.GameStatePlaying;

/**
 * Handles timer events for the game, updating game state and checking for collisions.
 */
public class TimerListener implements ActionListener {

    /**
     * Invoked when an action event occurs, usually from a timer tick.
     * This method updates the game animation and checks for collisions if the game is in a playing state.
     * @param e the event that triggered the action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        GameState state = App.win.getGameState();
        state.animate();
        if (state instanceof GameStatePlaying) {
            detectCollisions();
        }
        App.win.getCanvas().repaint();
    }

    /**
     * Checks for various types of collisions (food, wall, self) during the game and notifies observers accordingly.
     */
    private void detectCollisions() {
        checkFoodCollision();
        checkWallCollision();
        checkSelfCollision();
    }

    /**
     * Checks if the snake has collided with food and updates game model and view accordingly.
     */
    private void checkFoodCollision() {
        if (App.model.snakeGotFood()) {
            App.model.snake.notifyObserver(SnakeEvent.HIT_FOOD);
            App.model.food = App.model.createFood();  // Replace eaten food with a new one.
        }
    }

    /**
     * Checks if the snake has collided with the game boundary (left the scene) and notifies observers.
     */
    private void checkWallCollision() {
        if (App.model.snakeLeftScene()) {
            App.model.snake.notifyObserver(SnakeEvent.HIT_WALL);
        }
    }

    /**
     * Checks if the snake has collided with itself and notifies observers.
     */
    private void checkSelfCollision() {
        if (App.model.snakeHitsItsBody()) {
            App.model.snake.notifyObserver(SnakeEvent.HIT_SELF);
        }
    }
}

