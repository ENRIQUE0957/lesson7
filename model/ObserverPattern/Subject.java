package model.ObserverPattern;

public interface Subject {
    void addObserver(SnakeObserver o);
    void removeObserver(SnakeObserver o);
    void notifyObserver(SnakeEvent e);
}
