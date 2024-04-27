package model.StrategyPattern;
import model.GameModel;

public interface PlayStrategy {

  void execute (GameModel model);
  int getDelay();//add this method to return the delay for the timer 

}
