package com.github.voidleech.voided_enlightenment.mixin.render;

import net.mcreator.enlightened_end.client.screens.DashChargeOverlay;
import net.mcreator.enlightened_end.procedures.Dash0Procedure;
import net.mcreator.enlightened_end.procedures.Dash1Procedure;
import net.mcreator.enlightened_end.procedures.Dash2Procedure;
import net.mcreator.enlightened_end.procedures.Dash3Procedure;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.RenderGuiEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DashChargeOverlay.class)
public class DashChargeOverlayMixin {
    @Inject(method = "eventHandler(Lnet/minecraftforge/client/event/RenderGuiEvent$Pre;)V",
            at = @At("HEAD"),
            cancellable = true,
            remap = false)
    private static void ve$dontTouchRenderIfDoNoWork(RenderGuiEvent.Pre event, CallbackInfo ci){
        Player player = Minecraft.getInstance().player;
        if (!(Dash0Procedure.execute(player) || Dash1Procedure.execute(player) || Dash2Procedure.execute(player) || Dash3Procedure.execute(player))){
        ci.cancel();
        }
    }
}
