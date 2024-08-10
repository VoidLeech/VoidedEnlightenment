package com.github.voidleech.voided_enlightenment.mixin.ooze;

import net.mcreator.enlightened_end.procedures.FillCauldronOozeProcedure;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FillCauldronOozeProcedure.class)
public class FillCauldronProcedureMixin {
    @Inject(method = "onRightClickBlock", at = @At("HEAD"), remap = false, cancellable = true)
    private static void ve$cancelFillEvent(PlayerInteractEvent.RightClickBlock event, CallbackInfo ci){
        ci.cancel();
    }
}
