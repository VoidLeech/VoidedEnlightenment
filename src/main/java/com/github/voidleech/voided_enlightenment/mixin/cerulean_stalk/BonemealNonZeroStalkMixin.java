package com.github.voidleech.voided_enlightenment.mixin.cerulean_stalk;

import com.github.voidleech.voided_enlightenment.reimagined.CeruleanStalkGrowing;
import net.mcreator.enlightened_end.block.AncientStalk1Block;
import net.mcreator.enlightened_end.block.AncientStalk2Block;
import net.mcreator.enlightened_end.block.AncientStalk3Block;
import net.mcreator.enlightened_end.block.CeruleanStalk0Block;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = {AncientStalk1Block.class, AncientStalk2Block.class, AncientStalk3Block.class})
public abstract class BonemealNonZeroStalkMixin extends Block implements BonemealableBlock {
    public BonemealNonZeroStalkMixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        CeruleanStalkGrowing.growthTick(pLevel, pPos, pState, pRandom);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState, boolean b) {
        return CeruleanStalkGrowing.isValidBoneMealTarget(levelReader, blockPos);
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
