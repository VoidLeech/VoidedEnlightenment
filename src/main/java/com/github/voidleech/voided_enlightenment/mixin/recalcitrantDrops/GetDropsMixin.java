package com.github.voidleech.voided_enlightenment.mixin.recalcitrantDrops;

import net.mcreator.enlightened_end.block.AquaticBismuthGlassPaneBlock;
import net.mcreator.enlightened_end.block.BismuthGlassBlock;
import net.mcreator.enlightened_end.block.BismuthGlassPaneBlock;
import net.mcreator.enlightened_end.block.DazzlingBismuthGlassBlock;
import net.mcreator.enlightened_end.block.DazzlingBismuthGlassPaneBlock;
import net.mcreator.enlightened_end.block.EtherealBismuthGlassBlock;
import net.mcreator.enlightened_end.block.EtherealBismuthGlassPaneBlock;
import net.mcreator.enlightened_end.block.IridescentBismuthGlassBlock;
import net.mcreator.enlightened_end.block.IridescentBismuthGlassPaneBlock;
import net.mcreator.enlightened_end.block.PoiseBismuthGlassBlock;
import net.mcreator.enlightened_end.block.SereneBismuthGlassBlock;
import net.mcreator.enlightened_end.block.SereneBismuthGlassPaneBlock;
import net.mcreator.enlightened_end.block.VerdantBismuthGlassBlock;
import net.mcreator.enlightened_end.block.VerdantBismuthGlassPaneBlock;
import net.mcreator.enlightened_end.block.WaxedBismuthGlassBlock;
import net.mcreator.enlightened_end.block.WaxedBismuthGlassPaneBlock;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import org.spongepowered.asm.mixin.Mixin;

import java.util.List;

@Mixin(value = {BismuthGlassBlock.class, BismuthGlassPaneBlock.class,
        WaxedBismuthGlassBlock.class, WaxedBismuthGlassPaneBlock.class,
        DazzlingBismuthGlassBlock.class, DazzlingBismuthGlassPaneBlock.class,
        SereneBismuthGlassBlock.class, SereneBismuthGlassPaneBlock.class,
        VerdantBismuthGlassBlock.class, VerdantBismuthGlassPaneBlock.class,
        EtherealBismuthGlassBlock.class, EtherealBismuthGlassPaneBlock.class,
        PoiseBismuthGlassBlock.class, AquaticBismuthGlassPaneBlock.class,
        IridescentBismuthGlassBlock.class, IridescentBismuthGlassPaneBlock.class
})
public abstract class GetDropsMixin extends Block {
    public GetDropsMixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public List<ItemStack> getDrops(BlockState pState, LootParams.Builder pParams) {
        return super.getDrops(pState, pParams);
    }
}
