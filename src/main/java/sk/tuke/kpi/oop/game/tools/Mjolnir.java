package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Reactor;

public class Mjolnir<A extends Reactor> extends AbstractBreakableTool<A> {
    private Animation mjolnirAnimation;

    public Mjolnir(Actor actor) {
        super(1);
        mjolnirAnimation = new Animation("sprites/hammer.png");
        setAnimation(mjolnirAnimation);
    }

    @Override
    public void useWith(A actor) {

    }

}
