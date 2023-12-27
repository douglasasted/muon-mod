package com.asted.muon.world.feature;

import com.asted.muon.setup.Registration;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

import java.util.List;

public class MuonConfiguredFeatures
{
    // Amber Ore
    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_AMBER_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, Registration.AMBER_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, Registration.DEEPSLATE_AMBER_ORE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> AMBER_ORE = FeatureUtils.register("amber_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_AMBER_ORES, 8));
}
