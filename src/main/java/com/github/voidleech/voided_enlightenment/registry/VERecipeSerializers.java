package com.github.voidleech.voided_enlightenment.registry;

import com.github.voidleech.voided_enlightenment.VoidedEnlightenment;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class VERecipeSerializers {
    static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, VoidedEnlightenment.MOD_ID);

    public static void register(IEventBus modEventBus){
        RECIPE_SERIALIZERS.register(modEventBus);
    }
}
