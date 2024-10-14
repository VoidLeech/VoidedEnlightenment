package com.github.voidleech.voided_enlightenment.mixin.misc.entity;

import net.mcreator.enlightened_end.entity.FlashBombEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FlashBombEntity.class)
public abstract class FlashBombMixin extends AbstractArrow implements ItemSupplier {

    protected FlashBombMixin(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Inject(method = "onHitEntity", at = @At("TAIL"))
    private void voided_enlightenment$actuallyDiscard(EntityHitResult entityHitResult, CallbackInfo ci)
    {
        // Base damage is 0 so discard isn't called by default
        discard();
    }
}
