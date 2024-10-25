package com.github.voidleech.voided_enlightenment.mixin.ooze.vanilla;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(Blocks.class)
public abstract class BlocksMixinForCauldron {

    // Cauldron ticking is handled from pointed dripstone's random ticking, and ooze rain isn't precipitation, so we have to do this
    @ModifyExpressionValue(method = "<clinit>",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;of()Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;",
                    ordinal = 0
            ),
            slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=cauldron")))
    private static BlockBehaviour.Properties voided_enlightenment$makeCauldronTick(BlockBehaviour.Properties original){
        return original.randomTicks();
    }
}
