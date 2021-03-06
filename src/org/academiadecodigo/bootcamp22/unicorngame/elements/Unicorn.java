package org.academiadecodigo.bootcamp22.unicorngame.elements;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.List;

public class Unicorn implements KeyboardHandler {

    private final int UPPER_GRID_LIMIT = 50;
    private final int LOWER_GRID_LIMIT = 650;
    private final int LEFT_GRID_LIMIT = 10;
    private final int RIGHT_GRID_LIMIT = 610;

    private Picture unicornPicture;
    private Direction direction;
    private int happiness = 0;

    public Unicorn() {
        unicornPicture = new Picture(10, 50, "resources/unicornicon_right.png");
        direction = Direction.STOP;
        initKeyboard();
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int score) {
        int total = this.happiness + score;

        if (total > 100) {
            this.happiness = 100;
            return;
        }

        if (total < 0) {
            this.happiness = 0;
            return;
        }
        this.happiness = total;
    }

    public Picture getUnicornPicture() {
        return unicornPicture;
    }

    public void move() {
        switch (direction) {
            case UP:
                moveUp();
                direction = Direction.STOP;
                break;
            case DOWN:
                moveDown();
                direction = Direction.STOP;
                break;
            case LEFT:
                moveLeft();
                direction = Direction.STOP;
                break;
            case RIGHT:
                moveRight();
                direction = Direction.STOP;
                break;
            case STOP:
                stop();
                break;
        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                direction = Direction.UP;
                break;
            case KeyboardEvent.KEY_DOWN:
                direction = Direction.DOWN;
                break;
            case KeyboardEvent.KEY_LEFT:
                direction = Direction.LEFT;
                break;
            case KeyboardEvent.KEY_RIGHT:
                direction = Direction.RIGHT;
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        direction = Direction.STOP;
    }

    private void stop() {
        unicornPicture.translate(0, 0);
    }

    private void moveUp() {
        if (unicornPicture.getY() > UPPER_GRID_LIMIT) {
            unicornPicture.translate(0, -unicornPicture.getHeight());
        }
    }

    private void moveDown() {
        if (unicornPicture.getMaxY() < LOWER_GRID_LIMIT) {
            unicornPicture.translate(0, unicornPicture.getHeight());
        }
    }

    private void moveLeft() {
        if (unicornPicture.getX() > LEFT_GRID_LIMIT) {
            unicornPicture.load("resources/unicornicon_left.png");
            unicornPicture.translate(-unicornPicture.getWidth(), 0);
        }
    }

    private void moveRight() {
        if (unicornPicture.getMaxX() < RIGHT_GRID_LIMIT) {
            unicornPicture.load("resources/unicornicon_right.png");
            unicornPicture.translate(unicornPicture.getWidth(), 0);
        }
    }

    private void initKeyboard() {
        Keyboard keyboard = new Keyboard(this);
        List<Integer> keys = new ArrayList<>();

        keys.add(KeyboardEvent.KEY_UP);
        keys.add(KeyboardEvent.KEY_DOWN);
        keys.add(KeyboardEvent.KEY_LEFT);
        keys.add(KeyboardEvent.KEY_RIGHT);

        for (Integer key : keys) {
            KeyboardEvent event = new KeyboardEvent();
            event.setKey(key);
            event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(event);
        }
    }
}
