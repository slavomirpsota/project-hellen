package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Computer extends AbstractActor implements IEnergyConsumer {
    private Animation computerOnAnimation;
    private Animation computerOffAnimation;
    private boolean isPowered;

    public Computer() {
        computerOnAnimation = new Animation("sprites/computer.png",80,48,0.2f, Animation.PlayMode.LOOP_PINGPONG);
        computerOffAnimation = new Animation("sprites/computer.png",80,48,0.0f);
        isPowered = false;
        updateAnimation();
    }

    private void updateAnimation() {
        if(isPowered) setAnimation(computerOnAnimation);
        else setAnimation(computerOffAnimation);
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

    @Override
    public void setPowered(boolean isPowered) {
        this.isPowered = isPowered;
        updateAnimation();
    }
}
