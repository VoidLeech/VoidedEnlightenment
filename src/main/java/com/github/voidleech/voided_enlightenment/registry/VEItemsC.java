package com.github.voidleech.voided_enlightenment.registry;

import net.mcreator.enlightened_end.init.EnlightenedEndModTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class VEItemsC {
    public static final RegistryObject<Item> CRUSHED_RAW_BISMUTH = VEItems.ITEMS.register("crushed_raw_bismuth",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CRUSHED_RAW_IRRADIUM = VEItems.ITEMS.register("crushed_raw_irradium",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus modEventBus) {
        modEventBus.addListener(VEItemsC::buildContents);
    }

    private static void buildContents(BuildCreativeModeTabContentsEvent event){
        if (event.getTabKey() == EnlightenedEndModTabs.EE_BUILDING.getKey()){
            event.accept(CRUSHED_RAW_BISMUTH);
            event.accept(CRUSHED_RAW_IRRADIUM);
        }
    }
}
