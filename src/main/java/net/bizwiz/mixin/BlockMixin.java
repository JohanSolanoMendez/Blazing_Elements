package net.bizwiz.mixin;

import net.bizwiz.item.BlazingItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.RecipeType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;
@Mixin(Block.class)
public class BlockMixin {

    @Inject(
            method = "getDroppedStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)Ljava/util/List;",
            at = @At("RETURN"),
            cancellable = true)
    private static void getDroppedStacks(BlockState state, ServerWorld world, BlockPos pos, @Nullable BlockEntity blockEntity, @Nullable Entity entity, ItemStack stack, CallbackInfoReturnable<List<ItemStack>> cir) {
        List<ItemStack> items = new ArrayList<>();
        List<ItemStack> cirReturnValue = cir.getReturnValue();

        if(stack.getItem() != BlazingItems.BLAZINGPICKAXE){
            return;
        }

        for (int i=0; i < cirReturnValue.size();i++) {
            ItemStack itemStack = cirReturnValue.get(i);
            var recipe = world.getRecipeManager().getFirstMatch(RecipeType.SMELTING, new SimpleInventory(itemStack), world);

            if (recipe.isPresent()) {
                ItemStack smelted = recipe.get().value().getResult(world.getRegistryManager()).copy();
                smelted.setCount(itemStack.getCount());
                items.add(smelted);
            } else {
                items.add(itemStack);
            }
        }
        if(!world.isClient){
            world.playSound(null,pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS,1f, 1f);
            generateFireExplosion(world,pos);
        }
        cir.setReturnValue(items);
    }

    private static void generateFireExplosion(ServerWorld world, BlockPos pos) {
        for (int i = 0; i < 360; i += 10) { // Crear partículas en un círculo de 360 grados
            double radians = Math.toRadians(i);
            double xSpeed = Math.cos(radians);
            double zSpeed = Math.sin(radians);
            double ySpeed = 0.5; // Velocidad vertical aleatoria
            double offsetX = 0.5 * xSpeed;
            double offsetZ = 0.5 * zSpeed;
            world.spawnParticles(ParticleTypes.FLAME, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 1, offsetX, ySpeed, offsetZ, 0.1);
        }
    }
}
