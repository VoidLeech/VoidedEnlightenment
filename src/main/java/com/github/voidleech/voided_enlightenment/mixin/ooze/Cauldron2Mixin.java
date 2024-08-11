package com.github.voidleech.voided_enlightenment.mixin.ooze;

import net.mcreator.enlightened_end.block.OozeCauldron2Block;
import net.mcreator.enlightened_end.init.EnlightenedEndModBlocks;
import net.mcreator.enlightened_end.init.EnlightenedEndModItems;
import net.mcreator.enlightened_end.init.EnlightenedEndModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.items.ItemHandlerHelper;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(OozeCauldron2Block.class)
public class Cauldron2Mixin extends Block {
    public Cauldron2Mixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pPlayer.getItemInHand(pHand).getItem() == Items.GLASS_BOTTLE) {
            pLevel.setBlock(pPos, EnlightenedEndModBlocks.OOZE_CAULDRON_1.get().defaultBlockState(), Block.UPDATE_ALL);
            if (!pPlayer.isCreative()){
                ItemStack oozeBottle = new ItemStack(EnlightenedEndModItems.OOZE_BOTTLE.get());
                pPlayer.getItemInHand(pHand).shrink(1);
                ItemHandlerHelper.giveItemToPlayer(pPlayer, oozeBottle);
            }
            pLevel.playSound(pPlayer, pPos, EnlightenedEndModSounds.OOZE_BOTTLE_FILLED.get(), SoundSource.BLOCKS, 1.0f, 1.0f);
            return InteractionResult.sidedSuccess(pLevel.isClientSide());
        }

        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }
}
