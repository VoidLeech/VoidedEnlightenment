package com.github.voidleech.voided_enlightenment.mixin.render;

import net.mcreator.enlightened_end.procedures.EndSkiesProcedure;
import net.minecraftforge.client.event.ViewportEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(EndSkiesProcedure.class)
public class EndSkiesProcedureMixin {
    // Upper end fog sucks, shifting background colors is very jarring on the boundaries
    @Inject(method = "computeFogColor", at = @At("HEAD"), cancellable = true, remap = false)
    private static void voided_enlightenment$cancelComputeFog(ViewportEvent.ComputeFogColor event, CallbackInfo ci){
        ci.cancel();
    }
}
