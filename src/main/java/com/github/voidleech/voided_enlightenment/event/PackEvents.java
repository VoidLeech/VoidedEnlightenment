package com.github.voidleech.voided_enlightenment.event;

import com.github.voidleech.voided_enlightenment.VoidedEnlightenment;
import net.minecraft.SharedConstants;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.fml.ModList;
import org.apache.commons.lang3.text.WordUtils;

import java.nio.file.Path;
import java.util.Map;

public class PackEvents {
    private static final Map<String, Component> DESCRIPTIONS = Map.of(
            "voided_enlightenment", Component.literal("Enlightend asset overrides"));

    public static void addResourcePacks(AddPackFindersEvent event){
        if (event.getPackType() == PackType.CLIENT_RESOURCES){
            addResourcePack(event, "voided_enlightenment", true);
        }
    }

    private static void addResourcePack(AddPackFindersEvent event, String packName, boolean required){
        Path resourcePath = ModList.get().getModFileById(VoidedEnlightenment.MOD_ID).getFile().findResource("packs/resource/" + packName);
        Pack pack = Pack.create("builtin/" + packName,
                Component.literal("(VE" + (!required ? " Alt" : "") + ") " + WordUtils.capitalize(packName.replace('_', ' ').toLowerCase())),
                required,
                (path) -> new PathPackResources(path, resourcePath, true),
                new Pack.Info(DESCRIPTIONS.getOrDefault(packName, Component.empty()), SharedConstants.getCurrentVersion().getPackVersion(PackType.CLIENT_RESOURCES), FeatureFlagSet.of()),
                PackType.CLIENT_RESOURCES,
                Pack.Position.TOP,
                false,
                PackSource.BUILT_IN
                );
        event.addRepositorySource((packConsumer) -> {packConsumer.accept(pack);});
    }
}