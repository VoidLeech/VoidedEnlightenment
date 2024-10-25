package com.github.voidleech.voided_enlightenment.mixin.misc.item;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.mcreator.enlightened_end.item.BubbleJellyBottleItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BubbleJellyBottleItem.class)
public abstract class JellyBottleMixin extends Item {
    public JellyBottleMixin(Properties pProperties) {
        super(pProperties);
    }

    @ModifyExpressionValue(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/Item$Properties;stacksTo(I)Lnet/minecraft/world/item/Item$Properties;"))
    private static Properties voided_enlightenment$setCraftingRemainder(Properties original){
        return original.craftRemainder(Items.GLASS_BOTTLE);
    }
}
