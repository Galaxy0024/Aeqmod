package com.aequitas.aeqmod.events;

import net.minecraftforge.common.MinecraftForge;

public class EventManager {
    public static void RegisterEvents() {
        MinecraftForge.EVENT_BUS.register(new TooltipEvent());
        MinecraftForge.EVENT_BUS.register(new ArmorStandDetectorEvent());
    }
}
