package com.github.voidleech.voided_enlightenment.mixin.compat.create.c;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.fluids.pipes.VanillaFluidTargets;
import net.mcreator.enlightened_end.init.EnlightenedEndModBlocks;
import net.mcreator.enlightened_end.init.EnlightenedEndModFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fluids.FluidStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(VanillaFluidTargets.class)
public class VanillaFluidTargetsMixin {
    @ModifyReturnValue(method = "canProvideFluidWithoutCapability", at = @At("RETURN"), remap = false)
    private static boolean voided_enlightenment$oozeCauldronsCanProvide(boolean original, @Local(argsOnly = true) BlockState state){
        return original || (state.getBlock() == EnlightenedEndModBlocks.OOZE_CAULDRON_FULL.get());
    }

    @ModifyReturnValue(method = "drainBlock", at = @At("RETURN"), remap = false)
    private static FluidStack voided_enlightenment$drainOozeCauldron(FluidStack original, @Local(argsOnly = true) Level level, @Local(argsOnly = true) BlockPos pos, @Local(argsOnly = true) BlockState state, @Local(argsOnly = true) boolean simulate){
        if (original != FluidStack.EMPTY){
            return original;
        }
        if (state.getBlock() == EnlightenedEndModBlocks.OOZE_CAULDRON_FULL.get()){
            if (!simulate){
                level.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
            }
            return new FluidStack(EnlightenedEndModFluids.OOZE_FLUID.get(), 1000);
        }
        return FluidStack.EMPTY;
    }
}
