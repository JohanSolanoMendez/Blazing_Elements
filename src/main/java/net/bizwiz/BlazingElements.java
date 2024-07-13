package net.bizwiz;

import net.bizwiz.block.BlazingBlocks;
import net.bizwiz.enchantment.BlazingEnchantments;
import net.bizwiz.item.BlazingItemGroup;
import net.bizwiz.item.BlazingItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlazingElements implements ModInitializer {
	public static final String MOD_ID = "blazingelements";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		BlazingItems.registerModItems();
		BlazingItemGroup.registerItemGroup();
		BlazingBlocks.registerModBlocks();
		BlazingEnchantments.registerModEnchantments();
	}
}