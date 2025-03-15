package com.github.voidleech.voided_enlightenment.registry;

import com.github.voidleech.oblivion.util.RecipeLikeProperties;

public class VEFuel {
    public static void init() {
        RecipeLikeProperties.addFurnaceFuel(VEItems.CERULEAN_MOSAIC.get(), 300);
        RecipeLikeProperties.addFurnaceFuel(VEItems.CERULEAN_MOSAIC_STAIRS.get(), 300);
        RecipeLikeProperties.addFurnaceFuel(VEItems.CERULEAN_MOSAIC_SLAB.get(), 150);
    }
}
