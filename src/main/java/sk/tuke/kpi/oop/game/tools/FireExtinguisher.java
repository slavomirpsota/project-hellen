package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Reactor;

public class FireExtinguisher<A extends Reactor> extends AbstractBreakableTool<A> {
    private final Animation extinguisherAnimation;

    public FireExtinguisher(Actor actor) {
        super(1);
        extinguisherAnimation = new Animation("sprites/extinguisher.png");
        setAnimation(extinguisherAnimation);
    }

    @Override
    public void useWith(A actor) {
        actor.extinguish(this);
    }
}
