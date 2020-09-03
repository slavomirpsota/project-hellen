package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Light extends AbstractActor implements ISwitchable, IEnergyConsumer {
    private boolean isOn;
    private boolean isPowered;
    private final Animation lightOnAnimation;
    private final Animation lightOffAnimation;

    public Light() {
        isOn = false;
        lightOnAnimation = new Animation("sprites/light_on.png");
        lightOffAnimation = new Animation("sprites/light_off.png");
        setAnimation(lightOffAnimation);
    }

    public void setElectricityFlow(boolean isPowered) {
        this.isPowered = isPowered;
        updateAnimation();
    }

    private void updateAnimation() {
        if(isOn && isPowered) setAnimation(lightOnAnimation);
        else setAnimation(lightOffAnimation);
    }

    public boolean isPowered() {
        return isPowered;
    }

    @Override
    public void turnOn() {
        isOn = true;
        updateAnimation();
    }

    @Override
    public void turnOff() {
        isOn = false;
        updateAnimation();
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public void setPowered(boolean isPowered) {
        this.isPowered = isPowered;
    }

}
