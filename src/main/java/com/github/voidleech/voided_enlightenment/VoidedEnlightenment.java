package com.github.voidleech.voided_enlightenment;

import com.github.voidleech.voided_enlightenment.entities.client.VEBoatRenderer;
import com.github.voidleech.voided_enlightenment.entities.client.VEModelLayers;
import com.github.voidleech.voided_enlightenment.event.MobEvents;
import com.github.voidleech.voided_enlightenment.event.PipeCollisionEvents;
import com.github.voidleech.voided_enlightenment.registry.VEBlocks;
import com.github.voidleech.voided_enlightenment.registry.VEDispenserBehaviors;
import com.github.voidleech.voided_enlightenment.registry.VEEntities;
import com.github.voidleech.voided_enlightenment.registry.VEFluidInteractions;
import com.github.voidleech.voided_enlightenment.registry.VEItems;
import com.github.voidleech.voided_enlightenment.registry.VEItemsC;
import com.github.voidleech.voided_enlightenment.registry.VEItemsFD;
import com.github.voidleech.voided_enlightenment.registry.VEPacks;
import com.github.voidleech.voided_enlightenment.registry.VEPotionRecipes;
import com.github.voidleech.voided_enlightenment.registry.VERecipeSerializers;
import com.github.voidleech.voided_enlightenment.registry.VERecipeSerializersFD;
import com.github.voidleech.voided_enlightenment.registry.VERecipeTypes;
import com.github.voidleech.voided_enlightenment.registry.VERecipeTypesFD;
import com.github.voidleech.voided_enlightenment.registry.VEWoodTypes;
import com.mojang.logging.LogUtils;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
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

        VEBlocks.register(modEventBus);
        VEItems.register(modEventBus);
        VEEntities.register(modEventBus);
        VERecipeTypes.register(modEventBus);
        VERecipeSerializers.register(modEventBus);

        if (ModList.get().isLoaded("farmersdelight")){
            VEItemsFD.register(modEventBus);
            VERecipeTypesFD.register();
            VERecipeSerializersFD.register();
        }

        if (ModList.get().isLoaded("create")){
            VEItemsC.register(modEventBus);
            PipeCollisionEvents.register(forgeBus);
        }

        forgeBus.register(this);
        MobEvents.register(forgeBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, VoidedEnlightenmentConfig.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            VEFluidInteractions.register();
            VEDispenserBehaviors.register();
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
            event.enqueueWork(() -> {
                Sheets.addWoodType(VEWoodTypes.CERULEAN);
                Sheets.addWoodType(VEWoodTypes.INDIGO);

                EntityRenderers.register(VEEntities.BOAT.get().get(), context -> new VEBoatRenderer(context, false));
                EntityRenderers.register(VEEntities.CHEST_BOAT.get().get(), context -> new VEBoatRenderer(context, true));
            });
        }

        @SubscribeEvent
        public static void registerModelLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
            event.registerLayerDefinition(VEModelLayers.CERULEAN_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(VEModelLayers.CERULEAN_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(VEModelLayers.INDIGO_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(VEModelLayers.INDIGO_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
        }
    }
}
