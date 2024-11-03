package com.github.voidleech.voided_enlightenment.registry;

import net.mcreator.enlightened_end.EnlightenedEndMod;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class VEWoodTypes {
    // How to detect MCreator mod without decomp: no boats or signs
    public static final WoodType CERULEAN = WoodType.register(new WoodType(EnlightenedEndMod.MODID + ":cerulean", BlockSetType.OAK));
    public static final WoodType INDIGO = WoodType.register(new WoodType(EnlightenedEndMod.MODID + ":indigo", BlockSetType.OAK));
}
