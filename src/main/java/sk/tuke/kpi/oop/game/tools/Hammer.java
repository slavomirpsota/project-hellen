package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Reactor;

public class Hammer<A extends Reactor> extends AbstractBreakableTool<A> {
    private final Animation hammerAnimation;

    public Hammer() {
        super(1);
        hammerAnimation = new Animation("sprites/hammer.png");
        setAnimation(hammerAnimation);
    }

    @Override
    public void useWith(A actor) {
        super.useWith(actor);
        actor.repair(this);
    }
}
