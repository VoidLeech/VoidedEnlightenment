package com.github.voidleech.voided_enlightenment.mixin.compat.farmersdelight.forge;

import com.github.voidleech.voided_enlightenment.VoidedEnlightenment;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.mcreator.enlightened_end.init.EnlightenedEndModTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.function.Supplier;

@Mixin(DeferredRegister.class)
public abstract class DeferredRegisterMixin {
    @Shadow @Final private String modid;

    /** Completely removes Enlightend's compatibility tab and just makes the field point at
     * @reason See EETabsMixin for reasoning.
     */
    @WrapMethod(method = "register(Ljava/lang/String;Ljava/util/function/Supplier;)Lnet/minecraftforge/registries/RegistryObject;", remap = false)
    private <I> RegistryObject<I> voided_enlightenment$pointCompatTabAtBaseTab(String name, Supplier<? extends I> sup, Operation<RegistryObject<I>> original){
        if (modid.equals("enlightened_end") && name.equals("compatability" /*[sic]*/)) {
            VoidedEnlightenment.LOGGER.warn("Prevented EnlightenedEndModTabs.COMPATABILITY from registering, should now point at EnlightenedEndModTabs.EE_BUILDING");
            return (RegistryObject<I>) EnlightenedEndModTabs.EE_BUILDING;
        }
        return original.call(name, sup);
    }
}
