package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.graphics.Animation;

public class Mjolnir extends AbstractBreakableTool {
    private Animation mjolnirAnimation;

    public Mjolnir() {
        super(1);
        mjolnirAnimation = new Animation("sprites/hammer.png");
        setAnimation(mjolnirAnimation);
    }
}
