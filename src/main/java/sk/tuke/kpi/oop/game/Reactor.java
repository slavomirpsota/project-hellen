package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.tools.FireExtinguisher;
import sk.tuke.kpi.oop.game.tools.Hammer;

public class Reactor extends AbstractActor {
    private int temperature;
    private int damage;
    private boolean isRunning;
    private boolean didBreak;
    private boolean wasExtinguished;
    private Light light;
    private final Animation offAnimation;
    private final Animation normalAnimation;
    private final Animation hotAnimation;
    private final Animation brokenAnimation;
    private final Animation extinguishedAnimation;

    public Reactor(Light light) {
        temperature = 0;
        damage = 0;
        isRunning = false;
        didBreak = false;
        this.light = light;
        offAnimation = new Animation("sprites/reactor.png");
        normalAnimation = new Animation("sprites/reactor_on.png", 80, 80, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
        hotAnimation = new Animation("sprites/reactor_hot.png", 80, 80, 0.05f, Animation.PlayMode.LOOP_PINGPONG);
        brokenAnimation = new Animation("sprites/reactor_broken.png", 80, 80, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
        extinguishedAnimation = new Animation("sprites/reactor_extinguished.png");
        updateAnimation();
    }

    public void increaseTemperature(int increment) {
        if(increment < 0 || !isRunning) return;
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
                isRunning = false;
                didBreak = true;
                damage = 100;
            }
        } else {
            temperature += increment;
        }
        updateAnimation();
    }

    public void decreaseTemperature(int decrement) {
        if(decrement < 0 || !isRunning) return;
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
        else if(!isRunning && damage < 100) setAnimation(offAnimation);
        else if(temperature <= 4000) setAnimation(normalAnimation);
        else if(temperature < 6000) setAnimation(hotAnimation);
        if(!isRunning && light != null) removeLight(light);
        if(isRunning && light != null) addLight(light);
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

    public void addLight(Light light) {
        this.light = light;
        light.setElectricityFlow(true);
    }

    public void removeLight(Light light) {
        light.setElectricityFlow(false);
    }

    public void turnOn() {
        if(!isRunning) isRunning = true;
        light.setElectricityFlow(true);
        updateAnimation();
    }

    public void turnOff() {
        if(isRunning) isRunning = false;
        light.setElectricityFlow(false);
        updateAnimation();
    }

    public boolean isRunning() {
        return isRunning;
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
}
