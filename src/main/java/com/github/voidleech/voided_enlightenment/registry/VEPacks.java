package com.github.voidleech.voided_enlightenment.registry;

import com.github.voidleech.oblivion.util.Registration;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;

public class VEPacks {
    public static final Registration.PackData VE = new Registration.PackData("voided_enlightenment", Component.literal("VE: Asset Overrides"), true, true, PackType.CLIENT_RESOURCES);
}
