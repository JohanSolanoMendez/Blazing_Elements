package net.bizwiz.item;

import net.bizwiz.BlazingElements;
import net.bizwiz.block.BlazingBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
public class BlazingItemGroup {
    public static final ItemGroup BLAZING_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(BlazingElements.MOD_ID,"blazingtab"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.blazingtab"))
                    .icon(() -> new ItemStack(BlazingItems.PRIMORDIALFIREGEM)).entries((displayContext, entries) -> {
                        entries.add(BlazingItems.PRIMORDIALFIREGEM);
                        entries.add(BlazingItems.BOULDROSROD);
                        entries.add(BlazingItems.BRINEROD);
                        entries.add(BlazingItems.BRINEPOWDER);
                        entries.add(BlazingItems.BLAZINGPICKAXE);
                        entries.add(BlazingItems.UNCHARGEELEMENTALSWORD);
                        entries.add(BlazingBlocks.PEDESTALSWORD);
                        entries.add(BlazingItems.BOULDROSBOULDER);
                        entries.add(BlazingItems.BOULDROSCLAW);
                        entries.add(BlazingItems.BLAZINGSTAFF);
                    }).build());
    public static void registerItemGroup(){
        BlazingElements.LOGGER.info("Registering Item Groups for " +
                BlazingElements.MOD_ID);
    }
}
