package view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.App;
import controller.ButtonPressListener;
import controller.KeyPressListener;
import model.StrategyPattern.NormalPlayStrategy;
import model.StrategyPattern.SpeedBoostStrategy;
import view.statePattern.GameState;
import view.statePattern.GameStateinit;


public class AppWindow extends JFrame{

    private AppCanvas canvas;
    public static final int GRID_SIZE = 20;

    public JButton startPauseButton;
    public JButton restartButton;
    public JButton exitButton;
    public JButton fastSnakeButton;
    public JButton regularSnakeButton;
    public static final String START_ACTION = "Start";
    public static final String PAUSE_ACTION = "Pause";
    public static final String RESTART_ACTION = "App Restart";
    public static final String EXIT_ACTION = "Exit";

    private GameState gameState;

    public void init(){
        Container cp = getContentPane(); 
        canvas = new AppCanvas();
        cp.add(canvas, BorderLayout.CENTER);

          // Initialize and add the strategy selection buttons
         JPanel northPanel = new JPanel();
          fastSnakeButton = new JButton("Fast Snake");
          regularSnakeButton = new JButton("Regular Snake");
          northPanel.add(fastSnakeButton);
          northPanel.add(regularSnakeButton);
          cp.add(northPanel, BorderLayout.NORTH);

        JPanel southPanel = new JPanel();
        startPauseButton = new JButton(START_ACTION);
        restartButton = new JButton(RESTART_ACTION);
        exitButton = new JButton(EXIT_ACTION);
        southPanel.add(startPauseButton);
        southPanel.add(restartButton);
        southPanel.add(exitButton);
        cp.add(BorderLayout.SOUTH, southPanel);

        //action listeners for snake 

        //fastSnakeButton.addActionListener(e -> App.model.setStrategy(new SpeedBoostStrategy()));
        fastSnakeButton.addActionListener(e -> {
            App.model.setStrategy(new SpeedBoostStrategy());
            App.updateTimer();
            canvas.requestFocusInWindow();
            
            
        });
       // regularSnakeButton.addActionListener(e -> App.model.setStrategy(new NormalPlayStrategy()));
       regularSnakeButton.addActionListener(e -> {
        App.model.setStrategy(new NormalPlayStrategy());
        App.updateTimer();
        canvas.requestFocusInWindow();
    });

        ButtonPressListener buttonPressListener = new ButtonPressListener();
        startPauseButton.addActionListener(buttonPressListener);
        restartButton.addActionListener(buttonPressListener);
        exitButton.addActionListener(buttonPressListener);

        KeyPressListener keyPressListener = new KeyPressListener();
        canvas.addKeyListener(keyPressListener);
        canvas.requestFocusInWindow();
        canvas.setFocusable(true);
        canvas.addFocusListener(new java.awt.event.FocusListener() {
            public void focusGained(java.awt.event.FocusEvent e) {
                System.out.println("Canvas gained focus.");
            }

            public void focusLost(java.awt.event.FocusEvent e) {
                System.out.println("Canvas lost focus.");
            }
        });

        startPauseButton.setFocusable(false);
        restartButton.setFocusable(false);
        exitButton.setFocusable(false);

        gameState = new GameStateinit();


    }

    public void goNextState(){
        gameState.goNext(this);
    }

    public GameState getGameState(){
        return gameState;
    }    

    public void setGameState(GameState gameState){
        this.gameState = gameState;
    }
    public AppCanvas getCanvas(){
        return canvas;
    }
}
