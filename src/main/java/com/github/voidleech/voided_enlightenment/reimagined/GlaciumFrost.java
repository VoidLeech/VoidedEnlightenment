package com.github.voidleech.voided_enlightenment.reimagined;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;

public class GlaciumFrost {
    public static void applyGlaciumFrost(Entity entity, int minimumFrostWalkerLevel){
        if (entity != null){
            if (entity instanceof LivingEntity livingEntity){
                minimumFrostWalkerLevel -= EnchantmentHelper.getEnchantmentLevel(Enchantments.FROST_WALKER, livingEntity);
                if (minimumFrostWalkerLevel <= 0){
                    return;
                }
            }
            int ticks = entity.getTicksFrozen();
            if (ticks <= 300 && entity.getRemainingFireTicks() <= 0){
                // The colder it is, the quicker the frost applies
                entity.setTicksFrozen(ticks + (int)(7.5 * minimumFrostWalkerLevel));
            }
        }
    }
}
