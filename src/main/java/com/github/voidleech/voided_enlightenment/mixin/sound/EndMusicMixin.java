package com.github.voidleech.voided_enlightenment.mixin.sound;

import net.mcreator.enlightened_end.procedures.EndMusicProcedure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(EndMusicProcedure.class)
public class EndMusicMixin {
    @ModifyArg(method = "execute(Lnet/minecraftforge/eventbus/api/Event;Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;playSound(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V"),
            index = 4,
            remap = false
    )
    private static float voided_enlightenment$lowerVolumeServer(float volume){
        return 1.0f;
    }

    @ModifyArg(method = "execute(Lnet/minecraftforge/eventbus/api/Event;Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;playLocalSound(DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FFZ)V"),
            index = 5,
            remap = false
    )
    private static float voided_enlightenment$lowerVolumeLocal(float volume){
        return 1.0f;
    }
}
