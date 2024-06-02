package net.bizwiz.item;

import net.bizwiz.BlazingElements;
import net.bizwiz.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
public class ModItemGroup {
    public static final ItemGroup BLAZING_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(BlazingElements.MOD_ID,"blazingtab"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.blazingtab"))
                    .icon(() -> new ItemStack(ModItems.PRIMORDIALFIREGEM)).entries((displayContext, entries) -> {
                        entries.add(ModItems.PRIMORDIALFIREGEM);
                        entries.add(ModItems.BOULDROSROD);
                        entries.add(ModItems.BRINEROD);
                        entries.add(ModItems.BRINEPOWDER);
                        entries.add(ModItems.BLAZINGPICKAXE);
                        entries.add(ModItems.UNCHARGEELEMENTALSWORD);
                        entries.add(ModBlocks.PEDESTALSWORD);
                    }).build());
    public static void registerItemGroup(){
        BlazingElements.LOGGER.info("Registering Item Groups for " +
                BlazingElements.MOD_ID);
    }
}
