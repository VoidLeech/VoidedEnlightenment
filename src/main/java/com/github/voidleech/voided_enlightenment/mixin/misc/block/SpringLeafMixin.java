package com.github.voidleech.voided_enlightenment.mixin.misc.block;

import net.mcreator.enlightened_end.block.SpringleafBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SpringleafBlock.class)
public class SpringLeafMixin extends Block {
    public SpringLeafMixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        // This will allow sneaking underneath
        return box(0.0, 12.0, 0.0, 16.0, 16.0, 16.0);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Shapes.or(getCollisionShape(pState, pLevel, pPos, pContext), box(3.0, 0.0, 3.0, 13.0, 16.0, 13.0));
    }
}
