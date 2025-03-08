package com.github.voidleech.voided_enlightenment.mixin.accessor;

import net.minecraft.core.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(DefaultDispenseItemBehavior.class)
public interface DefaultDispenseItemBehaviorInvoker {
    @Invoker("execute")
    ItemStack voided_enlightenment$execute(BlockSource source, ItemStack stack);
}
