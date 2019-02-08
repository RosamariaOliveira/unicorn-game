package org.academiadecodigo.bootcamp22.unicorngame;

import org.academiadecodigo.bootcamp22.unicorngame.objects.TimeCounter;
import org.academiadecodigo.bootcamp22.unicorngame.objects.Unicorn;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Picture background = new Picture(10, 50, "resources/background_sad.jpg");
    private Unicorn unicorn = new Unicorn();
    private TimeCounter timer = new TimeCounter(15);

    public void start() {

        background.draw();

        timer.start();

        unicorn.move();

    }

    public void changeBackground() {

        if(unicorn.getHappiness() >= 50) {
            background = new Picture(10, 50, "resources/background_happy.jpg");
            background.draw();
        }
    }

}
