package org.booleanfloat.traveler.steps;

import org.booleanfloat.traveler.interfaces.Traversable;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Constants;
import org.powerbot.script.rt4.Game;
import org.powerbot.script.rt4.Magic;

public class Spell implements Traversable {
    protected Magic.Spell spell;

    public Spell(Magic.Spell spell) {
        this.spell = spell;
    }

    @Override
    public Tile getTile() {
        return new Tile(-1, -1, -1);
    }

    @Override
    public Tile getTile(ClientContext ctx) {
        return ctx.players.local().tile();
    }

    @Override
    public boolean isObstructing(ClientContext ctx) {
        return false;
    }

    @Override
    public boolean isTraversable(ClientContext ctx) {
        return ctx.skills.realLevel(Constants.SKILLS_MAGIC) >= spell.level();
    }

    @Override
    public boolean traverse(ClientContext ctx) {
        boolean hasCastSpell = ctx.magic.cast(spell);

        if(hasCastSpell) {
            Condition.sleep(1000);
            ctx.game.tab(Game.Tab.INVENTORY);
        }

        return hasCastSpell;
    }
}
