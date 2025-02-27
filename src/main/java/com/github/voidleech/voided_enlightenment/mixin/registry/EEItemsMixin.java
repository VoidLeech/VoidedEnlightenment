package com.github.voidleech.voided_enlightenment.mixin.registry;

import com.github.voidleech.oblivion.items.OblivionBoatItem;
import com.github.voidleech.voided_enlightenment.registry.VEBlocks;
import com.github.voidleech.voided_enlightenment.registry.VEItems;
import com.github.voidleech.voided_enlightenment.registry.VEWoodTypes;
import net.mcreator.enlightened_end.init.EnlightenedEndModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(EnlightenedEndModItems.class)
public abstract class EEItemsMixin {
    // This is one massive hack to get the signs & boats registered under Enlightend's mod id, s.t. mods like EveryCompat can detect them
    @Shadow @Final public static DeferredRegister<Item> REGISTRY;
    @Unique
    private static final RegistryObject<SignItem> VOIDED_ENLIGHTENMENT$CERULEAN_SIGN = REGISTRY.register("cerulean_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16),
                    VEBlocks.CERULEAN_STANDING_SIGN.get().get(), VEBlocks.CERULEAN_WALL_SIGN.get().get()));

    @Unique
    private static final RegistryObject<HangingSignItem> VOIDED_ENLIGHTENMENT$CERULEAN_HANGING_SIGN = REGISTRY.register("cerulean_hanging_sign",
            () -> new HangingSignItem(VEBlocks.CERULEAN_HANGING_SIGN.get().get(),
                    VEBlocks.CERULEAN_WALL_HANGING_SIGN.get().get(), new Item.Properties().stacksTo(16)));

    @Unique
    private static final RegistryObject<SignItem> VOIDED_ENLIGHTENMENT$INDIGO_SIGN = REGISTRY.register("indigo_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16),
                    VEBlocks.INDIGO_STANDING_SIGN.get().get(), VEBlocks.INDIGO_WALL_SIGN.get().get()));

    @Unique
    private static final RegistryObject<HangingSignItem> VOIDED_ENLIGHTENMENT$INDIGO_HANGING_SIGN = REGISTRY.register("indigo_hanging_sign",
            () -> new HangingSignItem(VEBlocks.INDIGO_HANGING_SIGN.get().get(),
                    VEBlocks.INDIGO_WALL_HANGING_SIGN.get().get(), new Item.Properties().stacksTo(16)));

    @Unique
    private static final RegistryObject<OblivionBoatItem> VOIDED_ENLIGHTENMENT$CERULEAN_RAFT = REGISTRY.register("cerulean_raft",
            () -> new OblivionBoatItem(false, VEWoodTypes.VEBoatType.CERULEAN, new Item.Properties().stacksTo(1)));

    @Unique
    private static final RegistryObject<OblivionBoatItem> VOIDED_ENLIGHTENMENT$CERULEAN_CHEST_RAFT = REGISTRY.register("cerulean_chest_raft",
            () -> new OblivionBoatItem(true, VEWoodTypes.VEBoatType.CERULEAN, new Item.Properties().stacksTo(1)));

    @Unique
    private static final RegistryObject<OblivionBoatItem> VOIDED_ENLIGHTENMENT$INDIGO_BOAT = REGISTRY.register("indigo_boat",
            () -> new OblivionBoatItem(false, VEWoodTypes.VEBoatType.INDIGO, new Item.Properties().stacksTo(1)));

    @Unique
    private static final RegistryObject<OblivionBoatItem> VOIDED_ENLIGHTENMENT$INDIGO_CHEST_BOAT = REGISTRY.register("indigo_chest_boat",
            () -> new OblivionBoatItem(true, VEWoodTypes.VEBoatType.INDIGO, new Item.Properties().stacksTo(1)));

    @Unique
    private static final RegistryObject<BlockItem> VOIDED_ENLIGHTENMENT$PACKED_CHORLOAM = REGISTRY.register("packed_chorloam",
            () -> new BlockItem(VEBlocks.PACKED_CHORLOAM.get().get(), new Item.Properties()));

    @Unique
    private static final RegistryObject<BlockItem> VOIDED_ENLIGHTENMENT$CHORLOAM_BRICKS = REGISTRY.register("chorloam_bricks",
            () -> new BlockItem(VEBlocks.CHORLOAM_BRICKS.get().get(), new Item.Properties()));

    @Unique
    private static final RegistryObject<BlockItem> VOIDED_ENLIGHTENMENT$CHORLOAM_BRICK_STAIRS = REGISTRY.register("chorloam_brick_stairs",
            () -> new BlockItem(VEBlocks.CHORLOAM_BRICK_STAIRS.get().get(), new Item.Properties()));

    @Unique
    private static final RegistryObject<BlockItem> VOIDED_ENLIGHTENMENT$CHORLOAM_BRICK_SLAB = REGISTRY.register("chorloam_brick_slab",
            () -> new BlockItem(VEBlocks.CHORLOAM_BRICK_SLAB.get().get(), new Item.Properties()));

    @Unique
    private static final RegistryObject<BlockItem> VOIDED_ENLIGHTENMENT$CHORLOAM_BRICK_WALL = REGISTRY.register("chorloam_brick_wall",
            () -> new BlockItem(VEBlocks.CHORLOAM_BRICK_WALL.get().get(), new Item.Properties()));

    static {
        VEItems.CERULEAN_SIGN.assign(VOIDED_ENLIGHTENMENT$CERULEAN_SIGN);
        VEItems.CERULEAN_HANGING_SIGN.assign(VOIDED_ENLIGHTENMENT$CERULEAN_HANGING_SIGN);
        VEItems.INDIGO_SIGN.assign(VOIDED_ENLIGHTENMENT$INDIGO_SIGN);
        VEItems.INDIGO_HANGING_SIGN.assign(VOIDED_ENLIGHTENMENT$INDIGO_HANGING_SIGN);
        VEItems.CERULEAN_RAFT.assign(VOIDED_ENLIGHTENMENT$CERULEAN_RAFT);
        VEItems.CERULEAN_CHEST_RAFT.assign(VOIDED_ENLIGHTENMENT$CERULEAN_CHEST_RAFT);
        VEItems.INDIGO_BOAT.assign(VOIDED_ENLIGHTENMENT$INDIGO_BOAT);
        VEItems.INDIGO_CHEST_BOAT.assign(VOIDED_ENLIGHTENMENT$INDIGO_CHEST_BOAT);
        VEItems.CHORLOAM_BRICKS.assign(VOIDED_ENLIGHTENMENT$CHORLOAM_BRICKS);
        VEItems.CHORLOAM_BRICK_STAIRS.assign(VOIDED_ENLIGHTENMENT$CHORLOAM_BRICK_STAIRS);
        VEItems.CHORLOAM_BRICK_SLAB.assign(VOIDED_ENLIGHTENMENT$CHORLOAM_BRICK_SLAB);
        VEItems.PACKED_CHORLOAM.assign(VOIDED_ENLIGHTENMENT$PACKED_CHORLOAM);
        VEItems.CHORLOAM_BRICK_WALL.assign(VOIDED_ENLIGHTENMENT$CHORLOAM_BRICK_WALL);
    }
}
