package com.github.voidleech.voided_enlightenment.mixin.ooze;

import net.mcreator.enlightened_end.block.OozeFluidBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(OozeFluidBlock.class)
public class OozeFluidBlockMixin extends LiquidBlock {
    public OozeFluidBlockMixin(FlowingFluid pFluid, Properties pProperties) {
        super(pFluid, pProperties);
    }

    @Inject(method = "onPlace",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/LiquidBlock;onPlace(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;Z)V",
                    shift = At.Shift.AFTER),
            cancellable = true
    )
    private void voided_enlightenment$noCustomNeighbourChangedOnPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving, CallbackInfo ci){
        ci.cancel();
    }

    @Inject(method = "neighborChanged",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/LiquidBlock;neighborChanged(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/Block;Lnet/minecraft/core/BlockPos;Z)V",
                    shift = At.Shift.AFTER),
            cancellable = true
    )
    private void voided_enlightenment$noCustomNeighbourChangedOnNeighbourChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving, CallbackInfo ci){
        ci.cancel();
    }
}
