package com.github.voidleech.voided_enlightenment.mixin.misc.item;

import net.mcreator.enlightened_end.init.EnlightenedEndModItems;
import net.mcreator.enlightened_end.item.HeliumBucketItem;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HeliumBucketItem.class)
public class HeliumJarMixin extends Item {
    public HeliumJarMixin(Properties pProperties) {
        super(pProperties);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void voided_enlightenment$setCraftingRemainder(CallbackInfo ci){
        this.craftingRemainingItem = EnlightenedEndModItems.GAS_JAR.get();
    }
}
