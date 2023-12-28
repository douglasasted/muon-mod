package com.asted.muon.datagen.loot;

import com.asted.muon.setup.Registration;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

public class MuonBlockLootTables extends BlockLoot
{
    @Override
    protected void addTables()
    {
        this.add(Registration.AMBER_ORE.get(), MuonBlockLootTables::createAmberOreDrops);
        this.add(Registration.DEEPSLATE_AMBER_ORE.get(), MuonBlockLootTables::createAmberOreDrops);
        this.dropSelf(Registration.AMBER_BLOCK.get());

        this.dropSelf(Registration.POLISHED_AMBER.get());
        this.dropSelf(Registration.AMBER_TILES.get());
        this.dropSelf(Registration.AMBER_BRICKS.get());
        this.dropSelf(Registration.CHISELED_AMBER.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks()
    {
        return Registration.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    // Common loot tables

    protected static LootTable.Builder createAmberOreDrops(Block pBlock)
    {
        return createSilkTouchDispatchTable(pBlock, applyExplosionDecay(pBlock, LootItem.lootTableItem(Registration.AMBER_SHARD.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }
}