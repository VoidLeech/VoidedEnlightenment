package com.github.voidleech.voided_enlightenment.mixin.gas;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.mcreator.enlightened_end.init.EnlightenedEndModItems;
import net.mcreator.enlightened_end.item.XenonBucketItem;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(XenonBucketItem.class)
public abstract class XenonJarMixin extends Item {
    public XenonJarMixin(Properties pProperties) {
        super(pProperties);
    }

    @ModifyExpressionValue(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/Item$Properties;stacksTo(I)Lnet/minecraft/world/item/Item$Properties;"))
    private static Properties voided_enlightenment$setCraftingRemainder(Properties original){
        return original.craftRemainder(EnlightenedEndModItems.GAS_JAR.get());
    }
}
