package com.github.voidleech.voided_enlightenment.event;

import net.mcreator.enlightened_end.init.EnlightenedEndModEntities;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public class MobEvents {
    private static void noLeviathan(MobSpawnEvent.FinalizeSpawn event){
        if (event.getEntity().getType() == EnlightenedEndModEntities.VOID_LEVIATHAN.get()){
            event.setSpawnCancelled(true);
        }
    }

    public static void register(IEventBus eventBus){
        eventBus.addListener(MobEvents::noLeviathan);
    }
}
