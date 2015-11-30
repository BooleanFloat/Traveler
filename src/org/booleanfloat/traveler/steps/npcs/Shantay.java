package org.booleanfloat.traveler.steps.npcs;

import org.booleanfloat.traveler.Config;
import org.booleanfloat.traveler.regions.kharidiandesert.AlKharid;
import org.booleanfloat.traveler.steps.Npc;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;

public class Shantay extends Npc {
    public Shantay() {
        super(4642, "Talk-to", AlKharid.ShantyPass.area);
    }

    @Override
    public Tile getTile(ClientContext ctx) {
        if(area.contains(ctx.players.local())) {
            return ctx.players.local().tile();
        }

        return getTile();
    }

    @Override
    public boolean isObstructing(ClientContext ctx) {
        return area.contains(ctx.players.local());
    }

    @Override
    public boolean traverse(ClientContext ctx) {
        Component chatContinueNpc = ctx.widgets.component(231, 2);
        Component chatContinuePlayer = ctx.widgets.component(217, 2);
        Component chatOptions = ctx.widgets.component(219, 0);

        if(chatContinueNpc.visible()) {
            chatContinueNpc.click();
            Condition.sleep(Config.CHAT_DELAY);
        }
        else if(chatContinuePlayer.visible()) {
            chatContinuePlayer.click();
            Condition.sleep(Config.CHAT_DELAY);
        }
        else if(chatOptions.visible()) {
            String firstOption = chatOptions.component(1).text();
            if(firstOption.equals("What is this place?")) {
                chatOptions.component(1).click();
                Condition.sleep(Config.CHAT_DELAY);
            }
            else if(firstOption.equals("I am definitely an outlaw, prepare to die!")) {
                chatOptions.component(1).click();
                Condition.sleep(Config.CHAT_DELAY);
                chatContinuePlayer.click();
                Condition.sleep(Config.CHAT_DELAY);
                chatContinueNpc.click();
                Condition.sleep(Config.CHAT_DELAY);
                chatContinueNpc.click();
                Condition.sleep(5000);
            }
            else if(firstOption.equals("Yes, okay.")) {
                chatOptions.component(2).click();
                Condition.sleep(Config.CHAT_DELAY);
            }
        }
        else {
            return ctx.npcs.select().id(id).within(area).nearest().poll().interact(interaction);
        }

        return false;
    }
}
