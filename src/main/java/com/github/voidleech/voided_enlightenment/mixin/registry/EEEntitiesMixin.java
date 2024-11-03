package com.github.voidleech.voided_enlightenment.mixin.registry;

import com.github.voidleech.voided_enlightenment.entities.VEBoatEntity;
import com.github.voidleech.voided_enlightenment.entities.VEChestBoatEntity;
import com.github.voidleech.voided_enlightenment.registry.VEEntities;
import net.mcreator.enlightened_end.init.EnlightenedEndModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(EnlightenedEndModEntities.class)
public abstract class EEEntitiesMixin {
    // This is one massive hack to get the boats registered under Enlightend's mod id, s.t. mods like EveryCompat can detect them

    @Shadow @Final public static DeferredRegister<EntityType<?>> REGISTRY;
    @Unique
    private static final RegistryObject<EntityType<VEBoatEntity>> VOIDED_ENLIGHTENMENT$BOAT = REGISTRY.register("boat", () -> EntityType.Builder.<VEBoatEntity>of(
            VEBoatEntity::new, MobCategory.MISC).sized(1.375f, 0.5625f).build("boat"));

    @Unique
    private static final RegistryObject<EntityType<VEChestBoatEntity>> VOIDED_ENLIGHTENMENT$CHEST_BOAT = REGISTRY.register("chest_boat", () -> EntityType.Builder.<VEChestBoatEntity>of(
            VEChestBoatEntity::new, MobCategory.MISC).sized(1.375f, 0.5625f).build("chest_boat"));

    static {
        VEEntities.BOAT.assign(VOIDED_ENLIGHTENMENT$BOAT);
        VEEntities.CHEST_BOAT.assign(VOIDED_ENLIGHTENMENT$CHEST_BOAT);
    }
}
