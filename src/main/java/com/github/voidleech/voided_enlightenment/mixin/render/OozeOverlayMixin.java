package com.github.voidleech.voided_enlightenment.mixin.render;

import net.mcreator.enlightened_end.client.screens.OozeOverlayOverlay;
import net.mcreator.enlightened_end.procedures.OozeOverlayDisplayOverlayIngameProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.RenderGuiEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(OozeOverlayOverlay.class)
public class OozeOverlayMixin {
    @Inject(method = "eventHandler", at = @At("HEAD"), cancellable = true, remap = false)
    private static void voided_enlightenment$dontTouchRenderIfDoNoWork(RenderGuiEvent.Pre event, CallbackInfo ci){
        Player player = Minecraft.getInstance().player;
        if (!OozeOverlayDisplayOverlayIngameProcedure.execute(player.level(), player.getX(), player.getY(), player.getZ(), player)){
        ci.cancel();
        }
    }
}
