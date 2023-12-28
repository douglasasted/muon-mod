package com.asted.muon.setup;

import com.asted.muon.Muon;
import net.minecraft.client.Minecraft;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class Registration
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Muon.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Muon.MOD_ID);

    public static void init()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        // Registering all blocks and items on the mod
        BLOCKS.register(bus);
        ITEMS.register(bus);
    }

    // Registering a block
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    // Registering the item for a block
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab)
    {
        return ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    // Items
    public static final RegistryObject<Item> AMBER_SHARD = ITEMS.register("amber_shard", () -> new Item(new Item.Properties().tab(ModSetup.MUON_TAB)));
    public static final RegistryObject<Item> AMBER = ITEMS.register("amber", () -> new Item(new Item.Properties().tab(ModSetup.MUON_TAB)));

    // Blocks

    //region Amber
    public static final RegistryObject<Block> AMBER_ORE = registerBlock("amber_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3.0f, 3f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), ModSetup.MUON_TAB);
    public static final RegistryObject<Block> DEEPSLATE_AMBER_ORE = registerBlock("deepslate_amber_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.DEEPSLATE).color(MaterialColor.DEEPSLATE).strength(4.5f, 3f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), ModSetup.MUON_TAB);
    public static final RegistryObject<Block> AMBER_BLOCK = registerBlock("amber_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0f, 6.0f).requiresCorrectToolForDrops()), ModSetup.MUON_TAB);

    public static final RegistryObject<Block> POLISHED_AMBER = registerBlock("polished_amber",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).sound(SoundType.POLISHED_DEEPSLATE)), ModSetup.MUON_TAB);
    public static final RegistryObject<Block> AMBER_TILES = registerBlock("amber_tiles",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).sound(SoundType.DEEPSLATE_TILES)), ModSetup.MUON_TAB);
    public static final RegistryObject<Block> AMBER_BRICKS = registerBlock("amber_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).sound(SoundType.DEEPSLATE_BRICKS)), ModSetup.MUON_TAB);
    public static final RegistryObject<Block> CHISELED_AMBER = registerBlock("chiseled_amber",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).sound(SoundType.DEEPSLATE_BRICKS)), ModSetup.MUON_TAB);
    //endregion
}