package com.aequitas.aeqmod.events;

import com.aequitas.aeqmod.utils.GuildOutputRedesign;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

public class TooltipEvent {
    @SubscribeEvent
    public void onItemTooltipEvent(ItemTooltipEvent event) {
        List<String> tooltip = event.getToolTip();
        if ( tooltip.get(0).contains("Guild Output") ) {
            GuildOutputRedesign.execute(tooltip);
        }
    }
}

