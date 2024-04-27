package model.StrategyPattern;

import model.GameModel;


public class NormalPlayStrategy implements PlayStrategy {
    @Override
    public void execute(GameModel model) {
        
        model.snake.move();
        if (model.snakeGotFood()) {
            model.snake.notifyObserver(SnakeEvent.HIT_FOOD);
            model.food = model.createFood();
        }
        if (model.snakeLeftScene()) {
            model.snake.notifyObserver(SnakeEvent.HIT_WALL);
        }
        if (model.snakeHitsItsBody()) {
            model.snake.notifyObserver(SnakeEvent.HIT_SELF);
        }
    }
    @Override
    public int getDelay() {
        return 250;  // Normal speed delay in milliseconds
    }

}

