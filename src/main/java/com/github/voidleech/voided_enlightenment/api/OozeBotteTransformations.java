package com.github.voidleech.voided_enlightenment.api;

import net.mcreator.enlightened_end.init.EnlightenedEndModBlocks;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Tuple;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class OozeBotteTransformations {

    private static final Map<Block, Tuple<Block, SoundEvent>> OOZE_BOTTLE_TRANSFORMATIONS = Collections.synchronizedMap(new HashMap<>());

    public static Tuple<Block, SoundEvent> put(Block blockToTransform, Tuple<Block, SoundEvent> intoWithSound){
        return OOZE_BOTTLE_TRANSFORMATIONS.put(blockToTransform, intoWithSound);
    }

    public static Tuple<Block, SoundEvent> get(Block block){
        return OOZE_BOTTLE_TRANSFORMATIONS.get(block);
    }

    static {
        put(Blocks.CAULDRON, new Tuple<>(EnlightenedEndModBlocks.OOZE_CAULDRON_1.get(), SoundEvents.BOTTLE_EMPTY));
        put(EnlightenedEndModBlocks.OOZE_CAULDRON_1.get(), new Tuple<>(EnlightenedEndModBlocks.OOZE_CAULDRON_2.get(), SoundEvents.BOTTLE_EMPTY));
        put(EnlightenedEndModBlocks.OOZE_CAULDRON_2.get(), new Tuple<>(EnlightenedEndModBlocks.OOZE_CAULDRON_FULL.get(), SoundEvents.BOTTLE_EMPTY));
        put(Blocks.MUD, new Tuple<>(EnlightenedEndModBlocks.CHORLOAM.get(), SoundEvents.MUD_PLACE));
    }
}
