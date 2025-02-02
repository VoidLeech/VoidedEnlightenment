package com.github.voidleech.voided_enlightenment.mixin.recalcitrantDrops;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.mcreator.enlightened_end.block.LaserBlock;
import net.mcreator.enlightened_end.block.LaserOnBlock;
import net.mcreator.enlightened_end.block.MalachitePanelBlock;
import net.mcreator.enlightened_end.block.MalachitePanelHorizontalBlock;
import net.mcreator.enlightened_end.block.MalachiteReflectorDownBlock;
import net.mcreator.enlightened_end.block.MalachiteReflectorDownOnBlock;
import net.mcreator.enlightened_end.block.MalachiteReflectorHorizontalOnBlock;
import net.mcreator.enlightened_end.block.MalachiteReflectorVeritcalOnBlock;
import net.mcreator.enlightened_end.block.RawUraniumBlockBlock;
import net.mcreator.enlightened_end.block.TeleporterBlock;
import net.mcreator.enlightened_end.block.UraniumOreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = {TeleporterBlock.class, UraniumOreBlock.class, RawUraniumBlockBlock.class, MalachitePanelBlock.class,
        MalachitePanelHorizontalBlock.class, MalachiteReflectorVeritcalOnBlock.class, MalachiteReflectorHorizontalOnBlock.class,
        MalachiteReflectorDownBlock.class, MalachiteReflectorDownOnBlock.class, LaserOnBlock.class, LaserBlock.class
})
public abstract class RequiresToolForDropsPropertyMixin {

    @ModifyExpressionValue(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;of()Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"))

    private static BlockBehaviour.Properties voided_enlightenment$requireToolForDrop(BlockBehaviour.Properties original){
        return original.requiresCorrectToolForDrops();
    }
}
