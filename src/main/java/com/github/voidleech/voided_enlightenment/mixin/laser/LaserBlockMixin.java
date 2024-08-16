package com.github.voidleech.voided_enlightenment.mixin.laser;

import com.github.voidleech.voided_enlightenment.util.AdvancementHelper;
import net.mcreator.enlightened_end.block.LaserBlock;
import net.mcreator.enlightened_end.init.EnlightenedEndModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(LaserBlock.class)
public class LaserBlockMixin extends Block {
    public LaserBlockMixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack stack = pPlayer.getItemInHand(pHand);
        if (stack.getItem() == Items.BLAZE_POWDER){
            return ve$setLaserStatus(pLevel, pPos, pPlayer, pHand, true);
        }
        else if (stack.getItem() == EnlightenedEndModItems.GLACIUM.get()){
            return ve$setLaserStatus(pLevel, pPos, pPlayer, pHand, false);
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Unique
    private InteractionResult ve$setLaserStatus(Level level, BlockPos pos, Player player, InteractionHand hand, boolean isBurning){
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
        if (player instanceof ServerPlayer serverPlayer) {
            AdvancementHelper.grantByName("enlightened_end:laser_mix_advancement", serverPlayer);
        }
        level.playSound(player, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0f, 1.0f);
        return InteractionResult.sidedSuccess(level.isClientSide());
    }
}
