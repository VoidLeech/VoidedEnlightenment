package com.github.voidleech.voided_enlightenment.registry;

import com.github.voidleech.voided_enlightenment.VoidedEnlightenment;
import com.github.voidleech.voided_enlightenment.mixin.accessor.DefaultDispenseItemBehaviorInvoker;
import com.github.voidleech.voided_enlightenment.mixin.accessor.DispenserBlockInvoker;
import net.mcreator.enlightened_end.init.EnlightenedEndModBlocks;
import net.mcreator.enlightened_end.init.EnlightenedEndModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.DispensibleContainerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.entity.DispenserBlockEntity;

public class VEDispenserBehaviors {
    static final DefaultDispenseItemBehavior DEFAULT = new DefaultDispenseItemBehavior();
    public static void register(){
        DispenserBlock.registerBehavior(EnlightenedEndModItems.OOZE_FLUID_BUCKET.get(), new DefaultDispenseItemBehavior(){

            @Override
            protected ItemStack execute(BlockSource pSource, ItemStack pStack) {
                DispensibleContainerItem dispensibleContainerItem = (DispensibleContainerItem) pStack.getItem();
                BlockPos pos = pSource.getPos().relative(pSource.getBlockState().getValue(DispenserBlock.FACING));
                Level level = pSource.getLevel();
                if (dispensibleContainerItem.emptyContents(null, level, pos, null, pStack)){
                    return new ItemStack(Items.BUCKET);
                }
                return DEFAULT.dispense(pSource, pStack);
            }
        });
        DispenserBlock.registerBehavior(EnlightenedEndModItems.OOZE_BOTTLE.get(), new DefaultDispenseItemBehavior(){
            @Override
            protected ItemStack execute(BlockSource pSource, ItemStack pStack) {
                BlockPos pos = pSource.getPos().relative(pSource.getBlockState().getValue(DispenserBlock.FACING));
                Level level = pSource.getLevel();
                if (level.getBlockState(pos).getBlock() == Blocks.MUD){
                    level.setBlockAndUpdate(pos, EnlightenedEndModBlocks.CHORLOAM.get().defaultBlockState());
                    level.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0f, 1.0f);
                    return new ItemStack(Items.GLASS_BOTTLE);
                }
                return DEFAULT.dispense(pSource, pStack);
            }
        });
        DispenseItemBehavior bottleOriginal = ((DispenserBlockInvoker)Blocks.DISPENSER).callGetDispenseMethod(new ItemStack(Items.GLASS_BOTTLE));
        if (bottleOriginal instanceof DefaultDispenseItemBehavior bottleOriginalDef) {
            DispenserBlock.registerBehavior(Items.GLASS_BOTTLE, new OptionalDispenseItemBehavior() {
                @Override
                protected ItemStack execute(BlockSource pSource, ItemStack pStack) {
                    setSuccess(false);
                    BlockPos pos = pSource.getPos().relative(pSource.getBlockState().getValue(DispenserBlock.FACING));
                    Level level = pSource.getLevel();
                    if (level.getFluidState(pos).is(VETags.OOZE)){
                        pStack.shrink(1);
                        setSuccess(true);
                        ItemStack oozeBottle = new ItemStack(EnlightenedEndModItems.OOZE_BOTTLE.get());
                        if (pStack.isEmpty()){
                            return oozeBottle;
                        }
                        if (((DispenserBlockEntity)pSource.getEntity()).addItem(oozeBottle) < 0){
                            DEFAULT.dispense(pSource, oozeBottle);
                        }
                        return pStack;
                    }
                    return ((DefaultDispenseItemBehaviorInvoker)bottleOriginalDef).callExecute(pSource, pStack);
                }
            });
        }
        else {
            VoidedEnlightenment.LOGGER.error("Some mod has replaced the dispenser behavior for glass bottles in an incompatible way. Voided Enlightenment will not wrap its own.");
        }
    }
}
