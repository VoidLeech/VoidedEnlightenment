package com.github.voidleech.voided_enlightenment.mixin.ennegel;

import net.mcreator.enlightened_end.procedures.PlaceEnnegelProcedure;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlaceEnnegelProcedure.class)
public class EnnegelGlobProcedureMixin {
    @Inject(method = "onRightClickBlock", at = @At("HEAD"), remap = false, cancellable = true)
    private static void voided_enlightenment$cancelRightClick(PlayerInteractEvent.RightClickBlock event, CallbackInfo ci){
        ci.cancel();
    }
}
