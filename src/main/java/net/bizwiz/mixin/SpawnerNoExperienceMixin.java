package net.bizwiz.mixin;

import net.bizwiz.enchantment.BlazingEnchantments;
import net.minecraft.block.BlockState;
import net.minecraft.block.SpawnerBlock;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SpawnerBlock.class)
public class SpawnerNoExperienceMixin {
    @Inject(method = "onStacksDropped", at = @At("HEAD"), cancellable = true)
    private void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack tool, boolean dropExperience, CallbackInfo ci) {
        if (!world.isClient) {
            if (EnchantmentHelper.getLevel(BlazingEnchantments.SPAWNERBREAKER, tool) > 0) {
                ci.cancel();
            }
        }
    }
}
