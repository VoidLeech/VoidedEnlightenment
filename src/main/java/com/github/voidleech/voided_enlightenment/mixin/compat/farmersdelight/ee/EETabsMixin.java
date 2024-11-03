package com.github.voidleech.voided_enlightenment.mixin.compat.farmersdelight.ee;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.mcreator.enlightened_end.init.EnlightenedEndModTabs;
import net.minecraft.world.item.CreativeModeTab;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;

@Debug(export = true)
@Mixin(EnlightenedEndModTabs.class)
public abstract class EETabsMixin {
    /**
     * @reason Just no. This tab has no right to exist. The knife could've perfectly sat in the base mod creative tab.
     * But since the base mod knife is botched anyhow it's better to axe the tab entirely.
     * @return An empty tab, no items, title, or icon, whose existence can only be traced by an empty hole where the tab should sit.
     */
    // That hole *is* undesirable imo and why I completely deny registration of the tab in DeferredRegisterMixin.
    // Other mods adding an item to this tab should see it get added to the main tab instead.

    // (This mixin is redundant since the supplier's never called due to the above,
    // but I'm keeping it around in case an incompatibility comes up that warrants disabling that mixin)
    @WrapMethod(method = "lambda$static$5") // Lambda for the CreativeModeTab supplier for the Compatibility tab
    private static CreativeModeTab voided_enlightenment$emptyOutCompatTab(Operation<CreativeModeTab> original){
        return CreativeModeTab.builder()
                .build();
    }
}
