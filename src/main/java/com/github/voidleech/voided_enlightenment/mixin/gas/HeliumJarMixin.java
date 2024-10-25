package com.github.voidleech.voided_enlightenment.mixin.gas;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.mcreator.enlightened_end.init.EnlightenedEndModItems;
import net.mcreator.enlightened_end.item.HeliumBucketItem;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(HeliumBucketItem.class)
public abstract class HeliumJarMixin extends Item {
    public HeliumJarMixin(Properties pProperties) {
        super(pProperties);
    }

    @ModifyExpressionValue(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/Item$Properties;stacksTo(I)Lnet/minecraft/world/item/Item$Properties;"))
    private static Properties voided_enlightenment$setCraftingRemainder(Properties original){
        return original.craftRemainder(EnlightenedEndModItems.GAS_JAR.get());
    }
}
