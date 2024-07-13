package net.bizwiz.item;

import net.bizwiz.BlazingElements;
import net.bizwiz.item.custom.BlazingPickaxe;
import net.bizwiz.item.custom.BlazingStaff;
import net.bizwiz.item.custom.BouldrosClaw;
import net.bizwiz.item.custom.UnchargedElementalSword;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class BlazingItems {

    //Items
    public static final Item PRIMORDIALFIREGEM = registerItem("primordial_fire_gem",
            new Item(new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static final Item BOULDROSROD = registerItem("bouldros_rod",
            new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item BOULDROSBOULDER = registerItem("bouldros_boulder",
            new Item(new FabricItemSettings().rarity(Rarity.COMMON)));
    public static final Item BRINEROD = registerItem("brine_rod",
            new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item BRINEPOWDER = registerItem("brine_powder",
            new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON)));

    //Tools & Weapons
    public static final Item BLAZINGPICKAXE = registerItem("blazing_pickaxe",
            new BlazingPickaxe(BlazingToolMaterial.BLAZE,2,-2.8f,new FabricItemSettings()));
    public static final Item BOULDROSCLAW = registerItem("bouldros_claw",
            new BouldrosClaw(BlazingToolMaterial.BOULDROS,2,-2.5f,new FabricItemSettings()));
    public static final Item UNCHARGEELEMENTALSWORD = registerItem("uncharged_elemental_sword",
            new UnchargedElementalSword(BlazingToolMaterial.ANCIENT,2,-2.8f,new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item BLAZINGSTAFF = registerItem("blazing_staff",
            new BlazingStaff(BlazingToolMaterial.BLAZE,new FabricItemSettings()));

    //Other
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM,new Identifier(BlazingElements.MOD_ID,name),item);
    }

    public static void registerModItems(){
        BlazingElements.LOGGER.info("Registering Mod Items for " + BlazingElements.MOD_ID);
    }
}
