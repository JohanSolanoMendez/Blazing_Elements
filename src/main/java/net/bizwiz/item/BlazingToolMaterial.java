package net.bizwiz.item;

import com.google.common.base.Supplier;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public enum BlazingToolMaterial implements ToolMaterial {

    BLAZE(5,900,8.5f,2.5f,10,()->Ingredient.ofItems(Items.BLAZE_POWDER)),
    BOULDROS(5,900,8.5f,2.5f,7,()->Ingredient.ofItems(BlazingItems.BOULDROSBOULDER)),
    ANCIENT(3,700,8.0f,3.0f,22,()->Ingredient.ofItems(BlazingItems.BOULDROSROD));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    BlazingToolMaterial(int miningLevel, int itemDurability, float miningSpeed,
                        float attackDamage, int enchantability,
                        Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }


    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
