package com.github.voidleech.voided_enlightenment.mixin.misc;

import net.mcreator.enlightened_end.init.EnlightenedEndModItems;
import net.mcreator.enlightened_end.item.XenonBucketItem;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(XenonBucketItem.class)
public class XenonJarMixin extends Item {
    public XenonJarMixin(Properties pProperties) {
        super(pProperties);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void ve$setCraftingRemainder(CallbackInfo ci){
        this.craftingRemainingItem = EnlightenedEndModItems.GAS_JAR.get();
    }
}
