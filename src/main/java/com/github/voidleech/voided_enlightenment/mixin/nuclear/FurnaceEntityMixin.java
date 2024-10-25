package com.github.voidleech.voided_enlightenment.mixin.nuclear;

import net.mcreator.enlightened_end.block.entity.NuclearFurnaceBlockEntity;
import net.mcreator.enlightened_end.init.EnlightenedEndModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(NuclearFurnaceBlockEntity.class)
public abstract class FurnaceEntityMixin extends RandomizableContainerBlockEntity implements WorldlyContainer {

    @Final
    @Mutable
    @Shadow
    private LazyOptional<? extends IItemHandler>[] handlers;
    protected FurnaceEntityMixin(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    @Override
    public boolean canPlaceItem(int pIndex, ItemStack pStack) {
        return pIndex == 0 && pStack.getItem() == EnlightenedEndModItems.IRRADIUM_BAR.get() || (pIndex > 0 && pIndex < 4);
    }

    @Override
    public boolean canPlaceItemThroughFace(int i, ItemStack itemStack, @Nullable Direction direction) {
        return switch (direction) {
            case DOWN, SOUTH -> false;
            case UP -> i == 0 && itemStack.getItem() == EnlightenedEndModItems.IRRADIUM_BAR.get();
            case NORTH -> i == 2;
            case WEST -> i == 1;
            case EAST -> i == 3;
        };
    }

    @Override
    public boolean canTakeItemThroughFace(int i, ItemStack itemStack, Direction direction) {
        return switch (direction){
            case DOWN -> i > 3;
            case UP -> i == 0;
            case NORTH -> i == 2;
            case SOUTH -> false;
            case WEST -> i == 1;
            case EAST -> i == 3;
        };
    }
}
