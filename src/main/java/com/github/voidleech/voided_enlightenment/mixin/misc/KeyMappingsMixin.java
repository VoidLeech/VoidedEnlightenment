package com.github.voidleech.voided_enlightenment.mixin.misc;

import net.mcreator.enlightened_end.init.EnlightenedEndModKeyMappings;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EnlightenedEndModKeyMappings.class)
public class KeyMappingsMixin {
    @Shadow @Final public static KeyMapping DASHING_LEGGINGS_ABILITY;

    @Inject(method = "registerKeyMappings", at = @At("HEAD"), remap = false)
    private static void voided_enlightenment$youGetYourOwnCategory(RegisterKeyMappingsEvent event, CallbackInfo ci){
        DASHING_LEGGINGS_ABILITY.category = "key.categories.enlightened_end";
        KeyMapping.CATEGORIES.add("key.categories.enlightened_end");
    }
}
