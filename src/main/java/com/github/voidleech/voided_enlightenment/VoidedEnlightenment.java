package com.github.voidleech.voided_enlightenment;

import com.github.voidleech.oblivion.entities.client.OblivionBoatRenderer;
import com.github.voidleech.oblivion.util.Platform;
import com.github.voidleech.oblivion.util.Registration;
import com.github.voidleech.voided_enlightenment.compat.create.blockspouting.SpoutingBehaviours;
import com.github.voidleech.voided_enlightenment.entities.client.VEModelLayers;
import com.github.voidleech.voided_enlightenment.event.MobEvents;
import com.github.voidleech.voided_enlightenment.compat.create.PipeCollisionEvents;
import com.github.voidleech.voided_enlightenment.registry.VEBlocks;
import com.github.voidleech.voided_enlightenment.registry.VEDispenserBehaviors;
import com.github.voidleech.voided_enlightenment.registry.VEFluidInteractions;
import com.github.voidleech.voided_enlightenment.registry.VEFuel;
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
import net.mcreator.enlightened_end.EnlightenedEndMod;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.ChestRaftModel;
import net.minecraft.client.model.RaftModel;
import net.minecraft.client.renderer.Sheets;
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

import java.util.List;

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
        Registration.registerPacks(List.of(VEPacks.VE, VEPacks.OOZE), MOD_ID);

        VEBlocks.register(modEventBus);
        VEItems.register(modEventBus);
        VERecipeTypes.register(modEventBus);
        VERecipeSerializers.register(modEventBus);

        VEFuel.init();

        if (ModList.get().isLoaded("farmersdelight")){
            VEItemsFD.register(modEventBus);
            VERecipeTypesFD.register();
            VERecipeSerializersFD.register();
        }

        if (Platform.isModLoaded("create")){
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
            if (Platform.isModLoaded("create")) {
                SpoutingBehaviours.register();
            }
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
            OblivionBoatRenderer.registerBoatResources(VEWoodTypes.VEBoatType.class, EnlightenedEndMod.MODID);
            event.enqueueWork(() -> {
                Sheets.addWoodType(VEWoodTypes.CERULEAN);
                Sheets.addWoodType(VEWoodTypes.INDIGO);
            });
        }

        @SubscribeEvent
        public static void registerModelLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
            event.registerLayerDefinition(VEModelLayers.CERULEAN_RAFT_LAYER, RaftModel::createBodyModel);
            event.registerLayerDefinition(VEModelLayers.CERULEAN_CHEST_RAFT_LAYER, ChestRaftModel::createBodyModel);
            event.registerLayerDefinition(VEModelLayers.INDIGO_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(VEModelLayers.INDIGO_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
        }
    }
}
