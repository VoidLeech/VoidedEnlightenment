package com.github.voidleech.voided_enlightenment.compat.stonezone;

import net.mcreator.enlightened_end.EnlightenedEndMod;
import net.mehvahdjukaar.stone_zone.api.set.mud.MudTypeRegistry;

public class StoneZoneCompat {
    public static void init(){
        MudTypeRegistry.INSTANCE.addSimpleFinder(EnlightenedEndMod.MODID, "chorloam");
    }
}
