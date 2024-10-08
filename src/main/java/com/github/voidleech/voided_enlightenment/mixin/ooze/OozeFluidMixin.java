package com.github.voidleech.voided_enlightenment.mixin.ooze;

import com.github.voidleech.oblivion.hackyMixinUtils.propertyRebuilders.FluidTypePropertiesRebuilder;
import net.mcreator.enlightened_end.fluid.types.OozeFluidFluidType;
import net.minecraftforge.fluids.FluidType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(OozeFluidFluidType.class)
public class OozeFluidMixin extends FluidType {
    public OozeFluidMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void voided_enlightenment$newOozeProperties(CallbackInfo ci){
        FluidTypePropertiesRebuilder.of(this)
                .canConvertToSource(false)
                .canSwim(false)
                .viscosity(2000) // double the viscosity of water
                .finalizeRebuild();
    }
}
