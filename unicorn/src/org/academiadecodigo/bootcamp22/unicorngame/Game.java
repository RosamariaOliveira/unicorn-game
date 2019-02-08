package org.academiadecodigo.bootcamp22.unicorngame;

import org.academiadecodigo.bootcamp22.unicorngame.field.Position;
import org.academiadecodigo.bootcamp22.unicorngame.objects.GameObject;
import org.academiadecodigo.bootcamp22.unicorngame.objects.GameObjectFactory;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import java.util.ArrayList;

public class Game {

    private Unicorn unicorn = new Unicorn();
    private ArrayList<GameObject> gameObjects = new ArrayList<>();

    public void start(int elements) {
        init();
        initObjects(elements);
        drawObjects();
    }


    private void init() {
        Picture background = new Picture(10, 50, "resources/background.jpg");
        background.draw();
        unicorn.getUnicornPicture().draw();
        unicorn.move();
    }

    private void initObjects(int elements) {
        for (int i = 0; i < elements; i++) {

            GameObject generated = GameObjectFactory.getGameObject();

            //check if the same position has been given
            while (!verifyPosition(generated)) {
                generated = GameObjectFactory.getGameObject();
            }

            gameObjects.add(generated);

        }
    }

    private boolean verifyPosition(GameObject gameObject) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject current = gameObjects.get(i);

            if (current.getPosition().equals(gameObject.getPosition())) {
                return false;
            }
        }
        return true;
    }

    private void drawObjects() {

        for (int i = 0; i < gameObjects.size(); i++) {
            Picture picture = new Picture(gameObjects.get(i).getPosition().getX(),
                    gameObjects.get(i).getPosition().getY(), gameObjects.get(i).getPicturePath());
            picture.draw();

            System.out.println("object: " + gameObjects.get(i).getPicturePath());
            System.out.println("x: " + gameObjects.get(i).getPosition().getX());
            System.out.println("y: " + gameObjects.get(i).getPosition().getY());
        }
    }

    public boolean checkPosition() {

        for (GameObject object: gameObjects) {

            if(object.) {

            }

            if(object.getPosition().equals(unicorn.getUnicornPicture().getMaxX(), unicorn.getUnicornPicture().getMaxY())) {

            }
        }

    }

}
