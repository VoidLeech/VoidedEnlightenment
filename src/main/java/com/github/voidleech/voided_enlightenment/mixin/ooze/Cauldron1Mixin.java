package com.github.voidleech.voided_enlightenment.mixin.ooze;

import com.github.voidleech.oblivion.hackyMixinUtils.propertyRebuilders.BlockPropertiesRebuilder;
import com.github.voidleech.voided_enlightenment.reimagined.OozeCauldronFilling;
import net.mcreator.enlightened_end.block.OozeCauldron1Block;
import net.mcreator.enlightened_end.init.EnlightenedEndModBlocks;
import net.mcreator.enlightened_end.init.EnlightenedEndModItems;
import net.mcreator.enlightened_end.init.EnlightenedEndModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.items.ItemHandlerHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(OozeCauldron1Block.class)
public class Cauldron1Mixin extends Block {
    public Cauldron1Mixin(Properties pProperties) {
        super(pProperties);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    void voided_enlightenment$enableRandomTicks(CallbackInfo ci){
        BlockPropertiesRebuilder.of(this)
                .randomTicks(true)
                .finalizeRebuild();
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (OozeCauldronFilling.canFill(pLevel, pPos, pRandom)){
            pLevel.setBlockAndUpdate(pPos, EnlightenedEndModBlocks.OOZE_CAULDRON_2.get().defaultBlockState());
            return; // We've replaced the block
        }
        super.tick(pState, pLevel, pPos, pRandom);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pPlayer.getItemInHand(pHand).getItem() == Items.GLASS_BOTTLE) {
            pLevel.setBlockAndUpdate(pPos, Blocks.CAULDRON.defaultBlockState());
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
