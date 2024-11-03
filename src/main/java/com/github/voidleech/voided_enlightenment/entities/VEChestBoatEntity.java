package com.github.voidleech.voided_enlightenment.entities;

import com.github.voidleech.voided_enlightenment.registry.VEEntities;
import com.github.voidleech.voided_enlightenment.registry.VEItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class VEChestBoatEntity extends ChestBoat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(Boat.class, EntityDataSerializers.INT);

    public VEChestBoatEntity(EntityType<? extends Boat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public VEChestBoatEntity(Level level, double pX, double pY, double pZ) {
        this(VEEntities.CHEST_BOAT.get().get(), level);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    }

    @Override
    public Item getDropItem() {
        return switch (getModVariant()){
            case CERULEAN -> VEItems.CERULEAN_CHEST_BOAT.get().get();
            case INDIGO -> VEItems.INDIGO_CHEST_BOAT.get().get();
        };
    }

    public void setVariant(VEBoatEntity.Type pVariant) {
        this.entityData.set(DATA_ID_TYPE, pVariant.ordinal());
    }

    public VEBoatEntity.Type getModVariant() {
        return VEBoatEntity.Type.byId(this.entityData.get(DATA_ID_TYPE));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE, VEBoatEntity.Type.CERULEAN.ordinal());
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putString("Type", this.getModVariant().getSerializedName());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {
        if (pCompound.contains("Type", 8)) {
            this.setVariant(VEBoatEntity.Type.byName(pCompound.getString("Type")));
        }
    }
}
