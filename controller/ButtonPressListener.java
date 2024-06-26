/* 
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.AppWindow;

public class ButtonPressListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e){
        String action = e.getActionCommand();
        JButton button = (JButton) e.getSource();

        switch (action){
            case AppWindow.START_ACTION:
                App.model.messages = null;
                App.win.goNextState();
                App.timer.start();
                break;
            case AppWindow.PAUSE_ACTION:
                App.win.goNextState();
                App.timer.stop();
                App.model.messages = "Paused - Press <Resume>";
                App.win.getCanvas().repaint();
                break;
            case AppWindow.RESTART_ACTION:
                App.model.init();
                App.win.goNextState();
                App.timer.stop();
                App.win.getCanvas().repaint();
                break;
            case AppWindow.EXIT_ACTION:
                System.exit(0);
            break;
        
        }

        
    }
}
*/
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.AppWindow;

/**
 * Handles button press events in the application, directing the flow of the game
 * based on the button clicked.
 */
public class ButtonPressListener implements ActionListener {

    /**
     * Responds to action events triggered by button presses.
     * @param e the event generated by button press
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        JButton button = (JButton) e.getSource();

        processButtonAction(action);
    }

    /**
     * Processes the specific button action and updates game state accordingly.
     * @param action the command associated with the button action
     */
    private void processButtonAction(String action) {
        switch (action) {
            case AppWindow.START_ACTION:
                handleStart();
                break;
            case AppWindow.PAUSE_ACTION:
                handlePause();
                break;
            case AppWindow.RESTART_ACTION:
                handleRestart();
                break;
            case AppWindow.EXIT_ACTION:
                handleExit();
                break;
        }
    }

    /**
     * Handles the start action, initializes game state and starts the timer.
     */
    private void handleStart() {
        App.model.messages = null;
        App.win.goNextState();
        App.timer.start();
    }

    /**
     * Handles the pause action, stops the timer and updates the game state to paused.
     */
    private void handlePause() {
        App.win.goNextState();
        App.timer.stop();
        App.model.messages = "Paused - Press <Resume>";
        App.win.getCanvas().repaint();
    }

    /**
     * Handles the restart action, reinitializes the game and updates the display.
     */
    private void handleRestart() {
        App.model.init();
        App.win.goNextState();
        App.timer.stop();
        App.win.getCanvas().repaint();
    }

    /**
     * Handles the exit action, terminates the application.
     */
    private void handleExit() {
        System.exit(0);
    }
}
