package com.github.voidleech.voided_enlightenment.mixin.ooze;

import net.mcreator.enlightened_end.network.EnlightenedEndModVariables;
import net.mcreator.enlightened_end.procedures.OozeRainChanceProcedure;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.eventbus.api.Event;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(OozeRainChanceProcedure.class)
public class OozeRainChanceProcedureMixin {
    @Inject(method = "execute(Lnet/minecraftforge/eventbus/api/Event;Lnet/minecraft/world/level/LevelAccessor;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/mcreator/enlightened_end/network/EnlightenedEndModVariables$WorldVariables;syncData(Lnet/minecraft/world/level/LevelAccessor;)V",
                    shift = At.Shift.AFTER,
                    ordinal = 0
            ),
            remap = false)
    private static void voided_enlightenment$resetTimeTillEnd(Event event, LevelAccessor world, CallbackInfo ci){
        // This variable only got reset via the /endweather clear command
        // Which meant that after the first (couple, if even) ooze rains, new ooze rains would instantly end.
        EnlightenedEndModVariables.MapVariables.get(world).endraintimetillend = 0;
        EnlightenedEndModVariables.MapVariables.get(world).syncData(world);
    }
}
