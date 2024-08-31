package com.github.voidleech.voided_enlightenment.mixin.sound;

import com.github.voidleech.oblivion.hackyMixinUtils.propertyRebuilders.BlockPropertiesRebuilder;
import net.mcreator.enlightened_end.block.GasVentBottomBlock;
import net.mcreator.enlightened_end.init.EnlightenedEndModSounds;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.common.util.ForgeSoundType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GasVentBottomBlock.class)
public class GasVentBottomMixin extends Block {
    public GasVentBottomMixin(Properties pProperties) {
        super(pProperties);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void voided_enlightenment$footstepIsJustStep(CallbackInfo ci){
        SoundType soundtype = new ForgeSoundType(1.0f, 1.0f,
                EnlightenedEndModSounds.LIGHT_VOID_SHALE_BREAK,
                EnlightenedEndModSounds.VOID_SHALE_STEP,
                EnlightenedEndModSounds.LIGHT_VOID_SHALE_BREAK,
                EnlightenedEndModSounds.LIGHT_VOID_SHALE_BREAK,
                EnlightenedEndModSounds.VOID_SHALE_STEP
        );
        BlockPropertiesRebuilder.of(this)
                .soundType(soundtype)
                .finalizeRebuild();
    }
}
