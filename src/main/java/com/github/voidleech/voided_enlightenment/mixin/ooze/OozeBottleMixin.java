package com.github.voidleech.voided_enlightenment.mixin.ooze;

import net.mcreator.enlightened_end.init.EnlightenedEndModBlocks;
import net.mcreator.enlightened_end.item.OozeBottleItem;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Tuple;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.items.ItemHandlerHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Mixin(OozeBottleItem.class)
public class OozeBottleMixin extends Item {
    public OozeBottleMixin(Properties pProperties) {
        super(pProperties);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void voided_enlightenment$setCraftingRemainder(CallbackInfo ci){
        this.craftingRemainingItem = Items.GLASS_BOTTLE;
    }

    @Unique
    private static final Map<Block, Tuple<Block, SoundEvent>> VOIDED_ENLIGHTENMENT$OOZE_BOTTLE_TRANSFORMATIONS = Collections.synchronizedMap(new HashMap<>());

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Block toTransform = pContext.getLevel().getBlockState(pContext.getClickedPos()).getBlock();
        Tuple<Block, SoundEvent> transformInto = VOIDED_ENLIGHTENMENT$OOZE_BOTTLE_TRANSFORMATIONS.get(toTransform);
        if (transformInto != null){
            pContext.getLevel().setBlock(pContext.getClickedPos(), transformInto.getA().defaultBlockState(), Block.UPDATE_ALL);
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

    static {
        VOIDED_ENLIGHTENMENT$OOZE_BOTTLE_TRANSFORMATIONS.put(Blocks.CAULDRON, new Tuple<>(EnlightenedEndModBlocks.OOZE_CAULDRON_1.get(), SoundEvents.BOTTLE_EMPTY));
        VOIDED_ENLIGHTENMENT$OOZE_BOTTLE_TRANSFORMATIONS.put(EnlightenedEndModBlocks.OOZE_CAULDRON_1.get(), new Tuple<>(EnlightenedEndModBlocks.OOZE_CAULDRON_2.get(), SoundEvents.BOTTLE_EMPTY));
        VOIDED_ENLIGHTENMENT$OOZE_BOTTLE_TRANSFORMATIONS.put(EnlightenedEndModBlocks.OOZE_CAULDRON_2.get(), new Tuple<>(EnlightenedEndModBlocks.OOZE_CAULDRON_FULL.get(), SoundEvents.BOTTLE_EMPTY));
    }
}
