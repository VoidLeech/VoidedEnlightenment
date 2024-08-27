package com.github.voidleech.voided_enlightenment.mixin.render;

import net.mcreator.enlightened_end.client.screens.RadiationBarOverlay;
import net.mcreator.enlightened_end.procedures.Radiation0Procedure;
import net.mcreator.enlightened_end.procedures.Radiation1Procedure;
import net.mcreator.enlightened_end.procedures.Radiation2Procedure;
import net.mcreator.enlightened_end.procedures.Radiation3Procedure;
import net.mcreator.enlightened_end.procedures.Radiation4Procedure;
import net.mcreator.enlightened_end.procedures.Radiation5Procedure;
import net.mcreator.enlightened_end.procedures.Radiation6Procedure;
import net.mcreator.enlightened_end.procedures.Radiation7Procedure;
import net.mcreator.enlightened_end.procedures.Radiation8Procedure;
import net.mcreator.enlightened_end.procedures.Radiation9Procedure;
import net.mcreator.enlightened_end.procedures.Radiation10Procedure;
import net.mcreator.enlightened_end.procedures.Radiation11Procedure;
import net.mcreator.enlightened_end.procedures.Radiation12Procedure;
import net.mcreator.enlightened_end.procedures.Radiation13Procedure;
import net.mcreator.enlightened_end.procedures.Radiation14Procedure;
import net.mcreator.enlightened_end.procedures.Radiation15Procedure;
import net.mcreator.enlightened_end.procedures.Radiation16Procedure;
import net.mcreator.enlightened_end.procedures.Radiation17Procedure;
import net.mcreator.enlightened_end.procedures.Radiation18Procedure;
import net.mcreator.enlightened_end.procedures.Radiation19Procedure;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.RenderGuiEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RadiationBarOverlay.class)
public class RadiationBarOverlayMixin {
    @Inject(method = "eventHandler", at = @At("HEAD"), cancellable = true, remap = false)
    private static void voided_enlightenment$dontTouchRenderIfDoNoWork(RenderGuiEvent.Pre event, CallbackInfo ci){
        Player player = Minecraft.getInstance().player;
        if (!(Radiation0Procedure.execute(player)  || Radiation1Procedure.execute(player)  || Radiation2Procedure.execute(player)
           || Radiation3Procedure.execute(player)  || Radiation4Procedure.execute(player)  || Radiation5Procedure.execute(player)
           || Radiation6Procedure.execute(player)  || Radiation7Procedure.execute(player)  || Radiation8Procedure.execute(player)
           || Radiation9Procedure.execute(player)  || Radiation10Procedure.execute(player) || Radiation11Procedure.execute(player)
           || Radiation12Procedure.execute(player) || Radiation13Procedure.execute(player) || Radiation14Procedure.execute(player)
           || Radiation15Procedure.execute(player) || Radiation16Procedure.execute(player) || Radiation17Procedure.execute(player)
           || Radiation18Procedure.execute(player) || Radiation19Procedure.execute(player))){
        ci.cancel();
        }
    }
}
