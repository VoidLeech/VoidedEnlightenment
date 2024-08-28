package com.github.voidleech.voided_enlightenment.mixin.laser;

import net.mcreator.enlightened_end.procedures.LaserEmissionEntityCollidesInTheBlockProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LaserEmissionEntityCollidesInTheBlockProcedure.class)
public class LaserWalkingMixin {
    @Inject(method = "execute", at = @At(value = "INVOKE",
                target = "Lnet/minecraft/world/entity/Entity;setDeltaMovement(Lnet/minecraft/world/phys/Vec3;)V",
                shift = At.Shift.BEFORE),
            remap = false, cancellable = true)
    private static void voided_enlightenment$cancelFloatingBehaviour(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci){
        // Todo reimplement advancement for walking on them (probably just override the advancement data with non-"minecraft:impossible" criteria
        ci.cancel();
    }
}
