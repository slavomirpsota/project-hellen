package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.ActionSequence;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.actions.Wait;
import sk.tuke.kpi.gamelib.actions.When;
import sk.tuke.kpi.gamelib.framework.Scenario;
import sk.tuke.kpi.oop.game.tools.Hammer;

public class Gameplay extends Scenario {

    @Override
    public void setupPlay(@NotNull Scene scene) {
        setupPowerSwitchAndReactor(scene);
//        Reactor reactor = new Reactor(null);
//        Cooler cooler = new Cooler(reactor);
//        Hammer hammer = new Hammer();
//        scene.addActor(reactor, 64,64);
//        //scene.addActor(cooler, 128, 128);
//        scene.addActor(hammer, 250,250);
//        reactor.turnOn();
//        /*new ActionSequence<>(
//                new Wait<>(5),
//                new Invoke<>(cooler::turnOn)
//        ).scheduleFor(cooler);*/
//        new When<>(
//                () -> reactor.getTemperature() >= 3000,
//                new Invoke<Actor>(() -> {
//                    reactor.repairWith(hammer);
//                })
//        ).scheduleFor(reactor);
    }

    private void setupPowerSwitchAndReactor(@NotNull Scene scene) {
        Reactor reactor = new Reactor(null);
        PowerSwitch powerSwitch = new PowerSwitch(reactor);
        scene.addActor(reactor, 64,64);
        scene.addActor(powerSwitch,130,64);
    }
}
