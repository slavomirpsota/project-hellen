package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.tools.BreakableTool;

public class Mjolnir extends BreakableTool {
    private Animation mjolnirAnimation;

    public Mjolnir() {
        super(1);
        mjolnirAnimation = new Animation("sprites/hammer.png");
        setAnimation(mjolnirAnimation);
    }
}
