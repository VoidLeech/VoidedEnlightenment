package com.github.voidleech.voided_enlightenment.mixin.laser;

import com.github.voidleech.voided_enlightenment.reimagined.LaserModeSwitching;
import net.mcreator.enlightened_end.block.LaserBlock;
import net.mcreator.enlightened_end.init.EnlightenedEndModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LaserBlock.class)
public class LaserBlockMixin extends Block {
    public LaserBlockMixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack stack = pPlayer.getItemInHand(pHand);
        if (stack.getItem() == Items.BLAZE_POWDER){
            return LaserModeSwitching.setLaserStatus(pLevel, pPos, pPlayer, pHand, true);
        }
        else if (stack.getItem() == EnlightenedEndModItems.GLACIUM.get()){
            return LaserModeSwitching.setLaserStatus(pLevel, pPos, pPlayer, pHand, false);
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }
}
