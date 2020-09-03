package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.gamelib.graphics.Color;

public class PowerSwitch extends AbstractActor implements ISwitchable {
    private ISwitchable device;
    private final Animation powerSwitchAnimation;

    public PowerSwitch(ISwitchable device) {
        powerSwitchAnimation = new Animation("sprites/switch.png");
        setAnimation(powerSwitchAnimation);
        this.device = device;
    }

    public ISwitchable getDevice() {
        return device;
    }

    @Override
    public void turnOn() {
        device.turnOn();
        getAnimation().setTint(Color.WHITE);
    }

    @Override
    public void turnOff() {
        device.turnOff();
        getAnimation().setTint(Color.GRAY);
    }

    @Override
    public boolean isOn() {
        return device.isOn();
    }
}
