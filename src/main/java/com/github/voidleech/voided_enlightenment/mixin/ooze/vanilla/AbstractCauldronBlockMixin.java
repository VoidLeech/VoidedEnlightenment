package com.github.voidleech.voided_enlightenment.mixin.ooze.vanilla;

import com.github.voidleech.oblivion.hackyMixinUtils.propertyRebuilders.BlockPropertiesRebuilder;
import com.github.voidleech.voided_enlightenment.reimagined.OozeCauldronFilling;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.mcreator.enlightened_end.init.EnlightenedEndModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.AbstractCauldronBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractCauldronBlock.class)
public class AbstractCauldronBlockMixin extends Block {
    public AbstractCauldronBlockMixin(Properties pProperties) {
        super(pProperties);
    }

    // Cauldrons are weird. This is necessary.
    // Even though they seem to use the tick method to handle dripstone dripping
    // My extra ticking behaviour is never called without this *shrug*
    @Inject(method = "<init>", at = @At("TAIL"))
    void voided_enlightenment$enableRandomTicks(CallbackInfo ci){
        BlockPropertiesRebuilder.of(this)
                .randomTicks(true)
                .finalizeRebuild();
    }

    @WrapMethod(method = "tick")
    private void voided_enlightenment$fillWithOoze(BlockState state, ServerLevel level, BlockPos pos, RandomSource randomSource, Operation<Void> original){
        if (OozeCauldronFilling.canFill(level, pos, randomSource)){
            level.setBlockAndUpdate(pos, EnlightenedEndModBlocks.OOZE_CAULDRON_1.get().defaultBlockState());
            return; // We've replaced the block
        }
        original.call(state, level, pos, randomSource);
    }
}
