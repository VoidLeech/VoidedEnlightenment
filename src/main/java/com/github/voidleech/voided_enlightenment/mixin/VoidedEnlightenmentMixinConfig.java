package com.github.voidleech.voided_enlightenment.mixin;

import com.github.voidleech.oblivion.mixin.plugin.AbstractOblivionMixinPlugin;
import com.github.voidleech.oblivion.mixin.plugin.Condition;

import java.util.Map;

public class VoidedEnlightenmentMixinConfig extends AbstractOblivionMixinPlugin {
    public VoidedEnlightenmentMixinConfig(){
        super("com.github.voidleech.voided_enlightenment.mixin.", Map.of(
                "compat.farmersdelight.ee.AdamantiteKnifeMixin", always,
                "compat.farmersdelight.ee.EETabsMixin", always,
                "compat.farmersdelight.forge.DeferredRegisterMixin", always
                ));
    }

    private static final Condition always = Condition.Builder.always().build();
}
