package com.github.voidleech.voided_enlightenment.mixin.ooze;

import com.github.voidleech.voided_enlightenment.api.OozeBotteTransformations;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.mcreator.enlightened_end.item.OozeBottleItem;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Tuple;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.items.ItemHandlerHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(OozeBottleItem.class)
public abstract class OozeBottleMixin extends Item {
    public OozeBottleMixin(Properties pProperties) {
        super(pProperties);
    }

    @ModifyExpressionValue(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/Item$Properties;stacksTo(I)Lnet/minecraft/world/item/Item$Properties;"))
    private static Properties voided_enlightenment$setCraftingRemainder(Properties original){
        return original.craftRemainder(Items.GLASS_BOTTLE);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Block toTransform = pContext.getLevel().getBlockState(pContext.getClickedPos()).getBlock();
        Tuple<Block, SoundEvent> transformInto = OozeBotteTransformations.get(toTransform);
        if (transformInto != null){
            pContext.getLevel().setBlockAndUpdate(pContext.getClickedPos(), transformInto.getA().defaultBlockState());
            Player player = pContext.getPlayer();
            if (!player.isCreative()){
                ItemStack glassBottle = new ItemStack(Items.GLASS_BOTTLE);
                player.getItemInHand(pContext.getHand()).shrink(1);
                ItemHandlerHelper.giveItemToPlayer(player, glassBottle);
            }
            pContext.getLevel().playSound(player, pContext.getClickedPos(), transformInto.getB(), SoundSource.BLOCKS, 1.0f, 1.0f);
            return InteractionResult.sidedSuccess(pContext.getLevel().isClientSide());
        }

        return super.useOn(pContext);
    }
}
