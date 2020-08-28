package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.actions.PerpetualReactorHeating;
import sk.tuke.kpi.oop.game.tools.FireExtinguisher;
import sk.tuke.kpi.oop.game.tools.Hammer;

import java.util.HashSet;
import java.util.Set;

public class Reactor extends AbstractActor implements Switchable, EnergyConsumer{
    private int temperature;
    private int damage;
    private boolean isOn;
    private boolean isPowered;
    private boolean didBreak;
    private boolean wasExtinguished;
    private EnergyConsumer device;
    private Set<EnergyConsumer> devices;
    private final Animation offAnimation;
    private final Animation normalAnimation;
    private final Animation hotAnimation;
    private final Animation brokenAnimation;
    private final Animation extinguishedAnimation;

    public Reactor(EnergyConsumer device) {
        temperature = 0;
        damage = 0;
        isOn = false;
        didBreak = false;
        devices = new HashSet<>();
        devices.add(device);
        isPowered = true;
        offAnimation = new Animation("sprites/reactor.png");
        normalAnimation = new Animation("sprites/reactor_on.png", 80, 80, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
        hotAnimation = new Animation("sprites/reactor_hot.png", 80, 80, 0.05f, Animation.PlayMode.LOOP_PINGPONG);
        brokenAnimation = new Animation("sprites/reactor_broken.png", 80, 80, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
        extinguishedAnimation = new Animation("sprites/reactor_extinguished.png");
        updateAnimation();
    }

    public void increaseTemperature(int increment) {
        if(increment < 0 || !isOn) return;
        if(temperature >= 2000 && damage < 33) {
            temperature += increment;
            damage = ((temperature - 2000) / 40);
        }
        else if(damage >= 33 && damage <= 66) {
            temperature += (int) Math.ceil(increment * 1.5);
            damage = ((temperature - 2000) / 40);
        }else if(damage > 66 && damage < 100) {
            temperature += (int) Math.ceil(increment * 2);
            damage = ((temperature - 2000) / 40);
            if(damage > 100) {
                isOn = false;
                didBreak = true;
                damage = 100;
            }
        } else {
            temperature += increment;
        }
        updateAnimation();
    }

    public void decreaseTemperature(int decrement) {
        if(decrement < 0 || !isOn || (temperature - decrement < -1)) return;
        if(damage >= 50 && damage < 100) {
            temperature -= decrement / 2;
        } else if(damage >= 100) {
            temperature -= decrement / 2;
            return;
        } else {
            temperature -= decrement;
        }
        updateAnimation();
    }

    private void updateAnimation() {
        if(didBreak) setAnimation(brokenAnimation);
        else if(wasExtinguished) setAnimation(extinguishedAnimation);
        else if(!isOn && damage < 100) setAnimation(offAnimation);
        else if(temperature <= 4000) setAnimation(normalAnimation);
        else if(temperature < 6000) setAnimation(hotAnimation);
        if(!isOn && devices != null) removeDevice(device);
        if(isOn && devices != null) addDevice(device);
    }

    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        new PerpetualReactorHeating(1).scheduleFor(this);
    }

    public void repairWith(Hammer hammer) {
        if(hammer != null) {
            if(damage >= 50) {
                temperature -= 2000;
                damage -= 50;
            } else {
                temperature -= damage * 40;
                damage = 0;
            }
        }
        hammer.use();
        updateAnimation();
    }

    public void extinguishWith(FireExtinguisher fireExtinguisher) {
        if(fireExtinguisher != null) {
            temperature = 4000;
            fireExtinguisher.use();
            setAnimation(extinguishedAnimation);
        }
    }

    public void addDevice(EnergyConsumer device) {
        if (device != null) {
            if (isOn) device.setPowered(true);
            devices.add(device);
        }
    }

    public void removeDevice(EnergyConsumer device){
        if (device != null && devices.contains(device)) {
                device.setPowered(false);
                devices.remove(device);
        }
    }

    public void turnOn() {
        if(!isOn) isOn = true;
        if(device != null)
            device.setPowered(true);
        updateAnimation();
    }

    public void turnOff() {
        if(isOn) isOn = false;
        if(device != null)
            device.setPowered(false);
        updateAnimation();
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    public boolean getDidBreak() {
        return didBreak;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void setPowered(boolean isPowered) {
        this.isPowered = isPowered;
    }
}
