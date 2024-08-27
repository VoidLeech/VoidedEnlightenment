package com.github.voidleech.voided_enlightenment.mixin.potion;

import net.mcreator.enlightened_end.init.EnlightenedEndModItems;
import net.mcreator.enlightened_end.init.EnlightenedEndModPotions;
import net.mcreator.enlightened_end.recipes.brewing.BrewSuffocationPotionBrewingRecipe;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BrewSuffocationPotionBrewingRecipe.class)
public class SuffocationRecipeMixin {
    @Inject(method = "init", at = @At("HEAD"), cancellable = true, remap = false)
    private static void voided_enlightenment$recipeViewableBurdenedRecipe(FMLCommonSetupEvent event, CallbackInfo ci){
        event.enqueueWork(() -> PotionBrewing.addMix(Potions.AWKWARD, EnlightenedEndModItems.SPLATTER_GLAND.get(), EnlightenedEndModPotions.SUFFOCATION_POTION.get()));
        ci.cancel();
    }
}
