package com.github.voidleech.voided_enlightenment.mixin.cerulean_stalk;

import net.mcreator.enlightened_end.init.EnlightenedEndModBlocks;
import net.mcreator.enlightened_end.item.CeruleanStalkItem;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CeruleanStalkItem.class)
public class StalkItemMixin extends Item {

    public StalkItemMixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        BlockPlaceContext ctx = new BlockPlaceContext(pContext);
        BlockState stalk0 = EnlightenedEndModBlocks.CERULEAN_STALK_0.get().getStateForPlacement(ctx);
        BlockState stalk1 = EnlightenedEndModBlocks.CERULEAN_STALK_1.get().getStateForPlacement(ctx);
        Level level = ctx.getLevel();
        Runnable runOnPlaced = () -> {
            Player player = ctx.getPlayer();
            if (!player.isCreative()){
                player.getItemInHand(ctx.getHand()).shrink(1);
            }
            if (level.isClientSide()){
                level.playLocalSound(ctx.getClickedPos(), SoundEvents.BAMBOO_SAPLING_PLACE, SoundSource.BLOCKS, 1.0f, 1.0f, false);
            }
            else {
                level.playSound(null, ctx.getClickedPos(), SoundEvents.BAMBOO_SAPLING_PLACE, SoundSource.BLOCKS, 1.0f, 1.0f);
            }
        };
        if (ctx.canPlace() && stalk0.canSurvive(level, ctx.getClickedPos())){
            level.setBlock(ctx.getClickedPos(), stalk0, Block.UPDATE_ALL);
            runOnPlaced.run();
            return InteractionResult.sidedSuccess(level.isClientSide());
        }
        else if (ctx.canPlace() && stalk1.canSurvive(level, ctx.getClickedPos())){
            level.setBlock(ctx.getClickedPos(), stalk1, Block.UPDATE_ALL);
            runOnPlaced.run();
            // Block above must be a stalk or stalk "sapling", (otherwise stalk0 could've been placed),
            // setting the block should've changed the stalk sapling to a stalk.
            // We now need to do some block entity admin and to determine whether the stalk should a leafier variant
            BlockEntity be0 = level.getBlockEntity(ctx.getClickedPos().above());
            int length = be0.getPersistentData().getInt("length");
            BlockEntity be1 = level.getBlockEntity(ctx.getClickedPos());
            be1.getPersistentData().putInt("length", length + 1);
            // TODO These cut-offs aren't set in stone. Will be finalized when rewriting the natural growing for the purpose of bonemealing
            if (length >= 9){
                BlockState stalk3 = EnlightenedEndModBlocks.CERULEAN_STALK_3.get().getStateForPlacement(ctx);
                level.setBlock(ctx.getClickedPos(), stalk3, Block.UPDATE_NONE);
                BlockEntity be3 = level.getBlockEntity(ctx.getClickedPos());
                be3.getPersistentData().putInt("length", length + 1);
            }
            else if (length >= 4){
                BlockState stalk2 = EnlightenedEndModBlocks.CERULEAN_STALK_2.get().getStateForPlacement(ctx);
                level.setBlock(ctx.getClickedPos(), stalk2, Block.UPDATE_NONE);
                BlockEntity be2 = level.getBlockEntity(ctx.getClickedPos());
                be2.getPersistentData().putInt("length", length + 1);
            }
            return InteractionResult.sidedSuccess(level.isClientSide());
        }
        return super.useOn(pContext);
    }
}
