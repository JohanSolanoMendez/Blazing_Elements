package net.bizwiz;

import net.bizwiz.block.ModBlocks;
import net.bizwiz.item.ModItemGroup;
import net.bizwiz.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlazingElements implements ModInitializer {
	public static final String MOD_ID = "blazingelements";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroup.registerItemGroup();
		ModBlocks.registerModBlocks();
	}
}