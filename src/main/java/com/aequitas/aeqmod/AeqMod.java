package com.aequitas.aeqmod;

import com.aequitas.aeqmod.events.EventManager;
import com.aequitas.aeqmod.utils.HandleGuildsJson;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = AeqMod.MODID, name = AeqMod.NAME, version = AeqMod.VERSION)
public class AeqMod
{
    public static final String MODID = "aeqmod";
    public static final String NAME = "AeqMod";
    public static final String VERSION = "1.0";

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        EventManager.RegisterEvents();
        HandleGuildsJson.setJsonArray();
    }
}
