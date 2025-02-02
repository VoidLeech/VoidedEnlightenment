package com.github.voidleech.voided_enlightenment.mixin.recalcitrantDrops;

import net.mcreator.enlightened_end.block.AbyssalEyliumBlock;
import net.mcreator.enlightened_end.block.BismuthBlockBlock;
import net.mcreator.enlightened_end.block.BismuthSheetSlabBlock;
import net.mcreator.enlightened_end.block.BismuthSheetStairsBlock;
import net.mcreator.enlightened_end.block.BismuthWallBlock;
import net.mcreator.enlightened_end.block.BlockofBismuthBlock;
import net.mcreator.enlightened_end.block.BlockofmalachiteBlock;
import net.mcreator.enlightened_end.block.ChiseledMalachiteBlock;
import net.mcreator.enlightened_end.block.ChiseledNullstoneBlock;
import net.mcreator.enlightened_end.block.ChiseledVoidShaleBlock;
import net.mcreator.enlightened_end.block.CrackedEndStoneBricksBlock;
import net.mcreator.enlightened_end.block.CrackedEndStoneTilesBlock;
import net.mcreator.enlightened_end.block.CrackedMalachiteBricksBlock;
import net.mcreator.enlightened_end.block.CrackedMalachiteTilesBlock;
import net.mcreator.enlightened_end.block.CrackedNullstoneBricksBlock;
import net.mcreator.enlightened_end.block.CrackedPalerockTilesBlock;
import net.mcreator.enlightened_end.block.CrackedPurpurBlock;
import net.mcreator.enlightened_end.block.CrackedVoidShaleBricksBlock;
import net.mcreator.enlightened_end.block.CrackedVoidShaleTilesBlock;
import net.mcreator.enlightened_end.block.DazzlingBismuthBlockBlock;
import net.mcreator.enlightened_end.block.DazzlingBismuthSheetStairsBlock;
import net.mcreator.enlightened_end.block.DazzlingBismuthSheetsBlock;
import net.mcreator.enlightened_end.block.DazzlingBismuthSlabBlock;
import net.mcreator.enlightened_end.block.DazzlingBismuthWallBlock;
import net.mcreator.enlightened_end.block.DepletedIrradiumBrickWallBlock;
import net.mcreator.enlightened_end.block.DepletedSacrificalStatueBlock;
import net.mcreator.enlightened_end.block.DepletedUraniumBlockBlock;
import net.mcreator.enlightened_end.block.DepletedUraniumBrickSlabBlock;
import net.mcreator.enlightened_end.block.DepletedUraniumBrickStairsBlock;
import net.mcreator.enlightened_end.block.DepletedUraniumBricksBlock;
import net.mcreator.enlightened_end.block.EndBismuthOreBlock;
import net.mcreator.enlightened_end.block.EndStoneSlabBlock;
import net.mcreator.enlightened_end.block.EndStoneStairsBlock;
import net.mcreator.enlightened_end.block.EndStoneTileSlabBlock;
import net.mcreator.enlightened_end.block.EndStoneTileStairsBlock;
import net.mcreator.enlightened_end.block.EndStoneTileWallBlock;
import net.mcreator.enlightened_end.block.EndStoneTilesBlock;
import net.mcreator.enlightened_end.block.EndStoneWallBlock;
import net.mcreator.enlightened_end.block.EtherealBismuthBlockBlock;
import net.mcreator.enlightened_end.block.EtherealBismuthSheetWallBlock;
import net.mcreator.enlightened_end.block.EtherealBismuthSheetsBlock;
import net.mcreator.enlightened_end.block.EtherealBismuthSheetsSlabBlock;
import net.mcreator.enlightened_end.block.EtherealBismuthStairsBlock;
import net.mcreator.enlightened_end.block.FreezingTotemBlock;
import net.mcreator.enlightened_end.block.FrostburnIceBlock;
import net.mcreator.enlightened_end.block.FrostburntVoidshaleBlock;
import net.mcreator.enlightened_end.block.GasVentBlock;
import net.mcreator.enlightened_end.block.GasVentBottomBlock;
import net.mcreator.enlightened_end.block.GasVentHeliumBlock;
import net.mcreator.enlightened_end.block.GasVentLavaBlock;
import net.mcreator.enlightened_end.block.GasVentMiddleBlock;
import net.mcreator.enlightened_end.block.GasVentOozeBlock;
import net.mcreator.enlightened_end.block.GasVentWaterBlock;
import net.mcreator.enlightened_end.block.GasVentXenonBlock;
import net.mcreator.enlightened_end.block.GlaciumBlockBlock;
import net.mcreator.enlightened_end.block.GlaciumBrickSlabBlock;
import net.mcreator.enlightened_end.block.GlaciumBrickStairsBlock;
import net.mcreator.enlightened_end.block.GlaciumBrickWallBlock;
import net.mcreator.enlightened_end.block.GlaciumBricksBlock;
import net.mcreator.enlightened_end.block.HeliumLanternBlock;
import net.mcreator.enlightened_end.block.IridescentBismuthBlockBlock;
import net.mcreator.enlightened_end.block.IridescentBismuthSheetsBlock;
import net.mcreator.enlightened_end.block.IridescentBismuthSlabBlock;
import net.mcreator.enlightened_end.block.IridescentBismuthStairsBlock;
import net.mcreator.enlightened_end.block.IridescentBismuthWallBlock;
import net.mcreator.enlightened_end.block.IrradiumBlockBlock;
import net.mcreator.enlightened_end.block.IrradiumBrickSlabBlock;
import net.mcreator.enlightened_end.block.IrradiumBrickStairsBlock;
import net.mcreator.enlightened_end.block.IrradiumBrickWallBlock;
import net.mcreator.enlightened_end.block.MalachiteBrickSlabBlock;
import net.mcreator.enlightened_end.block.MalachiteBrickStairsBlock;
import net.mcreator.enlightened_end.block.MalachiteBrickWallBlock;
import net.mcreator.enlightened_end.block.MalachiteBricksBlock;
import net.mcreator.enlightened_end.block.MalachiteOreBlock;
import net.mcreator.enlightened_end.block.MalachiteSlabBlock;
import net.mcreator.enlightened_end.block.MalachiteStairsBlock;
import net.mcreator.enlightened_end.block.MalachiteTIlesBlock;
import net.mcreator.enlightened_end.block.MalachiteTileSlabBlock;
import net.mcreator.enlightened_end.block.MalachiteTileStairsBlock;
import net.mcreator.enlightened_end.block.MalachiteTileWallBlock;
import net.mcreator.enlightened_end.block.MalachiteWallBlock;
import net.mcreator.enlightened_end.block.NuclearFurnaceBlock;
import net.mcreator.enlightened_end.block.NullstoneBlock;
import net.mcreator.enlightened_end.block.NullstoneBrickSlabBlock;
import net.mcreator.enlightened_end.block.NullstoneBrickStairsBlock;
import net.mcreator.enlightened_end.block.NullstoneBrickWallBlock;
import net.mcreator.enlightened_end.block.NullstoneBricksBlock;
import net.mcreator.enlightened_end.block.NullstoneSlabBlock;
import net.mcreator.enlightened_end.block.NullstoneStairsBlock;
import net.mcreator.enlightened_end.block.NullstoneWallBlock;
import net.mcreator.enlightened_end.block.OozeCauldron1Block;
import net.mcreator.enlightened_end.block.OozeCauldron2Block;
import net.mcreator.enlightened_end.block.OozeCauldronFullBlock;
import net.mcreator.enlightened_end.block.OozeTubesBlock;
import net.mcreator.enlightened_end.block.PaleRockTileSlabBlock;
import net.mcreator.enlightened_end.block.PalerockTileStairsBlock;
import net.mcreator.enlightened_end.block.PalerockTileWallBlock;
import net.mcreator.enlightened_end.block.PalerockTilesBlock;
import net.mcreator.enlightened_end.block.PoiseBismuthBlockBlock;
import net.mcreator.enlightened_end.block.PoiseBismuthSheetSlabBlock;
import net.mcreator.enlightened_end.block.PoiseBismuthSheetStairsBlock;
import net.mcreator.enlightened_end.block.PoiseBismuthSheetWallBlock;
import net.mcreator.enlightened_end.block.PoiseBismuthSheetsBlock;
import net.mcreator.enlightened_end.block.PolishedMalachiteBlock;
import net.mcreator.enlightened_end.block.PolishedMalachiteSlabBlock;
import net.mcreator.enlightened_end.block.PolishedMalachiteStairsBlock;
import net.mcreator.enlightened_end.block.PolishedMalachiteWallBlock;
import net.mcreator.enlightened_end.block.PolishedNullstoneBlock;
import net.mcreator.enlightened_end.block.PolishedNullstoneSlabBlock;
import net.mcreator.enlightened_end.block.PolishedNullstoneStairsBlock;
import net.mcreator.enlightened_end.block.PolishedNullstoneWallBlock;
import net.mcreator.enlightened_end.block.PolishedVoidShaleBlock;
import net.mcreator.enlightened_end.block.PolishedVoidShaleSlabBlock;
import net.mcreator.enlightened_end.block.PolishedVoidShaleStairsBlock;
import net.mcreator.enlightened_end.block.PolishedVoidShaleWallBlock;
import net.mcreator.enlightened_end.block.PureRadiumBlockBlock;
import net.mcreator.enlightened_end.block.PurpurWallBlock;
import net.mcreator.enlightened_end.block.RawBismuthBlockBlock;
import net.mcreator.enlightened_end.block.SacrificalStatueBlock;
import net.mcreator.enlightened_end.block.SereneBismuthBlockBlock;
import net.mcreator.enlightened_end.block.SereneBismuthSheetSlabBlock;
import net.mcreator.enlightened_end.block.SereneBismuthSheetStairsBlock;
import net.mcreator.enlightened_end.block.SereneBismuthSheetWallBlock;
import net.mcreator.enlightened_end.block.SereneBismuthSheetsBlock;
import net.mcreator.enlightened_end.block.SmoothPurpurBlock;
import net.mcreator.enlightened_end.block.SmoothPurpurSlabBlock;
import net.mcreator.enlightened_end.block.SmoothPurpurStairsBlock;
import net.mcreator.enlightened_end.block.SmoothPurpurWallBlock;
import net.mcreator.enlightened_end.block.UraniumLampBlock;
import net.mcreator.enlightened_end.block.UraniumLampOffBlock;
import net.mcreator.enlightened_end.block.VerdantBismuthBlockBlock;
import net.mcreator.enlightened_end.block.VerdantBismuthSheetSlabBlock;
import net.mcreator.enlightened_end.block.VerdantBismuthSheetStairsBlock;
import net.mcreator.enlightened_end.block.VerdantBismuthSheetWallBlock;
import net.mcreator.enlightened_end.block.VerdantBismuthSheetsBlock;
import net.mcreator.enlightened_end.block.VoidShaleBlock;
import net.mcreator.enlightened_end.block.VoidShaleBrickSlabBlock;
import net.mcreator.enlightened_end.block.VoidShaleBrickStairsBlock;
import net.mcreator.enlightened_end.block.VoidShaleBrickWallBlock;
import net.mcreator.enlightened_end.block.VoidShaleBricksBlock;
import net.mcreator.enlightened_end.block.VoidShaleButtonBlock;
import net.mcreator.enlightened_end.block.VoidShalePressurePlateBlock;
import net.mcreator.enlightened_end.block.VoidShaleSlabBlock;
import net.mcreator.enlightened_end.block.VoidShaleStairsBlock;
import net.mcreator.enlightened_end.block.VoidShaleTileSlabBlock;
import net.mcreator.enlightened_end.block.VoidShaleTileWallBlock;
import net.mcreator.enlightened_end.block.VoidShaleTilesBlock;
import net.mcreator.enlightened_end.block.VoidShaleWallBlock;
import net.mcreator.enlightened_end.block.VoidshaleTileStairsBlock;
import net.mcreator.enlightened_end.block.VoidsteelBlockBlock;
import net.mcreator.enlightened_end.block.VoidsteelOreBlock;
import net.mcreator.enlightened_end.block.WaxedBismuthBlock;
import net.mcreator.enlightened_end.block.WaxedBismuthBlockBlock;
import net.mcreator.enlightened_end.block.WaxedBismuthSheetWallBlock;
import net.mcreator.enlightened_end.block.WaxedBismuthSlabBlock;
import net.mcreator.enlightened_end.block.WaxedBismuthStairsBlock;
import net.mcreator.enlightened_end.block.XenonLanternBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = {SmoothPurpurBlock.class, SmoothPurpurStairsBlock.class, SmoothPurpurSlabBlock.class, SmoothPurpurWallBlock.class,
        CrackedPurpurBlock.class, PurpurWallBlock.class, EndStoneStairsBlock.class, EndStoneSlabBlock.class,
        CrackedEndStoneBricksBlock.class, CrackedEndStoneTilesBlock.class, EndStoneTilesBlock.class, EndStoneTileStairsBlock.class,
        EndStoneTileSlabBlock.class, EndStoneTileWallBlock.class, ChiseledNullstoneBlock.class, NullstoneBlock.class,
        NullstoneStairsBlock.class, NullstoneSlabBlock.class, NullstoneWallBlock.class, PolishedNullstoneBlock.class,
        PolishedNullstoneStairsBlock.class, PolishedNullstoneSlabBlock.class, PolishedNullstoneWallBlock.class,
        CrackedNullstoneBricksBlock.class, NullstoneBricksBlock.class, NullstoneBrickStairsBlock.class, NullstoneBrickSlabBlock.class,
        NullstoneBrickWallBlock.class, CrackedPalerockTilesBlock.class, PalerockTilesBlock.class, PalerockTileStairsBlock.class,
        PaleRockTileSlabBlock.class, PalerockTileWallBlock.class, ChiseledVoidShaleBlock.class, VoidShaleBlock.class,
        VoidShaleStairsBlock.class, VoidShaleSlabBlock.class, VoidShaleWallBlock.class, VoidShalePressurePlateBlock.class,
        VoidShaleButtonBlock.class, PolishedVoidShaleBlock.class, PolishedVoidShaleStairsBlock.class, PolishedVoidShaleSlabBlock.class,
        PolishedVoidShaleWallBlock.class, CrackedVoidShaleBricksBlock.class, VoidShaleBricksBlock.class, VoidShaleBrickStairsBlock.class,
        VoidShaleBrickSlabBlock.class, VoidShaleBrickWallBlock.class, CrackedVoidShaleTilesBlock.class, VoidShaleTilesBlock.class,
        VoidshaleTileStairsBlock.class, VoidShaleTileSlabBlock.class, VoidShaleTileWallBlock.class, AbyssalEyliumBlock.class,
        OozeTubesBlock.class, GasVentBlock.class, FrostburntVoidshaleBlock.class, FrostburnIceBlock.class,
        FreezingTotemBlock.class, SacrificalStatueBlock.class, DepletedSacrificalStatueBlock.class, GlaciumBlockBlock.class,
        GlaciumBricksBlock.class, GlaciumBrickStairsBlock.class, GlaciumBrickSlabBlock.class, GlaciumBrickWallBlock.class,
        XenonLanternBlock.class, HeliumLanternBlock.class, MalachiteOreBlock.class, ChiseledMalachiteBlock.class,
        BlockofmalachiteBlock.class, MalachiteStairsBlock.class, MalachiteSlabBlock.class, MalachiteWallBlock.class,
        PolishedMalachiteBlock.class, PolishedMalachiteStairsBlock.class, PolishedMalachiteSlabBlock.class, PolishedMalachiteWallBlock.class,
        CrackedMalachiteBricksBlock.class, MalachiteBricksBlock.class, MalachiteBrickStairsBlock.class, MalachiteBrickSlabBlock.class,
        MalachiteBrickWallBlock.class, CrackedMalachiteTilesBlock.class, MalachiteTIlesBlock.class, MalachiteTileStairsBlock.class,
        MalachiteTileSlabBlock.class, MalachiteTileWallBlock.class, IrradiumBlockBlock.class, PureRadiumBlockBlock.class,
        IrradiumBrickStairsBlock.class, IrradiumBrickSlabBlock.class, IrradiumBrickWallBlock.class, NuclearFurnaceBlock.class,
        UraniumLampBlock.class, DepletedUraniumBlockBlock.class, DepletedUraniumBricksBlock.class, DepletedUraniumBrickStairsBlock.class,
        DepletedUraniumBrickSlabBlock.class, DepletedIrradiumBrickWallBlock.class, RawBismuthBlockBlock.class, EndBismuthOreBlock.class,
        BlockofBismuthBlock.class, BismuthBlockBlock.class, BismuthSheetStairsBlock.class, BismuthSheetSlabBlock.class,
        BismuthWallBlock.class, WaxedBismuthBlockBlock.class, WaxedBismuthBlock.class, WaxedBismuthStairsBlock.class,
        WaxedBismuthSlabBlock.class, WaxedBismuthSheetWallBlock.class, DazzlingBismuthBlockBlock.class, DazzlingBismuthSheetsBlock.class,
        DazzlingBismuthSheetStairsBlock.class, DazzlingBismuthSlabBlock.class, DazzlingBismuthWallBlock.class, VerdantBismuthBlockBlock.class,
        VerdantBismuthSheetsBlock.class, VerdantBismuthSheetStairsBlock.class, VerdantBismuthSheetSlabBlock.class, VerdantBismuthSheetWallBlock.class,
        PoiseBismuthBlockBlock.class, PoiseBismuthSheetsBlock.class, PoiseBismuthSheetStairsBlock.class, PoiseBismuthSheetSlabBlock.class,
        PoiseBismuthSheetWallBlock.class, EtherealBismuthBlockBlock.class, EtherealBismuthSheetsBlock.class, EtherealBismuthStairsBlock.class,
        EtherealBismuthSheetsSlabBlock.class, EtherealBismuthSheetWallBlock.class, SereneBismuthBlockBlock.class, SereneBismuthSheetsBlock.class,
        SereneBismuthSheetStairsBlock.class, SereneBismuthSheetSlabBlock.class, SereneBismuthSheetWallBlock.class, IridescentBismuthSheetsBlock.class,
        IridescentBismuthStairsBlock.class, IridescentBismuthSlabBlock.class, IridescentBismuthWallBlock.class, IridescentBismuthBlockBlock.class,
        VoidsteelOreBlock.class, VoidsteelBlockBlock.class, UraniumLampOffBlock.class, GasVentMiddleBlock.class,
        GasVentOozeBlock.class, GasVentBottomBlock.class, GasVentWaterBlock.class, GasVentLavaBlock.class,
        GasVentXenonBlock.class, GasVentHeliumBlock.class, OozeCauldronFullBlock.class, OozeCauldron2Block.class,
        OozeCauldron1Block.class, EndStoneWallBlock.class
})
public abstract class CanHarvestMixin extends Block {
    public CanHarvestMixin(Properties pProperties) {
        super(pProperties);
    }

    // All these blocks check whether the tool is an instance of the tool's class,
    // or check the tier directly. Very unnecessary when the super should do that when the block is tagged correctly,
    // and mods circumventing that super won't have it applied
    @Override
    public boolean canHarvestBlock(BlockState state, BlockGetter level, BlockPos pos, Player player) {
        return super.canHarvestBlock(state, level, pos, player);
    }
}
