package com.asted.muon.datagen;

import com.asted.muon.Muon;
import com.asted.muon.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class MuonBlocksStateProvider extends BlockStateProvider
{
    public MuonBlocksStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper)
    {
        super(gen, Muon.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        simpleBlockWithItem(Registration.AMBER_ORE.get());
        simpleBlockWithItem(Registration.DEEPSLATE_AMBER_ORE.get());
        simpleBlockWithItem(Registration.AMBER_BLOCK.get());

        simpleBlockWithItem(Registration.POLISHED_AMBER.get());
        simpleBlockWithItem(Registration.AMBER_TILES.get());
        simpleBlockWithItem(Registration.AMBER_BRICKS.get());
        simpleBlockWithItem(Registration.CHISELED_AMBER.get());
    }

    private void simpleBlockWithItem(Block block)
    {
        String blockName = ForgeRegistries.BLOCKS.getKey(block).getPath();

        simpleBlock(block);
        itemModels().withExistingParent(blockName, new ResourceLocation(Muon.MOD_ID, "block/" + blockName));
    }
}
