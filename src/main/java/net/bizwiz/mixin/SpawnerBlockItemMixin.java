package net.bizwiz.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.SpawnerBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.MobSpawnerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockItem.class)
public class SpawnerBlockItemMixin {
    @Inject(method = "postPlacement", at = @At("HEAD"))
    public void postPlacement(BlockPos pos, World world, PlayerEntity player, ItemStack stack, BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (state.getBlock() instanceof SpawnerBlock && stack.hasNbt()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof MobSpawnerBlockEntity) {
                NbtCompound nbt = stack.getNbt();
                if (nbt != null) {
                    ((MobSpawnerBlockEntity) blockEntity).readNbt(nbt);
                }
            }
        }
    }
}
