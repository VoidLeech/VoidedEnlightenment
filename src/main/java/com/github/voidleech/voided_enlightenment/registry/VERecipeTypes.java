package com.github.voidleech.voided_enlightenment.registry;

import com.github.voidleech.voided_enlightenment.VoidedEnlightenment;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class VERecipeTypes {
    static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, VoidedEnlightenment.MOD_ID);

    public static void register(IEventBus modEventBus){
        RECIPE_TYPES.register(modEventBus);
    }
}
