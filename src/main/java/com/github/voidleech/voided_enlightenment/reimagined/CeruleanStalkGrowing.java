package com.github.voidleech.voided_enlightenment.reimagined;

import net.mcreator.enlightened_end.init.EnlightenedEndModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CeruleanStalkGrowing {
    public static void performBoneMeal(ServerLevel serverLevel, BlockPos blockPos, BlockState blockState) {
        while (serverLevel.getBlockState(blockPos.below()).getBlock() == EnlightenedEndModBlocks.CERULEAN_STALK_1.get() ||
                serverLevel.getBlockState(blockPos.below()).getBlock() == EnlightenedEndModBlocks.CERULEAN_STALK_2.get() ||
                serverLevel.getBlockState(blockPos.below()).getBlock() == EnlightenedEndModBlocks.CERULEAN_STALK_3.get()){
            blockPos = blockPos.below();
        }
        growStalk(serverLevel, blockPos, blockState, true);
    }

    public static void growStalk(Level level, BlockPos blockPos, BlockState blockState, boolean forced) {
        if (!level.isEmptyBlock(blockPos.below())){
            return;
        }
        BlockEntity be0 = level.getBlockEntity(blockPos);
        BlockState toPlace = EnlightenedEndModBlocks.CERULEAN_STALK_1.get().defaultBlockState();
        double length = 0;
        if (be0 != null){
            length = be0.getPersistentData().getDouble("length");
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
        }
        level.setBlock(blockPos.below(), toPlace, Block.UPDATE_ALL);
        BlockEntity newBE = level.getBlockEntity(blockPos.below());
        newBE.getPersistentData().putDouble("length", length + 1);
        newBE.setChanged();
    }
}
