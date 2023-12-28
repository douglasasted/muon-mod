package com.asted.muon.datagen;

import com.asted.muon.Muon;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Muon.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(new MuonRecipeProvider(generator));
        generator.addProvider(new MuonLootTableProvider(generator));
        generator.addProvider(new MuonBlocksStateProvider(generator, existingFileHelper));
        generator.addProvider(new MuonItemModelProvider(generator, existingFileHelper));
    }
}
