package com.github.voidleech.voided_enlightenment.mixin.cerulean_stalk;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.mcreator.enlightened_end.init.EnlightenedEndModBlocks;
import net.mcreator.enlightened_end.procedures.EbonyStalkBlockValidPlacementConditionProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(EbonyStalkBlockValidPlacementConditionProcedure.class)
public class PlacementMixin {
    @ModifyReturnValue(method = "execute", at = @At("RETURN"), remap = false)
    private static boolean ve$stalkOnFreshlyPlantedToo(boolean original, LevelAccessor level, double x, double y, double z){
        return original || level.getBlockState(BlockPos.containing(x, y + 1, z)).getBlock() == EnlightenedEndModBlocks.CERULEAN_STALK_0.get();
    }
}
