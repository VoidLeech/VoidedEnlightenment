package com.github.voidleech.voided_enlightenment.mixin.render;

import net.mcreator.enlightened_end.procedures.RenderWorldProcedure;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RenderWorldProcedure.class)
public class RenderWorldProcedureMixin {
    // I'll be real, I don't understand what this function is doing. I think some sort of random ambiance.
    // However, it's certainly messing with the render system, even when we're not in the end.
    @Inject(method = "renderSky", at = @At("HEAD"), cancellable = true, remap = false)
    private static void ve$cancelSky(RenderLevelStageEvent event, CallbackInfo ci){
        ci.cancel();
    }

}
