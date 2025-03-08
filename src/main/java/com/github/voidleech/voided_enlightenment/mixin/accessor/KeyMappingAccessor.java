package com.github.voidleech.voided_enlightenment.mixin.accessor;

import net.minecraft.client.KeyMapping;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

@Mixin(KeyMapping.class)
public interface KeyMappingAccessor {
    @Mutable
    @Accessor("category")
    void voided_enlightenment$setCategory(String category);

    @Accessor("CATEGORIES")
    static Set<String> voided_enlightenment$getCATEGORIES() {
        throw new AssertionError();
    }
}
