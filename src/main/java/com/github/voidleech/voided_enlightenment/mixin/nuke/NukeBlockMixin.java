package com.github.voidleech.voided_enlightenment.mixin.nuke;

import com.github.voidleech.voided_enlightenment.VoidedEnlightenmentConfig;
import net.mcreator.enlightened_end.block.NuclearBombBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
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
            // TODO do nuke-activation things
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }
}
