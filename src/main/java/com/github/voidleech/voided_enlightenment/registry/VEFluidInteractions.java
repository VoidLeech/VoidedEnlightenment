package com.github.voidleech.voided_enlightenment.registry;

import net.mcreator.enlightened_end.init.EnlightenedEndModBlocks;
import net.mcreator.enlightened_end.init.EnlightenedEndModFluidTypes;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.fluids.FluidInteractionRegistry;

public class VEFluidInteractions {

    public static void register(){
        FluidInteractionRegistry.addInteraction(EnlightenedEndModFluidTypes.OOZE_FLUID_TYPE.get(),
                new FluidInteractionRegistry.InteractionInformation(ForgeMod.WATER_TYPE.get(), fluidState ->
                        EnlightenedEndModBlocks.PALEROCK.get().defaultBlockState()));
        FluidInteractionRegistry.addInteraction(EnlightenedEndModFluidTypes.OOZE_FLUID_TYPE.get(),
                new FluidInteractionRegistry.InteractionInformation(ForgeMod.LAVA_TYPE.get(),
                        fluidState -> EnlightenedEndModBlocks.VOID_SHALE.get().defaultBlockState()));
    }
}
