package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.oop.game.DefectiveLight;
import sk.tuke.kpi.oop.game.IRepairable;
import sk.tuke.kpi.oop.game.Reactor;

public abstract class AbstractBreakableTool<A extends Actor> extends AbstractActor implements IUsable<A> {
    private int remainingUses;
    private A actor;

    public AbstractBreakableTool(int remainingUses) {
        this.remainingUses = remainingUses;
    }

    public void useWith(A actor){
        this.actor = actor;
        remainingUses -= 1;
        if(remainingUses <= 0 ) this.getScene().removeActor(this);
    }

    public int getRemainingUses() {
        return remainingUses;
    }

    public A getActor() {
        return actor;
    }
}
