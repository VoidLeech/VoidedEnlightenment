package com.github.voidleech.voided_enlightenment.registry;

import com.github.voidleech.oblivion.items.OblivionBoatItem;
import com.github.voidleech.oblivion.util.AssignOnceSupplier;
import com.github.voidleech.oblivion.util.Platform;
import com.github.voidleech.voided_enlightenment.VoidedEnlightenment;
import net.mcreator.enlightened_end.init.EnlightenedEndModItems;
import net.mcreator.enlightened_end.init.EnlightenedEndModTabs;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class VEItems {
    static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, VoidedEnlightenment.MOD_ID);
    // Actual Registry happens in mixins/registry/EEItemsMixin, this just serves as the api to access them since Mixin members cannot be public
    public static final AssignOnceSupplier<SignItem> CERULEAN_SIGN = new AssignOnceSupplier<>();
    public static final AssignOnceSupplier<HangingSignItem> CERULEAN_HANGING_SIGN = new AssignOnceSupplier<>();
    public static final AssignOnceSupplier<SignItem> INDIGO_SIGN = new AssignOnceSupplier<>();
    public static final AssignOnceSupplier<HangingSignItem> INDIGO_HANGING_SIGN = new AssignOnceSupplier<>();

    public static final AssignOnceSupplier<OblivionBoatItem> CERULEAN_RAFT = new AssignOnceSupplier<>();
    public static final AssignOnceSupplier<OblivionBoatItem> CERULEAN_CHEST_RAFT = new AssignOnceSupplier<>();
    public static final AssignOnceSupplier<OblivionBoatItem> INDIGO_BOAT = new AssignOnceSupplier<>();
    public static final AssignOnceSupplier<OblivionBoatItem> INDIGO_CHEST_BOAT = new AssignOnceSupplier<>();

    public static final AssignOnceSupplier<BlockItem> PACKED_CHORLOAM = new AssignOnceSupplier<>();
    public static final AssignOnceSupplier<BlockItem> CHORLOAM_BRICKS = new AssignOnceSupplier<>();
    public static final AssignOnceSupplier<BlockItem> CHORLOAM_BRICK_STAIRS = new AssignOnceSupplier<>();
    public static final AssignOnceSupplier<BlockItem> CHORLOAM_BRICK_SLAB = new AssignOnceSupplier<>();
    public static final AssignOnceSupplier<BlockItem> CHORLOAM_BRICK_WALL = new AssignOnceSupplier<>();

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
        modEventBus.addListener(VEItems::buildContents);
    }

    private static void buildContents(BuildCreativeModeTabContentsEvent event){
        if (event.getTabKey() == EnlightenedEndModTabs.EE_BUILDING.getKey()){
            if (!Platform.isModLoaded("farmersdelight")){
                event.accept(EnlightenedEndModItems.ADAMANTITE_KNIFE);
            }
            event.accept(PACKED_CHORLOAM.get());
            event.accept(CHORLOAM_BRICKS.get());
            event.accept(CHORLOAM_BRICK_STAIRS.get());
            event.accept(CHORLOAM_BRICK_SLAB.get());
            event.accept(CHORLOAM_BRICK_WALL.get());
            event.accept(CERULEAN_SIGN.get());
            event.accept(CERULEAN_HANGING_SIGN.get());
            event.accept(INDIGO_SIGN.get());
            event.accept(INDIGO_HANGING_SIGN.get());
            event.accept(CERULEAN_RAFT.get());
            event.accept(CERULEAN_CHEST_RAFT.get());
            event.accept(INDIGO_BOAT.get());
            event.accept(INDIGO_CHEST_BOAT.get());
        }
    }
}
