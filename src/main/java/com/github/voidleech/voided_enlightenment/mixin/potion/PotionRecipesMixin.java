package com.github.voidleech.voided_enlightenment.mixin.potion;

import net.mcreator.enlightened_end.recipes.brewing.BrewBurdenedPotionBrewingRecipe;
import net.mcreator.enlightened_end.recipes.brewing.BrewFrigidPotionBrewingRecipe;
import net.mcreator.enlightened_end.recipes.brewing.BrewRootedPotionBrewingRecipe;
import net.mcreator.enlightened_end.recipes.brewing.BrewSuffocationPotionBrewingRecipe;
import net.mcreator.enlightened_end.recipes.brewing.BrewVitalityPotionBrewingRecipe;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = {BrewBurdenedPotionBrewingRecipe.class, BrewFrigidPotionBrewingRecipe.class,
        BrewRootedPotionBrewingRecipe.class, BrewSuffocationPotionBrewingRecipe.class, BrewVitalityPotionBrewingRecipe.class})
public abstract class PotionRecipesMixin {
    @Inject(method = "init", at = @At("HEAD"), cancellable = true, remap = false)
    private static void voided_enlightenment$recipeViewableBurdenedRecipe(FMLCommonSetupEvent event, CallbackInfo ci){
        ci.cancel();
    }
}
