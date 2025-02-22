package com.github.voidleech.voided_enlightenment.mixin.laser;

import com.github.voidleech.oblivion.extensions.property.IBlockPropertyUndoer;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.mcreator.enlightened_end.block.LaserEmissionBlock;
import net.mcreator.enlightened_end.init.EnlightenedEndModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LaserEmissionBlock.class)
public abstract class LaserEmissionMixin extends Block {
    @Shadow
    @Final
    public static DirectionProperty FACING;

    public LaserEmissionMixin(Properties pProperties) {
        super(pProperties);
    }

    @ModifyExpressionValue(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;noCollission()Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"))
    private static Properties voided_enlightenment$enableCollision(Properties original){
        return ((IBlockPropertyUndoer)original).oblivion$collision();
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        if (pContext instanceof EntityCollisionContext ctx) {
            if (ctx.getEntity() instanceof LivingEntity entity) {
                if (entity.getItemBySlot(EquipmentSlot.FEET).getItem() == EnlightenedEndModItems.BOOST_BOOTS_BOOTS.get() && !pContext.isDescending()) {
                    VoxelShape shape = switch (pState.getValue(FACING)) {
                        case DOWN, UP -> box(6, 0, 6, 10, 16, 10);
                        case WEST, EAST -> box(0, 6, 6, 16, 10, 10);
                        case NORTH, SOUTH -> box(6, 6, 0, 10, 10, 16);
                    };
                    if (pContext.isAbove(shape, pPos, false)) {
                        return shape;
                    }
                }
            }
        }
        return Shapes.empty();
    }
}
