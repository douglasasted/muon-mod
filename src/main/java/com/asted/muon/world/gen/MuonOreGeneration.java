package com.asted.muon.world.gen;

import com.asted.muon.world.feature.MuonPlacedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

public class MuonOreGeneration
{
    public static void generateOres(final BiomeLoadingEvent event)
    {
        List<Holder<PlacedFeature>> base =
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        base.add(MuonPlacedFeatures.AMBER_ORE_PLACED);
    }
}
