package com.github.voidleech.voided_enlightenment.mixin.ooze;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.mcreator.enlightened_end.fluid.types.OozeFluidFluidType;
import net.minecraftforge.fluids.FluidType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(OozeFluidFluidType.class)
public abstract class OozeFluidMixin extends FluidType {
    public OozeFluidMixin(Properties properties) {
        super(properties);
    }

    @ModifyExpressionValue(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/fluids/FluidType$Properties;canConvertToSource(Z)Lnet/minecraftforge/fluids/FluidType$Properties;"))
    private static Properties voided_enlightenment$newOozeProperties(Properties original){
        return original
                .canConvertToSource(false)
                .canSwim(false)
                .viscosity(2000); // double the viscosity of water
    }
}
