package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ObserverPattern.SnakeEvent;
import view.statePattern.GameState;
import view.statePattern.GameStatePlaying;

public class TimerListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        GameState state = App.win.getGameState();
        state.animate();
        if(state instanceof GameStatePlaying){
            detectCollision();
        }
        App.win.getCanvas().repaint();
    }

    private void detectCollision(){
        if(App.model.snakeGotFood()){
            App.model.snake.notifyObserver(SnakeEvent.HIT_FOOD);
            App.model.food = App.model.createFood();
        }

        if(App.model.snakeLeftScene()){
            App.model.snake.notifyObserver(SnakeEvent.HIT_WALL);
        }

        if(App.model.snakeHitsItsBody()){
            App.model.snake.notifyObserver(SnakeEvent.HIT_SELF);
        }
  
    }
    
}
