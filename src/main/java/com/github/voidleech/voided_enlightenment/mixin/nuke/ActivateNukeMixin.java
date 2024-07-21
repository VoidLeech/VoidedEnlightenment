package com.github.voidleech.voided_enlightenment.mixin.nuke;

import net.mcreator.enlightened_end.procedures.LightNuclearBombProcedure;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LightNuclearBombProcedure.class)
public class ActivateNukeMixin {
    // We're gonna both fix the activation and make it configurable, cancel the original impl.
    @Inject(method = "onRightClickBlock", at = @At("HEAD"), cancellable = true, remap = false)
    private static void ve$cancelNukeEvent(PlayerInteractEvent.RightClickBlock event, CallbackInfo ci){
        ci.cancel();
    }
}
