package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.actions.Loop;

public class SmartCooler extends Cooler {

    public SmartCooler(Reactor reactor) {
        super(reactor);
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

    @Override
    public void coolReactor() {
        if(getReactor().getTemperature() >= 2500) {
            turnOn();
        } else if(getReactor().getTemperature() <= 1500) {
            turnOff();
        }
    }
}
