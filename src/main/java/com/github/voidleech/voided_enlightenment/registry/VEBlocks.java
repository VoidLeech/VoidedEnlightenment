package com.github.voidleech.voided_enlightenment.registry;

import com.github.voidleech.oblivion.blocks.OblivionHangingSignBlock;
import com.github.voidleech.oblivion.blocks.OblivionStandingSignBlock;
import com.github.voidleech.oblivion.blocks.OblivionWallHangingSignBlock;
import com.github.voidleech.oblivion.blocks.OblivionWallSignBlock;
import com.github.voidleech.oblivion.registry.OblivionBlockEntities;
import com.github.voidleech.oblivion.util.AssignOnceSupplier;
import com.github.voidleech.voided_enlightenment.VoidedEnlightenment;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class VEBlocks {
    static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, VoidedEnlightenment.MOD_ID);

    // Actual Registry happens in mixins/registry/EEBlocksMixin, this just serves as the api to access them since Mixin members cannot be public
    public static final AssignOnceSupplier<OblivionStandingSignBlock> CERULEAN_STANDING_SIGN = new AssignOnceSupplier<>();

    public static final AssignOnceSupplier<OblivionWallSignBlock> CERULEAN_WALL_SIGN = new AssignOnceSupplier<>();

    public static final AssignOnceSupplier<OblivionHangingSignBlock> CERULEAN_HANGING_SIGN = new AssignOnceSupplier<>();

    public static final AssignOnceSupplier<OblivionWallHangingSignBlock> CERULEAN_HANGING_WALL_SIGN = new AssignOnceSupplier<>();

    public static final AssignOnceSupplier<OblivionStandingSignBlock> INDIGO_STANDING_SIGN = new AssignOnceSupplier<>();

    public static final AssignOnceSupplier<OblivionWallSignBlock> INDIGO_WALL_SIGN = new AssignOnceSupplier<>();

    public static final AssignOnceSupplier<OblivionHangingSignBlock> INDIGO_HANGING_SIGN = new AssignOnceSupplier<>();

    public static final AssignOnceSupplier<OblivionWallHangingSignBlock> INDIGO_HANGING_WALL_SIGN = new AssignOnceSupplier<>();

    public static void register(IEventBus modEventBus){
        BLOCKS.register(modEventBus);
        OblivionBlockEntities.addSign(() -> CERULEAN_STANDING_SIGN.get().get(), () -> CERULEAN_WALL_SIGN.get().get(),
                () -> CERULEAN_HANGING_SIGN.get().get(), () -> CERULEAN_HANGING_WALL_SIGN.get().get());
    }
}
