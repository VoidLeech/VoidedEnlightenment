package com.github.voidleech.voided_enlightenment.registry;

import com.github.voidleech.oblivion.entities.OblivionBoatType;
import com.github.voidleech.oblivion.items.OblivionBoatItem;
import net.mcreator.enlightened_end.EnlightenedEndMod;
import net.mcreator.enlightened_end.init.EnlightenedEndModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.function.Supplier;

public class VEWoodTypes {
    // How to detect MCreator mod without decomp: no boats or signs
    public static final WoodType CERULEAN = WoodType.register(new WoodType(EnlightenedEndMod.MODID + ":cerulean", BlockSetType.OAK));
    public static final WoodType INDIGO = WoodType.register(new WoodType(EnlightenedEndMod.MODID + ":indigo", BlockSetType.OAK));

    public enum VEBoatType implements OblivionBoatType {

        CERULEAN(EnlightenedEndModBlocks.CERULEAN_PLANKS.get(), "cerulean", VEItems.CERULEAN_RAFT.get(), VEItems.CERULEAN_CHEST_RAFT.get(), true),
        INDIGO(EnlightenedEndModBlocks.INDIGO_PLANKS.get(), "indigo", VEItems.INDIGO_BOAT.get(), VEItems.INDIGO_CHEST_BOAT.get(), false);

        private final String name;
        private final Supplier<? extends OblivionBoatItem> boat;
        private final Supplier<? extends OblivionBoatItem> chestBoat;
        private final boolean usesRaftModel;
        private final Block planks;
        VEBoatType(Block pPlanks, String pName, Supplier<? extends OblivionBoatItem> boat, Supplier<? extends OblivionBoatItem> chestBoat, boolean usesRaftModel) {
            this.name = pName;
            this.boat = boat;
            this.chestBoat = chestBoat;
            this.planks = pPlanks;
            this.usesRaftModel = usesRaftModel;
            initOBT();
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getNamespace() {
            return EnlightenedEndMod.MODID;
        }

        @Override
        public Item getBoat() {
            return boat.get();
        }

        @Override
        public Item getChestBoat() {
            return chestBoat.get();
        }

        @Override
        public boolean usesRaftModel() {
            return usesRaftModel;
        }

        @Override
        public Block getPlanks() {
            return planks;
        }
    }
}
