package com.github.voidleech.voided_enlightenment.mixin.misc;

import com.github.voidleech.voided_enlightenment.mixin.accessor.KeyMappingAccessor;
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
public abstract class KeyMappingsMixin {
    @Shadow @Final public static KeyMapping DASHING_LEGGINGS_ABILITY;

    @Inject(method = "registerKeyMappings", at = @At("HEAD"), remap = false)
    private static void voided_enlightenment$youGetYourOwnCategory(RegisterKeyMappingsEvent event, CallbackInfo ci){
        ((KeyMappingAccessor)DASHING_LEGGINGS_ABILITY).voided_enlightenment$setCategory("key.categories.enlightened_end");
        KeyMappingAccessor.voided_enlightenment$getCATEGORIES().add("key.categories.enlightened_end");
    }
}
