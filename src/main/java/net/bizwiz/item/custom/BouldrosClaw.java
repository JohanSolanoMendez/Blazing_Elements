package net.bizwiz.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BouldrosClaw extends PickaxeItem {
    public BouldrosClaw(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient) {
            mineArea(world, pos, (PlayerEntity) miner);
            stack.damage(1, miner, (player) -> player.sendToolBreakStatus(miner.getActiveHand()));
        }
        return super.postMine(stack, world, state, pos, miner);
    }

    private void mineArea(World world, BlockPos pos, PlayerEntity miner) {
        int radius = 1;
        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos targetPos = pos.add(x, y, z);
                    BlockState targetState = world.getBlockState(targetPos);
                    if (targetState.getHardness(world, targetPos) != -1.0F) {
                        world.breakBlock(targetPos, true, miner);
                    }
                }
            }
        }
    }
}
