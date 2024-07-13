package net.bizwiz.mixin;

import net.minecraft.block.entity.MobSpawnerBlockEntity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(MobSpawnerBlockEntity.class)
public interface MobSpawnerBlockEntityInvoker {
    @Invoker("writeNbt")
    void invokeWriteNbt(NbtCompound nbt);
}