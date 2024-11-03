package com.github.voidleech.voided_enlightenment.entities.client;

import com.github.voidleech.voided_enlightenment.VoidedEnlightenment;
import com.github.voidleech.voided_enlightenment.entities.VEBoatEntity;
import com.github.voidleech.voided_enlightenment.entities.VEChestBoatEntity;
import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.mcreator.enlightened_end.EnlightenedEndMod;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;

import java.util.Map;
import java.util.stream.Stream;

public class VEBoatRenderer extends BoatRenderer {
    private final Map<VEBoatEntity.Type, Pair<ResourceLocation, ListModel<Boat>>> boatResources;

    public VEBoatRenderer(EntityRendererProvider.Context pContext, boolean pChestBoat) {
        super(pContext, pChestBoat);
        boatResources = Stream.of(VEBoatEntity.Type.values()).collect(ImmutableMap.toImmutableMap(type -> type,
                type -> Pair.of(new ResourceLocation(EnlightenedEndMod.MODID, getTextureLocation(type, pChestBoat)), createBoatModel(pContext, type, pChestBoat))));
    }

    private static String getTextureLocation(VEBoatEntity.Type pType, boolean pChestBoat) {
        return pChestBoat ? "textures/entity/chest_boat/" + pType.getName() + ".png" : "textures/entity/boat/" + pType.getName() + ".png";
    }

    private ListModel<Boat> createBoatModel(EntityRendererProvider.Context pContext, VEBoatEntity.Type pType, boolean pChestBoat) {
        ModelLayerLocation modellayerlocation = pChestBoat ? VEBoatRenderer.createChestBoatModelName(pType) : VEBoatRenderer.createBoatModelName(pType);
        ModelPart modelpart = pContext.bakeLayer(modellayerlocation);
        return pChestBoat ? new ChestBoatModel(modelpart) : new BoatModel(modelpart);
    }

    public static ModelLayerLocation createBoatModelName(VEBoatEntity.Type pType) {
        return createLocation("boat/" + pType.getName(), "main");
    }

    public static ModelLayerLocation createChestBoatModelName(VEBoatEntity.Type pType) {
        return createLocation("chest_boat/" + pType.getName(), "main");
    }

    private static ModelLayerLocation createLocation(String pPath, String pModel) {
        return new ModelLayerLocation(new ResourceLocation(EnlightenedEndMod.MODID, pPath), pModel);
    }

    public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat) {
        if(boat instanceof VEBoatEntity modBoat) {
            return this.boatResources.get(modBoat.getModVariant());
        } else if(boat instanceof VEChestBoatEntity modChestBoatEntity) {
            return this.boatResources.get(modChestBoatEntity.getModVariant());
        } else {
            return null;
        }
    }
}
