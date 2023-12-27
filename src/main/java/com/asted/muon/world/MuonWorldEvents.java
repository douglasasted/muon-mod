package com.asted.muon.world;

import com.asted.muon.Muon;
import com.asted.muon.world.gen.MuonOreGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Muon.MOD_ID)
public class MuonWorldEvents
{
    @SubscribeEvent
    public static void BiomeLoadingEvent(final BiomeLoadingEvent event)
    {
        MuonOreGeneration.generateOres(event);
    }
}
