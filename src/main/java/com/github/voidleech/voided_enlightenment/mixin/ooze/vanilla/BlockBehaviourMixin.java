package com.github.voidleech.voided_enlightenment.mixin.ooze.vanilla;

import com.github.voidleech.voided_enlightenment.reimagined.OozeCauldronFilling;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.mcreator.enlightened_end.init.EnlightenedEndModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BlockBehaviour.class)
public class BlockBehaviourMixin {
    @WrapMethod(method = "randomTick")
    private void voided_enlightenment$cauldronRandomTickWithoutCallingTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom, Operation<Void> original){
        if (pState.getBlock() == Blocks.CAULDRON){
            if (OozeCauldronFilling.canFill(pLevel, pPos, pRandom)){
                pLevel.setBlockAndUpdate(pPos, EnlightenedEndModBlocks.OOZE_CAULDRON_1.get().defaultBlockState());
            }
            return; // Don't call tick(...) as that would advance dripstone dripping
        }
        original.call(pState, pLevel, pPos, pRandom);
    }
}
