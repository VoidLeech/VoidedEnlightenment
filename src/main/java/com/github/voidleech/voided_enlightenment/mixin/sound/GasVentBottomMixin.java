package com.github.voidleech.voided_enlightenment.mixin.sound;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.mcreator.enlightened_end.block.GasVentBottomBlock;
import net.mcreator.enlightened_end.init.EnlightenedEndModSounds;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.common.util.ForgeSoundType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(GasVentBottomBlock.class)
public abstract class GasVentBottomMixin extends Block {
    public GasVentBottomMixin(Properties pProperties) {
        super(pProperties);
    }

    @ModifyExpressionValue(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;sound(Lnet/minecraft/world/level/block/SoundType;)Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"))
    private static BlockBehaviour.Properties voided_enlightenment$footstepIsJustStep(Properties original){
        SoundType soundtype = new ForgeSoundType(1.0f, 1.0f,
                EnlightenedEndModSounds.LIGHT_VOID_SHALE_BREAK,
                EnlightenedEndModSounds.VOID_SHALE_STEP,
                EnlightenedEndModSounds.LIGHT_VOID_SHALE_BREAK,
                EnlightenedEndModSounds.LIGHT_VOID_SHALE_BREAK,
                EnlightenedEndModSounds.VOID_SHALE_STEP
        );
        return original.sound(soundtype);
    }
}
