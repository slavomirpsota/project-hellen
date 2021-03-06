package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.DefectiveLight;
import sk.tuke.kpi.oop.game.IRepairable;

public class Wrench<A extends DefectiveLight> extends AbstractBreakableTool<A>{
    private Animation wrenchAnimation;

    public Wrench() {
        super(2);
        wrenchAnimation = new Animation("sprites/wrench.png");
        setAnimation(wrenchAnimation);
    }

    @Override
    public void useWith(A actor) {
        super.useWith(actor);
        actor.repair();
    }
}
