package com.github.voidleech.voided_enlightenment.registry;

import com.github.voidleech.oblivion.Oblivion;
import com.github.voidleech.oblivion.util.AssignOnceSupplier;
import com.github.voidleech.voided_enlightenment.entities.VEBoatEntity;
import com.github.voidleech.voided_enlightenment.entities.VEChestBoatEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class VEEntities {
    static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Oblivion.MOD_ID);

    public static final AssignOnceSupplier<EntityType<VEBoatEntity>> BOAT = new AssignOnceSupplier<>();

    public static final AssignOnceSupplier<EntityType<VEChestBoatEntity>> CHEST_BOAT = new AssignOnceSupplier<>();

    public static void register(IEventBus modEventBus){
        ENTITIES.register(modEventBus);
    }
}
