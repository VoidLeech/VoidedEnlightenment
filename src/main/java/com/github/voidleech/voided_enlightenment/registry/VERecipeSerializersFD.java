package com.github.voidleech.voided_enlightenment.registry;

import com.github.voidleech.voided_enlightenment.recipe.KnifeUpgradeRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.minecraftforge.registries.RegistryObject;

public class VERecipeSerializersFD {
    public static final RegistryObject<RecipeSerializer<KnifeUpgradeRecipe>> KNIFE_UPGRADE = VERecipeSerializers.RECIPE_SERIALIZERS
                    .register("knife_upgrade", () -> new SimpleCraftingRecipeSerializer<>(KnifeUpgradeRecipe::new));

    public static void register() {
    }
}
