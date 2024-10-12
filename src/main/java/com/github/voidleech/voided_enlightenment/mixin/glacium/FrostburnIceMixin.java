package com.github.voidleech.voided_enlightenment.mixin.glacium;

import com.github.voidleech.voided_enlightenment.reimagined.GlaciumFrost;
import net.mcreator.enlightened_end.block.FrostburnIceBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FrostburnIceBlock.class)
public class FrostburnIceMixin extends Block {
    public FrostburnIceMixin(Properties pProperties) {
        super(pProperties);
    }

    @Inject(method = "stepOn",
            at = @At(value = "INVOKE",
                    target = "Lnet/mcreator/enlightened_end/procedures/FrostburnIceEntityWalksOnTheBlockProcedure;execute(Lnet/minecraft/world/entity/Entity;)V",
                    shift = At.Shift.BEFORE,
                    remap = false),
            cancellable = true)
    private void voided_enlightenment$frostWalking(Level world, BlockPos pos, BlockState blockstate, Entity entity, CallbackInfo ci){
        GlaciumFrost.applyGlaciumFrost(entity, 1);
        ci.cancel();
    }
}
