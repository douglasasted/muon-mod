package com.asted.muon.setup;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class ModSetup
{
    public static final CreativeModeTab MUON_TAB = new CreativeModeTab("muon") {
        @Override
        public ItemStack makeIcon() { return new ItemStack(Registration.AMBER.get()); }
    };

    public static void init(FMLCommonSetupEvent event)
    {

    }
}
