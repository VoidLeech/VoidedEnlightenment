package com.github.voidleech.voided_enlightenment.mixin.registry;

import com.github.voidleech.oblivion.items.OblivionBoatItem;
import com.github.voidleech.voided_enlightenment.registry.VEBlocks;
import com.github.voidleech.voided_enlightenment.registry.VEItems;
import com.github.voidleech.voided_enlightenment.registry.VEWoodTypes;
import net.mcreator.enlightened_end.init.EnlightenedEndModItems;
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
    private static final RegistryObject<SignItem> VOIDED_ENLIGHTENMENT$CERULEAN_SIGN = REGISTRY.register("cerulean_sign", () ->
            new SignItem(new Item.Properties().stacksTo(16), VEBlocks.CERULEAN_STANDING_SIGN.get().get(), VEBlocks.CERULEAN_WALL_SIGN.get().get()));

    @Unique
    private static final RegistryObject<HangingSignItem> VOIDED_ENLIGHTENMENT$CERULEAN_HANGING_SIGN = REGISTRY.register("cerulean_hanging_sign", () ->
            new HangingSignItem(VEBlocks.CERULEAN_HANGING_SIGN.get().get(), VEBlocks.CERULEAN_WALL_HANGING_SIGN.get().get(), new Item.Properties().stacksTo(16)));

    @Unique
    private static final RegistryObject<SignItem> VOIDED_ENLIGHTENMENT$INDIGO_SIGN = REGISTRY.register("indigo_sign", () ->
            new SignItem(new Item.Properties().stacksTo(16), VEBlocks.INDIGO_STANDING_SIGN.get().get(), VEBlocks.INDIGO_WALL_SIGN.get().get()));

    @Unique
    private static final RegistryObject<HangingSignItem> VOIDED_ENLIGHTENMENT$INDIGO_HANGING_SIGN = REGISTRY.register("indigo_hanging_sign", () ->
            new HangingSignItem(VEBlocks.INDIGO_HANGING_SIGN.get().get(), VEBlocks.INDIGO_WALL_HANGING_SIGN.get().get(), new Item.Properties().stacksTo(16)));

    @Unique
    private static final RegistryObject<OblivionBoatItem> VOIDED_ENLIGHTENMENT$CERULEAN_BOAT = REGISTRY.register("cerulean_boat",
            () -> new OblivionBoatItem(false, VEWoodTypes.VEBoatType.CERULEAN, new Item.Properties().stacksTo(1)));

    @Unique
    private static final RegistryObject<OblivionBoatItem> VOIDED_ENLIGHTENMENT$CERULEAN_CHEST_BOAT = REGISTRY.register("cerulean_chest_boat",
            () -> new OblivionBoatItem(true, VEWoodTypes.VEBoatType.CERULEAN, new Item.Properties().stacksTo(1)));

    @Unique
    private static final RegistryObject<OblivionBoatItem> VOIDED_ENLIGHTENMENT$INDIGO_BOAT = REGISTRY.register("indigo_boat",
            () -> new OblivionBoatItem(false, VEWoodTypes.VEBoatType.INDIGO, new Item.Properties().stacksTo(1)));

    @Unique
    private static final RegistryObject<OblivionBoatItem> VOIDED_ENLIGHTENMENT$INDIGO_CHEST_BOAT = REGISTRY.register("indigo_chest_boat",
            () -> new OblivionBoatItem(true, VEWoodTypes.VEBoatType.INDIGO, new Item.Properties().stacksTo(1)));

    static {
        VEItems.CERULEAN_SIGN.assign(VOIDED_ENLIGHTENMENT$CERULEAN_SIGN);
        VEItems.CERULEAN_HANGING_SIGN.assign(VOIDED_ENLIGHTENMENT$CERULEAN_HANGING_SIGN);
        VEItems.INDIGO_SIGN.assign(VOIDED_ENLIGHTENMENT$INDIGO_SIGN);
        VEItems.INDIGO_HANGING_SIGN.assign(VOIDED_ENLIGHTENMENT$INDIGO_HANGING_SIGN);
        VEItems.CERULEAN_BOAT.assign(VOIDED_ENLIGHTENMENT$CERULEAN_BOAT);
        VEItems.CERULEAN_CHEST_BOAT.assign(VOIDED_ENLIGHTENMENT$CERULEAN_CHEST_BOAT);
        VEItems.INDIGO_BOAT.assign(VOIDED_ENLIGHTENMENT$INDIGO_BOAT);
        VEItems.INDIGO_CHEST_BOAT.assign(VOIDED_ENLIGHTENMENT$INDIGO_CHEST_BOAT);
    }

}
