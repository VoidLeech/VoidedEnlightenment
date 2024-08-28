package com.github.voidleech.voided_enlightenment.mixin.gas;

import com.github.voidleech.oblivion.hackyMixinUtils.propertyRebuilders.BlockPropertiesRebuilder;
import net.mcreator.enlightened_end.block.HeliumGasBlock;
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
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HeliumGasBlock.class)
public class HeliumGasMixin extends Block {
    public HeliumGasMixin(Properties pProperties) {
        super(pProperties);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void voided_enlightenment$newProperties(CallbackInfo ci){
        BlockPropertiesRebuilder.of(this)
                .collision(true)
                .finalizeRebuild();
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
