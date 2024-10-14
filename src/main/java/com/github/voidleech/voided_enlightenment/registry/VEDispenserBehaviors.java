package com.github.voidleech.voided_enlightenment.registry;

import net.mcreator.enlightened_end.init.EnlightenedEndModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.world.item.DispensibleContainerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;

public class VEDispenserBehaviors {
    public static void register(){
        DispenserBlock.registerBehavior(EnlightenedEndModItems.OOZE_FLUID_BUCKET.get(), new DefaultDispenseItemBehavior(){
            private final DefaultDispenseItemBehavior defaultDispenseItemBehavior = new DefaultDispenseItemBehavior();

            @Override
            protected ItemStack execute(BlockSource pSource, ItemStack pStack) {
                DispensibleContainerItem dispensibleContainerItem = (DispensibleContainerItem) pStack.getItem();
                BlockPos pos = pSource.getPos().relative(pSource.getBlockState().getValue(DispenserBlock.FACING));
                Level level = pSource.getLevel();
                if (dispensibleContainerItem.emptyContents(null, level, pos, null, pStack)){
                    return new ItemStack(Items.BUCKET);
                }
                return defaultDispenseItemBehavior.dispense(pSource, pStack);
            }
        });
    }
}
