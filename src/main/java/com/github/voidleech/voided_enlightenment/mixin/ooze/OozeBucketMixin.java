package com.github.voidleech.voided_enlightenment.mixin.ooze;

import net.mcreator.enlightened_end.init.EnlightenedEndModBlocks;
import net.mcreator.enlightened_end.item.OozeFluidItem;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EnchantmentTableBlock;
import net.minecraftforge.items.ItemHandlerHelper;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(OozeFluidItem.class)
public class OozeBucketMixin extends Item {
    public OozeBucketMixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos pos = pContext.getClickedPos();
        if (level.getBlockState(pos).getBlock() == Blocks.CAULDRON){
            level.setBlockAndUpdate(pos, EnlightenedEndModBlocks.OOZE_CAULDRON_FULL.get().defaultBlockState());
            Player player = pContext.getPlayer();
            if (!player.isCreative()){
                ItemStack bucket = new ItemStack(Items.BUCKET);
                player.getItemInHand(pContext.getHand()).shrink(1);
                ItemHandlerHelper.giveItemToPlayer(player, bucket);
            }
            level.playSound(player, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0f, 1.0f);
            return InteractionResult.sidedSuccess(level.isClientSide());
        }
        return super.useOn(pContext);
    }
}
