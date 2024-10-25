package com.github.voidleech.voided_enlightenment.mixin.ooze.vanilla;

import com.github.voidleech.oblivion.propertyUndoers.IBlockPropertyUndoerExtensions;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(targets = "net.minecraft.world.level.block.state.BlockBehaviour$Properties")
public class BlockBehaviour$PropertiesMixin {
    // Ensure that blocks copying from Cauldron don't take over the isRandomlyTicking value and have to get that as normal by calling randomTicks()
    @ModifyReturnValue(method = "copy", at = @At("RETURN"))
    private static BlockBehaviour.Properties voided_enlightenment$dontCopyRandomTickingFromCauldron(BlockBehaviour.Properties original, @Local(argsOnly = true) BlockBehaviour blockBehaviour){
        if (blockBehaviour instanceof Block block && block == Blocks.CAULDRON){
            return ((IBlockPropertyUndoerExtensions)original).oblivion$noRandomTicks();
        }
        return original;
    }
}
