package com.github.voidleech.voided_enlightenment.mixin.nuclear;

import com.github.voidleech.oblivion.advancement.AdvancementHelper;
import com.github.voidleech.voided_enlightenment.VoidedEnlightenmentConfig;
import net.mcreator.enlightened_end.block.NuclearBombBlock;
import net.mcreator.enlightened_end.init.EnlightenedEndModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(NuclearBombBlock.class)
public class NukeBlockMixin extends Block {
    public NukeBlockMixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pPlayer.getItemInHand(pHand).getItem() == Items.FLINT_AND_STEEL && VoidedEnlightenmentConfig.nukeAllowed){
            pLevel.playSound(pPlayer, pPos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0f, 1.0f);
            pPlayer.getItemInHand(pHand).hurtAndBreak(1, pPlayer, (p) -> p.broadcastBreakEvent(pHand));
            pLevel.setBlockAndUpdate(pPos, Blocks.AIR.defaultBlockState());
            if (pLevel instanceof ServerLevel serverLevel){
                EnlightenedEndModEntities.ACTIVATED_NUCLEAR_BOMB.get().spawn(serverLevel, pPos, MobSpawnType.TRIGGERED);
                AdvancementHelper.grantByName("enlightened_end:ihavebecomedeath", pPlayer);
            }
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }
}
