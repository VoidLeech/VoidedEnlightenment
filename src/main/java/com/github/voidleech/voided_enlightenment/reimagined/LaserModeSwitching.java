package com.github.voidleech.voided_enlightenment.reimagined;

import com.github.voidleech.oblivion.advancement.AdvancementHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

public class LaserModeSwitching {

    public static InteractionResult setLaserStatus(Level level, BlockPos pos, Player player, InteractionHand hand, boolean isBurning){
        BlockEntity be = level.getBlockEntity(pos);
        CompoundTag tag = be.getPersistentData();
        if (isBurning){
            tag.putBoolean("burning", true);
            tag.putBoolean("freezing", false);
        }
        else {
            tag.putBoolean("freezing", true);
            tag.putBoolean("burning", false);
        }
        be.setChanged();
        if (!player.isCreative()) {
            player.getItemInHand(hand).shrink(1);
        }
        AdvancementHelper.grantByName("enlightened_end:laser_mix_advancement", player);
        level.playSound(player, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0f, 1.0f);
        return InteractionResult.sidedSuccess(level.isClientSide());
    }
}
