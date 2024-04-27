package model.StrategyPattern;

public interface Subject {
    void addObserver(SnakeObserver o);
    void removeObserver(SnakeObserver o);
    void notifyObserver(SnakeEvent e);
}
