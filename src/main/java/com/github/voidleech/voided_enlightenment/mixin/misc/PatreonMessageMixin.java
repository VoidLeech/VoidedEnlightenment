package com.github.voidleech.voided_enlightenment.mixin.misc;

import net.mcreator.enlightened_end.procedures.PlayerEnterEndProcedure;
import net.minecraftforge.event.TickEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEnterEndProcedure.class)
public class PatreonMessageMixin {
    @Inject(method = "onPlayerTick", at = @At("HEAD"), remap = false, cancellable = true)
    private static void ve$noAdvertising(TickEvent.PlayerTickEvent event, CallbackInfo ci){
        /*
        > Why are you cancelling this?!?! Don't you want to see modders supported for their work?
        No of course I do, but I don't believe in-game is the place for advertising. Ever.
        Especially since you kinda get the message *before* you've encountered any content Enlightend adds
        (except for the changed ender chest recipe, fog *incompatibility* with other mods,
        and the tiny specks of new stuff the worldgen has blessed the center end island with)

        Since you're reading this right now, and this minus-on wouldn't be possible without the original project existing,
        consider visiting https://www.patreon.com/lixir to support Enlightend.
        */
        ci.cancel();
    }
}
