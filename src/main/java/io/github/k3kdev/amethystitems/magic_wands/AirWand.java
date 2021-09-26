package io.github.k3kdev.amethystitems.magic_wands;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Timer;
import java.util.TimerTask;

public class AirWand {

    static Timer timer = new Timer();

    public static void attackRight(PlayerEntity player, World world) {
        player.move(MovementType.PLAYER, new Vec3d(0, 15, 0));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 180, 2));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 80, 2));
    }

    public static void attackLeft(PlayerEntity player, World world, Hand hand, Entity entity, @Nullable EntityHitResult hitResult) {
        entity.damage(DamageSource.FLY_INTO_WALL, 5f);
        entity.setGlowing(true);
        try{
            LivingEntity livingEntity = (LivingEntity) entity;
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 120, 2));
        } catch (ClassCastException e) {
            entity.move(MovementType.PLAYER, new Vec3d(0, 20, 0));
        }

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                entity.setGlowing(false);
            }
        }, 5000);
    }
}