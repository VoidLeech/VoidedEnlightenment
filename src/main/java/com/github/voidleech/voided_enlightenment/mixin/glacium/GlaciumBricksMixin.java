package com.github.voidleech.voided_enlightenment.mixin.glacium;

import com.github.voidleech.voided_enlightenment.reimagined.GlaciumFrost;
import net.mcreator.enlightened_end.block.GlaciumBricksBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GlaciumBricksBlock.class)
public class GlaciumBricksMixin extends Block {
    public GlaciumBricksMixin(Properties pProperties) {
        super(pProperties);
    }

    @Inject(method = "onPlace",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/world/level/Level;scheduleTick(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/Block;I)V",
                    shift = At.Shift.BEFORE),
            cancellable = true)
    private void voided_enlightenment$noTickOnPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving, CallbackInfo ci){
        ci.cancel();
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        super.stepOn(pLevel, pPos, pState, pEntity);
        GlaciumFrost.applyGlaciumFrost(pEntity, 2);
    }
}
