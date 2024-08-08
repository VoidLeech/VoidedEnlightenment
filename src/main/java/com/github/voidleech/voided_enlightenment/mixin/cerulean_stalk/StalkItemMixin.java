package com.github.voidleech.voided_enlightenment.mixin.cerulean_stalk;

import net.mcreator.enlightened_end.init.EnlightenedEndModBlocks;
import net.mcreator.enlightened_end.item.CeruleanStalkItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
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
        Level level = ctx.getLevel();
        if (ctx.canPlace() && stalk0.canSurvive(level, ctx.getClickedPos())){
            level.setBlock(ctx.getClickedPos(), stalk0, Block.UPDATE_ALL);
            return InteractionResult.sidedSuccess(level.isClientSide());
        }
        return super.useOn(pContext);
    }
}
