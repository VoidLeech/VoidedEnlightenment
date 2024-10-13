package com.github.voidleech.voided_enlightenment;

import com.github.voidleech.voided_enlightenment.event.MobEvents;
import com.github.voidleech.voided_enlightenment.event.PipeCollisionEvents;
import com.github.voidleech.voided_enlightenment.registry.VEItems;
import com.github.voidleech.voided_enlightenment.registry.VEItemsFD;
import com.github.voidleech.voided_enlightenment.registry.VEPacks;
import com.github.voidleech.voided_enlightenment.registry.VEPotionRecipes;
import com.github.voidleech.voided_enlightenment.registry.VERecipeSerializers;
import com.github.voidleech.voided_enlightenment.registry.VERecipeSerializersFD;
import com.github.voidleech.voided_enlightenment.registry.VERecipeTypes;
import com.github.voidleech.voided_enlightenment.registry.VERecipeTypesFD;
import com.mojang.logging.LogUtils;
import net.mcreator.enlightened_end.init.EnlightenedEndModBlocks;
import net.mcreator.enlightened_end.init.EnlightenedEndModFluidTypes;
import net.mcreator.enlightened_end.init.EnlightenedEndModFluids;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fluids.FluidInteractionRegistry;
import net.minecraftforge.fml.ModList;
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
        VEItems.register(modEventBus);
        VERecipeTypes.register(modEventBus);
        VERecipeSerializers.register(modEventBus);
        if (ModList.get().isLoaded("farmersdelight")){
            VEItemsFD.register(modEventBus);
            VERecipeTypesFD.register();
            VERecipeSerializersFD.register();
        }

        forgeBus.register(this);
        MobEvents.register(forgeBus);
        if (ModList.get().isLoaded("create")){
            PipeCollisionEvents.register(forgeBus);
        }

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, VoidedEnlightenmentConfig.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            FluidInteractionRegistry.addInteraction(EnlightenedEndModFluidTypes.OOZE_FLUID_TYPE.get(),
                    new FluidInteractionRegistry.InteractionInformation(ForgeMod.WATER_TYPE.get(), fluidState ->
                            EnlightenedEndModBlocks.PALEROCK.get().defaultBlockState()));
            FluidInteractionRegistry.addInteraction(EnlightenedEndModFluidTypes.OOZE_FLUID_TYPE.get(),
                    new FluidInteractionRegistry.InteractionInformation(ForgeMod.LAVA_TYPE.get(),
                            fluidState -> EnlightenedEndModBlocks.VOID_SHALE.get().defaultBlockState()));
        });
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
