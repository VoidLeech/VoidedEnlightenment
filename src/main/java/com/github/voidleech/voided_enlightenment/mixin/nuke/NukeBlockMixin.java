package com.github.voidleech.voided_enlightenment.mixin.nuke;

import com.github.voidleech.voided_enlightenment.VoidedEnlightenmentConfig;
import com.github.voidleech.voided_enlightenment.util.AdvancementHelper;
import net.mcreator.enlightened_end.block.NuclearBombBlock;
import net.mcreator.enlightened_end.init.EnlightenedEndModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
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
            pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
            if (pLevel instanceof ServerLevel serverLevel){
                EnlightenedEndModEntities.ACTIVATED_NUCLEAR_BOMB.get().spawn(serverLevel, pPos, MobSpawnType.TRIGGERED);
                if (pPlayer instanceof ServerPlayer serverPlayer){
                    AdvancementHelper.grantByName("enlightened_end:ihavebecomedeath", serverPlayer);
                }
            }
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }
}
