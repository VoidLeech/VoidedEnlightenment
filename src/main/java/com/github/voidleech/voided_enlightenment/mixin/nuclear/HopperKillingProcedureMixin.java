package com.github.voidleech.voided_enlightenment.mixin.nuclear;

import net.mcreator.enlightened_end.procedures.NuclearFurnaceNeighbourBlockChangesProcedure;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NuclearFurnaceNeighbourBlockChangesProcedure.class)
public class HopperKillingProcedureMixin {
    @Inject(method = "execute", at = @At("HEAD"), remap = false, cancellable = true)
    private static void ve$dontBreakHopper(LevelAccessor world, double x, double y, double z, CallbackInfo ci){
        // It's not like the capabilities don't work on the sides.
        // This procedure was specifically made to kill hoppers on the side.
        ci.cancel();
    }
}
