package com.github.voidleech.voided_enlightenment.registry;

import net.mcreator.enlightened_end.init.EnlightenedEndModItems;
import net.mcreator.enlightened_end.init.EnlightenedEndModTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.KnifeItem;

public class VEItemsFD {

    // We'll just make our own knife because some I cannot give something a different superclass with mixin
    public static final RegistryObject<KnifeItem> ADAMANTITE_KNIFE = VEItems.ITEMS.register("adamantite_knife", () ->
            // I hate this, all the Enlightend tools use inlined tiers /w different attack damage bonus,
                    // I just have to take a *stab* here to see what the damage value should be
            new KnifeItem(new Tier() {
                @Override
                public int getUses() {
                    return 1561;
                }

                @Override
                public float getSpeed() {
                    return 14;
                }

                @Override
                public float getAttackDamageBonus() {
                    return 5;
                }

                @Override
                public int getLevel() {
                    return 5;
                }

                @Override
                public int getEnchantmentValue() {
                    return 15;
                }

                @Override
                public Ingredient getRepairIngredient() {
                    return Ingredient.of(EnlightenedEndModItems.ADAMANTITE_INGOT.get());
                }
            }, 0.5f, -2.2f, new Item.Properties())
            );


    public static void register(IEventBus modEventBus) {
        modEventBus.addListener(VEItemsFD::buildContents);
    }

    private static void buildContents(BuildCreativeModeTabContentsEvent event){
        if (event.getTabKey() == EnlightenedEndModTabs.EE_BUILDING.getKey()){
            event.accept(ADAMANTITE_KNIFE);
        }
    }
}
