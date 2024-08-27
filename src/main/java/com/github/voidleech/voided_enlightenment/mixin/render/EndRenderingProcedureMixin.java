package com.github.voidleech.voided_enlightenment.mixin.render;

import net.mcreator.enlightened_end.procedures.EndRenderingProcedure;
import net.minecraftforge.client.event.ViewportEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EndRenderingProcedure.class)
public class EndRenderingProcedureMixin {
    // Upper end fog sucks. It's jarring and flickery on the borders.
    @Inject(method = "renderFog", at = @At("HEAD"), cancellable = true, remap = false)
    private static void voided_enlightenment$cancelFog(ViewportEvent.RenderFog event, CallbackInfo ci){
        ci.cancel();
    }

}
