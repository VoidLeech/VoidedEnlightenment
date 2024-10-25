package com.github.voidleech.voided_enlightenment.mixin.cerulean_stalk;

import com.github.voidleech.voided_enlightenment.reimagined.CeruleanStalkGrowing;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.mcreator.enlightened_end.block.CeruleanStalk0Block;
import net.mcreator.enlightened_end.init.EnlightenedEndModBlocks;
import net.mcreator.enlightened_end.init.EnlightenedEndModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.List;

@Mixin(CeruleanStalk0Block.class)
public abstract class Stalk0Mixin extends Block implements BonemealableBlock {

    public Stalk0Mixin(Properties pProperties) {
        super(pProperties);
    }

    @ModifyExpressionValue(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;instabreak()Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"))
    private static Properties voided_enlightenment$hasStrength(Properties original){
        return original.strength(1.0f);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return box(4, 6, 4, 12, 16, 12);
    }

    @Override
    public List<ItemStack> getDrops(BlockState pState, LootParams.Builder pParams) {
        return List.of(new ItemStack(EnlightenedEndModItems.CERULEAN_STALK.get()));
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
        return !pState.canSurvive(pLevel, pPos)
                ? Blocks.AIR.defaultBlockState()
                : (CeruleanStalkGrowing.isStalk(pLevel.getBlockState(pPos.below()).getBlock())
                    ? EnlightenedEndModBlocks.CERULEAN_STALK_1.get().defaultBlockState()
                    : super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos));
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        CeruleanStalkGrowing.growthTick(pLevel, pPos, pState, pRandom);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState, boolean b) {
        return levelReader.isEmptyBlock(blockPos.below());
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
