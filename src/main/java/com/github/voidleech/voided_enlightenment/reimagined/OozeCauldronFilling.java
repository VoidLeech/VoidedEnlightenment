package com.github.voidleech.voided_enlightenment.reimagined;

import net.mcreator.enlightened_end.init.EnlightenedEndModBlocks;
import net.mcreator.enlightened_end.procedures.IsOozeRainProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class OozeCauldronFilling {
    public static boolean canFill(Level level, BlockPos pos, RandomSource random){
        if (level.dimension() != Level.END || !IsOozeRainProcedure.execute(level) || !isOozeFillableBlock(level.getBlockState(pos)) || random.nextFloat() < 0.95){
            return false;
        }
        // level.canSeeSky(pos) doesn't work as the end doesn't have sky light
        while (pos.above().getY() < level.getMaxBuildHeight()){
            pos = pos.above();
            if (level.getBlockState(pos).getBlock() != Blocks.AIR){
                return false;
            }
        }
        return true;
    }

    public static boolean isOozeFillableBlock(BlockState state){
        Block block = state.getBlock();
        return block == Blocks.CAULDRON || block == EnlightenedEndModBlocks.OOZE_CAULDRON_1.get() || block == EnlightenedEndModBlocks.OOZE_CAULDRON_2.get();
    }
}
