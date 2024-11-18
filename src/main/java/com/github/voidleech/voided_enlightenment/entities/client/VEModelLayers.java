package com.github.voidleech.voided_enlightenment.entities.client;

import net.mcreator.enlightened_end.EnlightenedEndMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class VEModelLayers {
    public static final ModelLayerLocation CERULEAN_RAFT_LAYER = new ModelLayerLocation(
            new ResourceLocation(EnlightenedEndMod.MODID, "boat/cerulean"), "main");
    public static final ModelLayerLocation CERULEAN_CHEST_RAFT_LAYER = new ModelLayerLocation(
            new ResourceLocation(EnlightenedEndMod.MODID, "chest_boat/cerulean"), "main");
    public static final ModelLayerLocation INDIGO_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(EnlightenedEndMod.MODID, "boat/indigo"), "main");
    public static final ModelLayerLocation INDIGO_CHEST_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(EnlightenedEndMod.MODID, "chest_boat/indigo"), "main");
}
