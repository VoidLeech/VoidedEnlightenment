package com.github.voidleech.voided_enlightenment.mixin.laser;

import net.mcreator.enlightened_end.procedures.PlayerMixLaserProcedure;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerMixLaserProcedure.class)
public class ModifyLaserTypeMixin {
    @Inject(method = "onRightClickBlock", at = @At("HEAD"), remap = false, cancellable = true)
    private static void ve$cancelMixEvent(PlayerInteractEvent.RightClickBlock event, CallbackInfo ci){
        ci.cancel();
    }
}
