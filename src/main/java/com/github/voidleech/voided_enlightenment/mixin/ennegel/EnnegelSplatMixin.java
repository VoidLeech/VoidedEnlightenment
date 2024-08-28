package com.github.voidleech.voided_enlightenment.mixin.ennegel;

import net.mcreator.enlightened_end.block.EnnegelSplatBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(EnnegelSplatBlock.class)
public class EnnegelSplatMixin extends Block {
    @Shadow @Final public static EnumProperty<AttachFace> FACE;

    @Shadow @Final public static DirectionProperty FACING;

    public EnnegelSplatMixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return switch (pState.getValue(FACE)){
            case CEILING -> Block.isFaceFull(pLevel.getBlockState(pPos.above()).getShape(pLevel, pPos.above()), Direction.DOWN);
            case FLOOR -> Block.isFaceFull(pLevel.getBlockState(pPos.below()).getShape(pLevel, pPos.below()), Direction.UP);
            case WALL -> switch (pState.getValue(FACING)){
                case DOWN, UP -> false;
                case NORTH -> Block.isFaceFull(pLevel.getBlockState(pPos.south()).getShape(pLevel, pPos.below()), Direction.NORTH);
                case SOUTH -> Block.isFaceFull(pLevel.getBlockState(pPos.north()).getShape(pLevel, pPos.below()), Direction.SOUTH);
                case WEST -> Block.isFaceFull(pLevel.getBlockState(pPos.east()).getShape(pLevel, pPos.below()), Direction.WEST);
                case EAST -> Block.isFaceFull(pLevel.getBlockState(pPos.west()).getShape(pLevel, pPos.below()), Direction.EAST);
            };
        };
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
        return !pState.canSurvive(pLevel, pPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
    }
}
