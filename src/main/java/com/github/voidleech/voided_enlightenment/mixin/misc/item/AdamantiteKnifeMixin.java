package com.github.voidleech.voided_enlightenment.mixin.misc.item;

import net.mcreator.enlightened_end.item.AdamantiteKnifeItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

import java.util.List;

@Mixin(AdamantiteKnifeItem.class)
public class AdamantiteKnifeMixin extends Item {

    public AdamantiteKnifeMixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (!ModList.get().isLoaded("farmersdelight")){
           pTooltipComponents.add(Component.translatable("tooltip.voided_enlightenment.knife_unsupported"));
        }
        else {
            pTooltipComponents.add(Component.translatable("tooltip.voided_enlightenment.knife_deprecation"));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
