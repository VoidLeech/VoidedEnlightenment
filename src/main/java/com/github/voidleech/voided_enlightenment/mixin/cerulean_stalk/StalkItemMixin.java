package com.github.voidleech.voided_enlightenment.mixin.cerulean_stalk;

import com.github.voidleech.voided_enlightenment.reimagined.CeruleanStalkGrowing;
import net.mcreator.enlightened_end.init.EnlightenedEndModBlocks;
import net.mcreator.enlightened_end.item.CeruleanStalkItem;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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
import org.spongepowered.asm.mixin.Unique;

import java.util.function.Consumer;

@Mixin(CeruleanStalkItem.class)
public class StalkItemMixin extends Item {

    public StalkItemMixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        BlockPlaceContext ctx = new BlockPlaceContext(pContext);
        BlockState stalk0 = EnlightenedEndModBlocks.CERULEAN_STALK_0.get().defaultBlockState();
        BlockState stalk1 = EnlightenedEndModBlocks.CERULEAN_STALK_1.get().defaultBlockState();
        Level level = ctx.getLevel();
        if (ctx.canPlace() && stalk0.canSurvive(level, ctx.getClickedPos())){
            level.setBlock(ctx.getClickedPos(), stalk0, Block.UPDATE_ALL);
            ve$subtractItemWithSound(SoundEvents.BAMBOO_SAPLING_PLACE, ctx, level);
            return InteractionResult.sidedSuccess(level.isClientSide());
        }
        else if (ctx.canPlace() && stalk1.canSurvive(level, ctx.getClickedPos())){
            ve$subtractItemWithSound(SoundEvents.BAMBOO_PLACE, ctx, level);
            CeruleanStalkGrowing.growStalk(level, ctx.getClickedPos().above(), level.getBlockState(ctx.getClickedPos().above()), true);
            return InteractionResult.sidedSuccess(level.isClientSide());
        }
        return super.useOn(pContext);
    }

    @Unique
    private static void ve$subtractItemWithSound(SoundEvent sound, BlockPlaceContext ctx, Level level) {
        Player player = ctx.getPlayer();
        if (!player.isCreative()){
            player.getItemInHand(ctx.getHand()).shrink(1);
        }
        level.playSound(player, ctx.getClickedPos(), sound, SoundSource.BLOCKS, 1.0f, 1.0f);
    }
}
