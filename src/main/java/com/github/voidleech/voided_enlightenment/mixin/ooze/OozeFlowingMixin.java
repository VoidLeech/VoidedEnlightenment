package com.github.voidleech.voided_enlightenment.mixin.ooze;

import com.github.voidleech.voided_enlightenment.registry.VETags;
import net.mcreator.enlightened_end.fluid.OozeFluidFluid;
import net.mcreator.enlightened_end.init.EnlightenedEndModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(OozeFluidFluid.class)
public abstract class OozeFlowingMixin extends ForgeFlowingFluid {
    protected OozeFlowingMixin(Properties properties) {
        super(properties);
    }

    @Override
    protected void spreadTo(LevelAccessor pLevel, BlockPos pPos, BlockState pBlockState, Direction pDirection, FluidState pFluidState) {
        if (pDirection == Direction.DOWN){
            FluidState fluidState = pLevel.getFluidState(pPos);
            if (this.is(VETags.OOZE) && fluidState.is(FluidTags.LAVA)){
                if (pBlockState.getBlock() instanceof LiquidBlock){
                    pLevel.setBlock(pPos, ForgeEventFactory.fireFluidPlaceBlockEvent(pLevel, pPos, pPos, EnlightenedEndModBlocks.VOID_SHALE.get().defaultBlockState()), 3);
                }
                return;
            }
            if (this.is(VETags.OOZE) && fluidState.is(FluidTags.WATER)){
                if (pBlockState.getBlock() instanceof LiquidBlock){
                    pLevel.setBlock(pPos, ForgeEventFactory.fireFluidPlaceBlockEvent(pLevel, pPos, pPos, EnlightenedEndModBlocks.PALEROCK.get().defaultBlockState()), 3);
                }
                return;
            }
        }
        super.spreadTo(pLevel, pPos, pBlockState, pDirection, pFluidState);
    }
}
