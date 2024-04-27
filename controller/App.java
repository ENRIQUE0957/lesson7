/* 
package controller;

import javax.swing.JFrame;
import javax.swing.Timer;

import model.GameModel;
import model.StrategyPattern.NormalPlayStrategy;
import view.AppWindow;

public class App{

    public static AppWindow win = new AppWindow ();
    public static GameModel model = new GameModel();
    public static Timer timer;

    public static final int FPS = 4;
    public static final int DELAY = 1000 / FPS;
    
    public static void main(String[] args){

        win.init();
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setTitle("Snake Game");
        win.setLocation(300, 200);
        win.pack();
        win.setVisible(true);
        win.getCanvas().requestFocusInWindow();

        updateTimer();


        SnakeEventListener listener = new SnakeEventListener();
        App.model.snake.addObserver(listener);

        //timer = new Timer(DELAY,new TimerListener());
        //timer = new Timer(model.snake.getSpeed(), new TimerListener());
        // Set a default strategy before initializing the timer
        model.setStrategy(new NormalPlayStrategy());
        updateTimer();  // Initialize the timer with the delay from the current strategy
    
    
    }
    public static void updateTimer() {
        //timer.setDelay(model.snake.getSpeed());
        if (timer != null) {
            timer.stop();
        }
        // Initialize the timer using the delay fetched from the current strategy through GameModel
        timer = new Timer(model.getStrategyDelay(), new TimerListener());
        timer.start();
    }
    }

*/
package controller;

import javax.swing.JFrame;
import javax.swing.Timer;

import model.GameModel;
import model.StrategyPattern.NormalPlayStrategy;
import view.AppWindow;

/**
 * Main class that drives the snake game application.
 */
public class App {

    public static AppWindow win = new AppWindow();
    public static GameModel model = new GameModel();
    public static Timer timer;

    public static final int FPS = 4;
    public static final int DELAY = 1000 / FPS;

    public static void main(String[] args) {

        setupWindow();
        configureGame();
        startGame();
    }

    /**
     * Sets up the game window with necessary configuration.
     */
    private static void setupWindow() {
        win.init();
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setTitle("Snake Game");
        win.setLocation(300, 200);
        win.pack();
        win.setVisible(true);
        win.getCanvas().requestFocusInWindow();
    }

    /**
     * Configures game settings and initializes components necessary for the game.
     */
    private static void configureGame() {
        model.setStrategy(new NormalPlayStrategy()); // Set a default game strategy.
        SnakeEventListener listener = new SnakeEventListener();
        model.snake.addObserver(listener);
        updateTimer();  // Set and start the game timer based on the strategy.
    }

    /**
     * Starts the game timer and ensures all components are ready.
     */
    private static void startGame() {
        updateTimer();
    }

    /**
     * Creates or updates the game timer with the appropriate delay, derived from the game model.
     */
    public static void updateTimer() {
        if (timer != null) {
            timer.stop();
        }
        timer = new Timer(model.getStrategyDelay(), new TimerListener());
        timer.start();
    }
}

