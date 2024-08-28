package com.github.voidleech.voided_enlightenment.registry;

import com.github.voidleech.oblivion.registry.OblivionPotionRecipes;
import net.mcreator.enlightened_end.init.EnlightenedEndModItems;
import net.mcreator.enlightened_end.init.EnlightenedEndModPotions;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class VEPotionRecipes {

    public static void register(){
        // Eating these items already gives these effects so this only makes sense.
        OblivionPotionRecipes.addMix(() -> Potions.AWKWARD, EnlightenedEndModItems.AZURE_BERRIES, EnlightenedEndModPotions.LEVITATION_POTION);
        OblivionPotionRecipes.addMix(() -> Potions.AWKWARD, EnlightenedEndModItems.SQUISHED_BOUNCER, EnlightenedEndModPotions.BOUNCY_POTION);
        // No recipe for resistance, but I do have something in mind for how to obtain it in the future.
    }
}
