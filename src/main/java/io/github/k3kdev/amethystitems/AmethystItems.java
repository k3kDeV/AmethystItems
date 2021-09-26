package io.github.k3kdev.amethystitems;

import io.github.k3kdev.amethystitems.magic_wands.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.ActionResult;
import net.minecraft.util.TypedActionResult;

public class AmethystItems implements ModInitializer {

    @Override
    public void onInitialize () {

        Register.register();

        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {

            if (player.getMainHandStack().isOf(Register.FIRE_WAND)) {
                FireWand.attackLeft(player, world, hand, entity, hitResult);
            }
            if (player.getMainHandStack().isOf(Register.FROZEN_WAND)) {
                FrozenWand.attackLeft(player, world, hand, entity, hitResult);
            }
            if (player.getMainHandStack().isOf(Register.WATER_WAND)) {
                WaterWand.attackLeft(player, world, hand, entity, hitResult);
            }
            if (player.getMainHandStack().isOf(Register.AIR_WAND)) {
                AirWand.attackLeft(player, world, hand, entity, hitResult);
            }
            if (player.getMainHandStack().isOf(Register.EARTH_WAND)) {
                EarthWand.attackLeft(player, world, hand, entity, hitResult);
            }

            return ActionResult.PASS;
        });

        UseItemCallback.EVENT.register((player, world, hand) -> {

            if (player.getMainHandStack().isOf(Register.FIRE_WAND)) {
                FireWand.attackRight(player, world);
            }
            if (player.getMainHandStack().isOf(Register.FROZEN_WAND)) {
                FrozenWand.attackRight(player, world);
            }
            if (player.getMainHandStack().isOf(Register.WATER_WAND)) {
                WaterWand.attackRight(player, world);
            }
            if (player.getMainHandStack().isOf(Register.AIR_WAND)) {
                AirWand.attackRight(player, world);
            }
            if (player.getMainHandStack().isOf(Register.EARTH_WAND)) {
                EarthWand.attackRight(player, world);
            }

            return TypedActionResult.pass(ItemStack.EMPTY);
        });


    }

    public static class CustomPickaxeItem extends PickaxeItem {
        public CustomPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
    }

    public static class CustomAxeItem extends AxeItem {
        public CustomAxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
    }

    public static class CustomHoeItem extends HoeItem {
        public CustomHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
    }
}