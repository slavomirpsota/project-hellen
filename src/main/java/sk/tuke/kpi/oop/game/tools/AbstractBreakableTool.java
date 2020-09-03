package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.framework.AbstractActor;

public abstract class AbstractBreakableTool extends AbstractActor {
    private int remainingUses;

    public AbstractBreakableTool(int remainingUses) {
        this.remainingUses = remainingUses;
    }

    public void use(){
        remainingUses -= 1;
        if(remainingUses <= 0 ) this.getScene().removeActor(this);
    }

    public int getRemainingUses() {
        return remainingUses;
    }
}
