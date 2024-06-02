package net.bizwiz.block;

import com.eliotlash.mclib.math.functions.classic.Mod;
import net.bizwiz.BlazingElements;
import net.bizwiz.item.ModItems;
import net.fabricmc.fabric.api.block.v1.FabricBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block PEDESTALSWORD = registerBlock("pedestal_elemental_sword",
            new PedestalElementalSwordBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).sounds(BlockSoundGroup.DEEPSLATE), ModItems.UNCHARGEELEMENTALSWORD));

    public static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BlazingElements.MOD_ID,
                name),block);
    }

    public static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(
                BlazingElements.MOD_ID,name
        ),new BlockItem(block,new FabricItemSettings()));
    }
    public static void registerModBlocks(){
        BlazingElements.LOGGER.info("Registering Mod Blocks for " +
                BlazingElements.MOD_ID);
    }
}
