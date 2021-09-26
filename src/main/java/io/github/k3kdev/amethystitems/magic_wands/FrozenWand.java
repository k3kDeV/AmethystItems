package io.github.k3kdev.amethystitems.magic_wands;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class FrozenWand {

    public static void attackRight(PlayerEntity player, World world) {
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 120, 2));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 120, 5));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 120, 2));
    }

    public static void attackLeft(PlayerEntity player, World world, Hand hand, Entity entity, @Nullable EntityHitResult hitResult) {
        entity.damage(DamageSource.FLY_INTO_WALL, 4f);
        try{
            LivingEntity livingEntity = (LivingEntity) entity;
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 120, 2));
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 60, 2));
        } catch (ClassCastException e) {
            player.sendMessage(Text.of("Cannot do that on this enemy!"), false);
        }
    }

}
