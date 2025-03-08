package com.github.voidleech.voided_enlightenment.mixin.compat.create.c;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.foundation.data.RuntimeDataGenerator;
import net.mcreator.enlightened_end.init.EnlightenedEndModItems;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(RuntimeDataGenerator.class)
public class RuntimeDataGeneratorMixin {
    @WrapOperation(method = "cuttingRecipes",
            at = @At(value = "INVOKE", target = "Ljava/lang/String;contains(Ljava/lang/CharSequence;)Z", ordinal = 0),
            slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=block")),
            require = 0,
            remap = false)
    private static boolean voided_enlightenment$adjustPlanksCount(String instance, CharSequence s, Operation<Boolean> original, @Local(argsOnly = true) ResourceLocation itemId){
        return original.call(instance, s) || itemId.equals(EnlightenedEndModItems.STRIPPED_CERULEAN_LOG.getId());
    }
}
