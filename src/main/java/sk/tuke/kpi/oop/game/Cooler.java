package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Cooler extends AbstractActor implements Switchable{
    private boolean isOn;
    private Animation coolerOnAnimation;
    private Animation coolerOffAnimation;
    private Reactor reactor;

    public Cooler(Reactor reactor) {
        this.reactor = reactor;
        isOn = true;
        coolerOnAnimation = new Animation("sprites/fan.png", 32,32, 0.2f, Animation.PlayMode.LOOP_PINGPONG);
        coolerOffAnimation = new Animation("sprites/fan.png", 32,32,0.0f);
        setAnimation(coolerOnAnimation);
    }

    public void coolReactor() {
        if(isOn)
            reactor.decreaseTemperature(1);
    }

    /**
     * This method is scheduling actions when Actor is added to scene and repeating it every frame
     * @param scene
     */
    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        new Loop<>(new Invoke<Actor>(this::coolReactor)).scheduleFor(this);
    }

    public void turnOn() {
        if(!isOn) {
            this.getAnimation().play();
            isOn = true;
        }
    }

    public void turnOff() {
        if(isOn) {
            this.getAnimation().pause();
            isOn = false;
        }
    }

    public boolean isOn() {
        return isOn;
    }

    public Reactor getReactor() {
        return reactor;
    }

}
