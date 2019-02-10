package org.academiadecodigo.bootcamp22.unicorngame.objects;

public abstract class GameObjectFactory {

    public static GameObject getGameObject() {

        double random = Math.random(); //12.5% chance of everything

        if(random < 0.125) {
            return new GameObject(GameObjectsType.BLACKHOLE);
        }

        if(random < 0.25) {
            return new GameObject(GameObjectsType.POOP);
        }

        if(random < 0.375) {
            return new GameObject(GameObjectsType.ROCK);
        }

        if(random < 0.50) {
            return new GameObject(GameObjectsType.VAMPIRE);
        }

        if(random < 0.625) {
            return new GameObject(GameObjectsType.CHERRY_POOP);
        }

        if(random < 0.75) {
            return new GameObject(GameObjectsType.CRYSTAL);
        }

        if(random < 0.875) {
            return new GameObject(GameObjectsType.DONUT);
        }

        return new GameObject(GameObjectsType.RAINBOW);

    }


}
