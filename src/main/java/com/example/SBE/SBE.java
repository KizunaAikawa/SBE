package com.example.SBE;

import mods.flammpfeil.slashblade.SlashBlade;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = SBE.MODID, name = SBE.NAME, version = SBE.VERSION)
public class SBE {
    public static final String MODID = "slash_blade_extension";
    public static final String NAME = "SlashBladeExtension";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        SlashBlade.InitEventBus.register(new BladeRegister());
        SlashBlade.InitEventBus.post(new ScanBladeEvent());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    }
}
