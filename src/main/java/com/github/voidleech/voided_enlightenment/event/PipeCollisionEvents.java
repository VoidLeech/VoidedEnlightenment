package com.github.voidleech.voided_enlightenment.event;

import com.github.voidleech.voided_enlightenment.registry.VETags;
import com.simibubi.create.api.event.PipeCollisionEvent;
import net.mcreator.enlightened_end.init.EnlightenedEndModBlocks;
import net.mcreator.enlightened_end.init.EnlightenedEndModFluids;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.eventbus.api.IEventBus;

public class PipeCollisionEvents {
    private static void flowCollision(PipeCollisionEvent.Flow event) {
        Fluid f1 = event.getFirstFluid();
        Fluid f2 = event.getSecondFluid();
        if (f1 == Fluids.WATER && f2 == EnlightenedEndModFluids.OOZE_FLUID.get() || f2 == Fluids.WATER && f1 == EnlightenedEndModFluids.OOZE_FLUID.get()){
            event.setState(EnlightenedEndModBlocks.PALEROCK.get().defaultBlockState());
        }
        if (f1 == Fluids.LAVA && f2 == EnlightenedEndModFluids.OOZE_FLUID.get() || f2 == Fluids.LAVA && f1 == EnlightenedEndModFluids.OOZE_FLUID.get()){
            event.setState(EnlightenedEndModBlocks.VOID_SHALE.get().defaultBlockState());
        }
    }

    private static void spillCollision(PipeCollisionEvent.Spill event) {
        Fluid f1 = event.getPipeFluid();
        Fluid f2 = event.getWorldFluid();
        if (f1 == Fluids.WATER && f2.is(VETags.OOZE) || f2.is(FluidTags.WATER) && f1 == EnlightenedEndModFluids.OOZE_FLUID.get()){
            event.setState(EnlightenedEndModBlocks.PALEROCK.get().defaultBlockState());
        }
        if (f1 == Fluids.LAVA && f2.is(VETags.OOZE) || f2.is(FluidTags.LAVA) && f1 == EnlightenedEndModFluids.OOZE_FLUID.get()){
            event.setState(EnlightenedEndModBlocks.VOID_SHALE.get().defaultBlockState());
        }
    }

    public static void register(IEventBus forgeBus) {
        forgeBus.addListener(PipeCollisionEvents::flowCollision);
        forgeBus.addListener(PipeCollisionEvents::spillCollision);
    }
}
