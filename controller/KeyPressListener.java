package controller;
import model.Direction;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyPressListener implements KeyListener {

  
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println("Key Pressed: " + KeyEvent.getKeyText(key));
        changeSnakeDirection(key);
    }

   
    private void changeSnakeDirection(int key) {
        switch (key) {
            case KeyEvent.VK_LEFT:
                App.model.snake.setDirection(Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                App.model.snake.setDirection(Direction.RIGHT);
                break;
            case KeyEvent.VK_UP:
                App.model.snake.setDirection(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                App.model.snake.setDirection(Direction.DOWN);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not implemented, but available for future use if needed.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not implemented, but available for future use if needed.
    }
}
