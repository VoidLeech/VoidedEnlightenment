package com.github.voidleech.voided_enlightenment;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = VoidedEnlightenment.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class VoidedEnlightenmentConfig
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue NUKE_ALLOWED = BUILDER
            .comment("Whether the nuclear bomb can be used.")
            .define("nuke_allowed", true);

    public static boolean nukeAllowed;

    static final ForgeConfigSpec SPEC = BUILDER.build();

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        nukeAllowed = NUKE_ALLOWED.get();
    }
}
