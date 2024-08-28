package com.github.voidleech.voided_enlightenment;

import com.github.voidleech.voided_enlightenment.event.MobEvents;
import com.github.voidleech.voided_enlightenment.registry.VEPacks;
import com.github.voidleech.voided_enlightenment.registry.VEPotionRecipes;
import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(VoidedEnlightenment.MOD_ID)
public class VoidedEnlightenment
{
    public static final String MOD_ID = "voided_enlightenment";
    public static final Logger LOGGER = LogUtils.getLogger();

    public VoidedEnlightenment()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        modEventBus.addListener(this::commonSetup);
        VEPotionRecipes.register();
        new VEPacks().register(modEventBus);

        forgeBus.register(this);
        MobEvents.register(forgeBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, VoidedEnlightenmentConfig.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
