package com.github.voidleech.voided_enlightenment.mixin.registry;

import com.github.voidleech.oblivion.blocks.OblivionHangingSignBlock;
import com.github.voidleech.oblivion.blocks.OblivionStandingSignBlock;
import com.github.voidleech.oblivion.blocks.OblivionWallHangingSignBlock;
import com.github.voidleech.oblivion.blocks.OblivionWallSignBlock;
import com.github.voidleech.voided_enlightenment.registry.VEBlocks;
import com.github.voidleech.voided_enlightenment.registry.VEWoodTypes;
import net.mcreator.enlightened_end.init.EnlightenedEndModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(EnlightenedEndModBlocks.class)
public abstract class EEBlocksMixin {
    // This is one massive hack to get the signs registered under Enlightend's mod id, s.t. mods like EveryCompat can detect them
    @Shadow @Final public static DeferredRegister<Block> REGISTRY;
    @Unique
    private static final RegistryObject<OblivionStandingSignBlock> VOIDED_ENLIGHTENMENT$CERULEAN_STANDING_SIGN = REGISTRY.register("cerulean_sign", () ->
            new OblivionStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).mapColor(MapColor.COLOR_CYAN), VEWoodTypes.CERULEAN));

    @Unique
    private static final RegistryObject<OblivionWallSignBlock> VOIDED_ENLIGHTENMENT$CERULEAN_WALL_SIGN = REGISTRY.register("cerulean_wall_sign", () ->
            new OblivionWallSignBlock(BlockBehaviour.Properties.copy(VOIDED_ENLIGHTENMENT$CERULEAN_STANDING_SIGN.get())
                    .dropsLike(VOIDED_ENLIGHTENMENT$CERULEAN_STANDING_SIGN.get()), VEWoodTypes.CERULEAN));

    @Unique
    private static final RegistryObject<OblivionHangingSignBlock> VOIDED_ENLIGHTENMENT$CERULEAN_HANGING_SIGN = REGISTRY.register("cerulean_hanging_sign", () ->
            new OblivionHangingSignBlock(BlockBehaviour.Properties.copy(VOIDED_ENLIGHTENMENT$CERULEAN_STANDING_SIGN.get()), VEWoodTypes.CERULEAN));

    @Unique
    private static final RegistryObject<OblivionWallHangingSignBlock> VOIDED_ENLIGHTENMENT$CERULEAN_WALL_HANGING_SIGN = REGISTRY.register("cerulean_wall_hanging_sign", () ->
            new OblivionWallHangingSignBlock(BlockBehaviour.Properties.copy(VOIDED_ENLIGHTENMENT$CERULEAN_STANDING_SIGN.get())
                    .dropsLike(VOIDED_ENLIGHTENMENT$CERULEAN_HANGING_SIGN.get()), VEWoodTypes.CERULEAN));

    @Unique
    private static final RegistryObject<OblivionStandingSignBlock> VOIDED_ENLIGHTENMENT$INDIGO_STANDING_SIGN = REGISTRY.register("indigo_sign", () ->
            new OblivionStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).mapColor(MapColor.COLOR_PURPLE), VEWoodTypes.INDIGO));

    @Unique
    private static final RegistryObject<OblivionWallSignBlock> VOIDED_ENLIGHTENMENT$INDIGO_WALL_SIGN = REGISTRY.register("indigo_wall_sign", () ->
            new OblivionWallSignBlock(BlockBehaviour.Properties.copy(VOIDED_ENLIGHTENMENT$INDIGO_STANDING_SIGN.get())
                    .dropsLike(VOIDED_ENLIGHTENMENT$INDIGO_STANDING_SIGN.get()), VEWoodTypes.INDIGO));

    @Unique
    private static final RegistryObject<OblivionHangingSignBlock> VOIDED_ENLIGHTENMENT$INDIGO_HANGING_SIGN = REGISTRY.register("indigo_hanging_sign", () ->
            new OblivionHangingSignBlock(BlockBehaviour.Properties.copy(VOIDED_ENLIGHTENMENT$INDIGO_STANDING_SIGN.get()), VEWoodTypes.INDIGO));

    @Unique
    private static final RegistryObject<OblivionWallHangingSignBlock> VOIDED_ENLIGHTENMENT$INDIGO_WALL_HANGING_SIGN = REGISTRY.register("indigo_wall_hanging_sign", () ->
            new OblivionWallHangingSignBlock(BlockBehaviour.Properties.copy(VOIDED_ENLIGHTENMENT$INDIGO_STANDING_SIGN.get())
                    .dropsLike(VOIDED_ENLIGHTENMENT$INDIGO_HANGING_SIGN.get()), VEWoodTypes.INDIGO));

    @Unique
    private static final RegistryObject<Block> VOIDED_ENLIGHTENMENT$PACKED_CHORLOAM = REGISTRY.register("packed_chorloam", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.PACKED_MUD)));

    @Unique
    private static final RegistryObject<Block> VOIDED_ENLIGHTENMENT$CHORLOAM_BRICKS = REGISTRY.register("chorloam_bricks", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.MUD_BRICKS)));

    @Unique
    private static final RegistryObject<StairBlock> VOIDED_ENLIGHTENMENT$CHORLOAM_BRICK_STAIRS = REGISTRY.register("chorloam_brick_stairs", () ->
            new StairBlock(VOIDED_ENLIGHTENMENT$CHORLOAM_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.MUD_BRICK_STAIRS)));

    @Unique
    private static final RegistryObject<SlabBlock> VOIDED_ENLIGHTENMENT$CHORLOAM_BRICK_SLAB = REGISTRY.register("chorloam_brick_slab", () ->
            new SlabBlock(BlockBehaviour.Properties.copy(Blocks.MUD_BRICK_SLAB)));

    @Unique
    private static final RegistryObject<WallBlock> VOIDED_ENLIGHTENMENT$CHORLOAM_BRICK_WALL = REGISTRY.register("chorloam_brick_wall", () ->
            new WallBlock(BlockBehaviour.Properties.copy(Blocks.MUD_BRICK_WALL)));

    static {
        VEBlocks.CERULEAN_STANDING_SIGN.assign(VOIDED_ENLIGHTENMENT$CERULEAN_STANDING_SIGN);
        VEBlocks.CERULEAN_WALL_SIGN.assign(VOIDED_ENLIGHTENMENT$CERULEAN_WALL_SIGN);
        VEBlocks.CERULEAN_HANGING_SIGN.assign(VOIDED_ENLIGHTENMENT$CERULEAN_HANGING_SIGN);
        VEBlocks.CERULEAN_WALL_HANGING_SIGN.assign(VOIDED_ENLIGHTENMENT$CERULEAN_WALL_HANGING_SIGN);
        VEBlocks.INDIGO_STANDING_SIGN.assign(VOIDED_ENLIGHTENMENT$INDIGO_STANDING_SIGN);
        VEBlocks.INDIGO_WALL_SIGN.assign(VOIDED_ENLIGHTENMENT$INDIGO_WALL_SIGN);
        VEBlocks.INDIGO_HANGING_SIGN.assign(VOIDED_ENLIGHTENMENT$INDIGO_HANGING_SIGN);
        VEBlocks.INDIGO_WALL_HANGING_SIGN.assign(VOIDED_ENLIGHTENMENT$INDIGO_WALL_HANGING_SIGN);
        VEBlocks.PACKED_CHORLOAM.assign(VOIDED_ENLIGHTENMENT$PACKED_CHORLOAM);
        VEBlocks.CHORLOAM_BRICKS.assign(VOIDED_ENLIGHTENMENT$CHORLOAM_BRICKS);
        VEBlocks.CHORLOAM_BRICK_STAIRS.assign(VOIDED_ENLIGHTENMENT$CHORLOAM_BRICK_STAIRS);
        VEBlocks.CHORLOAM_BRICK_SLAB.assign(VOIDED_ENLIGHTENMENT$CHORLOAM_BRICK_SLAB);
        VEBlocks.CHORLOAM_BRICK_WALL.assign(VOIDED_ENLIGHTENMENT$CHORLOAM_BRICK_WALL);
    }
}
