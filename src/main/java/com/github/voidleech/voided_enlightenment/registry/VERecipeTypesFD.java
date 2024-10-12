package com.github.voidleech.voided_enlightenment.registry;

import com.github.voidleech.voided_enlightenment.VoidedEnlightenment;
import com.github.voidleech.voided_enlightenment.recipe.KnifeUpgradeRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.RegistryObject;

public class VERecipeTypesFD {
    public static final RegistryObject<RecipeType<KnifeUpgradeRecipe>> KNIFE_UPGRADE = VERecipeTypes.RECIPE_TYPES.register("knife_upgrade", () ->
            new RecipeType<KnifeUpgradeRecipe>() {
                @Override
                public String toString() {
                    return VoidedEnlightenment.MOD_ID + ":knife_upgrade";
                }
            });

    public static void register() {
    }
}
