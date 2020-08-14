package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Computer extends AbstractActor {
    private Animation computerAnimation;

    public Computer() {
        this.computerAnimation = new Animation("sprites/computer.png",80,48,0.2f, Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(computerAnimation);
    }

    public int add(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public float add(float firstNumber, float secondNumber) {
        return firstNumber + secondNumber;
    }

    public int sub(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public float sub(float firstNumber, float secondNumber) {
        return firstNumber + secondNumber;
    }

}
