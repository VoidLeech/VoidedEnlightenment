package com.github.voidleech.voided_enlightenment.reimagined;

import net.mcreator.enlightened_end.init.EnlightenedEndModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class CeruleanStalkGrowing {
    public static boolean isValidBoneMealTarget(LevelReader levelReader, BlockPos blockPos) {
        int length = 1;
        BlockPos toCheck = blockPos.above();
        while (isStalk(levelReader.getBlockState(toCheck).getBlock())){
            toCheck = toCheck.above();
            length++;
        }
        toCheck = blockPos.below();
        while(isStalk(levelReader.getBlockState(toCheck).getBlock())){
            toCheck = toCheck.below();
            length++;
        }
        return length < 14 && levelReader.isEmptyBlock(toCheck);
    }

    public static void growthTick(Level level, BlockPos pos, BlockState state, RandomSource random){
        int upperLimit = level.dimension() == Level.END ? 19 : 39;
        if (random.nextInt(0, upperLimit) == 0){
            CeruleanStalkGrowing.growStalk(level, pos, state, false);
        }
    }

    public static boolean isStalk(Block block){
        return block == EnlightenedEndModBlocks.CERULEAN_STALK_1.get() ||
                block == EnlightenedEndModBlocks.CERULEAN_STALK_2.get() ||
                block == EnlightenedEndModBlocks.CERULEAN_STALK_3.get();
    }

    public static void performBoneMeal(ServerLevel serverLevel, BlockPos blockPos, BlockState blockState) {
        while (isStalk(serverLevel.getBlockState(blockPos.below()).getBlock())){
            blockPos = blockPos.below();
        }
        growStalk(serverLevel, blockPos, blockState, false);
    }

    public static void growStalk(Level level, BlockPos blockPos, BlockState blockState, boolean forced) {
        if (!level.isEmptyBlock(blockPos.below()) || blockPos.below().getY() < level.getMinBuildHeight()){
            return;
            // This does mean that level cerulean "saplings" never grow to the stalk form at world bottom but this is consistent with bamboo at world height
        }
        BlockState toPlace = EnlightenedEndModBlocks.CERULEAN_STALK_1.get().defaultBlockState();
        double length = 0;
        BlockPos toCheck = blockPos;
        while (isStalk(level.getBlockState(toCheck).getBlock())){
            toCheck = toCheck.above();
            length++;
        }
        if (length > 13 && !forced) {
            return;
        }
        if (length > 5){
            if (length > 10){
                toPlace = EnlightenedEndModBlocks.CERULEAN_STALK_3.get().defaultBlockState();
            }
            else {
                toPlace = EnlightenedEndModBlocks.CERULEAN_STALK_2.get().defaultBlockState();
            }
        }
        level.setBlockAndUpdate(blockPos.below(), toPlace);
    }
}
