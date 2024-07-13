package net.bizwiz;

import net.bizwiz.datagen.BlazingAdvancementProvider;
import net.bizwiz.datagen.BlazingItemTagProvider;
import net.bizwiz.datagen.BlazingModelProvider;
import net.bizwiz.datagen.BlazingRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class BlazingElementsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(BlazingItemTagProvider::new);
		pack.addProvider(BlazingModelProvider::new);
		pack.addProvider(BlazingRecipeProvider::new);
		pack.addProvider(BlazingAdvancementProvider::new);
	}
}
