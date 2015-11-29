package org.booleanfloat.traveler.steps.npcs;

import org.booleanfloat.traveler.Config;
import org.booleanfloat.traveler.steps.Npc;
import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;

public class EastArdougneKaramjaCaptain extends Npc {
    public EastArdougneKaramjaCaptain(int id, String interaction, Area area) {
        super(id, interaction, area);
    }

    @Override
    public boolean traverse(ClientContext ctx) {
        Component chatContinueNpc = ctx.widgets.component(231, 2);
        Component chatContinuePlayer = ctx.widgets.component(217, 2);
        Component chatOptionsSelect = ctx.widgets.component(219, 0).component(1);

        if(chatContinueNpc.visible()) {
            chatContinueNpc.click();
            Condition.sleep(Config.CHAT_DELAY);
        }
        else if(chatOptionsSelect.visible()) {
            chatOptionsSelect.click();
            Condition.sleep(Config.CHAT_DELAY);
        }
        else if(chatContinuePlayer.visible()) {
            chatContinuePlayer.click();
            Condition.sleep(Config.CHAT_DELAY);
        }
        else {
            return npc != null && npc.interact(interaction);
        }

        return false;
    }
}
