package com.github.voidleech.voided_enlightenment.mixin.ooze.vanilla;

import com.github.voidleech.voided_enlightenment.VoidedEnlightenmentConfig;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.mcreator.enlightened_end.init.EnlightenedEndModFluids;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.ReloadableServerResources;
import net.minecraft.world.level.material.Fluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Collection;
import java.util.Map;

@Mixin(ReloadableServerResources.class)
public class ReloadableServerResourcesMixin {

    @ModifyExpressionValue(method = "updateRegistryTags(Lnet/minecraft/core/RegistryAccess;Lnet/minecraft/tags/TagManager$LoadResult;)V",
    at = @At(value = "INVOKE", target = "Lnet/minecraft/tags/TagManager$LoadResult;tags()Ljava/util/Map;"))
    private static <T> Map<ResourceLocation, Collection<Holder<T>>> ve$oozeIsntWater(Map<ResourceLocation, Collection<Holder<T>>> original){
        if (!VoidedEnlightenmentConfig.oozeIsntWater){
            return original;
        }
        ResourceLocation water = new ResourceLocation("minecraft", "water");
        if (original.containsKey(water)){
            // Mental gymnastics needed due to runtime erasure
            Collection<Holder<T>> collection = original.get(water);
            if (collection.isEmpty()) {
                // Someone's broken the water tag, let's not crash
                return original;
            }
            Holder<T> holder = collection.stream().toList().get(0);
            T t = holder.get();
            if (t instanceof Fluid){
                // Keep everything except for ooze.
                original.put(water, original.get(water).stream().filter((h) -> h.get() != EnlightenedEndModFluids.OOZE_FLUID.get() && h.get() != EnlightenedEndModFluids.FLOWING_OOZE_FLUID.get()).toList());
            }
        }
        return original;
    }
}
