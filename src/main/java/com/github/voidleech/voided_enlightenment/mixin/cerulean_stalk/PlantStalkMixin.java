package com.github.voidleech.voided_enlightenment.mixin.cerulean_stalk;

import net.mcreator.enlightened_end.procedures.PlantCeruleanStalkProcedure;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlantCeruleanStalkProcedure.class)
public class PlantStalkMixin {
    @Inject(method = "onRightClickBlock", at = @At("HEAD"), remap = false, cancellable = true)
    private static void voided_enlightenment$cancelPlacement(PlayerInteractEvent.RightClickBlock event, CallbackInfo ci){
        ci.cancel();
    }
}
