package net.bizwiz.item.custom;

import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class BlazingPickaxe extends PickaxeItem {
    public BlazingPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean canBeEnchantedWith(ItemStack stack, Enchantment enchantment, EnchantingContext context) {
        if(enchantment==Enchantments.SILK_TOUCH){
            return false;
        }

        return super.canBeEnchantedWith(stack, enchantment, context);
    }
}
