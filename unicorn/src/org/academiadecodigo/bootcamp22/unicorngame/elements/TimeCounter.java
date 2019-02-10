package org.academiadecodigo.bootcamp22.unicorngame.elements;

import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Timer;
import java.util.TimerTask;

public class TimeCounter {

    private Timer timer;
    private int totalSeconds;
    private int secondsLeft;
    private Text timerText;
    private Picture timerIcon;

    public TimeCounter(int totalSeconds) {
        timer = new Timer();
        this.totalSeconds = totalSeconds;
    }

    public int getSecondsLeft() {
        return secondsLeft;
    }

    public void endTimer() {
        timer.cancel();
    }

    public void start() {

        secondsLeft = totalSeconds;
        timerText = new Text(525, 25, "00 : " + secondsLeft);
        timerText.grow(35, 15);
        timerText.draw();

        timerIcon = new Picture(450, 10,"resources/game_clock.png");
        timerIcon.draw();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                secondsLeft--;

                if(secondsLeft < 10) {
                    timerText.setText("00 : 0" + secondsLeft);
                }

                if(secondsLeft >= 10){
                    timerText.setText("00 : " + secondsLeft);
                }

                if(secondsLeft == 0) {
                    timer.cancel();
                }
            }
        }, 1000, 1000);

    }

}
