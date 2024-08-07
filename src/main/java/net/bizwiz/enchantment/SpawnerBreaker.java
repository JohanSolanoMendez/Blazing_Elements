package net.bizwiz.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;


public class SpawnerBreaker extends Enchantment {
    protected SpawnerBreaker() {
        super(Rarity.VERY_RARE, EnchantmentTarget.DIGGER, EquipmentSlot.values());
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }
}
