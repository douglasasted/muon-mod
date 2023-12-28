package com.asted.muon.datagen;

import com.asted.muon.setup.Registration;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.client.Minecraft;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class MuonRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    public MuonRecipeProvider(DataGenerator pGenerator)
    {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer)
    {
        // Amber Shard From Amber
        ShapelessRecipeBuilder.shapeless(Registration.AMBER_SHARD.get(), 9).requires(Registration.AMBER.get()).unlockedBy("has_amber", has(Registration.AMBER.get())).save(pFinishedRecipeConsumer);

        // Amber From Amber Shard
        ShapedRecipeBuilder.shaped(Registration.AMBER.get()).define('A', Registration.AMBER_SHARD.get()).pattern("AAA").pattern("AAA").pattern("AAA").unlockedBy("has_amber", has(Registration.AMBER_SHARD.get())).save(pFinishedRecipeConsumer);

        // Amber Block
        ShapedRecipeBuilder.shaped(Registration.AMBER_BLOCK.get()).define('A', Registration.AMBER.get()).pattern("AAA").pattern("AAA").pattern("AAA").unlockedBy("has_amber", has(Registration.AMBER.get())).save(pFinishedRecipeConsumer);

        // Amber From Block
        ShapelessRecipeBuilder.shapeless(Registration.AMBER.get(), 9).requires(Registration.AMBER_BLOCK.get()).unlockedBy("has_amber_block", has(Registration.AMBER_BLOCK.get())).save(pFinishedRecipeConsumer, "amber_from_block");

        // Polished Amber
        amberDecorationBuilder(pFinishedRecipeConsumer, Registration.POLISHED_AMBER.get(), Blocks.POLISHED_DEEPSLATE);

        // Amber Tiles
        amberDecorationBuilder(pFinishedRecipeConsumer, Registration.AMBER_TILES.get(), Blocks.DEEPSLATE_TILES);
        ShapedRecipeBuilder.shaped(Registration.AMBER_TILES.get(), 4).define('O', Registration.AMBER_BRICKS.get()).pattern("OO").pattern("OO").unlockedBy("has_amber_bricks", has(Registration.AMBER_BRICKS.get())).save(pFinishedRecipeConsumer, "amber_tiles_from_amber_bricks");

        // Amber Bricks
        amberDecorationBuilder(pFinishedRecipeConsumer, Registration.AMBER_BRICKS.get(), Blocks.DEEPSLATE_BRICKS);
        ShapedRecipeBuilder.shaped(Registration.AMBER_BRICKS.get(), 4).define('O', Registration.POLISHED_AMBER.get()).pattern("OO").pattern("OO").unlockedBy("has_polished_amber", has(Registration.POLISHED_AMBER.get())).save(pFinishedRecipeConsumer, "amber_bricks_from_polished_amber");

        // Chiseled Amber
        ShapedRecipeBuilder.shaped(Registration.CHISELED_AMBER.get(), 4).define('A', Registration.AMBER.get()).define('S', Registration.AMBER_SHARD.get()).define('O', Blocks.CHISELED_DEEPSLATE).pattern("OSO").pattern("SAS").pattern("OSO").unlockedBy("has_amber", has(Registration.AMBER.get())).save(pFinishedRecipeConsumer);
    }


    // Common shapes

    protected static void amberDecorationBuilder(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pAmberBlock, ItemLike pBlock)
    {
        ShapedRecipeBuilder.shaped(pAmberBlock, 5).define('S', Registration.AMBER_SHARD.get()).define('O', pBlock).pattern("OSO").pattern("SOS").pattern("OSO").unlockedBy("has_amber_shard", has(Registration.AMBER_SHARD.get())).save(pFinishedRecipeConsumer);
    }


    // Utility functions

    // Creates a new InventoryChangeTrigger that checks for a player having a certain item.
    protected static InventoryChangeTrigger.TriggerInstance has(ItemLike pItemLike)
    {
        return inventoryTrigger(ItemPredicate.Builder.item().of(pItemLike).build());
    }
}