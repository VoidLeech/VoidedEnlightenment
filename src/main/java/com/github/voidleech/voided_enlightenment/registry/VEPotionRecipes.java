package com.github.voidleech.voided_enlightenment.registry;

import net.mcreator.enlightened_end.init.EnlightenedEndModItems;
import net.mcreator.enlightened_end.init.EnlightenedEndModPotions;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class VEPotionRecipes {
    private static void addMissingBrewingRecipes(FMLCommonSetupEvent event){
        event.enqueueWork(() -> {
            // Eating these items already gives these effects so this only makes sense.
            PotionBrewing.addMix(Potions.AWKWARD, EnlightenedEndModItems.AZURE_BERRIES.get(), EnlightenedEndModPotions.LEVITATION_POTION.get());
            PotionBrewing.addMix(Potions.AWKWARD, EnlightenedEndModItems.SQUISHED_BOUNCER.get(), EnlightenedEndModPotions.BOUNCY_POTION.get());
        });
    }

    public static void register(IEventBus eventBus){
        eventBus.addListener(VEPotionRecipes::addMissingBrewingRecipes);
    }
}
