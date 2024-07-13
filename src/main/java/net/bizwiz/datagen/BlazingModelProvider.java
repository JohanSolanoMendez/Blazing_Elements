package net.bizwiz.datagen;

import net.bizwiz.BlazingElements;
import net.bizwiz.item.BlazingItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class BlazingModelProvider extends FabricModelProvider {
    public BlazingModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //Tools
        itemModelGenerator.register(BlazingItems.UNCHARGEELEMENTALSWORD, Models.HANDHELD);
        itemModelGenerator.register(BlazingItems.BLAZINGPICKAXE, Models.HANDHELD);

        //Items
        itemModelGenerator.register(BlazingItems.BRINEPOWDER, Models.GENERATED);
        itemModelGenerator.register(BlazingItems.BRINEROD, Models.HANDHELD);
        itemModelGenerator.register(BlazingItems.BOULDROSROD, Models.HANDHELD);
        itemModelGenerator.register(BlazingItems.PRIMORDIALFIREGEM, Models.GENERATED);
        itemModelGenerator.register(BlazingItems.BOULDROSBOULDER, Models.GENERATED);
    }
}
