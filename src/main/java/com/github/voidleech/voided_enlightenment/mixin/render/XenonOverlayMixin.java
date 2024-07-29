package com.github.voidleech.voided_enlightenment.mixin.render;

import net.mcreator.enlightened_end.client.screens.XenonOverlayOverlay;
import net.mcreator.enlightened_end.procedures.XenonOverlayDisplayProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.RenderGuiEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(XenonOverlayOverlay.class)
public class XenonOverlayMixin {
    @Inject(method = "eventHandler", at = @At("HEAD"), cancellable = true, remap = false)
    private static void ve$dontTouchRenderIfDoNoWork(RenderGuiEvent.Pre event, CallbackInfo ci){
        Player player = Minecraft.getInstance().player;
        if (!XenonOverlayDisplayProcedure.execute(player.level(), player.getX(), player.getY(), player.getZ())){
        ci.cancel();
        }
    }
}
