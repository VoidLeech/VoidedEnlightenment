package com.github.voidleech.voided_enlightenment.registry;

import com.github.voidleech.oblivion.util.RecipeLikeProperties;
import net.mcreator.enlightened_end.init.EnlightenedEndModItems;
import net.mcreator.enlightened_end.init.EnlightenedEndModPotions;
import net.minecraft.world.item.alchemy.Potions;

public class VEPotionRecipes {

    public static void register(){
        // Existing recipes, just actually visible now
        RecipeLikeProperties.addMix(() -> Potions.AWKWARD, EnlightenedEndModItems.STALKER_TOOTH, EnlightenedEndModPotions.BURDENED);
        RecipeLikeProperties.addMix(() -> Potions.AWKWARD, EnlightenedEndModItems.FROST_FRUIT, EnlightenedEndModPotions.FRIGID_POTION);
        RecipeLikeProperties.addMix(() -> Potions.AWKWARD, EnlightenedEndModItems.ANCIENT_ROOT, EnlightenedEndModPotions.ROOTED_POTION);
        RecipeLikeProperties.addMix(() -> Potions.AWKWARD, EnlightenedEndModItems.SPLATTER_GLAND, EnlightenedEndModPotions.SUFFOCATION_POTION);
        RecipeLikeProperties.addMix(() -> Potions.AWKWARD, EnlightenedEndModItems.BISMUTH_INGOT, EnlightenedEndModPotions.VITALITY);
        // Eating these items already gives these effects so this only makes sense.
        RecipeLikeProperties.addMix(() -> Potions.AWKWARD, EnlightenedEndModItems.AZURE_BERRIES, EnlightenedEndModPotions.LEVITATION_POTION);
        RecipeLikeProperties.addMix(() -> Potions.AWKWARD, EnlightenedEndModItems.SQUISHED_BOUNCER, EnlightenedEndModPotions.BOUNCY_POTION);
        // No recipe for resistance, but I do have something in mind for how to obtain it in the future.
    }
}
