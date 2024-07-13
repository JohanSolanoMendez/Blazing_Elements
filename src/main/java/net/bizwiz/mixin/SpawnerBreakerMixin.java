package net.bizwiz.mixin;

import net.bizwiz.enchantment.BlazingEnchantments;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.MobSpawnerBlockEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Mixin(Block.class)
public class SpawnerBreakerMixin {

    @Shadow @Final private static Logger LOGGER;


    @Inject(method = "getDroppedStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)Ljava/util/List;", at = @At("HEAD"), cancellable = true)
    private static void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, BlockEntity blockEntity, Entity entity, ItemStack stack, CallbackInfoReturnable<List<ItemStack>> cir) {
        try {
            if (!world.isClient) {
                if (blockEntity instanceof MobSpawnerBlockEntity) {
                    if (EnchantmentHelper.getLevel(BlazingEnchantments.SPAWNERBREAKER, stack) > 0) {
                        MobSpawnerBlockEntity spawnerBlockEntity = (MobSpawnerBlockEntity) blockEntity;
                        ItemStack spawnerItem = new ItemStack(Blocks.SPAWNER);
                        NbtCompound nbt = new NbtCompound();

                        EntityType<?> spawnerEntityType = Objects.requireNonNull(spawnerBlockEntity.getLogic().getRenderedEntity(world, pos)).getType();
                        String entityName = getEntityName(spawnerEntityType);

                        ((MobSpawnerBlockEntityInvoker) spawnerBlockEntity).invokeWriteNbt(nbt);
                        spawnerItem.setNbt(nbt);
                        spawnerItem.setCustomName(Text.of(entityName));

                        List<ItemStack> droppedStacks = new ArrayList<>();
                        droppedStacks.add(spawnerItem);
                        cir.setReturnValue(droppedStacks);
                        cir.cancel();
                    }
                } else {
                    LOGGER.info("BlockEntity is not instance of MobSpawnerBlockEntity");
                }
            }
        } catch (Exception e) {
            LOGGER.info("Error handling onStacksDropped: " + e.getMessage());
        }
    }

    @Unique
    private static String getEntityName(EntityType<?> entityType) {
        Identifier entityId = EntityType.getId(entityType);
        if (entityId != null) {
            return entityId.getPath().toUpperCase();
        } else {
            return "Unknown";
        }
    }
}

