package model.ObserverPattern;

public interface SnakeObserver {
    void hitFood();
    void hitWall();
    void hitSelf();
}
