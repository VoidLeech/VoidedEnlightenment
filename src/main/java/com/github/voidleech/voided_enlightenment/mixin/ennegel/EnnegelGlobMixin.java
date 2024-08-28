package com.github.voidleech.voided_enlightenment.mixin.ennegel;

import com.github.voidleech.oblivion.advancement.AdvancementHelper;
import net.mcreator.enlightened_end.init.EnlightenedEndModBlocks;
import net.mcreator.enlightened_end.init.EnlightenedEndModSounds;
import net.mcreator.enlightened_end.item.EnnegelGlobItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EnnegelGlobItem.class)
public class EnnegelGlobMixin extends Item {
    public EnnegelGlobMixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        if (level.getBlockState(pContext.getClickedPos()).getBlock() == EnlightenedEndModBlocks.ENNEGEL_BLOCK.get()){
            BlockEntity be = level.getBlockEntity(pContext.getClickedPos());
            CompoundTag tag = be.getPersistentData();
            double bounceBoost = tag.getDouble("bounceBoost");
            if (bounceBoost <= 2.0){
                tag.putDouble("bounceBoost", bounceBoost + 0.1);
                be.setChanged();
                Player player = pContext.getPlayer();
                if (!player.isCreative()){
                    pContext.getPlayer().getItemInHand(pContext.getHand()).shrink(1);
                }
                level.playSound(player, pContext.getClickedPos(), EnlightenedEndModSounds.ENNEGEL_BREAK.get(), SoundSource.BLOCKS, 1.0f, 1.4f);
                if (bounceBoost + 0.1 > 2){
                    AdvancementHelper.grantByName("enlightened_end:super_ennegel_bounce", player);
                }
                return InteractionResult.sidedSuccess(level.isClientSide());
            }
        }
        return super.useOn(pContext);
    }
}
