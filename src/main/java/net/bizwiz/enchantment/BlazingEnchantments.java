package net.bizwiz.enchantment;

import net.bizwiz.BlazingElements;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlazingEnchantments {
    public static final Enchantment SPAWNERBREAKER = registerEnchantment("spawner_breaker", new SpawnerBreaker());

    private static Enchantment registerEnchantment(String name, Enchantment enchantment){
        return Registry.register(Registries.ENCHANTMENT,new Identifier(BlazingElements.MOD_ID,name),enchantment);
    }
    public static void registerModEnchantments(){
        BlazingElements.LOGGER.info("Registering Mod Enchantments for " + BlazingElements.MOD_ID);
    }
}
