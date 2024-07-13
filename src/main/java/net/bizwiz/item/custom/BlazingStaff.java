package net.bizwiz.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class BlazingStaff extends ToolItem {

    public BlazingStaff(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            ItemStack stack = user.getStackInHand(hand);
            if(!user.getAbilities().creativeMode && removeFireCharge(user)){
                FireballEntity fireball = getFireballEntity(world, user);

                fireball.setPos(user.getX(), user.getY() + user.getEyeHeight(user.getPose()) + 0.5, user.getZ());
                world.spawnEntity(fireball);

                stack.damage(1, user, p -> p.sendToolBreakStatus(hand));
                return TypedActionResult.success(user.getStackInHand(hand));
            }
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    @NotNull
    private static FireballEntity getFireballEntity(World world, PlayerEntity user) {
        float pitch = user.getPitch();
        float yaw = user.getYaw();

        float pitchRad = (float)Math.toRadians(pitch);
        float yawRad = (float)Math.toRadians(yaw);

        double x = -Math.sin((float)Math.toRadians(yaw)) * Math.cos((float)Math.toRadians(pitch));
        double y = -Math.sin((float)Math.toRadians(pitch));
        double z = Math.cos((float)Math.toRadians(yaw)) * Math.cos((float)Math.toRadians(pitch));

        FireballEntity fireball = new FireballEntity(world, user, x, y, z, 3);
        return fireball;
    }

    private boolean removeFireCharge(PlayerEntity player) {
        for (int i = 0; i < player.getInventory().size(); i++) {
            ItemStack stack = player.getInventory().getStack(i);
            if (stack.getItem() == Items.FIRE_CHARGE) {
                stack.decrement(1);
                return true;
            }
        }
        return false;
    }
}
