package com.github.voidleech.voided_enlightenment.mixin.ooze.vanilla;

import com.github.voidleech.voided_enlightenment.registry.VETags;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.Direction;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.LavaFluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LavaFluid.class)
public abstract class LavaFluidMixin extends FlowingFluid {
    @ModifyReturnValue(method = "canBeReplacedWith", at = @At("RETURN"))
    private boolean voided_enlightenment$lavaIsReplaceableByNotJustWater(boolean original, @Local(argsOnly = true) Fluid fluid, @Local(argsOnly = true) Direction direction){
        return original || (direction == Direction.DOWN && fluid.is(VETags.OOZE));
    }
}
