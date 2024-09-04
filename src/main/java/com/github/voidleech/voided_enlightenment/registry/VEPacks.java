package com.github.voidleech.voided_enlightenment.registry;

import com.github.voidleech.oblivion.registry.AbstractOblivionPacks;
import com.github.voidleech.voided_enlightenment.VoidedEnlightenment;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Tuple;

import java.util.Map;

public class VEPacks extends AbstractOblivionPacks {
    private static final Map<String, Tuple<Component, Boolean>> DESCRIPTIONS = Map.of(
            "voided_enlightenment", new Tuple<>(Component.literal("Enlightend asset overrides"), true));

    public VEPacks() {
        super(DESCRIPTIONS, VoidedEnlightenment.MOD_ID, "VE");
    }
}