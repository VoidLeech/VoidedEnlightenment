package com.github.voidleech.voided_enlightenment.registry;

import com.github.voidleech.oblivion.blocks.OblivionHangingSignBlock;
import com.github.voidleech.oblivion.blocks.OblivionStandingSignBlock;
import com.github.voidleech.oblivion.blocks.OblivionWallHangingSignBlock;
import com.github.voidleech.oblivion.blocks.OblivionWallSignBlock;
import com.github.voidleech.oblivion.util.AssignOnceSupplier;
import com.github.voidleech.voided_enlightenment.VoidedEnlightenment;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class VEBlocks {
    static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, VoidedEnlightenment.MOD_ID);

    // Actual Registry happens in mixins/registry/EEBlocksMixin, this just serves as the api to access them since Mixin members cannot be public
    public static final AssignOnceSupplier<OblivionStandingSignBlock> CERULEAN_STANDING_SIGN = new AssignOnceSupplier<>();
    public static final AssignOnceSupplier<OblivionWallSignBlock> CERULEAN_WALL_SIGN = new AssignOnceSupplier<>();
    public static final AssignOnceSupplier<OblivionHangingSignBlock> CERULEAN_HANGING_SIGN = new AssignOnceSupplier<>();
    public static final AssignOnceSupplier<OblivionWallHangingSignBlock> CERULEAN_WALL_HANGING_SIGN = new AssignOnceSupplier<>();

    public static final AssignOnceSupplier<OblivionStandingSignBlock> INDIGO_STANDING_SIGN = new AssignOnceSupplier<>();
    public static final AssignOnceSupplier<OblivionWallSignBlock> INDIGO_WALL_SIGN = new AssignOnceSupplier<>();
    public static final AssignOnceSupplier<OblivionHangingSignBlock> INDIGO_HANGING_SIGN = new AssignOnceSupplier<>();
    public static final AssignOnceSupplier<OblivionWallHangingSignBlock> INDIGO_WALL_HANGING_SIGN = new AssignOnceSupplier<>();

    public static final AssignOnceSupplier<Block> CHORLOAM_BRICKS = new AssignOnceSupplier<>();
    public static final AssignOnceSupplier<StairBlock> CHORLOAM_BRICK_STAIRS = new AssignOnceSupplier<>();
    public static final AssignOnceSupplier<SlabBlock> CHORLOAM_BRICK_SLAB = new AssignOnceSupplier<>();
    public static final AssignOnceSupplier<WallBlock> CHORLOAM_BRICK_WALL = new AssignOnceSupplier<>();
    public static final AssignOnceSupplier<Block> PACKED_CHORLOAM = new AssignOnceSupplier<>();

    public static final AssignOnceSupplier<Block> CERULEAN_MOSAIC = new AssignOnceSupplier<>();
    public static final AssignOnceSupplier<StairBlock> CERULEAN_MOSAIC_STAIRS = new AssignOnceSupplier<>();
    public static final AssignOnceSupplier<SlabBlock> CERULEAN_MOSAIC_SLAB = new AssignOnceSupplier<>();

    public static void register(IEventBus modEventBus){
        BLOCKS.register(modEventBus);
    }
}
