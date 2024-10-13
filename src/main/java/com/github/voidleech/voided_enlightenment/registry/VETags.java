package com.github.voidleech.voided_enlightenment.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.ForgeRegistries;

public class VETags {
    public static final TagKey<Fluid> OOZE = ForgeRegistries.FLUIDS.tags().createTagKey(new ResourceLocation("enlightened_end:ooze"));
}
