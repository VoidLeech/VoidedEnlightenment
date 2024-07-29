package com.github.voidleech.voided_enlightenment.mixin.cerulean_stalk;

import net.mcreator.enlightened_end.block.CeruleanStalk0Block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CeruleanStalk0Block.class)
public class Stalk0Mixin extends Block {

    public Stalk0Mixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return box(4, 6, 4, 12, 16, 12);
    }
}
