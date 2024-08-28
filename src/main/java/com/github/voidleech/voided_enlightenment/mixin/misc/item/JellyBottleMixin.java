package com.github.voidleech.voided_enlightenment.mixin.misc.item;

import net.mcreator.enlightened_end.item.BubbleJellyBottleItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BubbleJellyBottleItem.class)
public class JellyBottleMixin extends Item {
    public JellyBottleMixin(Properties pProperties) {
        super(pProperties);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void voided_enlightenment$setCraftingRemainder(CallbackInfo ci){
        this.craftingRemainingItem = Items.GLASS_BOTTLE;
    }
}
