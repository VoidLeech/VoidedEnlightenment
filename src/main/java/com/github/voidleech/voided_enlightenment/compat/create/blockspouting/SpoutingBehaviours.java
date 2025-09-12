package com.github.voidleech.voided_enlightenment.compat.create.blockspouting;

import com.simibubi.create.api.behaviour.spouting.BlockSpoutingBehaviour;
import com.simibubi.create.api.behaviour.spouting.CauldronSpoutingBehavior;
import com.simibubi.create.api.behaviour.spouting.StateChangingBehavior;
import net.mcreator.enlightened_end.init.EnlightenedEndModBlocks;
import net.mcreator.enlightened_end.init.EnlightenedEndModFluids;
import net.minecraft.world.level.material.Fluid;

import java.util.function.Predicate;

public class SpoutingBehaviours {
    public static void register(){
        Predicate<Fluid> isOoze = f -> f.isSame(EnlightenedEndModFluids.OOZE_FLUID.get());
        BlockSpoutingBehaviour.BY_BLOCK.register(EnlightenedEndModBlocks.OOZE_CAULDRON_1.get(),
                StateChangingBehavior.setTo(250, isOoze, EnlightenedEndModBlocks.OOZE_CAULDRON_2.get()));
        BlockSpoutingBehaviour.BY_BLOCK.register(EnlightenedEndModBlocks.OOZE_CAULDRON_2.get(),
                StateChangingBehavior.setTo(250, isOoze, EnlightenedEndModBlocks.OOZE_CAULDRON_FULL.get()));
        CauldronSpoutingBehavior.CAULDRON_INFO.register(EnlightenedEndModFluids.OOZE_FLUID.get(),
                new CauldronSpoutingBehavior.CauldronInfo(250, EnlightenedEndModBlocks.OOZE_CAULDRON_1.get()));
    }
}
