
package model.StrategyPattern;
import controller.App;
import model.GameModel;


public class SpeedBoostStrategy implements PlayStrategy {
    private int currentDelay = 150; // Start with a default delay for fast snake
    private final int minimumDelay = 50; // Minimum delay to prevent too fast gameplay
    private final int delayDecrement = 10;
    @Override
    public void execute(GameModel model) {
        model.snake.move();
       // model.snake.speedUp(); // Assuming you add a method to increase the snake's speed
        if (model.snakeGotFood()) {
            speedUp();
            model.snake.speedUp();;
           // App.updateTimer();
            model.snake.notifyObserver(SnakeEvent.HIT_FOOD);
            model.food = model.createFood(); // Reposition the food
        }
        if (model.snakeLeftScene()) {
            model.snake.notifyObserver(SnakeEvent.HIT_WALL);
        }
        if (model.snakeHitsItsBody()) {
            model.snake.notifyObserver(SnakeEvent.HIT_SELF);
        }
    }
    private void speedUp() {
        if (currentDelay > minimumDelay) {
            currentDelay -= delayDecrement; // Decrease delay
        }
    }
    @Override
    public int getDelay() {
        return currentDelay;  // Faster speed delay in milliseconds
    }
}

