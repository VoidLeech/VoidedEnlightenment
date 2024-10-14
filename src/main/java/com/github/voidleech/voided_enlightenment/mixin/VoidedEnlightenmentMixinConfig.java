package com.github.voidleech.voided_enlightenment.mixin;

import com.github.voidleech.oblivion.mixin.plugin.AbstractOblivionMixinPlugin;

import java.util.Map;

public class VoidedEnlightenmentMixinConfig extends AbstractOblivionMixinPlugin {
    public VoidedEnlightenmentMixinConfig(){
        super("com.github.voidleech.voided_enlightenment.mixin.", Map.of(
                "compat.create.c.VanillaFluidTargetsMixin", "create"
                ));
    }
}
