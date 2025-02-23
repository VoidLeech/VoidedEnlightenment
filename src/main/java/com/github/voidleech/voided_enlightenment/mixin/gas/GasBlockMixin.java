package com.github.voidleech.voided_enlightenment.mixin.gas;

import com.github.voidleech.oblivion.extensions.property.IBlockPropertyUndoer;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.mcreator.enlightened_end.block.HeliumGasBlock;
import net.mcreator.enlightened_end.block.XenonGasBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = {HeliumGasBlock.class, XenonGasBlock.class})
public abstract class GasBlockMixin extends Block {
    public GasBlockMixin(Properties pProperties) {
        super(pProperties);
    }

    @ModifyExpressionValue(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;noCollission()Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"))
    private static Properties voided_enlightenment$enableCollision(Properties original){
        return ((IBlockPropertyUndoer)original).oblivion$collision().noOcclusion();
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        if (pContext instanceof EntityCollisionContext ctx){
            if (ctx.getEntity() instanceof LivingEntity entity){
                int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.FROST_WALKER, entity);
                if (i > 0 && pContext.isAbove(Shapes.block(), pPos, false) && !pContext.isDescending()){
                    return Shapes.block();
                }
            }
        }
        return Shapes.empty();
    }
}
