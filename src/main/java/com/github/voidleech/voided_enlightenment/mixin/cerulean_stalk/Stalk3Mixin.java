package com.github.voidleech.voided_enlightenment.mixin.cerulean_stalk;

import com.github.voidleech.voided_enlightenment.reimagined.CeruleanStalkGrowing;
import net.mcreator.enlightened_end.block.AncientStalk3Block;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(AncientStalk3Block.class)
public class Stalk3Mixin extends Block implements BonemealableBlock {
    public Stalk3Mixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        int upperLimit = pLevel.dimension() == Level.END ? 19 : 39;
        if (pRandom.nextInt(0, upperLimit) == 0){
            CeruleanStalkGrowing.growStalk(pLevel, pPos, pState, false);
        }
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState, boolean b) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        CeruleanStalkGrowing.performBoneMeal(serverLevel, blockPos, blockState);
    }
}
