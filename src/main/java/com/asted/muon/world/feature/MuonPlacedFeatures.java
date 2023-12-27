package com.asted.muon.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class MuonPlacedFeatures
{
    public static final Holder<PlacedFeature> AMBER_ORE_PLACED = PlacementUtils.register("amber_ore_placed",
            MuonConfiguredFeatures.AMBER_ORE, MuonOrePlacement.commonOrePlacement(4,
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
}
