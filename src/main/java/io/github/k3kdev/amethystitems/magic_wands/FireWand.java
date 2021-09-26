package io.github.k3kdev.amethystitems.magic_wands;

import net.minecraft.client.util.math.Vector3d;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Timer;
import java.util.TimerTask;

public class FireWand {
    public static void attackRight(PlayerEntity player, World world) {

        if(!player.getInventory().contains(new ItemStack(Items.FIRE_CHARGE,1))) {
            player.sendMessage(Text.of("You don't have enough fire charges!"),false);
            return;
        }

        Vec3d look = player.getRotationVector().multiply(3);

        Entity fireball = new FireballEntity(EntityType.FIREBALL, world);
        fireball.setPos(player.getX() + look.x, player.getY() + 0.5, player.getZ() + look.z);
        world.spawnEntity(fireball);
        player.getInventory().removeStack(player.getInventory().getSlotWithStack(new ItemStack(Items.FIRE_CHARGE)),1);

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            public void run() {
                fireball.kill();
            }
        }, 2000);

    }

    public static void attackLeft(PlayerEntity player, World world, Hand hand, Entity entity, @Nullable EntityHitResult hitResult) {
    }

}
