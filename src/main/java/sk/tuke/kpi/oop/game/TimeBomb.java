package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class TimeBomb extends AbstractActor{
    private float timeToDetonation;
    private boolean activated;
    private final Animation deactivatedAnimation;
    private final Animation activatedAnimation;
    private final Animation detonationAnimation;


    public TimeBomb(float timeToDetonation) {
        this.timeToDetonation = timeToDetonation;
        deactivatedAnimation = new Animation("sprites/bomb.png");
        activatedAnimation = new Animation("sprites/bomb_activated.png");
        detonationAnimation = new Animation("sprites/small_explosion.png");
        detonationAnimation.setPlayMode(Animation.PlayMode.ONCE);
    }

    public void activate() {

    }

    public boolean isActivated() {
        return activated;
    }
}
