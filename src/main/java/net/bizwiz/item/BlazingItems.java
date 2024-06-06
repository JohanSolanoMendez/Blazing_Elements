package net.bizwiz.item;

import net.bizwiz.BlazingElements;
import net.bizwiz.item.custom.BlazingPickaxe;
import net.bizwiz.item.custom.UnchargedElementalSword;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class BlazingItems {

    //Items
    public static final Item PRIMORDIALFIREGEM = registerItem("primordialfiregem",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static final Item BOULDROSROD = registerItem("bouldrosrod",
            new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item BRINEROD = registerItem("brinerod",
            new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item BRINEPOWDER = registerItem("brinepowder",
            new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item BLAZINGPICKAXE = registerItem("blazingpickaxe",
            new BlazingPickaxe(BlazingToolMaterial.BLAZE,2,3f,new FabricItemSettings()));
    public static final Item UNCHARGEELEMENTALSWORD = registerItem("unchargeelementalsword",
            new UnchargedElementalSword(BlazingToolMaterial.ANCIENT,2,1f,new FabricItemSettings().rarity(Rarity.EPIC)));
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM,new Identifier(BlazingElements.MOD_ID,name),item);
    }

    public static void registerModItems(){
        BlazingElements.LOGGER.info("Registering Mod Items for " + BlazingElements.MOD_ID);
    }
}
