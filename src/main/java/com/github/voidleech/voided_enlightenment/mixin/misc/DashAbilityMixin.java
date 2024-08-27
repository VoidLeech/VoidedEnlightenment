package com.github.voidleech.voided_enlightenment.mixin.misc;

import com.llamalad7.mixinextras.sugar.Local;
import net.mcreator.enlightened_end.procedures.DashingLeggingsAbilityOnKeyPressedProcedure;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(DashingLeggingsAbilityOnKeyPressedProcedure.class)
public class DashAbilityMixin {
    @ModifyArg(method = "execute", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;setDeltaMovement(Lnet/minecraft/world/phys/Vec3;)V"), remap = false)
    private static Vec3 voided_enlightenment$allowVerticalDash(Vec3 pDeltaMovement, @Local(argsOnly = true) Entity entity){
        Vec3 lookingAt = entity.getLookAngle();
        Vec3 currentDeltaMovement = entity.getDeltaMovement();
        return new Vec3(
                currentDeltaMovement.x() + 1.4 * lookingAt.x(),
                currentDeltaMovement.y() + 1.4 * lookingAt.y(),
                currentDeltaMovement.z() + 1.4 * lookingAt.z()
        );
    }

    @ModifyArg(method = "execute", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;playSound(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V"), remap = false)
    private static SoundSource voided_enlightenment$playerSoundIsntNeutral(SoundSource original){
        return SoundSource.PLAYERS;
    }

    @ModifyArg(method = "execute", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;playLocalSound(DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FFZ)V"), remap = false)
    private static SoundSource voided_enlightenment$playerSoundIsntNeutralLocal(SoundSource original){
        return SoundSource.PLAYERS;
    }
}
