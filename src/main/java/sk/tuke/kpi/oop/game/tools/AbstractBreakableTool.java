package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.oop.game.IRepairable;
import sk.tuke.kpi.oop.game.Reactor;

public abstract class AbstractBreakableTool<A extends IRepairable> extends AbstractActor implements IUsable<A> {
    private int remainingUses;

    public AbstractBreakableTool(int remainingUses) {
        this.remainingUses = remainingUses;
    }

    public void useWith(A actor){
        remainingUses -= 1;
        if(remainingUses <= 0 ) this.getScene().removeActor(this);
    }

    public int getRemainingUses() {
        return remainingUses;
    }

}
