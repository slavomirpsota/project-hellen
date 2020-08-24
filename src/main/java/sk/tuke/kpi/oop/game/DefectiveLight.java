package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.gamelib.graphics.Animation;

import java.util.Random;

public class DefectiveLight extends Light {
    private final Animation lightOnAnimation;
    private final Animation lightOffAnimation;


    public DefectiveLight() {
        lightOnAnimation = new Animation("sprites/light_on.png");
        lightOffAnimation = new Animation("sprites/light_off.png");
    }

    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        new Loop<>(new Invoke<Actor>(this::defectiveLightBehaviour)).scheduleFor(this);
    }

    private void defectiveLightBehaviour() {
        if(!isPowered()) return;
        Random randomObj = new Random();
        int randomNumber = randomObj.nextInt(20);
        if(randomNumber == 1) {
            this.setAnimation(lightOffAnimation);
        } else {
            this.setAnimation(lightOnAnimation);
        }
    }

}
