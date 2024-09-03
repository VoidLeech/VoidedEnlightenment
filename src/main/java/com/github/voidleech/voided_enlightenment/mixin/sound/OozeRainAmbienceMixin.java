package com.github.voidleech.voided_enlightenment.mixin.sound;

import net.mcreator.enlightened_end.procedures.OozeRainParticlesProcedure;
import net.minecraft.sounds.SoundSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(OozeRainParticlesProcedure.class)
public class OozeRainAmbienceMixin {
    @ModifyArg(method = "execute(Lnet/minecraftforge/eventbus/api/Event;Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/Level;playSound(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V",
                    remap = true
            ),
            index = 3,
            remap = false
    )
    private static SoundSource voided_enlightenment$oozeRainIsWeatherServer(SoundSource original){
        return SoundSource.WEATHER;
    }

    @ModifyArg(method = "execute(Lnet/minecraftforge/eventbus/api/Event;Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/Level;playLocalSound(DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FFZ)V",
                    remap = true
            ),
            index = 4,
            remap = false
    )
    private static SoundSource voided_enlightenment$lowerVolumeLocal(SoundSource original){
        return SoundSource.WEATHER;
    }

    @ModifyArg(method = "execute(Lnet/minecraftforge/eventbus/api/Event;Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/Level;playSound(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V",
                    remap = true
            ),
            index = 4,
            remap = false
    )
    private static float voided_enlightenment$lowerVolumeServer(float volume){
        // This goes seemingly complete silent at 1.0 (idk why), 100.0 is obvs bonkers because it doesn't scale
        // This seems to work well *shrug*
        return 2.0f;
    }

    @ModifyArg(method = "execute(Lnet/minecraftforge/eventbus/api/Event;Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/Level;playLocalSound(DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FFZ)V",
                    remap = true
            ),
            index = 5,
            remap = false
    )
    private static float voided_enlightenment$lowerVolumeLocal(float volume){
        return 2.0f;
    }
}
