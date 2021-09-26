package io.github.k3kdev.amethystitems.magic_wands;

import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class EarthWand {
    public static void attackRight(PlayerEntity player, World world) {

        for (int i = 0; i < 10; i++) {
            BlockPos pos0 = new BlockPos(player.getRotationVector().multiply(i).add(player.getX(), player.getY() + 1, player.getZ()));
            BlockPos pos1 = new BlockPos(player.getRotationVector().multiply(i).add(player.getX(), player.getY() + 2, player.getZ()));
            if(world.getBlockState(pos0).getBlock() == Blocks.BEDROCK || world.getBlockState(pos1).getBlock() == Blocks.BEDROCK) {
                return;
            }

            world.breakBlock(pos0, false);
            world.breakBlock(pos1, false);
        }
    }

    public static void attackLeft(PlayerEntity player, World world, Hand hand, Entity entity, @Nullable EntityHitResult hitResult) {
        player.sendMessage(Text.of("Ability not done yet"), false);
    }

}
