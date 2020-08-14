package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Light extends AbstractActor {
    private boolean isRunning;
    private boolean isPowered;
    private final Animation lightOnAnimation;
    private final Animation lightOffAnimation;

    public Light() {
        isRunning = false;
        lightOnAnimation = new Animation("sprites/light_on.png");
        lightOffAnimation = new Animation("sprites/light_off.png");
        setAnimation(lightOffAnimation);
    }

    public void toggle() {
        isRunning = !isRunning;
        updateAnimation();
    }

    public void setElectricityFlow(boolean isPowered) {
        this.isPowered = isPowered;
        updateAnimation();
    }

    private void updateAnimation() {
        if(isRunning && isPowered) setAnimation(lightOnAnimation);
        else setAnimation(lightOffAnimation);
    }

}
