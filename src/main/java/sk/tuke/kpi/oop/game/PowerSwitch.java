package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class ControlSwitch extends AbstractActor {
    private Reactor reactor;
    private final Animation controllerAnimation;

    public ControlSwitch(Reactor reactor) {
        controllerAnimation = new Animation("sprites/switch.png");
        setAnimation(controllerAnimation);
        this.reactor = reactor;
    }

    public void toggle() {
        if(reactor.getDidBreak()) {
            reactor.turnOff();
            return;
        }
        if(reactor.isRunning()) reactor.turnOff();
        else reactor.turnOn();
    }
}
