package org.booleanfloat.traveler.steps.npcs;

import org.booleanfloat.traveler.Config;
import org.booleanfloat.traveler.steps.Npc;
import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;

public class KaramjaCustomsOfficer extends Npc {
    public KaramjaCustomsOfficer(int id, String interaction, Area area) {
        super(id, interaction, area);
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
            if(firstOption.equals("Can I journey on this ship?")) {
                chatOptions.component(1).click();
            }
            else if(firstOption.equals("Why?")) {
                chatOptions.component(2).click();
            }
            else if(firstOption.equals("Ok.")) {
                chatOptions.component(1).click();
            }
            Condition.sleep(Config.CHAT_DELAY);
        }
        else {
            return npc != null && npc.interact(interaction);
        }

        return false;
    }
}
